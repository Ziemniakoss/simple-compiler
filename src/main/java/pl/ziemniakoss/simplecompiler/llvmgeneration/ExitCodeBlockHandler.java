package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

public class ExitCodeBlockHandler implements IExitContextHandler<SimpleGrammarParser.CodeBlockContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.CodeBlockContext ctx) {
		state.getLlvmCode().append("\t".repeat(Math.max(0, --state.indent)));
		state.getVariableContexts().pop();
	}
}
