package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.generateCastingLlvmCode;

public class ExitReturnStatementHandler implements IExitContextHandler<SimpleGrammarParser.ReturnStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ReturnStatementContext ctx) {
		int operationWithReturnedValue = state.getContextToOperationWithResult().get(ctx.value());
		VariableType returnedType = state.getOperationIndexToStoredValueType().get(operationWithReturnedValue);
		if (returnedType != state.getCurrentlyDefinedFunctionReturnType()) {
			operationWithReturnedValue = generateCastingLlvmCode(state, operationWithReturnedValue, returnedType, state.getCurrentlyDefinedFunctionReturnType());
		}
		state.getLlvmCode().append("ret ")
			.append(state.getCurrentlyDefinedFunctionReturnType())
			.append(" %")
			.append(operationWithReturnedValue)
			.append('\n')
			.append("\t".repeat(state.indent))
			.append("unreachable")
			.append('\n');
		state.nextOperationIndex += 2;
	}
}
