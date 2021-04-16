package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.Function;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.genererateLlvmCodeForFunctionCall;

public class ExitSimpleValueHandler implements IEnterContextHandler<SimpleGrammarParser.SimpleValueContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.SimpleValueContext ctx) {
		if (ctx.ID() != null) {
			var usedVariable = state.getVariable(ctx.ID().toString());
			if (usedVariable.isPointer()) {
				state.getLlvmCode().append('%')
					.append(state.nextOperationIndex)
					.append(" = load ")
					.append(usedVariable.getType().toString())
					.append(", ")
					.append(usedVariable.getType().toString())
					.append("* %")
					.append(usedVariable.getRegisterWithValue())
					.append('\n')
					.append("\t".repeat(state.indent));
				state.getContextToOperationWithResult().put(ctx, state.nextOperationIndex);
				state.getOperationIndexToStoredValueType().put(state.nextOperationIndex++, usedVariable.getType());

			} else {
				state.getContextToOperationWithResult().put(ctx, usedVariable.getRegisterWithValue());
			}
		} else if (ctx.Int() != null || ctx.Real() != null) {
			var variableType = ctx.Int() != null ? VariableType.INTEGER : VariableType.REAL;
			var valueAsString = ctx.Int() != null ? ctx.Int().getText() : ctx.Real().getText();
			state.getLlvmCode().append('%')
				.append(state.nextOperationIndex)
				.append(" = alloca ")
				.append(variableType.toString())
				.append("\n")
				.append("\t".repeat(state.indent));

			state.getLlvmCode().append("store ")
				.append(variableType.toString())
				.append(' ')
				.append(valueAsString)
				.append(", ").append(variableType.toString())
				.append("*  %")
				.append(state.nextOperationIndex)
				.append('\n')
				.append("\t".repeat(state.indent));

			state.getLlvmCode().append('%')
				.append(state.nextOperationIndex + 1)
				.append(" = load ")
				.append(variableType.toString())
				.append(", ")
				.append(variableType.toString())
				.append("* %")
				.append(state.nextOperationIndex)
				.append('\n')
				.append("\t".repeat(state.indent));
			state.getContextToOperationWithResult().put(ctx, ++state.nextOperationIndex);
			state.getOperationIndexToStoredValueType().put(state.nextOperationIndex++, variableType);
		} else {
			int operationWithFunctionCallResult = genererateLlvmCodeForFunctionCall(state, ctx.functionCall());
			state.getContextToOperationWithResult().put(ctx, operationWithFunctionCallResult);
			Function calledFunction = state.getFunctionNameToDefinition().get(ctx.functionCall().ID().toString());
			state.getOperationIndexToStoredValueType().put(operationWithFunctionCallResult, calledFunction.getReturnType());
		}
	}


}
