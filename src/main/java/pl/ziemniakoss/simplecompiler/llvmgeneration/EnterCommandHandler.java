package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

public class EnterCommandHandler implements IEnterContextHandler<SimpleGrammarParser.CommandContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.CommandContext ctx) {
		state.getLlvmCode().append("\t".repeat(state.indent));
	}
}
