package org.example.escaperoomspring.controllers;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.example.escaperoomspring.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escape-room")
@CrossOrigin(origins = "http://localhost:3000")
public class EscapeRoomController {

    private final EscapeRoomBuild escapeRoomBuild;

    @Autowired
    public EscapeRoomController(@Qualifier("customEscapeRoomBuild") EscapeRoomBuild escapeRoomBuild) {
        this.escapeRoomBuild = escapeRoomBuild;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return escapeRoomBuild.getCurrentRoom().getTasks();
    }

    @PostMapping("/task/{taskId}/solve")
    public ResponseEntity<?> solveTask(@PathVariable int taskId, @RequestBody String answer) throws MqttException, InterruptedException {
        List<Task> tasks = escapeRoomBuild.getCurrentRoom().getTasks();

        if (taskId < 0 || taskId >= tasks.size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task with id " + taskId + " not found");
        }

        Task task = tasks.get(taskId);
        String result = escapeRoomBuild.handleTask(task, answer);


        if ("solved".equals(result)) {
            escapeRoomBuild.getCurrentRoom().incrementSolvedTasks();
            int nextTaskIndex = escapeRoomBuild.getCurrentRoom().getCurrentTasksIndex();
            if (nextTaskIndex < tasks.size()) {
                return ResponseEntity.ok(tasks.get(nextTaskIndex)); // Return the next task
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("All tasks completed!");
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect answer, try again.");
    }
}
