package org.cip;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.exceptions.CombinedException;
import org.exceptions.InvalidConstraintException;
import org.exceptions.UnknownVariableException;
import org.knowledge_base.KnowledgeBase;
import org.variable.ValueRange;
import org.variable.Variable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CIPTreeListener implements CIPListener {
    private final KnowledgeBase knowledgeBase;
    private final List<String> errorMessages = new ArrayList<>();
    private final ParseTreeProperty<ValueRange> exprRange = new ParseTreeProperty<>();

    public CIPTreeListener(KnowledgeBase kb) {
        this.knowledgeBase = kb;
    }

    public void ensureNoErrors() throws CombinedException {
        if (!this.errorMessages.isEmpty()) {
            throw new CombinedException(this.errorMessages);
        }
    }

    @Override
    public void enterKnowledgeBase(CIPParser.KnowledgeBaseContext ctx) {

    }

    @Override
    public void exitKnowledgeBase(CIPParser.KnowledgeBaseContext ctx) {

    }

    @Override
    public void enterStatementLine(CIPParser.StatementLineContext ctx) {

    }

    @Override
    public void exitStatementLine(CIPParser.StatementLineContext ctx) {

    }

    @Override
    public void enterAssignStmt(CIPParser.AssignStmtContext ctx) {
    }

    @Override
    public void exitAssignStmt(CIPParser.AssignStmtContext ctx) {
        String name = ctx.VARIABLE().toString();
        ValueRange range = exprRange.get(ctx.expr());
        Variable variable = knowledgeBase.addVariable(name);
        try {
            variable.updateRange(range);
        } catch (InvalidConstraintException e) {
            errorMessages.add(e.getMessage());
        }

    }

    @Override
    public void enterDeclStmt(CIPParser.DeclStmtContext ctx) {

    }

    @Override
    public void exitDeclStmt(CIPParser.DeclStmtContext ctx) {
        String name = ctx.VARIABLE().toString();
        knowledgeBase.addVariable(name);
    }

    @Override
    public void enterVariableExpr(CIPParser.VariableExprContext ctx) {
    }

    @Override
    public void exitVariableExpr(CIPParser.VariableExprContext ctx) {
        try {
            Variable variable = knowledgeBase.getVariable(ctx.VARIABLE().toString());
            exprRange.put(ctx, variable.getRange());
        } catch (UnknownVariableException e) {
            errorMessages.add(e.getMessage());
        }
    }

    @Override
    public void enterAddSubExpr(CIPParser.AddSubExprContext ctx) {

    }

    @Override
    public void exitAddSubExpr(CIPParser.AddSubExprContext ctx) {
        ValueRange left = exprRange.get(ctx.expr(0));
        ValueRange right = exprRange.get(ctx.expr(1));
        ValueRange newRange = new ValueRange();

        if (left == null) {
            errorMessages.add("Left side (" + ctx.expr(0).toString() + ") of + or - does not have range yet.");
            return;
        }
        if (right == null) {
            errorMessages.add("Right side (" + ctx.expr(1).toString() + ") of + or - does not have range yet.");
            return;
        }

        try {
            newRange.updateMinConstraint(left.min());
            newRange.updateMaxConstraint(left.max());
        } catch (InvalidConstraintException e) {
            errorMessages.add(e.getMessage());
        }

        if (Objects.equals(ctx.children.get(1).toString(), "+")) {
            newRange.add(right);
        } else {
            newRange.sub(right);
        }

        exprRange.put(ctx, newRange);
    }

    @Override
    public void enterIntegerExpr(CIPParser.IntegerExprContext ctx) {

    }

    @Override
    public void exitIntegerExpr(CIPParser.IntegerExprContext ctx) {
        BigInteger value = new BigInteger(ctx.INTEGER().toString());
        ValueRange range = new ValueRange();
        try {
            range.updateMinConstraint(value);
            range.updateMaxConstraint(value);
        } catch (InvalidConstraintException e) {
            errorMessages.add(e.getMessage());
        }
        exprRange.put(ctx, range);
    }

    @Override
    public void enterParenExpr(CIPParser.ParenExprContext ctx) {

    }

    @Override
    public void exitParenExpr(CIPParser.ParenExprContext ctx) {
        exprRange.put(ctx, exprRange.get(ctx.expr()));
    }


    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }
}
