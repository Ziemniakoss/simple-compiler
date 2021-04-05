grammar SimpleGrammar;


prog: funDeclaration+;

type: IntType | RealType;

ArithmeticOperator: Plus | Minus | Div | Mod | Mult;
If: 'if';
Else: 'else';
ElseIf: 'elIf';
Fucntion: 'fun';
Variable: 'var';
LCurly: '{';
RCurly: '}';
LBracket: '(';
RBracket: ')';
IntType: 'int';
RealType: 'real';
CommandTerminator: ';';
While: 'while';
Return: 'return';
Plus: '+';
Minus: '-';
Div: '/';
Mod: '%';
Mult: '*';
Comma: ',';
Assigment: '=';


command
	: varDeclaration
	| varAssigment
	| functionCall CommandTerminator
	| returnStatement;

codeBlock: LCurly (command|codeBlock)* RCurly;

ID: ('a'..'z'|'A'..'Z')+;

returnStatement: Return value CommandTerminator;

varDeclaration: Variable type ID Assigment value CommandTerminator;

varAssigment: ID Assigment value CommandTerminator;


simpleValue
	: ID
	| functionCall
	| Int
	| Real;

value
	: simpleValue (ArithmeticOperator value)?;

functionCall: ID LBracket functionArguments RBracket;

functionArguments: (value (Comma value)*)?;

funParameter: type ID;

funDeclaration: Fucntion type ID LBracket (funParameter (Comma funParameter)*)? RBracket codeBlock;

Int: Digit+;

Real: Digit+ '.' Digit+;

fragment
Digit: '0'..'9';

fragment
Char: ('a'..'z'|'A'..'Z');

fragment
NewLine:	'\r'? '\n'
;

WS:   (' '|'\t' | '\n')+ -> skip
;

LineComment: '//' ~[\r\n]* -> skip;

MultiLineComment: '/*' .*? '*/' -> skip;