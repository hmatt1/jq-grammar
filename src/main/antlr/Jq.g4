grammar Jq;

top
    : expd ('|' expd)* # vPipe
    | '[' expd ('|' expd)* ']' # vArrPipe
    | '(' expd ('|' expd)* ')' # vValuePipe
    ;

expd
    : value #vValue
    | term_list '[' exp? ':'? exp? ']' '?'? # vTermListFilter
    ;

json
   : '{' pair (',' pair)* '}'
   | '{' '}'
   ;

pair
    : term_list ':' value
    ;

arr
   : '[' value? (',' value)* ']'
   ;

value
   : json # vJson
   | arr # vArr
   | term_list # vTermList
   | keyword # vKeyword
   | function # vFunction
   ;


exp
    : term_list '?'
	| term_list '=' term_list
	| term_list 'or' term_list
	| term_list 'and' term_list
	| term_list '//' term_list
	| term_list '//=' term_list
	| term_list '|=' term_list
	| term_list '|' term_list
	| term_list ',' term_list
	| term_list '+' term_list
	| term_list '+=' term_list
	| '-' term_list
	| term_list '-' term_list
	| term_list '-=' term_list
	| term_list '*' term_list
	| term_list '*=' term_list
	| term_list '/' term_list
	| term_list '%' term_list
	| term_list '/=' term_list
	| term_list '%=' term_list
	| term_list '==' term_list
	| term_list '!=' term_list
	| term_list '<' term_list
	| term_list '>' term_list
	| term_list '<=' term_list
	| term_list '>=' term_list
	| term_list
    ;

term_list
    : '(' term_list_inner ')'
    | '[' term_list_inner ']'
    | term_list_inner
    ;

term_list_inner
    : (term) +
    ;

term
	: '.'
	| '..'
	| '.' FIELD
	| '.' FIELD '?'
	| '.' STRING
	| '.' STRING '?'
	| '[' ']'
	| '[' ']' '?'
	| NUMBER
    | STRING
    | FIELD
    | IDENT
	;

function
    : IDENT '(' args ')'
    ;

args
    : term_list (',' term_list)*
    ;

keyword
    : 'true'
    | 'false'
    | 'null'
    ;

IDENT
    : (VALID_IDENT_CHAR+ ':' ':')* VALID_IDENT_CHAR+
    ;

fragment VALID_IDENT_CHAR
    : ('a' .. 'z')
    | ('A' .. 'Z')
    | '_'
    | ('0' .. '9')
    ;

FIELD
    : VALID_CHAR+
    ;

fragment VALID_CHAR
    : ('a' .. 'z')
    | ('A' .. 'Z')
    | '_'
    | ('0' .. '9')
    | '\\.'
    ;


STRING
   : 'FORMAT'? '"' (ESC | SAFECODEPOINT)* '"'
   ;


fragment ESC
   : '\\' (["\\/bfnrt(] | UNICODE)
   ;
fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;
fragment HEX
   : [0-9a-fA-F]
   ;
fragment SAFECODEPOINT
   : ~ ["\\\u0000-\u001F]
   ;


NUMBER
   : '-'? INT ('.' [0-9] +)? EXP?
   ;


fragment INT
   : '0' | [1-9] [0-9]*
   ;

// no leading zeros

fragment EXP
   : [Ee] [+\-]? INT
   ;

// \- since - means "range" inside [...]

WS
    :   (' ' | '\t' | '\r'| '\n') -> skip
    ;

