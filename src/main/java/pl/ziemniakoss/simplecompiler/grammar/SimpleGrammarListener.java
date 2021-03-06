// Generated from SimpleGrammar.g4 by ANTLR 4.9
package pl.ziemniakoss.simplecompiler.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleGrammarParser}.
 */
public interface SimpleGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpleGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpleGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpleGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpleGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperator(SimpleGrammarParser.ArithmeticOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperator(SimpleGrammarParser.ArithmeticOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#valueComparison}.
	 * @param ctx the parse tree
	 */
	void enterValueComparison(SimpleGrammarParser.ValueComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#valueComparison}.
	 * @param ctx the parse tree
	 */
	void exitValueComparison(SimpleGrammarParser.ValueComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#valueComparator}.
	 * @param ctx the parse tree
	 */
	void enterValueComparator(SimpleGrammarParser.ValueComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#valueComparator}.
	 * @param ctx the parse tree
	 */
	void exitValueComparator(SimpleGrammarParser.ValueComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(SimpleGrammarParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(SimpleGrammarParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(SimpleGrammarParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(SimpleGrammarParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(SimpleGrammarParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(SimpleGrammarParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SimpleGrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SimpleGrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(SimpleGrammarParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(SimpleGrammarParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(SimpleGrammarParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(SimpleGrammarParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(SimpleGrammarParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(SimpleGrammarParser.CodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SimpleGrammarParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SimpleGrammarParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(SimpleGrammarParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(SimpleGrammarParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#varAssigment}.
	 * @param ctx the parse tree
	 */
	void enterVarAssigment(SimpleGrammarParser.VarAssigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#varAssigment}.
	 * @param ctx the parse tree
	 */
	void exitVarAssigment(SimpleGrammarParser.VarAssigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#simpleValue}.
	 * @param ctx the parse tree
	 */
	void enterSimpleValue(SimpleGrammarParser.SimpleValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#simpleValue}.
	 * @param ctx the parse tree
	 */
	void exitSimpleValue(SimpleGrammarParser.SimpleValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SimpleGrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SimpleGrammarParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SimpleGrammarParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SimpleGrammarParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArguments(SimpleGrammarParser.FunctionArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArguments(SimpleGrammarParser.FunctionArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#funParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunParameters(SimpleGrammarParser.FunParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#funParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunParameters(SimpleGrammarParser.FunParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#funParameter}.
	 * @param ctx the parse tree
	 */
	void enterFunParameter(SimpleGrammarParser.FunParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#funParameter}.
	 * @param ctx the parse tree
	 */
	void exitFunParameter(SimpleGrammarParser.FunParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleGrammarParser#funDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleGrammarParser#funDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx);
}