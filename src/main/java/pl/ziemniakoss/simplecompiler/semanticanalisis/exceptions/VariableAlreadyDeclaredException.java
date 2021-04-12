package pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions;

public class VariableAlreadyDeclaredException extends SemanticException{
	public VariableAlreadyDeclaredException(int line, int column, String message) {
		super(line, column, message);
	}
}
