grammar Jq;

eval
    :    Number
    ;

Number
    :    ('0'..'9')+ ('.' ('0'..'9')+)?
    ;

WS
    :   (' ' | '\t' | '\r'| '\n') -> skip
    ;