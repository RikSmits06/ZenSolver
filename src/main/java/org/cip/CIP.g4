grammar CIP;

knowledgeBase : statementLine* EOF;

statementLine : statement END_STATEMENT;

statement :
        VARIABLE 'in' expr    # assignStmt
    |   'var' VARIABLE        # declStmt;

expr :
      VARIABLE                      # variableExpr
    | INTEGER                       # integerExpr
    | '[' INTEGER ',' INTEGER ']'   # rangeExpr
    | '(' expr ')'                  # parenExpr
    | expr '*' expr                 # multExpr
    | expr ('+' | '-') expr         # addSubExpr;

INTEGER : '-'? DIGIT+;
VARIABLE : LOWER_LETTER (UPPER_LETTER | LOWER_LETTER)*;
LOWER_LETTER : [a-z];
UPPER_LETTER : [A-Z];
DIGIT : [0-9];
END_STATEMENT: '.';
WS: [ \t\r\n] -> skip;
COMMENT: '%' (~'%')* '%' -> skip;