package pl.ziemniakoss.simplecompiler.llvmgeneration.enterHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IEnterContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

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
