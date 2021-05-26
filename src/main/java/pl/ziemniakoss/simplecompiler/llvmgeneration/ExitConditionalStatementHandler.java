package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getEndOfConditionalBlockKey;
import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.replaceAllPlaceholdersInCodeWithValue;

public class ExitConditionalStatementHandler implements IExitContextHandler<SimpleGrammarParser.ConditionalStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ConditionalStatementContext ctx) {
		state.getLlvmCode().append('\n')
			.append(state.nextOperationIndex)
			.append(":\n")
			.append("\t".repeat(state.indent));
		var endingLabel = getEndOfConditionalBlockKey(ctx);

		replaceAllPlaceholdersInCodeWithValue(state, endingLabel, "%" + state.nextOperationIndex++);

	}
}
