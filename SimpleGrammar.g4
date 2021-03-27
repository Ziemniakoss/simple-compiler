grammar SimpleGrammar;

prog: funDeclaration+;

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
ArithmeticOperator: Plus | Minus | Div | Mod | Mult;


command
	: varDeclaration
	| varAssigment;

ID: ('a'..'z'|'A'..'Z')+;


varDeclaration: Variable Type ID Assigment value CommandTerminator;

varAssigment: ID Assigment value CommandTerminator;

value
	: simpleValue ArithmeticOperator value
	| simpleValue;

simpleValue
	: ID
	| functionCall
	| Int;


functionCall: ID LBracket functionArguments RBracket;

functionArguments: value (Comma value)*;

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