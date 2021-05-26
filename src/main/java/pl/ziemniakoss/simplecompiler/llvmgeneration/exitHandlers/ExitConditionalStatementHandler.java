package pl.ziemniakoss.simplecompiler.llvmgeneration.exitHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IExitContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getEndOfConditionalBlockKey;
import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.replaceAllPlaceholdersInCodeWithValue;

public class ExitConditionalStatementHandler implements IExitContextHandler<SimpleGrammarParser.ConditionalStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ConditionalStatementContext ctx) {
		state.getLlvmCode().append('\n')
			.append(state.nextOperationIndex)
			.append(':');
		state.newLineAndIdent();
		var endingLabel = getEndOfConditionalBlockKey(ctx);

		replaceAllPlaceholdersInCodeWithValue(state, endingLabel, "%" + state.nextOperationIndex++);

	}
}
