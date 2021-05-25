package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getContextKey;
import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getEndOfConditionalBlockKey;

public class EnterIfStatementHandler implements IEnterContextHandler<SimpleGrammarParser.IfStatementContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.IfStatementContext ctx) {
		var parent = (SimpleGrammarParser.ConditionalStatementContext) ctx.parent;
		String jumpTOLabelIfConditionIsFalse;
		if(parent.elseIfStatement().size() > 0) {
			jumpTOLabelIfConditionIsFalse = getContextKey(parent.elseIfStatement(0));
		} else if(parent.elseStatement() != null) {
			jumpTOLabelIfConditionIsFalse = getContextKey(parent.elseStatement());
		} else {
			jumpTOLabelIfConditionIsFalse = getEndOfConditionalBlockKey(parent);
		}
		// jump

	}

}
