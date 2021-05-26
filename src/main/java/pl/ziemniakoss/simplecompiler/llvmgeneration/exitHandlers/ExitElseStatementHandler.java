package pl.ziemniakoss.simplecompiler.llvmgeneration.exitHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IExitContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

public class ExitElseStatementHandler implements IExitContextHandler<SimpleGrammarParser.ElseStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ElseStatementContext ctx) {
		state.newLineAndIdent()
			.append("br label ")
			.append(LlvmCodeGenerationUtils.getEndOfConditionalBlockKey((SimpleGrammarParser.ConditionalStatementContext) ctx.parent))
			.append('\n');
	}
}
