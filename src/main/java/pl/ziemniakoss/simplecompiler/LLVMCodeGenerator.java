package pl.ziemniakoss.simplecompiler;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarBaseListener;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LLVMCodeGenerator extends SimpleGrammarBaseListener {
	private static final String ioLibraryCode =
			"@.str = private unnamed_addr constant [3 x i8] c\"%d \"\n" +
					"@.str.1 = private unnamed_addr constant [3 x i8] c\"%f \"\n" +
					"@.str.2 = private unnamed_addr constant [3 x i8] c\"%d \"\n" +
					"@.str.3 = private unnamed_addr constant [3 x i8] c\"%f \"\n" +

					"define dso_local i32 @readInt() #0 {\n" +
					"	%1 = alloca i32\n" +
					"	%2 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i32* %1)\n" +
					"	%3 = load i32, i32* %1\n" +
					"	ret i32 %3\n" +
					"}\n\n" +
					"declare dso_local i32 @__isoc99_scanf(i8*, ...) #1\n\n" +

					"define dso_local float @readFloat() #0 {\n" +
					"	%1 = alloca float\n" +
					"	%2 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.1, i64 0, i64 0), float* %1)\n" +
					"	%3 = load float, float* %1\n" +
					"	ret float %3\n" +
					"}\n\n" +
					"define dso_local i32 @writeInt(i32 %0) #0 {\n" +
					"	%2 = alloca i32\n" +
					"	store i32 %0, i32* %2\n" +
					"	%3 = load i32, i32* %2\n" +
					"	%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32 %3)\n" +
					"	ret i32 %4" +
					"}\n\n" +
					"declare dso_local i32 @printf(i8*, ...) #1\n" +
					"define dso_local i32 @writeReal(float %0) #0 {\n" +
					"	%2 = alloca float\n" +
					"	store float %0, float* %2\n" +
					"	%3 = load float, float* %2\n" +
					"	%4 = fpext float %3 to double\n" +
					"	%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.3, i64 0, i64 0), double %4)\n" +
					"	ret i32 %5\n" +
					"}\n\n";

	private final Map<String, Function> functionNameToDefinition;
	private final StringBuilder llvmCode = new StringBuilder(ioLibraryCode);
	private final Stack<Map<String, Variable>> contexts;
	private int instructionIndex = 1;
	private int indent = 0;
	private OperationResult lastOperationResult;


	public LLVMCodeGenerator() {
		this.functionNameToDefinition = new HashMap<>();
		functionNameToDefinition.put("readInt", new Function("readInt", VariableType.INTEGER, new VariableType[0]));
		functionNameToDefinition.put("readReal", new Function("readReal", VariableType.REAL, new VariableType[0]));

		functionNameToDefinition.put("write", null);
		functionNameToDefinition.put("writeInt", null);
		functionNameToDefinition.put("writeReal", null);

		this.contexts = new Stack<>();
	}

	public String getLlvmCode() {
		return llvmCode.toString();
	}

	@Override
	public void enterCommand(SimpleGrammarParser.CommandContext ctx) {
		llvmCode.append("\t".repeat(indent));
	}

	@Override
	public void exitCommand(SimpleGrammarParser.CommandContext ctx) {
		llvmCode.append("\n");
	}

	@Override
	public void enterCodeBlock(SimpleGrammarParser.CodeBlockContext ctx) {
		llvmCode.append("\t".repeat(indent++));
		if (isGlobalContext()) {
			llvmCode.append('{');
		}
		llvmCode.append('\n');
		contexts.push(new HashMap<>());
	}

	@Override
	public void exitCodeBlock(SimpleGrammarParser.CodeBlockContext ctx) {
		llvmCode.append("\t".repeat(--indent));
		contexts.pop();
		System.out.println("Yes " + isGlobalContext());
		if (isGlobalContext()) {
			llvmCode.append('}');
		}
		System.out.println(indent);
	}

	@Override
	public void exitReturnStatement(SimpleGrammarParser.ReturnStatementContext ctx) {
		llvmCode.append("ret ")
				.append(lastOperationResult.getType())
				.append(" %")
				.append(lastOperationResult.getOperationNumber());
	}

	@Override
	public void enterVarDeclaration(SimpleGrammarParser.VarDeclarationContext ctx) {
		var variableType = ctx.type();
		var variableName = ctx.ID().toString();
		if (isVariableDefined(variableName)) {
			throw new RuntimeException("Variable \"" + variableName + "\" already defined");
		}
		llvmCode.append('%')
				.append(instructionIndex++)
				.append(" = alloca ")
				.append(variableType.IntType() != null ? "i32" : "float");
		var currentContext = contexts.peek();
		currentContext.put(variableName, new Variable(
				variableType.IntType() != null ? VariableType.INTEGER : VariableType.REAL,
				variableName
		));
	}

	@Override
	public void enterVarAssigment(SimpleGrammarParser.VarAssigmentContext ctx) {
		super.enterVarAssigment(ctx);
	}

	@Override
	public void enterFunctionCall(SimpleGrammarParser.FunctionCallContext ctx) {
		super.enterFunctionCall(ctx);
	}

	@Override
	public void enterFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx) {
		llvmCode.append("define dso_local ");
		if (ctx.type().IntType() != null) {
			llvmCode.append("i32 ");
		} else {
			llvmCode.append("float ");
		}
		llvmCode.append("@");
		llvmCode.append(ctx.ID().toString());
		llvmCode.append("(");
		//TODO args
		llvmCode.append(") #0 ");
	}

	@Override
	public void exitFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx) {
		instructionIndex = 1;
		//TODO store value
	}

	@Override
	public String toString() {
		return getLlvmCode();
	}

	private boolean isVariableDefined(String variableName) {
		for (var context : contexts) {
			if (context.containsKey(variableName)) {
				return true;
			}
		}
		return false;
	}

	private Variable getVariable(String variableName) {
		for (var context : contexts) {
			if (context.containsKey((variableName))) {
				return context.get(variableName);
			}
		}
		return null;
	}

	private boolean isGlobalContext() {
		return contexts.size() == 0;
	}
}
