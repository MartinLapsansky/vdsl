package org.example.escaperoomspring.controllers;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.example.escaperoomspring.services.MqttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/escape-room")
public class EscapeRoomController {

    private final EscapeRoomBuild escapeRoomBuild;
    private final MqttService mqttService;

    @Autowired
    public EscapeRoomController(EscapeRoomBuild escapeRoomBuild, MqttService mqttService) {
        this.escapeRoomBuild = escapeRoomBuild;
        this.mqttService = mqttService;
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return escapeRoomBuild.getWelcomeMessage();
    }

    @PostMapping("/play")
    public String playGame() throws MqttException, InterruptedException {
        escapeRoomBuild.play(mqttService);
        return "Game started!";
    }

    // other endpoints as needed, for example, to handle rooms, tasks, etc.
}
