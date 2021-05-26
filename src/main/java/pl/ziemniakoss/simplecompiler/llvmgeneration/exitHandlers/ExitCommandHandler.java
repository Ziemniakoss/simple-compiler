package pl.ziemniakoss.simplecompiler.llvmgeneration.exitHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IExitContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.genererateLlvmCodeForFunctionCall;

public class ExitCommandHandler implements IExitContextHandler<SimpleGrammarParser.CommandContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.CommandContext ctx) {
		if (ctx.functionCall() != null) {
			genererateLlvmCodeForFunctionCall(state, ctx.functionCall());
		}
	}
}
