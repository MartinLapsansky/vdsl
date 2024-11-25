// Generated from C:/Users/Admin/Documents/skola/5r/vdsl/escape-room-spring/Escaperoom.g4 by ANTLR 4.13.2
package org.example.escaperoomspring.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EscaperoomParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EscaperoomVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#escaperoom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscaperoom(EscaperoomParser.EscaperoomContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#welcomeMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWelcomeMessage(EscaperoomParser.WelcomeMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#escapeMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscapeMessage(EscaperoomParser.EscapeMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#room}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoom(EscaperoomParser.RoomContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(EscaperoomParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#finalTask}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalTask(EscaperoomParser.FinalTaskContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#task}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTask(EscaperoomParser.TaskContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#taskDetails}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskDetails(EscaperoomParser.TaskDetailsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#successColors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuccessColors(EscaperoomParser.SuccessColorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(EscaperoomParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHint(EscaperoomParser.HintContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolution(EscaperoomParser.SolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#lightSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLightSequence(EscaperoomParser.LightSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link EscaperoomParser#successColor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuccessColor(EscaperoomParser.SuccessColorContext ctx);
}