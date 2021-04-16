package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.HashMap;

public class EnterCodeBlockHandler implements IEnterContextHandler<SimpleGrammarParser.CodeBlockContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.CodeBlockContext ctx) {
		state.getLlvmCode().append("\t".repeat(state.indent++));
		if (state.isGlobalContext()) {//todo move to exitDunDeclaration
			state.getLlvmCode().append('{');
		}
		state.getLlvmCode().append('\n');
		state.getVariableContexts().push(new HashMap<>());

	}
}
