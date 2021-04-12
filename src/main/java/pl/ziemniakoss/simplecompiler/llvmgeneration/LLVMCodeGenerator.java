package pl.ziemniakoss.simplecompiler.llvmgeneration;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.ziemniakoss.simplecompiler.Function;
import pl.ziemniakoss.simplecompiler.Variable;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarBaseListener;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LLVMCodeGenerator extends SimpleGrammarBaseListener {
	private final Map<String, Function> functionNameToDefinition;
	private final StringBuilder llvmCode = new StringBuilder();
	private final Stack<Map<String, Variable>> contexts;
	private int instructionIndex = 1;
	private int indent = 0;
	private final Map<SimpleGrammarParser.ValueContext, Integer> valueTokenToOperationWithValue = new HashMap<>();
	private final Map<SimpleGrammarParser.SimpleValueContext, Integer> simpleValueTokenToOperationWithValue = new HashMap<>();
	private final Map<Integer, VariableType> operationIndexToStoredValueType = new HashMap<>();
	private final ParseTree parseTree;

	public LLVMCodeGenerator(ParseTree parseTree) {
		this.functionNameToDefinition = new HashMap<>();
		functionNameToDefinition.put("readInt", new Function("readInt", VariableType.INTEGER, new VariableType[0]));
		functionNameToDefinition.put("readReal", new Function("readReal", VariableType.REAL, new VariableType[0]));

		functionNameToDefinition.put("write", null);
		functionNameToDefinition.put("writeInt", null);
		functionNameToDefinition.put("writeReal", null);
		this.parseTree = parseTree;
		this.contexts = new Stack<>();
	}

	public String getLlvmCode() {
		return llvmCode.toString();
	}

	public void generateLlvmCode() throws IOException {
		loadIoLibrary();
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.parseTree);
	}

	private void loadIoLibrary() throws IOException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream ioLibraryStream = classloader.getResourceAsStream("ioLibrary.ll");
		if (ioLibraryStream == null) {
			throw new RuntimeException("Could not load simple language IO library");
		}

		BufferedReader ioLibraryReader = new BufferedReader(new InputStreamReader(ioLibraryStream));
		for (String line; (line = ioLibraryReader.readLine()) != null; ) {
			llvmCode.append(line)
					.append('\n');
		}
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
	}

	@Override
	public void exitReturnStatement(SimpleGrammarParser.ReturnStatementContext ctx) {
		//llvmCode.append("ret ")
		//		.append(lastOperationResult.getType())
		//		.append(" %")
		//		.append(lastOperationResult.getOperationNumber());
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
	public void enterFunctionCall(SimpleGrammarParser.FunctionCallContext ctx) {
		super.enterFunctionCall(ctx);
	}

	@Override
	public void exitSimpleValue(SimpleGrammarParser.SimpleValueContext ctx) {
		if (ctx.Int() != null) {

		} else if (ctx.Real() != null) {

		} else if (ctx.ID() != null) {

		}
		super.exitSimpleValue(ctx);
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
		llvmCode.append("\t".repeat(indent + 1))
				.append("ret")
				.append(ctx.type().IntType() != null ? " i32 0\n" : " float 0.0\n")
				.append("}\n\n");
	}

	@Override
	public void enterValue(SimpleGrammarParser.ValueContext ctx) {
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
