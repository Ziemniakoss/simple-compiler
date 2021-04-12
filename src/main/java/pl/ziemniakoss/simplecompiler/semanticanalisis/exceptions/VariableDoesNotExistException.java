package pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions;

public class VariableDoesNotExistException extends SemanticException{
	public VariableDoesNotExistException(int line, int column, String message) {
		super(line, column, message);
	}
}
