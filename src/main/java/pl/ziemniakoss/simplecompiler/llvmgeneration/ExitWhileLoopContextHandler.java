package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getEndOfWhileLoopLabel;
import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getStartOfWhileLoopLabel;

public class ExitWhileLoopContextHandler implements IExitContextHandler<SimpleGrammarParser.WhileLoopContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.WhileLoopContext ctx) {
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent + 1))
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
