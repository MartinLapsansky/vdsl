package org.example.escaperoomspring;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.example.escaperoomspring.antlr4.*;
import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.example.escaperoomspring.parser.EscaperoomParserListener;
import org.example.escaperoomspring.semantics.GameInterpreter;
import org.example.escaperoomspring.services.GameService;

import java.io.IOException;

public class MainExternal {
    public static void main(String[] args) throws IOException {
        var lexer = new EscaperoomLexer(CharStreams.fromFileName("room.txt"));

        var tokens = new CommonTokenStream(lexer);
        var parser = new EscaperoomParser(tokens);
        ParseTree tree = parser.escaperoom();
        ParseTreeWalker treeWalker = new ParseTreeWalker();

        var listener = new EscaperoomParserListener();
        treeWalker.walk(listener, tree);

        EscapeRoomBuild escapeRoom = listener.getEscapeRoom();

        escapeRoom.validate();

        GameService escapeRoomService = new GameService(escapeRoom);
        new GameInterpreter(escapeRoomService).startGame();
    }
}
