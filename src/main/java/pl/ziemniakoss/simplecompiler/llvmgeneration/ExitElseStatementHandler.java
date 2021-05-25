package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

public class ExitElseStatementHandler implements IExitContextHandler<SimpleGrammarParser.ElseStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ElseStatementContext ctx) {
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent + 1))
			.append("br label ")
			.append(LlvmCodeGenerationUtils.getEndOfConditionalBlockKey((SimpleGrammarParser.ConditionalStatementContext) ctx.parent))
		.append('\n');
	}
}
