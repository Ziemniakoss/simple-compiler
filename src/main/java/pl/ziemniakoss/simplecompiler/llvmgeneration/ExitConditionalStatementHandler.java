package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

public class ExitConditionalStatementHandler implements IExitContextHandler<SimpleGrammarParser.ConditionalStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ConditionalStatementContext ctx) {
		//TODO
	}
}
