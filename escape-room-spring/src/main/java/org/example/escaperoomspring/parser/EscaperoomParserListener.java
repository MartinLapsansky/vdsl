package org.example.escaperoomspring.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.escaperoomspring.antlr4.*;
import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.example.escaperoomspring.models.Task;

public class EscaperoomParserListener implements EscaperoomListener{

    private EscapeRoomBuild.EscapeRoomBuilder builder;

    public EscaperoomParserListener() {
        this.builder = new EscapeRoomBuild.EscapeRoomBuilder();
    }

    public EscapeRoomBuild getEscapeRoom() {
        return builder.build();
    }

    @Override
    public void enterEscaperoom(EscaperoomParser.EscaperoomContext ctx) {

    }

    @Override
    public void exitEscaperoom(EscaperoomParser.EscaperoomContext ctx) {

    }

    @Override
    public void enterWelcomeMessage(EscaperoomParser.WelcomeMessageContext ctx) {
        String welcomeMessage = ctx.STRING().getText().replaceAll("\"", ""); // Remove quotes
        builder.setWelcomeMessage(welcomeMessage);
    }

    @Override
    public void exitWelcomeMessage(EscaperoomParser.WelcomeMessageContext ctx) {

    }

    @Override
    public void enterEscapeMessage(EscaperoomParser.EscapeMessageContext ctx) {
        String escapeMessage = ctx.STRING().getText().replaceAll("\"", ""); // Remove quotes
        builder.setEscapeMessage(escapeMessage);
    }

    @Override
    public void exitEscapeMessage(EscaperoomParser.EscapeMessageContext ctx) {

    }

    @Override
    public void enterRoom(EscaperoomParser.RoomContext ctx) {

        //TODO:final task*/

        String name = ctx.name.getText().replaceAll("\"", "");
        String description = ctx.description().getText().replaceAll("description", "")
                                                        .replaceAll("\"", "");
        int timeLimit = Integer.parseInt(ctx.timeLimit.getText());

        EscapeRoomBuild.RoomBuilder roomBuilder = builder.addRoom(name, description, timeLimit);

        for (EscaperoomParser.TaskContext taskCtx : ctx.task()) {
            EscapeRoomBuild.TaskBuilder taskBuilder = roomBuilder.addTask(
                    Integer.parseInt(taskCtx.index.getText()),
                    taskCtx.name.getText(),
                    taskCtx.description().getText()
                                .replaceAll("description", "")
                                .replaceAll("\"", ""),
                    Task.taskType.valueOf(taskCtx.type().getText()),
                    taskCtx.taskDetails().getText()
                                .replaceAll("taskDetails", "")
                                .replaceAll("\"", ""),
                    taskCtx.successColor().getText()
                                .replaceAll("successColor", "")
                                .replaceAll("\"", "")
            );
            //System.out.println("sol: " +taskCtx.solution().getText().replaceAll("solution", "").replaceAll("\"", ""));
            //System.out.println("hint: " +taskCtx.hint().getText().replaceAll("hint", "").replaceAll("\"", ""));

            // Finish the task
            taskBuilder
                .addSolution(
                    taskCtx.solution().getText()
                        .replaceAll("solution", "")
                        .replaceAll("\"", "")
                )
                .addHint(
                    taskCtx.hint().getText()
                        .replaceAll("hint", "")
                        .replaceAll("\"", "")
                )
                .finishTask();
        }

        roomBuilder.finishRoom();
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
        /*currentHint = ctx.getText().replaceAll("\"", "");
        System.out.println("current hint: "+currentHint);*/
    }

    @Override
    public void exitHint(EscaperoomParser.HintContext ctx) {

    }

    @Override
    public void enterSolution(EscaperoomParser.SolutionContext ctx) {
       /* currentSolution = ctx.getText().replaceAll("\"", "");
        System.out.println("current sol: " + currentSolution);*/
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
