package pl.ziemniakoss.simplecompiler.llvmgeneration;

import org.antlr.v4.runtime.ParserRuleContext;

public interface IEnterContextHandler <T extends ParserRuleContext> {
	void handle(LlvmCodeGeneratorState state, T ctx);
}