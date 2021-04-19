package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.Function;
import pl.ziemniakoss.simplecompiler.Variable;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.HashMap;
import java.util.Map;

public class EnterFunDeclarationHandler implements IEnterContextHandler<SimpleGrammarParser.FunDeclarationContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.FunDeclarationContext ctx) {

		state.getLlvmCode().append("define dso_local ");
		if (ctx.type().IntType() != null) {
			state.getLlvmCode().append("i32 ");
			state.setCurrentlyDefinedFunctionReturnType(VariableType.INTEGER);
		} else {
			state.getLlvmCode().append("double ");
			state.setCurrentlyDefinedFunctionReturnType(VariableType.REAL);
		}
		state.getLlvmCode().append("@");
		state.getLlvmCode().append(ctx.ID().toString());
		state.getLlvmCode().append("(");
		Map<String, Variable> contextWithFunParameters = new HashMap<>();
		state.getVariableContexts().push(contextWithFunParameters);
		if (ctx.funParameters() == null || ctx.funParameters().funParameter() == null) {
			state.getLlvmCode().append(") {");
			state.nextOperationIndex = 1;
			return;
		}
		boolean isFirst = true;
		state.nextOperationIndex = 0;
		VariableType[] functionParametersTypes = new VariableType[ctx.funParameters() != null ? ctx.funParameters().funParameter().size() : 0];
		var functionParameters = ctx.funParameters().funParameter();
		for (int i = 0; i < functionParameters.size(); i++) {
			var parameter = functionParameters.get(i);
			var parameterAsVariable = new Variable(
				parameter.type().IntType() != null ? VariableType.INTEGER : VariableType.REAL,
				parameter.ID().toString(),
				state.nextOperationIndex++,
				false
			);
			functionParametersTypes[i] = parameterAsVariable.getType();
			state.getOperationIndexToStoredValueType().put(parameterAsVariable.getRegisterWithValue(), parameterAsVariable.getType());
			contextWithFunParameters.put(parameterAsVariable.getName(), parameterAsVariable);
			if (!isFirst) {
				state.getLlvmCode().append(", ");
			} else {
				isFirst = false;
			}
			state.getLlvmCode().append(parameterAsVariable.getType().toString())
				.append(" %")
				.append(parameterAsVariable.getRegisterWithValue());
		}
		state.getLlvmCode().append(") {");
		state.getFunctionNameToDefinition().put(ctx.ID().toString(), new Function(
			ctx.ID().toString(),
			ctx.type().IntType() != null ? VariableType.INTEGER : VariableType.REAL,
			functionParametersTypes
		));
		state.nextOperationIndex++;
	}

}
