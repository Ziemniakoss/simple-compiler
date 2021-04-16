package pl.ziemniakoss.simplecompiler.llvmgeneration;

import org.antlr.v4.runtime.ParserRuleContext;

public interface IExitContextHandler<T extends ParserRuleContext> {
	void handle(LlvmCodeGeneratorState state, T ctx);
}
