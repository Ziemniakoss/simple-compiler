package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

public class EnterElseStatementHandler implements IEnterContextHandler<SimpleGrammarParser.ElseStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ElseStatementContext ctx) {
		state.getLlvmCode().append('\n')
			.append("; begin else block")
			.append('\n')
			.append(state.nextOperationIndex)
			.append(":\n");
		state.setLabel(LlvmCodeGenerationUtils.getContextKey(ctx), state.nextOperationIndex++);

	}
}
