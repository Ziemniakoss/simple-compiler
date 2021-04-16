package pl.ziemniakoss.simplecompiler.llvmgeneration;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.ziemniakoss.simplecompiler.Function;
import pl.ziemniakoss.simplecompiler.RpnOperationType;
import pl.ziemniakoss.simplecompiler.Variable;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarBaseListener;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
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
	private final LlvmCodeGeneratorState state = new LlvmCodeGeneratorState();

	public LLVMCodeGenerator(ParseTree parseTree) {
		this.functionNameToDefinition = new HashMap<>();
		functionNameToDefinition.put("readInt", new Function("readInt", VariableType.INTEGER, new VariableType[0]));
		functionNameToDefinition.put("readReal", new Function("readReal", VariableType.REAL, new VariableType[0]));

		functionNameToDefinition.put("writeInt", new Function("writeInt", VariableType.INTEGER, new VariableType[]{VariableType.INTEGER}));
		functionNameToDefinition.put("writeReal", new Function("writeReal", VariableType.INTEGER, new VariableType[]{VariableType.REAL}));
		this.parseTree = parseTree;
		this.contexts = new Stack<>();
	}

	public String getLlvmCode() {
		return llvmCode.toString();
	}

	public void generateLlvmCode() throws IOException {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.parseTree);
	}

	@Override
	public void enterProg(SimpleGrammarParser.ProgContext ctx) {
		new EnterProgHandler().handle(state, ctx);
	}

	@Override
	public void enterCommand(SimpleGrammarParser.CommandContext ctx) {
		llvmCode.append("\t".repeat(indent));
	}

	@Override
	public void exitCommand(SimpleGrammarParser.CommandContext ctx) {
		if (ctx.functionCall() != null) {
			genererateLlvmCodeForFunctionCall(ctx.functionCall());
		}
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
		int operationWithReturnedValue = valueTokenToOperationWithValue.get(ctx.value());
		VariableType returnedType = operationIndexToStoredValueType.get(operationWithReturnedValue);
		if (returnedType != currentlyDefinedFunctionReturnType) {
			operationWithReturnedValue = generateCastingLlvmCode(operationWithReturnedValue, returnedType, currentlyDefinedFunctionReturnType);
		}
		llvmCode.append("ret ")
			.append(currentlyDefinedFunctionReturnType)
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
			if (usedVariable.isPointer()) {
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

			} else {
				simpleValueTokenToOperationWithValue.put(ctx, usedVariable.getRegisterWithValue());
			}
		} else if (ctx.Int() != null || ctx.Real() != null) {
			var variableType = ctx.Int() != null ? VariableType.INTEGER : VariableType.REAL;
			var valueAsString = ctx.Int() != null ? ctx.Int().getText() : ctx.Real().getText();
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
			int operationWithFunctionCallResult = genererateLlvmCodeForFunctionCall(ctx.functionCall());
			simpleValueTokenToOperationWithValue.put(ctx, operationWithFunctionCallResult);
			Function calledFunction = functionNameToDefinition.get(ctx.functionCall().ID().toString());
			operationIndexToStoredValueType.put(operationWithFunctionCallResult, calledFunction.getReturnType());
		}
	}

	private int genererateLlvmCodeForFunctionCall(SimpleGrammarParser.FunctionCallContext ctx) {
		String calledFunctionName = ctx.ID().toString();
		Function calledFunction = functionNameToDefinition.get(calledFunctionName);
		LinkedList<Integer> operationsWithFunctionArgments = new LinkedList<>();
		var passedFunctionArguments = ctx.functionArguments().value();
		for (int i = 0; i < passedFunctionArguments.size(); i++) {
			var functionParameter = calledFunction.getArgumentsTypes()[i];
			var passedArgument = passedFunctionArguments.get(i);
			var operationWithPassedArgument = valueTokenToOperationWithValue.get(passedArgument);
			var passedArgumentType = operationIndexToStoredValueType.get(operationWithPassedArgument);
			if (passedArgumentType != functionParameter) {
				operationWithPassedArgument = generateCastingLlvmCode(operationWithPassedArgument, passedArgumentType, functionParameter);
			}
			operationsWithFunctionArgments.push(operationWithPassedArgument);
		}
		llvmCode.append('%')
			.append(nextOperationIndex)
			.append(" = call ")
			.append(calledFunction.getReturnType())
			.append(" @")
			.append(calledFunction.getName())
			.append('(');
		for (int i = 0; i < calledFunction.getArgumentsTypes().length; i++) {
			if (i != 0) {
				llvmCode.append(", ");
			}
			llvmCode.append(calledFunction.getArgumentsTypes()[i])
				.append(" %")
				.append(operationsWithFunctionArgments.get(i));
		}
		llvmCode.append(")\n")
			.append("\t".repeat(indent));
		return nextOperationIndex++;
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
		Map<String, Variable> contextWithFunParameters = new HashMap<>();
		contexts.push(contextWithFunParameters);
		if (ctx.funParameters() == null || ctx.funParameters().funParameter() == null) {
			llvmCode.append(") {");
			nextOperationIndex = 1;
			return;
		}
		boolean isFirst = true;
		nextOperationIndex = 0;
		VariableType[] functionParametersTypes = new VariableType[ctx.funParameters() != null ? ctx.funParameters().funParameter().size() : 0];
		var functionParameters = ctx.funParameters().funParameter();
		for (int i = 0; i < functionParameters.size(); i++) {
			var parameter = functionParameters.get(i);
			var parameterAsVariable = new Variable(
				parameter.type().IntType() != null ? VariableType.INTEGER : VariableType.REAL,
				parameter.ID().toString(),
				nextOperationIndex++,
				false
			);
			functionParametersTypes[i] = parameterAsVariable.getType();
			operationIndexToStoredValueType.put(parameterAsVariable.getRegisterWithValue(), parameterAsVariable.getType());
			contextWithFunParameters.put(parameterAsVariable.getName(), parameterAsVariable);
			if (!isFirst) {
				llvmCode.append(", ");
			} else {
				isFirst = false;
			}
			llvmCode.append(parameterAsVariable.getType().toString())
				.append(" %")
				.append(parameterAsVariable.getRegisterWithValue());
		}
		llvmCode.append(") {");
		functionNameToDefinition.put(ctx.ID().toString(), new Function(
			ctx.ID().toString(),
			ctx.type().IntType() != null ? VariableType.INTEGER : VariableType.REAL,
			functionParametersTypes
		));
		nextOperationIndex++;
	}

	@Override
	public void exitFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx) {
		nextOperationIndex = 1;
		llvmCode.append("\t".repeat(indent + 1))
			.append("ret")
			.append(ctx.type().IntType() != null ? " i32 0\n" : " double 0.0\n")
			.append("}\n\n");
		currentlyDefinedFunctionReturnType = null;
		contexts.pop();
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
		int secondOperandIndex = valuesStack.pop();
		var secondOperandType = typesStack.pop();
		int firstOperandIndex = valuesStack.pop();
		var firstOperandType = typesStack.pop();

		VariableType operationExecutedOnType;
		if (operationType == RpnOperationType.MOD) {
			if (firstOperandType == VariableType.REAL) {
				firstOperandIndex = generateCastingLlvmCode(firstOperandIndex, VariableType.REAL, VariableType.INTEGER);
			}
			if (secondOperandType == VariableType.REAL) {
				secondOperandIndex = generateCastingLlvmCode(secondOperandIndex, VariableType.REAL, VariableType.INTEGER);
			}
			operationExecutedOnType = VariableType.INTEGER;

		} else if (firstOperandType == secondOperandType) {
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
		String llvmInstruction;
		if (operationType == RpnOperationType.ADD) {
			llvmInstruction = typeOfOperands == VariableType.INTEGER ? "add i32" : "fadd double";
		} else if (operationType == RpnOperationType.SUB) {
			llvmInstruction = typeOfOperands == VariableType.INTEGER ? "sub i32" : "fsub double";
		} else if (operationType == RpnOperationType.MUL) {
			llvmInstruction = typeOfOperands == VariableType.INTEGER ? "mul i32" : "fmul double";
		} else if (operationType == RpnOperationType.DIV) {
			llvmInstruction = typeOfOperands == VariableType.INTEGER ? "sdiv i32" : "fdiv double";
		} else {
			llvmInstruction = "srem i32";
		}
		llvmCode.append('%')
			.append(nextOperationIndex)
			.append(" = ")
			.append(llvmInstruction)
			.append(" %")
			.append(firstOperand)
			.append(", %")
			.append(secondOperand)
			.append('\n')
			.append("\t".repeat(indent));
		return nextOperationIndex++;
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
