//package org.example.escaperoomspring;
//
//import org.antlr.v4.runtime.CharStreams;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;
//import org.antlr.v4.runtime.tree.ParseTreeWalker;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.example.escaperoomspring.antlr4.*;
//import org.example.escaperoomspring.builder.EscapeRoomBuild;
//import org.example.escaperoomspring.interfaces.MqttServiceInterface;
//import org.example.escaperoomspring.parser.EscaperoomParserListener;
//import org.example.escaperoomspring.semantics.GameInterpreter;
//import org.example.escaperoomspring.services.GameService;
//import org.example.escaperoomspring.services.MockMqttService;
//import org.example.escaperoomspring.services.MqttService;
//
//import java.io.IOException;
//
//public class MainExternal {
//
//    public static void main(String[] args) throws IOException, MqttException, InterruptedException {
//        MqttServiceInterface mqttService = new MockMqttService();
//
//        var lexer = new EscaperoomLexer(CharStreams.fromFileName("/Users/Lapso/IdeaProjects/vdsl/escape-room-spring/room.txt"));
//
//        var tokens = new CommonTokenStream(lexer);
//        var parser = new EscaperoomParser(tokens);
//        ParseTree tree = parser.escaperoom();
//        ParseTreeWalker treeWalker = new ParseTreeWalker();
//
//        var listener = new EscaperoomParserListener(mqttService);
//        treeWalker.walk(listener, tree);
//
//        EscapeRoomBuild escapeRoom = listener.getEscapeRoom();
//
//        escapeRoom.validate();
//
//        GameService escapeRoomService = new GameService(escapeRoom);
//        // TODO: figure out how to pass mqttService here
//        new GameInterpreter(escapeRoomService).startGame(mqttService);
//    }
//}