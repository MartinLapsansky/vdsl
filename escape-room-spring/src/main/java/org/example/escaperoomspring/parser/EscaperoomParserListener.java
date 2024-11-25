package org.example.escaperoomspring.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.escaperoomspring.antlr4.*;
import org.example.escaperoomspring.builder.EscapeRoomBuild;

public class EscaperoomParserListener implements EscaperoomListener{
    private EscapeRoomBuild escapeRoom;

    public EscapeRoomBuild getEscapeRoom() {
        return escapeRoom;
    }

    @Override
    public void enterEscaperoom(EscaperoomParser.EscaperoomContext ctx) {

    }

    @Override
    public void exitEscaperoom(EscaperoomParser.EscaperoomContext ctx) {

    }

    @Override
    public void enterWelcomeMessage(EscaperoomParser.WelcomeMessageContext ctx) {

    }

    @Override
    public void exitWelcomeMessage(EscaperoomParser.WelcomeMessageContext ctx) {

    }

    @Override
    public void enterEscapeMessage(EscaperoomParser.EscapeMessageContext ctx) {

    }

    @Override
    public void exitEscapeMessage(EscaperoomParser.EscapeMessageContext ctx) {

    }

    @Override
    public void enterRoom(EscaperoomParser.RoomContext ctx) {

    }

    @Override
    public void exitRoom(EscaperoomParser.RoomContext ctx) {

    }

    @Override
    public void enterDescription(EscaperoomParser.DescriptionContext ctx) {

    }

    @Override
    public void exitDescription(EscaperoomParser.DescriptionContext ctx) {

    }

    @Override
    public void enterFinalTask(EscaperoomParser.FinalTaskContext ctx) {

    }

    @Override
    public void exitFinalTask(EscaperoomParser.FinalTaskContext ctx) {

    }

    @Override
    public void enterTask(EscaperoomParser.TaskContext ctx) {

    }

    @Override
    public void exitTask(EscaperoomParser.TaskContext ctx) {

    }

    @Override
    public void enterTaskDetails(EscaperoomParser.TaskDetailsContext ctx) {

    }

    @Override
    public void exitTaskDetails(EscaperoomParser.TaskDetailsContext ctx) {

    }

    @Override
    public void enterSuccessColors(EscaperoomParser.SuccessColorsContext ctx) {

    }

    @Override
    public void exitSuccessColors(EscaperoomParser.SuccessColorsContext ctx) {

    }

    @Override
    public void enterType(EscaperoomParser.TypeContext ctx) {

    }

    @Override
    public void exitType(EscaperoomParser.TypeContext ctx) {

    }

    @Override
    public void enterHint(EscaperoomParser.HintContext ctx) {

    }

    @Override
    public void exitHint(EscaperoomParser.HintContext ctx) {

    }

    @Override
    public void enterSolution(EscaperoomParser.SolutionContext ctx) {

    }

    @Override
    public void exitSolution(EscaperoomParser.SolutionContext ctx) {

    }

    @Override
    public void enterLightSequence(EscaperoomParser.LightSequenceContext ctx) {

    }

    @Override
    public void exitLightSequence(EscaperoomParser.LightSequenceContext ctx) {

    }

    @Override
    public void enterSuccessColor(EscaperoomParser.SuccessColorContext ctx) {

    }

    @Override
    public void exitSuccessColor(EscaperoomParser.SuccessColorContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
