package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.generateCastingLlvmCode;

public class ExitVarDeclarationHandler implements IExitContextHandler<SimpleGrammarParser.VarDeclarationContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.VarDeclarationContext ctx) {
		int operationWithValueForVariable = state.getContextToOperationWithResult().get(ctx.value());
		var valueTypeForDeclaredVariable = state.getOperationIndexToStoredValueType().get(operationWithValueForVariable);
		String declaredVariableName = ctx.ID().toString();
		var declaredVariable = state.getVariable(declaredVariableName);
		if (valueTypeForDeclaredVariable != declaredVariable.getType()) {
			operationWithValueForVariable = generateCastingLlvmCode(state, operationWithValueForVariable, valueTypeForDeclaredVariable, declaredVariable.getType());

		}
		state.getLlvmCode().append("store ")
			.append(declaredVariable.getType().toString())
			.append(" %")
			.append(operationWithValueForVariable)
			.append(", ")
			.append(declaredVariable.getType().toString())
			.append("* %")
			.append(declaredVariable.getRegisterWithValue())
			.append('\n');
	}
}
