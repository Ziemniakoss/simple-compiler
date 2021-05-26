package pl.ziemniakoss.simplecompiler.llvmgeneration.enterHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IEnterContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getStartOfWhileLoopLabel;

public class EnterWhileLoopHandler implements IEnterContextHandler<SimpleGrammarParser.WhileLoopContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.WhileLoopContext ctx) {
		state.newLineAndIdent()
			.append("br label %")
			.append(state.nextOperationIndex)
			.append("\n")
			.append(state.nextOperationIndex)
			.append(":\n")
			.append("\t".repeat(state.indent));
		state.setLabel(getStartOfWhileLoopLabel(ctx), state.nextOperationIndex++);

	}
}
