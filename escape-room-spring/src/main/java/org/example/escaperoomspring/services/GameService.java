package org.example.escaperoomspring.services;

import org.example.escaperoomspring.builder.EscapeRoomBuild;
import org.example.escaperoomspring.models.FinalTask;
import org.example.escaperoomspring.models.Room;
import org.example.escaperoomspring.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class GameService {
    public EscapeRoomBuild escapeRoom;

    public GameService(EscapeRoomBuild escapeRoom) {
        this.escapeRoom = escapeRoom;
    }

    public String startGame() {
        return escapeRoom.getWelcomeMessage();
    }

    public String enterRoom() {
        Room currentRoom = escapeRoom.getRooms().get(escapeRoom.getCurrentRoomIndex());
        return "You are now in: " + currentRoom.getDescription();
    }

    public String handleTask(Task task) {
        StringBuilder result = new StringBuilder();
        AtomicBoolean taskCompleted = new AtomicBoolean(false);
        Scanner scanner = new Scanner(System.in);

        result.append("Task Name: ").append(task.getName()).append("\n")
                .append("Task Description: ").append(task.getDescription()).append("\n")
                .append("Puzzle Details: ").append(task.getPuzzleDetails()).append("\n");

        while (!taskCompleted.get()) {
            result.append("\nEnter your answer or type 'hint' for a hint: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.isEmpty()) {
                result.append("Please enter a valid answer or request a hint.\n");
            } else if (userInput.equalsIgnoreCase("hint")) {
                result.append("Hint: ").append(task.getHint()).append("\n");
            } else {
                if (task.execute(userInput)) {
                    result.append("Correct! Moving to the next challenge...\n");
                    taskCompleted.set(true);
                } else {
                    result.append("Incorrect! Try again or ask for a hint.\n");
                }
            }
        }
        return result.toString();
    }

    public boolean isRoomComplete(Room room) {
        return room.areAllTasksSolved();
    }

    public void completeRoom(Room room) {
        escapeRoom.incrementCurrentRoomIndex();
    }

    public FinalTask prepareFinalTask(List<String> overallSuccessColors) {
        return new FinalTask(1, "Final Color Sequence Challenge", overallSuccessColors);
    }

    public boolean evaluateFinalChallenge(FinalTask finalTask, String[] userColors) {
        return finalTask.validate(userColors);
    }

    public int calculateRoomScore(Room room) {
        return room.calculateScore();
    }

    public boolean isGameOver() {
        return escapeRoom.getCurrentRoomIndex() >= escapeRoom.getRooms().size();
    }
}

