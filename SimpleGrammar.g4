grammar SimpleGrammar;

program: command+;

command
	: variable_assigment
	| conditional_statement
//	| function_declaration
	| variable_declaration
//	| function_call;
;
variable_assigment: variable_name '=' value ';';

variable_declaration: 'var' variable_name '=' value ';';

value
	: function_call
	| integer
	| real
	| variable_name
	| value aritmetic_operation value;

aritmetic_operation
	: '-'
	| '+'
	| '*'
	| '/'
	| '%';

variable_name : character+;

real
	: digit+ '.' digit+
	| '-' digit+ '.' digit+;

digit: '0' | '1' |'2' |'3' |'4'| '5'| '6' |'7' | '8' | '9' | '0';

integer
	: '-'? digit+;

function_call
	: variable_name '(' ')'
	| variable_name '(' value ')'
	| variable_name '(' value (',' value)+ ')';

function_declaration
	: 'fun' variable_name '(' function_parameters ')';


//TODO
function_parameters:;

conditional_statement
	: if_statement else_if_statement* else_statement?;

if_statement: 'if' value '{' command? '}';

else_if_statement: 'elif' value '{' command? '}';

else_statement: 'else' '{' command? '}';

code_block:;

character
	: 'a'
	| 'b'
	| 'c'
	| 'd'
	| 'e'
	| 'f'
	| 'g'
	| 'h'
	| 'i'
	| 'j'
	| 'k'
	| 'l'
	| 'm'
	| 'n'
	| 'o'
	| 'p'
	| 'r'
	| 's'
	| 't'
	| 'u'
	| 'w'
	| 'v'
	| 'y'
	| 'z';

WS : [ \t\r\n]+ -> skip ;
