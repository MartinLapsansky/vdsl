package org.example.escaperoomspring.controllers;

import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/escape-room")
public class EscapeRoomController {

    private final EscapeRoomBuild escapeRoomBuild;

    @Autowired
    public EscapeRoomController(EscapeRoomBuild escapeRoomBuild) {
        this.escapeRoomBuild = escapeRoomBuild;
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return escapeRoomBuild.getWelcomeMessage();
    }

    @PostMapping("/play")
    public String playGame() {
        escapeRoomBuild.play();
        return "Game started!";
    }

    // other endpoints as needed, for example, to handle rooms, tasks, etc.
}
