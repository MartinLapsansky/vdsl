package org.example.escaperoomspring.controllers;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.example.escaperoomspring.models.Task;
import org.example.escaperoomspring.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.escaperoomspring.models.FinalTask;

import java.util.List;

@RestController
@RequestMapping("/api/escape-room")
@CrossOrigin(origins = "http://localhost:3000")
public class EscapeRoomController {

    private final EscapeRoomBuild escapeRoomBuild;
    private final GameService gameService;

    @Autowired
    public EscapeRoomController(@Qualifier("customEscapeRoomBuild") EscapeRoomBuild escapeRoomBuild, GameService gameService) {
        this.escapeRoomBuild = escapeRoomBuild;
        this.gameService = gameService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return escapeRoomBuild.getCurrentRoom().getTasks();
    }

    @GetMapping("/final-task")
    public ResponseEntity<FinalTask> getFinalTask() {
        FinalTask finalTask = escapeRoomBuild.getFinalTask();
        if (finalTask != null) {
            return ResponseEntity.ok(finalTask);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
