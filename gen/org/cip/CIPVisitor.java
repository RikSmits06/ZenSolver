// Generated from /home/rik/ZenSolver/src/main/java/org/cip/CIP.g4 by ANTLR 4.13.2
package org.cip;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CIPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CIPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CIPParser#knowledgeBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnowledgeBase(CIPParser.KnowledgeBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CIPParser#statementLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementLine(CIPParser.StatementLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link CIPParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(CIPParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declStmt}
	 * labeled alternative in {@link CIPParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclStmt(CIPParser.DeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(CIPParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(CIPParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerExpr(CIPParser.IntegerExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link CIPParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(CIPParser.ParenExprContext ctx);
}