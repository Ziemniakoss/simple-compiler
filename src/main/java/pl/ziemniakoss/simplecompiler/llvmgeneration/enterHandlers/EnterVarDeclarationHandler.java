package pl.ziemniakoss.simplecompiler.llvmgeneration.enterHandlers;

import pl.ziemniakoss.simplecompiler.Variable;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IEnterContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

public class EnterVarDeclarationHandler implements IEnterContextHandler<SimpleGrammarParser.VarDeclarationContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.VarDeclarationContext ctx) {
		var variableType = ctx.type();
		var variableName = ctx.ID().toString();
		if (state.isVariableDefined(variableName)) {
			throw new RuntimeException("Variable \"" + variableName + "\" already defined");
		}
		state.newLineAndIdent()
			.append('%')
			.append(state.nextOperationIndex)
			.append(" = alloca ")
			.append(variableType.IntType() != null ? "i32" : "double")
			.append('\n')
			.append("\t".repeat(state.indent));
		var currentContext = state.getVariableContexts().peek();
		currentContext.put(variableName, new Variable(
			variableType.IntType() != null ? VariableType.INTEGER : VariableType.REAL,
			variableName,
			state.nextOperationIndex++
		));
	}
}
