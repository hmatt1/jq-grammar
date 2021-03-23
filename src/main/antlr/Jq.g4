grammar Jq;

exp
    :    term_list
    ;

term_list
    : (term)+
    ;

term
    : '.'
    | '.' STRING
    ;

STRING:
    VALID_CHAR+;

fragment VALID_CHAR
    : ('a' .. 'z') | ('A' .. 'Z') | '_' | ('0' .. '9')
    ;

NUMBER
    :    ('0'..'9')+ ('.' ('0'..'9')+)?
    ;

WS
    :   (' ' | '\t' | '\r'| '\n') -> skip
    ;