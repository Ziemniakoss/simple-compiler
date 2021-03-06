package pl.ziemniakoss.simplecompiler.llvmgeneration.exitHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IExitContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getEndOfWhileLoopLabel;
import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getStartOfWhileLoopLabel;

public class ExitWhileLoopContextHandler implements IExitContextHandler<SimpleGrammarParser.WhileLoopContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.WhileLoopContext ctx) {
		state.newLineAndIdent().append('\t')
			.append("br label ")
			.append(getStartOfWhileLoopLabel(ctx))
			.append('\n')
			.append(state.nextOperationIndex)
			.append(":\n");
		var endingLabel = getEndOfWhileLoopLabel(ctx);
		LlvmCodeGenerationUtils.replaceAllPlaceholdersInCodeWithValue(state, endingLabel, "%" + state.nextOperationIndex++);
		LlvmCodeGenerationUtils.replaceAllPlaceholdersInCodeWithValue(state, getStartOfWhileLoopLabel(ctx), "%" + state.getLabel(getStartOfWhileLoopLabel(ctx)));
	}
}
