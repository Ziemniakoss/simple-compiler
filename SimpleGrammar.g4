grammar SimpleGrammar;

//program: command+;

instruction
	: var_declaration ';'
	| var_assigment ';'
	| fun_call ';';

var_declaration: type_declaration var_name '=' value;

var_assigment: var_name '=' value;

fun_declaration
	: 'fun' var_name '(' ')' code_block
	| 'fun' var_name '(' type_declaration var_name (',' type_declaration var_name)* ')' code_block;

type_declaration: 'integer' | 'real';

var_name: character+;

value
	: integer
	| real
	| var_name
	| fun_call
	| value aritmetic_operator value;

aritmetic_operator: '-' | '+' | '/' |'*';

integer : digit+;

real: integer '.' integer;


fun_call
	: var_name '(' ')'
	| var_name '(' value (',' value)* ')';

return_value: 'return_value' value? ;

code_block
	: '{' (instruction | return_value)* '}';

/*
 *
 * Fragmenty
 *
 */




terminator: ';';

l_bracket: '}';

r_bracket: '{';

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
	| 'z'
	| 'x';

digit
	: '0'
	| '1'
	| '2'
	| '3'
	| '4'
	| '5'
	| '6'
	| '7'
	| '8'
	| '9'
	| '0';

WS : [ \t\r\n]+ -> skip ;
