package org.example.escaperoomspring.builder;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.escaperoomspring.interfaces.EscapeRoom;
import org.example.escaperoomspring.interfaces.MqttServiceInterface;
import org.example.escaperoomspring.models.*;
import org.example.escaperoomspring.semantics.GameInterpreter;
import org.example.escaperoomspring.services.GameService;
import org.springframework.stereotype.Component;
import org.example.escaperoomspring.interfaces.MqttServiceInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class EscapeRoomBuild implements EscapeRoom {
    private final MqttServiceInterface mqttService;
    private String welcomeMessage;
    private String escapeMessage;
    private List<Room> rooms;
    private int currentRoomIndex;
    private  List<Task> tasks;

    private GameInterpreter gameInterpreter;
    public GameService gameService;

    public EscapeRoomBuild(EscapeRoomBuilder builder, MqttServiceInterface mqttService) {
        this.welcomeMessage = builder.welcomeMessage;
        this.escapeMessage = builder.escapeMessage;
        this.rooms = builder.rooms;
        this.tasks = builder.tasks;
        this.currentRoomIndex = 0;
        this.gameService = new GameService(this);
        this.gameInterpreter = new GameInterpreter(gameService);
        this.mqttService = mqttService;
    }

    @Override
    public EscapeRoom addRoom(Room room) {
        this.rooms.add(room);
        return this;
    }

    @Override
    public List<Task> getTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).setId(i);
        }
        return tasks;
    }

    public FinalTask getFinalTask() {
        List<String> successColors = new ArrayList<>();
        return new FinalTask(1, "Enter the colors displayed after finishing each task, in order, separated by spaces:", successColors);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Room getCurrentRoom() {
        return rooms.get(currentRoomIndex);
    }

    public int getCurrentRoomIndex() {
        return currentRoomIndex;
    }

    public void incrementCurrentRoomIndex() {
        this.currentRoomIndex++;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }
    public String getEscapeMessage() {
        return escapeMessage;
    }

    public void play(MqttServiceInterface mqttService) throws MqttException, InterruptedException {
        gameInterpreter.startGame(mqttService);
    }

    public String handleTask(Task task, String answer) throws MqttException, InterruptedException {
        return gameService.handleTask(task, answer, mqttService);
    }

    @Component
    public static class EscapeRoomBuilder {
        private final MqttServiceInterface mqttService;
        private String welcomeMessage;
        private String escapeMessage;
        private List<Room> rooms = new ArrayList<>();
        private RoomBuilder currentRoomBuilder;
        private List<Task> tasks = new ArrayList<>();

        public EscapeRoomBuilder(MqttServiceInterface mqttService) {
            this.mqttService = mqttService;
        }

        public EscapeRoomBuilder setWelcomeMessage(String welcomeMessage) {
            this.welcomeMessage = welcomeMessage;
            return this;
        }

        public EscapeRoomBuilder setEscapeMessage(String escapeMessage) {
            this.escapeMessage = escapeMessage;
            return this;
        }

        public RoomBuilder addRoom(String name, String description, int timeLimit) {
            currentRoomBuilder = new RoomBuilder(this, timeLimit, name, description);
            return currentRoomBuilder;
        }

        public EscapeRoomBuild build() {
            return new EscapeRoomBuild(this, mqttService);
        }
    }

    public static class RoomBuilder {
        private EscapeRoomBuilder parentBuilder;
        private Room room;
        private TaskBuilder currentTaskBuilder;

        public RoomBuilder(EscapeRoomBuilder parentBuilder, int timeLimit, String name, String description) {
            this.parentBuilder = parentBuilder;
            this.room = new Room(timeLimit, name, description);
        }
        public RoomBuilder setFinalTask(int id, String description, List<String> successColors) {
            FinalTask finalTask = new FinalTask(id, description, successColors);
            this.room.setFinalTask(finalTask);
            return this;
        }


        public TaskBuilder addTask(int index, String name, String description, Task.taskType type, String taskDetails, String successColor) {
            currentTaskBuilder = new TaskBuilder(this, index, name, description, type, taskDetails, successColor);
            //this.addTask();
            return currentTaskBuilder;
        }

        public EscapeRoomBuilder finishRoom() {
            parentBuilder.rooms.add(room);
            return parentBuilder;
        }
    }

    public static class TaskBuilder {
        private RoomBuilder parentRoomBuilder;
        private Task task;

        public TaskBuilder(RoomBuilder parentRoomBuilder, int index, String name, String description, Task.taskType type,String taskDetails, String successColor) {
            this.parentRoomBuilder = parentRoomBuilder;
            this.task = new Task(index, name, description, type, taskDetails, successColor);
        }

        public TaskBuilder addHint(String hintText) {
            task.addHint(new Hint(hintText)); // Create a new Hint from the provided text
            return this;
        }
        public TaskBuilder addSolution(String solutionText) {
            task.addSolution(new Solution(solutionText));
            return this;
        }

//        public TaskBuilder addLight(String lightColor) {
//            task.addLight(lightColor);
//            return this;
//        }

        public TaskBuilder lightColorSequence(String... colors) {
            for (String color : colors) {
                task.addLight(color);
            }
            return this;
        }


        public RoomBuilder finishTask() {
            parentRoomBuilder.room.addTask(task);
            return parentRoomBuilder;
        }
    }

    public void validate() {
        // Validate that each room has a unique and valid time limit
        for (Room room : rooms) {
            if (room.getTimeLimit() <= 0) {
                throw new IllegalArgumentException("Room '" + room.getName() + "' must have a positive time limit.");
            }

            // Validate that each task within the room has a unique and valid ID
            Set<Integer> taskIds = new HashSet<>();
            for (Task task : room.getTasks()) {
                if (task.getIndex() <= 0) {
                    throw new IllegalArgumentException("Task ID must be positive. Found invalid ID in task '" + task.getName() + "'.");
                }
                if (!taskIds.add(task.getIndex())) {
                    throw new IllegalArgumentException("Duplicate Task ID found in room '" + room.getName() + "'. Task ID: " + task.getIndex());
                }
                // Check for non-null and non-empty strings for task attributes
                if (task.getName() == null || task.getName().trim().isEmpty()) {
                    throw new IllegalArgumentException("Task name cannot be null or empty for task ID " + task.getIndex());
                }
                if (task.getDescription() == null || task.getDescription().trim().isEmpty()) {
                    throw new IllegalArgumentException("Task description cannot be null or empty for task '" + task.getName() + "'.");
                }
                if (task.getTaskDetails() == null || task.getTaskDetails().trim().isEmpty()) {
                    throw new IllegalArgumentException("Task details cannot be null or empty for task '" + task.getName() + "'.");
                }
            }
        }

    }
}
