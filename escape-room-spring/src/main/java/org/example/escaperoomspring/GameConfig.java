// src/main/java/org/example/escaperoomspring/config/GameConfig.java
package org.example.escaperoomspring;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.escaperoomspring.antlr4.EscaperoomLexer;
import org.example.escaperoomspring.antlr4.EscaperoomParser;
import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.example.escaperoomspring.parser.EscaperoomParserListener;
import org.example.escaperoomspring.services.MockMqttService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GameConfig {

    @Bean(name = "customEscapeRoomBuild")
    public EscapeRoomBuild escapeRoomBuild() throws IOException, MqttException {
        var lexer = new EscaperoomLexer(CharStreams.fromFileName("/Users/Lapso/IdeaProjects/vdsl/escape-room-spring/room.txt"));
        var tokens = new CommonTokenStream(lexer);
        var parser = new EscaperoomParser(tokens);
        ParseTree tree = parser.escaperoom();
        ParseTreeWalker treeWalker = new ParseTreeWalker();

        var listener = new EscaperoomParserListener(new MockMqttService());
        treeWalker.walk(listener, tree);

        EscapeRoomBuild escapeRoom = listener.getEscapeRoom();
        escapeRoom.validate();

        return escapeRoom;
    }
}