package pl.ziemniakoss.simplecompiler.llvmgeneration;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.ziemniakoss.simplecompiler.Function;
import pl.ziemniakoss.simplecompiler.RpnOperationType;
import pl.ziemniakoss.simplecompiler.Variable;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarBaseListener;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LLVMCodeGenerator extends SimpleGrammarBaseListener {
	private final Map<String, Function> functionNameToDefinition;
	private final StringBuilder llvmCode = new StringBuilder();
	private final Stack<Map<String, Variable>> contexts;
	private int nextOperationIndex = 1;
	private int indent = 0;
	private final Map<SimpleGrammarParser.ValueContext, Integer> valueTokenToOperationWithValue = new HashMap<>();
	private final Map<SimpleGrammarParser.SimpleValueContext, Integer> simpleValueTokenToOperationWithValue = new HashMap<>();
	private final Map<Integer, VariableType> operationIndexToStoredValueType = new HashMap<>();
	private final ParseTree parseTree;
	private VariableType currentlyDefinedFunctionReturnType;

	public LLVMCodeGenerator(ParseTree parseTree) {
		this.functionNameToDefinition = new HashMap<>();
		functionNameToDefinition.put("readInt", new Function("readInt", VariableType.INTEGER, new VariableType[0]));
		functionNameToDefinition.put("readReal", new Function("readReal", VariableType.REAL, new VariableType[0]));

		functionNameToDefinition.put("write", null);
		functionNameToDefinition.put("writeInt", null);
		functionNameToDefinition.put("writeReal", null);
		this.parseTree = parseTree;
		this.contexts = new Stack<>();
	}

	public String getLlvmCode() {
		return llvmCode.toString();
	}

	public void generateLlvmCode() throws IOException {
		loadIoLibrary();
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.parseTree);
	}

	private void loadIoLibrary() throws IOException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream ioLibraryStream = classloader.getResourceAsStream("ioLibrary.ll");
		if (ioLibraryStream == null) {
			throw new RuntimeException("Could not load simple language IO library");
		}

		BufferedReader ioLibraryReader = new BufferedReader(new InputStreamReader(ioLibraryStream));
		for (String line; (line = ioLibraryReader.readLine()) != null; ) {
			llvmCode.append(line)
				.append('\n');
		}
	}

	@Override
	public void enterCommand(SimpleGrammarParser.CommandContext ctx) {
		llvmCode.append("\t".repeat(indent));
	}

	@Override
	public void exitCommand(SimpleGrammarParser.CommandContext ctx) {
		llvmCode.append("\n");
	}

	@Override
	public void enterCodeBlock(SimpleGrammarParser.CodeBlockContext ctx) {
		llvmCode.append("\t".repeat(indent++));
		if (isGlobalContext()) {
			llvmCode.append('{');
		}
		llvmCode.append('\n');
		contexts.push(new HashMap<>());
	}

	@Override
	public void exitCodeBlock(SimpleGrammarParser.CodeBlockContext ctx) {
		llvmCode.append("\t".repeat(--indent));
		contexts.pop();
	}

	@Override
	public void exitReturnStatement(SimpleGrammarParser.ReturnStatementContext ctx) {
		System.out.println(ctx.value());
		int operationWithReturnedValue = valueTokenToOperationWithValue.get(ctx.value());
		VariableType returnedType = operationIndexToStoredValueType.get(operationWithReturnedValue);
		if (returnedType != currentlyDefinedFunctionReturnType) {
			operationWithReturnedValue = generateCastingLlvmCode(operationWithReturnedValue, returnedType, currentlyDefinedFunctionReturnType);
		}
		llvmCode.append("ret ")
			.append(returnedType)
			.append(" %")
			.append(operationWithReturnedValue)
			.append('\n')
			.append("\t".repeat(indent))
			.append("unreachable")
			.append('\n');
		nextOperationIndex += 2;
	}

	@Override
	public void enterVarDeclaration(SimpleGrammarParser.VarDeclarationContext ctx) {
		var variableType = ctx.type();
		var variableName = ctx.ID().toString();
		if (isVariableDefined(variableName)) {
			throw new RuntimeException("Variable \"" + variableName + "\" already defined");
		}
		llvmCode.append('\n')
			.append("\t".repeat(indent))
			.append('%')
			.append(nextOperationIndex)
			.append(" = alloca ")
			.append(variableType.IntType() != null ? "i32" : "double")
			.append('\n')
			.append("\t".repeat(indent));
		var currentContext = contexts.peek();
		currentContext.put(variableName, new Variable(
			variableType.IntType() != null ? VariableType.INTEGER : VariableType.REAL,
			variableName,
			nextOperationIndex++
		));
	}

	@Override
	public void exitVarDeclaration(SimpleGrammarParser.VarDeclarationContext ctx) {
		int operationWithValueForVariable = valueTokenToOperationWithValue.get(ctx.value());
		var valueTypeForDeclaredVariable = operationIndexToStoredValueType.get(operationWithValueForVariable);
		String declaredVariableName = ctx.ID().toString();
		var declaredVariable = getVariable(declaredVariableName);
		if (valueTypeForDeclaredVariable != declaredVariable.getType()) {
			operationWithValueForVariable = generateCastingLlvmCode(operationWithValueForVariable, valueTypeForDeclaredVariable, declaredVariable.getType());

		}
		llvmCode.append("store ")
			.append(declaredVariable.getType().toString())
			.append(" %")
			.append(operationWithValueForVariable)
			.append(", ")
			.append(declaredVariable.getType().toString())
			.append("* %")
			.append(declaredVariable.getRegisterWithValue())
			.append('\n');
	}

	@Override
	public void exitSimpleValue(SimpleGrammarParser.SimpleValueContext ctx) {
		if (ctx.ID() != null) {
			var usedVariable = getVariable(ctx.ID().toString());
			llvmCode.append('%')
				.append(nextOperationIndex)
				.append(" = load ")
				.append(usedVariable.getType().toString())
				.append(", ")
				.append(usedVariable.getType().toString())
				.append("* %")
				.append(usedVariable.getRegisterWithValue())
				.append('\n')
				.append("\t".repeat(indent));
			simpleValueTokenToOperationWithValue.put(ctx, nextOperationIndex);
			operationIndexToStoredValueType.put(nextOperationIndex++, usedVariable.getType());
		} else if (ctx.Int() != null || ctx.Real() != null) {
			var variableType = ctx.Int() != null ? VariableType.INTEGER : VariableType.REAL;
			var valueAsString = ctx.Int() != null ? ctx.Int().toString() : ctx.Real().toString();
			llvmCode.append('%')
				.append(nextOperationIndex)
				.append(" = alloca ")
				.append(variableType.toString())
				.append("\n")
				.append("\t".repeat(indent));

			llvmCode.append("store ")
				.append(variableType.toString())
				.append(' ')
				.append(valueAsString)
				.append(", ").append(variableType.toString())
				.append("*  %")
				.append(nextOperationIndex)
				.append('\n')
				.append("\t".repeat(indent));

			llvmCode.append('%')
				.append(nextOperationIndex + 1)
				.append(" = load ")
				.append(variableType.toString())
				.append(", ")
				.append(variableType.toString())
				.append("* %")
				.append(nextOperationIndex)
				.append('\n')
				.append("\t".repeat(indent));
			simpleValueTokenToOperationWithValue.put(ctx, ++nextOperationIndex);
			operationIndexToStoredValueType.put(nextOperationIndex++, variableType);
		} else {
			//TODO function call
			System.out.println("Function call");
		}
	}

	@Override
	public void enterFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx) {
		llvmCode.append("define dso_local ");
		if (ctx.type().IntType() != null) {
			llvmCode.append("i32 ");
			currentlyDefinedFunctionReturnType = VariableType.INTEGER;
		} else {
			llvmCode.append("double ");
			currentlyDefinedFunctionReturnType = VariableType.REAL;
		}
		llvmCode.append("@");
		llvmCode.append(ctx.ID().toString());
		llvmCode.append("(");
		//TODO args
		llvmCode.append(") #0 ");
	}

	@Override
	public void exitFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx) {
		nextOperationIndex = 1;
		llvmCode.append("\t".repeat(indent + 1))
			.append("ret")
			.append(ctx.type().IntType() != null ? " i32 0\n" : " double 0.0\n")
			.append("}\n\n");
		currentlyDefinedFunctionReturnType = null;
	}

	@Override
	public void exitValue(SimpleGrammarParser.ValueContext ctx) {
		Stack<Integer> operatorsOfValues = new Stack<>();
		Stack<VariableType> valueType = new Stack<>();

		for (var child : ctx.children) {
			if (child instanceof SimpleGrammarParser.SimpleValueContext) {
				var simpleValue = (SimpleGrammarParser.SimpleValueContext) child;
				int operationWithValue = simpleValueTokenToOperationWithValue.get(simpleValue);
				operatorsOfValues.push(operationWithValue);
				valueType.push(operationIndexToStoredValueType.get(operationWithValue));
			} else {
				var operator = (SimpleGrammarParser.ArithmeticOperatorContext) child;
				RpnOperationType operationType;
				if (operator.Plus() != null) {
					operationType = RpnOperationType.ADD;
				} else if (operator.Minus() != null) {
					operationType = RpnOperationType.SUB;
				} else if (operator.Div() != null) {
					operationType = RpnOperationType.DIV;
				} else if (operator.Mult() != null) {
					operationType = RpnOperationType.MUL;
				} else {
					operationType = RpnOperationType.MOD;
				}
				generateRpnOperationCode(operatorsOfValues, valueType, operationType);
			}
		}
		valueTokenToOperationWithValue.put(ctx, operatorsOfValues.peek());
		operationIndexToStoredValueType.put(operatorsOfValues.pop(), valueType.pop());
	}

	@Override
	public void exitVarAssigment(SimpleGrammarParser.VarAssigmentContext ctx) {
		int operationWithValue = valueTokenToOperationWithValue.get(ctx.value());
		var assignedValueType = operationIndexToStoredValueType.get(operationWithValue);
		var variableName = ctx.ID().toString();
		var variable = getVariable(variableName);
		System.out.println(assignedValueType + " is");
		if (variable.getType() != assignedValueType) {
			operationWithValue = generateCastingLlvmCode(operationWithValue, assignedValueType, variable.getType());
		}
		llvmCode.append('\n')
			.append("\t".repeat(indent))
			.append("store ")
			.append(variable.getType())
			.append(" %")
			.append(operationWithValue)
			.append(", ")
			.append(variable.getType())
			.append("* %")
			.append(variable.getRegisterWithValue())
			.append('\n');
	}

	private void generateRpnOperationCode(Stack<Integer> valuesStack, Stack<VariableType> typesStack, RpnOperationType operationType) {
		if (operationType == RpnOperationType.MOD) {
			//TODO support for Mod operation
			return;
		}
		int firstOperandIndex = valuesStack.pop();
		var firstOperandType = typesStack.pop();
		int secondOperandIndex = valuesStack.pop();
		var secondOperandType = typesStack.pop();

		VariableType operationExecutedOnType;
		if (firstOperandType == secondOperandType) {
			operationExecutedOnType = firstOperandType;
		} else {
			// Cast to real needed
			if (firstOperandType != VariableType.REAL) {
				firstOperandIndex = generateCastingLlvmCode(firstOperandIndex, firstOperandType, VariableType.REAL);
			} else if (secondOperandType != VariableType.REAL) {
				secondOperandIndex = generateCastingLlvmCode(secondOperandIndex, secondOperandType, VariableType.REAL);
			}
			operationExecutedOnType = VariableType.REAL;
		}
		int operationWithResult = generateLlvmCodeForOperation(operationType, operationExecutedOnType, firstOperandIndex, secondOperandIndex);
		valuesStack.push(operationWithResult);
		typesStack.push(operationExecutedOnType);
	}

	private int generateCastingLlvmCode(int operationToCast, VariableType from, VariableType to) {
		var castingInstruction = from == VariableType.INTEGER ? "sitofp" : "fptoui";
		System.out.println("Casting from " + from + " to " + to + " with " + castingInstruction);
		llvmCode.append('\n')
			.append("\t".repeat(indent))
			.append('%')
			.append(nextOperationIndex)
			.append(" = ")
			.append(castingInstruction)
			.append(' ')
			.append(from)
			.append(" %")
			.append(operationToCast)
			.append(" to ")
			.append(to)
			.append('\n')
			.append("\t".repeat(indent));
		return nextOperationIndex++;
	}

	/**
	 * Generates llvm code for given operation performed on specified operands type
	 *
	 * @param firstOperand  index of operation holding value of first operand
	 * @param secondOperand index of operation holding value of second operand
	 * @return index of operation containing result of operation
	 */
	private int generateLlvmCodeForOperation(RpnOperationType operationType, VariableType typeOfOperands, int firstOperand, int secondOperand) {
		if (operationType == RpnOperationType.ADD) {
			llvmCode.append('%')
				.append(nextOperationIndex)
				.append(typeOfOperands == VariableType.INTEGER ? " = add i32 %" : " = fadd double %")
				.append(firstOperand)
				.append(", %")
				.append(secondOperand)
				.append('\n')
				.append("\t".repeat(indent));
			return nextOperationIndex++;
		} else if (operationType == RpnOperationType.SUB) {

		} else if (operationType == RpnOperationType.MUL) {

		} else if (operationType == RpnOperationType.DIV) {

		} else {
			//TODO support for mod
			return nextOperationIndex;
		}
		return 0;
	}

	@Override
	public String toString() {
		return getLlvmCode();
	}

	private boolean isVariableDefined(String variableName) {
		for (var context : contexts) {
			if (context.containsKey(variableName)) {
				return true;
			}
		}
		return false;
	}

	private Variable getVariable(String variableName) {
		for (var context : contexts) {
			if (context.containsKey((variableName))) {
				return context.get(variableName);
			}
		}
		return null;
	}

	private boolean isGlobalContext() {
		return contexts.size() == 0;
	}
}
