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
        /* Build abstract syntax tree/graph from a sentence */
        //var lexer = new GameLexer(CharStreams.fromFileName("game1.game"));
        var lexer = new EscaperoomLexer(CharStreams.fromFileName("room.txt"));

        var tokens = new CommonTokenStream(lexer);
        var parser = new EscaperoomParser(tokens);
        ParseTree tree = parser.escaperoom();
        ParseTreeWalker treeWalker = new ParseTreeWalker();

        var listener = new EscaperoomParserListener();
        treeWalker.walk(listener, tree);

        //var escapeRoom = listener.getEscapeRoom();
        EscapeRoomBuild escapeRoom = listener.getEscapeRoom();

        /* Validate a game model. */
        escapeRoom.validate();

        /* Generate an output or interpret a game. */
        /*try (var writer = new FileWriter("src/main/java/Game.java", Charset.forName("utf-8"))) {
            var generator = new GameGeneratorVelocity();
            generator.generate(game, writer);
        }*/

        GameService escapeRoomService = new GameService(escapeRoom);
        //new GameInterpreter(escapeRoom).startGame();
        new GameInterpreter(escapeRoomService).startGame();
    }
}
