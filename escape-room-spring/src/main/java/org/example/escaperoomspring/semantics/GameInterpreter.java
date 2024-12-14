package org.example.escaperoomspring.semantics;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.escaperoomspring.interfaces.MqttServiceInterface;
import org.example.escaperoomspring.models.FinalTask;
import org.example.escaperoomspring.models.Room;
import org.example.escaperoomspring.models.Task;
import org.example.escaperoomspring.services.GameService;
import org.example.escaperoomspring.services.MockMqttService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameInterpreter {
    private final GameService gameService;

    public GameInterpreter(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame(MqttServiceInterface mqttService) throws MqttException, InterruptedException {
        mqttService.publishSingleLight("none");
        System.out.println(gameService.startGame());
        List<String> overallSuccessColors = new ArrayList<>();

        //System.out.println("is game over: "+gameService.isGameOver());
        while (!gameService.isGameOver()) {
            Room currentRoom = gameService.escapeRoom.getRooms().get(gameService.escapeRoom.getCurrentRoomIndex());
            //System.out.println("currentRoom: "+currentRoom);
            System.out.println(gameService.enterRoom());

            for (Task task : currentRoom.getTasks()) {
                System.out.println("task name: "+task.getName());
                currentRoom.addSuccessColor(task.getSuccessColor());
                System.out.println("task succ color: "+task.getSuccessColor());
                System.out.println(gameService.handleTask(task,"blue",mqttService));
            }

            if (gameService.isRoomComplete(currentRoom)) {
                gameService.completeRoom(currentRoom);
                int roomScore = gameService.calculateRoomScore(currentRoom);
                System.out.println("Your total score for this room is: " + roomScore);
                overallSuccessColors.addAll(currentRoom.getSuccessColors());
                //System.out.println(overallSuccessColors);
            } else {
                System.out.println("You could not complete all tasks in time. The game is over.");
                break;
            }
        }

        FinalTask finalTask = gameService.prepareFinalTask(overallSuccessColors);
        evaluateFinalChallenge(finalTask, mqttService);
    }

    private void evaluateFinalChallenge(FinalTask finalTask, MqttServiceInterface mqttService) throws MqttException {
        System.out.println("\nFinal Task: " + finalTask.getName());
        System.out.println("Description: " + finalTask.getDescription());
        //System.out.println("Colors to Remember: " + finalTask.getSuccessColors());

        Scanner scanner = new Scanner(System.in);
        mqttService.publishSingleLight("none");
        System.out.print("Enter the colors displayed after finishing each task, in order, separated by spaces: ");
        String userInput = scanner.nextLine().trim();
        String[] userColors = userInput.split("\\s+");
        //System.out.print("userColors: " + Arrays.toString(userColors));
        //System.out.print("finalTask: " + Arrays.toString(finalTask));

        if (gameService.evaluateFinalChallenge(finalTask, userColors)) {
            mqttService.publishSingleLight("win");
            System.out.println("\n" + gameService.escapeRoom.getEscapeMessage());
        } else {
            System.out.println("Incorrect color sequence. Better luck next time!");
        }
    }
}
