package pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions;

public class FunctionNotDeclaredException extends SemanticException {
	public FunctionNotDeclaredException(int line, int column, String message) {
		super(line, column, message);
	}
}
