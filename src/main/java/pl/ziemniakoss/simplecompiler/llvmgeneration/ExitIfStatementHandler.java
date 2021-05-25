package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getEndOfConditionalBlockKey;

public class ExitIfStatementHandler implements IExitContextHandler<SimpleGrammarParser.IfStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.IfStatementContext ctx) {
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent + 1))
			.append("br label ")
			.append(getEndOfConditionalBlockKey((SimpleGrammarParser.ConditionalStatementContext) ctx.parent))
			.append('\n')
		.append("; end of if block\n");
	}
}
