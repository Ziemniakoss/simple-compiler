package pl.ziemniakoss.simplecompiler.llvmgeneration.enterHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IEnterContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

public class EnterCommandHandler implements IEnterContextHandler<SimpleGrammarParser.CommandContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.CommandContext ctx) {
		state.newLineAndIdent();
	}
}
