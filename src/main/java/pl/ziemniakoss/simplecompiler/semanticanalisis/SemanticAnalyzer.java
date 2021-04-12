package pl.ziemniakoss.simplecompiler.semanticanalisis;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.ziemniakoss.simplecompiler.Function;
import pl.ziemniakoss.simplecompiler.Variable;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarBaseListener;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions.*;

import java.util.*;

public class SemanticAnalyzer extends SimpleGrammarBaseListener {
	private final Map<String, Function> functionNameToFunction;
	private final Stack<Map<String, Variable>> variableContexts;
	private final ParseTree parseTree;

	public SemanticAnalyzer(ParseTree parseTree) {
		functionNameToFunction = new HashMap<>();
		variableContexts = new Stack<>();
		this.parseTree = parseTree;
		createDefaultContext();
	}

	public void analyze() {
		new ParseTreeWalker().walk(this, parseTree);
	}

	@Override
	public void enterCodeBlock(SimpleGrammarParser.CodeBlockContext ctx) {
		variableContexts.push(new HashMap<>());
	}

	@Override
	public void exitCodeBlock(SimpleGrammarParser.CodeBlockContext ctx) {
		variableContexts.pop();
	}


	@Override
	public void enterVarDeclaration(SimpleGrammarParser.VarDeclarationContext ctx) {
		String declaredVariableName = ctx.ID().toString();
		if (doesVariableExist(declaredVariableName)) {
			throw new VariableAlreadyDeclaredException(
					ctx.getStart().getLine(),
					ctx.getStart().getCharPositionInLine(),
					"Variable with name " + declaredVariableName + " already exists in this context"
			);
		}
		var declaredVariableType = ctx.type().IntType() == null ? VariableType.INTEGER : VariableType.REAL;
		var declaredVariable = new Variable(declaredVariableType, declaredVariableName);
		variableContexts.peek().put(declaredVariableName, declaredVariable);
	}

	@Override
	public void enterVarAssigment(SimpleGrammarParser.VarAssigmentContext ctx) {
		String nameOfVariableToAssign = ctx.ID().toString();
		if (!doesVariableExist(nameOfVariableToAssign)) {
			throw new VariableDoesNotExistException(
					ctx.getStart().getLine(),
					ctx.getStart().getCharPositionInLine(),
					"Variable " + nameOfVariableToAssign + " is not declared in current context"
			);
		}
	}

	@Override
	public void enterSimpleValue(SimpleGrammarParser.SimpleValueContext ctx) {
		if (ctx.ID() != null) {
			String referencedVariableName = ctx.ID().toString();
			if (!doesVariableExist(referencedVariableName)) {
				throw new VariableDoesNotExistException(
						ctx.getStart().getLine(),
						ctx.getStart().getCharPositionInLine(),
						"Variable " + referencedVariableName + " is not declared in current context"
				);
			}
		}
	}

	@Override
	public void enterValue(SimpleGrammarParser.ValueContext ctx) {
		int reversePolishNotationStackDepth = 0;
		for (ParseTree child : ctx.children) {
			if (child instanceof SimpleGrammarParser.SimpleValueContext) {
				reversePolishNotationStackDepth++;
			} else {
				SimpleGrammarParser.ArithmeticOperatorContext arithmeticOperator = (SimpleGrammarParser.ArithmeticOperatorContext) child;
				if (reversePolishNotationStackDepth < 2) {
					throw new ReversePolishNotationException(
							arithmeticOperator.getStart().getLine(),
							arithmeticOperator.getStart().getCharPositionInLine(),
							"Operator Reverse Polish Notation needs 2 element on stack, found " + reversePolishNotationStackDepth
					);
				}
				reversePolishNotationStackDepth--;
			}
		}

		if (reversePolishNotationStackDepth != 1) {
			throw new ReversePolishNotationException(
					ctx.getStop().getLine(),
					ctx.getStop().getCharPositionInLine(),
					"Variable stack after operations sholud have one value"
			);
		}
	}

	@Override
	public void enterFunctionCall(SimpleGrammarParser.FunctionCallContext ctx) {
		String calledFunctionName = ctx.ID().toString();
		if (!functionNameToFunction.containsKey(calledFunctionName)) {
			throw new FunctionNotDeclaredException(
					ctx.getStart().getLine(),
					ctx.getStart().getCharPositionInLine(),
					"Called function " + calledFunctionName + " is not declared"
			);
		}
	}

	@Override
	public void exitProg(SimpleGrammarParser.ProgContext ctx) {
		if (!functionNameToFunction.containsKey("main")) {
			throw new MainMethodNotDefinedException("Main method is not defined");
		}
	}

	@Override
	public void enterFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx) {
		String declaredFunctionName = ctx.ID().toString();
		if (declaredFunctionName.equals("main")) {
			validateMainFunctionDeclaration(ctx);
		}
		var declaredFunctionReturnType = ctx.type().IntType() != null ? VariableType.INTEGER : VariableType.REAL;
		var declaredFunctionParametersTypes = new ArrayList<VariableType>();
		if (ctx.funParameters() != null) {
			for (var parameter : ctx.funParameters().funParameter()) {
				declaredFunctionParametersTypes.add(parameter.type().IntType() != null ? VariableType.INTEGER : VariableType.REAL);
			}
		}
		var declaredFunctionParametersTypesAsArray = declaredFunctionParametersTypes.toArray(VariableType[]::new);
		var declaredFunction = new Function(declaredFunctionName, declaredFunctionReturnType, declaredFunctionParametersTypesAsArray);
		functionNameToFunction.put(declaredFunctionName, declaredFunction);
		super.enterFunDeclaration(ctx);
	}

	private void validateMainFunctionDeclaration(SimpleGrammarParser.FunDeclarationContext ctx) {
		if (ctx.type().IntType() == null) {
			throw new InvalidMainDeclarationException(
					ctx.getStart().getLine(),
					ctx.getStart().getCharPositionInLine(),
					"Main function must return integer"
			);
		}
		if (ctx.funParameters() != null) {
			throw new InvalidMainDeclarationException(
					ctx.getStart().getLine(),
					ctx.getStart().getCharPositionInLine(),
					"Main function cant take any parameters"
			);
		}
	}

	@Override
	public void enterFunParameters(SimpleGrammarParser.FunParametersContext ctx) {
		super.enterFunParameters(ctx);
		Set<String> declaredParametersNames = new HashSet<>();
		for (SimpleGrammarParser.FunParameterContext parameter : ctx.funParameter()) {
			String parameterName = parameter.ID().toString();
			if (declaredParametersNames.contains(parameterName)) {
				throw new DuplicateParameterNamesException(
						parameter.getStart().getLine(),
						parameter.getStart().getCharPositionInLine(),
						"Duplicate parameter name " + parameterName + " in function declaration "
				);
			}
			declaredParametersNames.add(parameterName);
		}
	}

	private void createDefaultContext() {
		functionNameToFunction.put("readInt", new Function("readInt", VariableType.INTEGER, new VariableType[0]));
		functionNameToFunction.put("readReal", new Function("readReal", VariableType.REAL, new VariableType[0]));
		functionNameToFunction.put("write", null);
		functionNameToFunction.put("writeInt", null);
		functionNameToFunction.put("writeReal", null);

		variableContexts.push(new HashMap<>());
	}

	private boolean doesVariableExist(String name) {
		for (var context : variableContexts) {
			if (context.containsKey(name)) {
				return true;
			}
		}
		return false;
	}
}
