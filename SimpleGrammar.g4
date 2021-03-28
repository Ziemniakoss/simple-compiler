grammar SimpleGrammar;

prog: funDeclaration+;


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
CommandTerminator: ';';
While: 'while';
Return: 'return';
Type: 'int' | 'real';
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

ID: ('a'..'z'|'A'..'Z')+;

returnStatement: Return value CommandTerminator;

varDeclaration: Variable Type ID Assigment value CommandTerminator;

varAssigment: ID Assigment value CommandTerminator;


simpleValue
	: ID
	| functionCall
	| Int;

value
	: simpleValue (ArithmeticOperator value)?;

functionCall: ID LBracket functionArguments RBracket;

functionArguments: (value (Comma value)*)?;

funParameter: Type ID;

funDeclaration: Fucntion Type ID LBracket (funParameter (Comma funParameter)*)? RBracket LCurly command* RCurly;

Int: Digit+;

fragment
Digit: '0'..'9';

fragment
Char: ('a'..'z'|'A'..'Z');

fragment
NewLine:	'\r'? '\n'
;

WS:   (' '|'\t' | '\n')+ -> skip
;