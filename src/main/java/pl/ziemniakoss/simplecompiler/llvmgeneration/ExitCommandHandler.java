package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.genererateLlvmCodeForFunctionCall;

public class ExitCommandHandler implements IExitContextHandler<SimpleGrammarParser.CommandContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.CommandContext ctx) {
		if (ctx.functionCall() != null) {
			genererateLlvmCodeForFunctionCall(state, ctx.functionCall());
		}
		state.getLlvmCode().append("\n");
	}
}
