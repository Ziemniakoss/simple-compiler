package pl.ziemniakoss.simplecompiler.llvmgeneration;

import org.antlr.v4.runtime.ParserRuleContext;
import pl.ziemniakoss.simplecompiler.Function;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.LinkedList;

public class LlvmCodeGenerationUtils {
	public static final String INTEGER_COMPARISON_INSTRUCTION = "icmp";
	public static final String INTEGER_COMPARISON_EQUAL = "eq";
	public static final String INTEGER_COMPARISON_NOT_EQUAL = "neq";
	public static final String INTEGER_COMPARISON_GREATER = "sgt";
	public static final String INTEGER_COMPARISON_GREATER_OR_EQUAL = "sge";
	public static final String INTEGER_COMPARISON_SMALLER = "slt";
	public static final String INTEGER_COMPARISON_SMALLER_OR_EQUAL = "sle";

	public static final String REAL_COMPARISON_INSTRUCTION = "fcmp";
	public static final String REAL_COMPARISON_EQUAL = "ueq";
	public static final String REAL_COMPARISON_NOT_EQUAL = "une";
	public static final String REAL_COMPARISON_GREATER = "ugt";
	public static final String REAL_COMPARISON_GREATER_OR_EQUAL = "uge";
	public static final String REAL_COMPARISON_SMALLER = "ult";
	public static final String REAL_COMPARISON_SMALLER_OR_EQUAL = "ule";

	public static int genererateLlvmCodeForFunctionCall(LlvmCodeGeneratorState state, SimpleGrammarParser.FunctionCallContext ctx) {
		String calledFunctionName = ctx.ID().toString();
		Function calledFunction = state.getFunctionNameToDefinition().get(calledFunctionName);
		LinkedList<Integer> operationsWithFunctionArgments = new LinkedList<>();
		var passedFunctionArguments = ctx.functionArguments().value();
		for (int i = 0; i < passedFunctionArguments.size(); i++) {
			var functionParameter = calledFunction.getArgumentsTypes()[i];
			var passedArgument = passedFunctionArguments.get(i);
			var operationWithPassedArgument = state.getContextToOperationWithResult().get(passedArgument);
			var passedArgumentType = state.getOperationIndexToStoredValueType().get(operationWithPassedArgument);
			if (passedArgumentType != functionParameter) {
				operationWithPassedArgument = generateCastingLlvmCode(state, operationWithPassedArgument, passedArgumentType, functionParameter);
			}
			operationsWithFunctionArgments.push(operationWithPassedArgument);
		}
		state.getLlvmCode().append('%')
			.append(state.nextOperationIndex)
			.append(" = call ")
			.append(calledFunction.getReturnType())
			.append(" @")
			.append(calledFunction.getName())
			.append('(');
		for (int i = 0; i < calledFunction.getArgumentsTypes().length; i++) {
			if (i != 0) {
				state.getLlvmCode().append(", ");
			}
			state.getLlvmCode().append(calledFunction.getArgumentsTypes()[i])
				.append(" %")
				.append(operationsWithFunctionArgments.get(i));
		}
		state.getLlvmCode().append(")\n")
			.append("\t".repeat(state.indent));
		return state.nextOperationIndex++;
	}

	public static int generateCastingLlvmCode(LlvmCodeGeneratorState state, int operationToCast, VariableType from, VariableType to) {
		var castingInstruction = from == VariableType.INTEGER ? "sitofp" : "fptoui";
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent))
			.append('%')
			.append(state.nextOperationIndex)
			.append(" = ")
			.append(castingInstruction)
			.append(' ')
			.append(from)
			.append(" %")
			.append(operationToCast)
			.append(" to ")
			.append(to)
			.append('\n')
			.append("\t".repeat(state.indent));
		return state.nextOperationIndex++;
	}

	public static ComparisonType getComparisonType(SimpleGrammarParser.ValueComparatorContext ctx) {
		if (ctx.Equal() != null) {
			return ComparisonType.EQUAL;
		} else if (ctx.NotEqual() != null) {
			return ComparisonType.NOT_EQUAL;
		} else if (ctx.Greater() != null) {
			return ComparisonType.GREATER;
		} else if (ctx.GreaterOrEqual() != null) {
			return ComparisonType.GREATER_OR_EQUAL;
		} else if (ctx.Smaller() != null) {
			return ComparisonType.SMALLER;
		} else {
			return ComparisonType.SMALLER_OR_EQUAL;
		}
	}

	public static String getLlvmComparisonTypeString(VariableType variableType, ComparisonType comparisonType) {
		if (variableType == VariableType.INTEGER) {
			switch (comparisonType) {
				case SMALLER:
					return INTEGER_COMPARISON_SMALLER;
				case SMALLER_OR_EQUAL:
					return INTEGER_COMPARISON_SMALLER_OR_EQUAL;
				case GREATER:
					return INTEGER_COMPARISON_GREATER;
				case GREATER_OR_EQUAL:
					return INTEGER_COMPARISON_GREATER_OR_EQUAL;
				case EQUAL:
					return INTEGER_COMPARISON_EQUAL;
				case NOT_EQUAL:
					return INTEGER_COMPARISON_NOT_EQUAL;
				default:
					return null;
			}
		} else {
			switch (comparisonType) {
				case SMALLER:
					return REAL_COMPARISON_SMALLER;
				case SMALLER_OR_EQUAL:
					return REAL_COMPARISON_SMALLER_OR_EQUAL;
				case GREATER:
					return REAL_COMPARISON_GREATER;
				case GREATER_OR_EQUAL:
					return REAL_COMPARISON_GREATER_OR_EQUAL;
				case EQUAL:
					return REAL_COMPARISON_EQUAL;
				case NOT_EQUAL:
					return REAL_COMPARISON_NOT_EQUAL;
				default:
					return null;
			}

		}
	}

	public static String getContextKey(ParserRuleContext ctx) {
		return ctx.getStart().getLine() +
			":" +
			ctx.getStart().getCharPositionInLine() +
			"-" +
			ctx.getStop().getLine() +
			":" +
			ctx.getStop().getCharPositionInLine();
	}

	public static String getEndOfConditionalBlockKey(SimpleGrammarParser.ConditionalStatementContext ctx) {
		return getContextKey(ctx) + "key";
	}

	public static void replaceAllPlaceholdersInCodeWithValue(LlvmCodeGeneratorState state, String placeholder, String value) {
		int startIndexOfPlaceholder = state.getLlvmCode().indexOf(placeholder);
		while (startIndexOfPlaceholder != -1) {
			state.getLlvmCode().replace(startIndexOfPlaceholder, startIndexOfPlaceholder + placeholder.length(), value);
			startIndexOfPlaceholder = state.getLlvmCode().indexOf(placeholder);
		}
	}

	public static void replaceValueComparisonPlaceholders(LlvmCodeGeneratorState state, SimpleGrammarParser.ValueComparisonContext ctx) {
		final var valueComparisonPlaceholder = getContextKey(ctx);
		final var replacement = "%" + state.getContextToOperationWithResult().get(ctx);
		replaceAllPlaceholdersInCodeWithValue(state, valueComparisonPlaceholder, replacement);
	}
}
