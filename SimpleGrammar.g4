grammar SimpleGrammar;


prog: funDeclaration+ EOF;

type: IntType | RealType;

arithmeticOperator: Plus | Minus | Div | Mod | Mult;

valueComparison: value valueComparator value;

valueComparator: GreaterOrEqual | SmallerOrEqual | Smaller | Greater | Equal;

If: 'if';
Else: 'else';
ElseIf: 'elif';
GreaterOrEqual: '>=';
SmallerOrEqual: '<=';
Smaller: '<';
Greater: '>';
Equal: '==';
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
	| returnStatement
	| conditionalStatement;

conditionalStatement: ifStatement elseIfStatement* elseStatement?;

ifStatement: If LBracket valueComparison RBracket codeBlock;

elseStatement: Else codeBlock;

elseIfStatement: ElseIf LBracket valueComparison RBracket codeBlock;

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
	: simpleValue (simpleValue | arithmeticOperator)*;

functionCall: ID LBracket functionArguments RBracket;

functionArguments: (value (Comma value)*)?;

funParameters: funParameter (Comma funParameter)*;

funParameter: type ID;

funDeclaration: Fucntion type ID LBracket funParameters? RBracket codeBlock;

Int: Minus? Digit+;

Real: Minus? Digit+ '.' Digit+;

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