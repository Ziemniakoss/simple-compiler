package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getStartOfWhileLoopLabel;

public class EnterWhileLoopHandler implements IEnterContextHandler<SimpleGrammarParser.WhileLoopContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.WhileLoopContext ctx) {
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent))
			.append("br label %")
			.append(state.nextOperationIndex)
			.append("\n")
			.append(state.nextOperationIndex)
			.append(":\n")
			.append("\t".repeat(state.indent));
		state.setLabel(getStartOfWhileLoopLabel(ctx), state.nextOperationIndex++);

	}
}
