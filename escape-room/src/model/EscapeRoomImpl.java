package model;

import Interfaces.EscapeRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class EscapeRoomImpl implements EscapeRoom {
    private String welcomeMessage;
    private String escapeMessage;
    private List<Room> rooms;
    private int currentRoomIndex;

    private GameInterpreter gameInterpreter;

    // Constructor
    public EscapeRoomImpl(EscapeRoomBuilder builder) {
        this.welcomeMessage = builder.welcomeMessage;
        this.escapeMessage = builder.escapeMessage;
        this.rooms = builder.rooms;
        this.currentRoomIndex = 0;
        this.gameInterpreter = new GameInterpreter(this);
    }

    @Override
    public EscapeRoom addRoom(Room room) {
        this.rooms.add(room);
        return this;
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

    public void play() {
        gameInterpreter.startGame();
    }

    public static class EscapeRoomBuilder {
        private String welcomeMessage;
        private String escapeMessage;
        private List<Room> rooms = new ArrayList<>();
        private RoomBuilder currentRoomBuilder;

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

        public EscapeRoomImpl build() {
            return new EscapeRoomImpl(this);
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

        public TaskBuilder addTask(int index, String name, String description, Task.taskType type, Solution solution, String taskDetails, String successColor) {
            currentTaskBuilder = new TaskBuilder(this, index, name, description, type, solution, taskDetails, successColor);
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

        public TaskBuilder(RoomBuilder parentRoomBuilder, int index, String name, String description, Task.taskType type, Solution solution, String taskDetails, String successColor) {
            this.parentRoomBuilder = parentRoomBuilder;
            this.task = new Task(index, name, description, type, solution, taskDetails, successColor);
        }

        public TaskBuilder addHint(String hintText) {
            task.addHint(new Hint(hintText)); // Create a new Hint from the provided text
            return this;
        }

        public TaskBuilder addLight(String lightColor) {
            task.addLight(lightColor);
            return this;
        }

        public RoomBuilder finishTask() {
            parentRoomBuilder.room.addTask(task);
            return parentRoomBuilder;
        }
    }

    private boolean validateColorSequence (List < String > expectedColors, String[]userColors){
        if (expectedColors.size() != userColors.length) {
            return false;
        }
        for (int i = 0; i < expectedColors.size(); i++) {
            if (!expectedColors.get(i).equalsIgnoreCase(userColors[i])) {
                return false;
            }
        }
        return true;
    }
}
