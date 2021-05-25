package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.Map;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.replaceAllPlaceholdersInCodeWithValue;

public class ExitFunDeclarationHandler implements IExitContextHandler<SimpleGrammarParser.FunDeclarationContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.FunDeclarationContext ctx) {
		state.nextOperationIndex = 1;
		state.getLlvmCode().append("\t".repeat(state.indent + 1))
			.append("ret")
			.append(ctx.type().IntType() != null ? " i32 0\n" : " double 0.0\n")
			.append("}\n\n");
		state.setCurrentlyDefinedFunctionReturnType(null);
//		state.getVariableContexts().pop();
		System.out.println("exit fun " + ctx.ID().toString());

		replaceAllPlaceholders(state, state.getLabelsStack().pop());
	}

	private void replaceAllPlaceholders(LlvmCodeGeneratorState state, Map<String, Integer> labelToOperation) {
		for(String label : labelToOperation.keySet()) {
			replaceAllPlaceholdersInCodeWithValue(state, label, "%" + labelToOperation.get(label));
		}
	}
}
