package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.generateCastingLlvmCode;

public class ExitVarAssigmentHandler implements IExitContextHandler<SimpleGrammarParser.VarAssigmentContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.VarAssigmentContext ctx) {
		int operationWithValue = state.getContextToOperationWithResult().get(ctx.value());
		var assignedValueType = state.getOperationIndexToStoredValueType().get(operationWithValue);
		var variableName = ctx.ID().toString();
		var variable = state.getVariable(variableName);
		if (variable.getType() != assignedValueType) {
			operationWithValue = generateCastingLlvmCode(state, operationWithValue, assignedValueType, variable.getType());
		}
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent))
			.append("store ")
			.append(variable.getType())
			.append(" %")
			.append(operationWithValue)
			.append(", ")
			.append(variable.getType())
			.append("* %")
			.append(variable.getRegisterWithValue())
			.append('\n');
	}
}
