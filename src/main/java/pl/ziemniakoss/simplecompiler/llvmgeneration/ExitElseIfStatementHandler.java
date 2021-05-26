package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getEndOfConditionalBlockKey;

public class ExitElseIfStatementHandler implements IExitContextHandler<SimpleGrammarParser.ElseIfStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ElseIfStatementContext ctx) {
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent + 1))
			.append("br label ")
			.append(getEndOfConditionalBlockKey((SimpleGrammarParser.ConditionalStatementContext) ctx.parent))
			.append("; end of else if block");

	}
}
