grammar CIP;

knowledgeBase : statementLine*;

statementLine : statement END_STATEMENT;
statement :
        VARIABLE 'in' expr    # assignStmt
    |   VARIABLE              # declStmt;

expr :
      VARIABLE              # variableExpr
    | INTEGER               # integerExpr
    | '(' expr ')'          # parenExpr
    | expr ('+' | '-') expr # addSubExpr;

INTEGER : '-'? DIGIT+;
VARIABLE : LOWER_LETTER (UPPER_LETTER | LOWER_LETTER)*;
LOWER_LETTER : [a-z];
UPPER_LETTER : [a-z];
DIGIT : [0-9];
END_STATEMENT: '.';
WS: [ \t\r\n] -> skip;