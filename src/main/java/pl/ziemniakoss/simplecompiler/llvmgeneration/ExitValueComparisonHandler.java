package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.*;

public class ExitValueComparisonHandler implements IExitContextHandler<SimpleGrammarParser.ValueComparisonContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ValueComparisonContext ctx) {
		final var firstOperandContext = ctx.value(0);
		final var secondOperandContext = ctx.value(1);
		int firstOperandOperationNumber = state.getContextToOperationWithResult().get(firstOperandContext);
		int secondOperandOperationNumber = state.getContextToOperationWithResult().get(secondOperandContext);
		final var firstOperandVariableType = state.getOperationIndexToStoredValueType().get(firstOperandOperationNumber);
		final var secondOperandVariableType = state.getOperationIndexToStoredValueType().get(secondOperandOperationNumber);

		VariableType operationType;
		if (firstOperandVariableType == secondOperandVariableType) {
			operationType = firstOperandVariableType;
		} else if (firstOperandVariableType == VariableType.REAL || secondOperandVariableType == VariableType.REAL) {
			operationType = VariableType.REAL;
		} else {
			operationType = VariableType.INTEGER;
		}

		if (firstOperandVariableType != operationType) {
			firstOperandOperationNumber = generateCastingLlvmCode(state, firstOperandOperationNumber, firstOperandVariableType, operationType);
		}
		if (secondOperandVariableType != operationType) {
			secondOperandOperationNumber = generateCastingLlvmCode(state, secondOperandOperationNumber, secondOperandVariableType, operationType);
		}

		var comparisonType = getComparisonType(ctx.valueComparator());
		int resultOperationNumber = generateComparisonCode(
			state, comparisonType, operationType, firstOperandOperationNumber, secondOperandOperationNumber
		);
		state.getContextToOperationWithResult().put(ctx, resultOperationNumber);
		state.setLabel(getContextKey(ctx), resultOperationNumber);
	}

	private int generateComparisonCode(
		LlvmCodeGeneratorState state, ComparisonType comparisonType, VariableType variableType,
		int firstOperandOperationNumber, int secondOperandOperationNumber
	) {
		state.getLlvmCode()
			.append('\n')
			.append("\t".repeat(state.indent))
			.append('%')
			.append(state.nextOperationIndex)
			.append(" = ")
			.append(variableType == VariableType.INTEGER ? LlvmCodeGenerationUtils.INTEGER_COMPARISON_INSTRUCTION : REAL_COMPARISON_INSTRUCTION)
			.append(' ')
			.append(getLlvmComparisonTypeString(variableType, comparisonType))
			.append(' ')
			.append(variableType.toString())
			.append(" %")
			.append(firstOperandOperationNumber)
			.append(", %")
			.append(secondOperandOperationNumber);
		return  state.nextOperationIndex++;
	}
}
