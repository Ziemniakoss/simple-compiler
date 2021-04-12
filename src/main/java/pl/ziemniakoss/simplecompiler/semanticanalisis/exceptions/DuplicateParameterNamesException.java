package pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions;

public class DuplicateParameterNamesException extends SemanticException{
	public DuplicateParameterNamesException(int line, int column, String message) {
		super(line, column, message);
	}
}
