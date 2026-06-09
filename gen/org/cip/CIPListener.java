// Generated from /home/rik/ZenSolver/src/main/java/org/cip/CIP.g4 by ANTLR 4.13.2
package org.cip;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CIPParser}.
 */
public interface CIPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CIPParser#knowledgeBase}.
	 * @param ctx the parse tree
	 */
	void enterKnowledgeBase(CIPParser.KnowledgeBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CIPParser#knowledgeBase}.
	 * @param ctx the parse tree
	 */
	void exitKnowledgeBase(CIPParser.KnowledgeBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CIPParser#statementLine}.
	 * @param ctx the parse tree
	 */
	void enterStatementLine(CIPParser.StatementLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CIPParser#statementLine}.
	 * @param ctx the parse tree
	 */
	void exitStatementLine(CIPParser.StatementLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link CIPParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(CIPParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link CIPParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(CIPParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declStmt}
	 * labeled alternative in {@link CIPParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclStmt(CIPParser.DeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declStmt}
	 * labeled alternative in {@link CIPParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclStmt(CIPParser.DeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpr(CIPParser.VariableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpr(CIPParser.VariableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(CIPParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(CIPParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntegerExpr(CIPParser.IntegerExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntegerExpr(CIPParser.IntegerExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(CIPParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(CIPParser.ParenExprContext ctx);
}