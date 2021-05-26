package pl.ziemniakoss.simplecompiler;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IEnterContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getContextKey;

public class EnterElseIfStatementHandler implements IEnterContextHandler<SimpleGrammarParser.ElseIfStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ElseIfStatementContext ctx) {
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent))
			.append(state.nextOperationIndex)
			.append(":\n")
			.append("\t".repeat(state.indent));
		state.setLabel(getContextKey(ctx), state.nextOperationIndex++);
	}
}
