package pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions;

public class InvalidMainDeclarationException extends SemanticException{
	public InvalidMainDeclarationException(int line, int column, String message) {
		super(line, column, message);
	}
}
