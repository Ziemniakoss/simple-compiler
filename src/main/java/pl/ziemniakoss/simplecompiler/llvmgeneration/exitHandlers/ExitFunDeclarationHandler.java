package pl.ziemniakoss.simplecompiler.llvmgeneration.exitHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IExitContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

import java.util.Map;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.replaceAllPlaceholdersInCodeWithValue;

public class ExitFunDeclarationHandler implements IExitContextHandler<SimpleGrammarParser.FunDeclarationContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.FunDeclarationContext ctx) {
		state.nextOperationIndex = 1;
		state.newLineAndIdent().append('\t')
			.append("ret")
			.append(ctx.type().IntType() != null ? " i32 0\n" : " double 0.0\n")
			.append("}\n\n");
		state.setCurrentlyDefinedFunctionReturnType(null);

		replaceAllPlaceholders(state, state.getLabelsStack().pop());
	}

	private void replaceAllPlaceholders(LlvmCodeGeneratorState state, Map<String, Integer> labelToOperation) {
		for(String label : labelToOperation.keySet()) {
			replaceAllPlaceholdersInCodeWithValue(state, label, "%" + labelToOperation.get(label));
		}
	}
}
