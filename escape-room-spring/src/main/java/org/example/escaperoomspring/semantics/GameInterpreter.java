package org.example.escaperoomspring.semantics;

import org.example.escaperoomspring.models.FinalTask;
import org.example.escaperoomspring.models.Room;
import org.example.escaperoomspring.models.Task;
import org.example.escaperoomspring.services.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInterpreter {
    private final GameService gameService;

    public GameInterpreter(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        System.out.println(gameService.startGame());
        List<String> overallSuccessColors = new ArrayList<>();

        System.out.println("is game over: "+gameService.isGameOver());
        while (!gameService.isGameOver()) {
            Room currentRoom = gameService.escapeRoom.getRooms().get(gameService.escapeRoom.getCurrentRoomIndex());
            //System.out.println("currentRoom: "+currentRoom);
            System.out.println(gameService.enterRoom());

            for (Task task : currentRoom.getTasks()) {
                //System.out.println("task name: "+task.getName());
                System.out.println(gameService.handleTask(task));
            }

            if (gameService.isRoomComplete(currentRoom)) {
                gameService.completeRoom(currentRoom);
                int roomScore = gameService.calculateRoomScore(currentRoom);
                System.out.println("Your total score for this room is: " + roomScore);
                overallSuccessColors.addAll(currentRoom.getSuccessColors());
            } else {
                System.out.println("You could not complete all tasks in time. The game is over.");
                break;
            }
        }

        FinalTask finalTask = gameService.prepareFinalTask(overallSuccessColors);
        evaluateFinalChallenge(finalTask);
    }

    private void evaluateFinalChallenge(FinalTask finalTask) {
        System.out.println("\nFinal Task: " + finalTask.getName());
        System.out.println("Description: " + finalTask.getDescription());
        System.out.println("Colors to Remember: " + finalTask.getSuccessColors());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sequence of colors, separated by spaces: ");
        String userInput = scanner.nextLine().trim();
        String[] userColors = userInput.split("\\s+");

        if (gameService.evaluateFinalChallenge(finalTask, userColors)) {
            System.out.println(gameService.escapeRoom.getEscapeMessage());
        } else {
            System.out.println("Incorrect color sequence. Better luck next time!");
        }
    }
}
