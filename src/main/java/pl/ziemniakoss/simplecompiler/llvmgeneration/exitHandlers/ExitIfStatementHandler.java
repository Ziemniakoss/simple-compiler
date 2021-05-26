package pl.ziemniakoss.simplecompiler.llvmgeneration.exitHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IExitContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getEndOfConditionalBlockKey;

public class ExitIfStatementHandler implements IExitContextHandler<SimpleGrammarParser.IfStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.IfStatementContext ctx) {
		state.newLineAndIdent().append('\t')
			.append("br label ")
			.append(getEndOfConditionalBlockKey((SimpleGrammarParser.ConditionalStatementContext) ctx.parent))
			.append('\n')
			.append("; end of if block\n");
	}
}
