package semantics;

import builder.EscapeRoomBuild;
import model.FinalTask;
import model.Room;
import model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameInterpreter {
    private EscapeRoomBuild escapeRoom;

    public GameInterpreter(EscapeRoomBuild escapeRoom) {
        this.escapeRoom = escapeRoom;
    }

    public void startGame() {
        System.out.println(escapeRoom.getWelcomeMessage());
        List<String> overallSuccessColors = new ArrayList<>();

        while (escapeRoom.getCurrentRoomIndex() < escapeRoom.getRooms().size()) {
            Room currentRoom = escapeRoom.getRooms().get(escapeRoom.getCurrentRoomIndex());
            System.out.println("You are now in: " + currentRoom.getDescription());

            AtomicBoolean roomTimeExpired = new AtomicBoolean(false);
            AtomicBoolean completedRoom = new AtomicBoolean(false);
            int roomTimeLimit = currentRoom.getTimeLimit() * 1000; // Sekundy na milisekundy

            Thread timerThread = new Thread(() -> {
                try {
                    Thread.sleep(roomTimeLimit);
                    if (!completedRoom.get()) {
                        roomTimeExpired.set(true);
                        System.out.println("\nTime's up! You failed to escape the room.");
                    }
                } catch (InterruptedException _) {

                }
            });
            timerThread.start();

            for (Task task : currentRoom.getTasks()) {
                if (roomTimeExpired.get()) {
                    System.out.println("You could not complete all tasks in time. The game is over.");
                    break;
                }

                if (task == null) {
                    System.out.println("Error: Task is null");
                    continue;
                }

                boolean solved = false;
                task.startTask();

                System.out.println("Task Name: " + task.getName());
                System.out.println("Task Description: " + task.getDescription());
                System.out.println("Puzzle Details: " + task.getPuzzleDetails());

                while (!solved && !roomTimeExpired.get()) {
                    System.out.print("Enter your answer or type 'hint' for a hint: ");
                    Scanner scanner = new Scanner(System.in);
                    String userInput = scanner.nextLine().trim();

                    if (userInput.isEmpty() && !roomTimeExpired.get()) {
                        System.out.println("Please enter a valid answer or request a hint.");
                    } else if (userInput.equalsIgnoreCase("hint")) {
                        System.out.println("Hint: " + task.getHint());
                        currentRoom.incrementHintsTaken();
                    } else {
                        if (task.execute(userInput)) {
                            System.out.println("Correct! Moving to the next challenge...");
                            currentRoom.incrementSolvedTasks();
                            currentRoom.addSuccessColor(task.getSuccessColor());
                            solved = true;
                        } else {
                            System.out.println("Incorrect! Try again or ask for a hint.");
                        }
                    }
                }
                // Ak čas vypršal
                if (roomTimeExpired.get()) {
                    break;
                }
                if (roomTimeExpired.get()) {
                    System.out.println("You could not complete all tasks in time. The game is over.");
                    break; // Exit the main game loop
                } else {
                    completedRoom.set(true);
                }
            }
            // Vyhodnotenie výsledkov
            if (!roomTimeExpired.get() && currentRoom.areAllTasksSolved()) {
                completedRoom.set(true);
                overallSuccessColors.addAll(currentRoom.getSuccessColors());
                int roomScore = currentRoom.calculateScore();
                System.out.println("Your total score for this room is: " + roomScore);
                escapeRoom.incrementCurrentRoomIndex();
            }
            if (!roomTimeExpired.get() && currentRoom.areAllTasksSolved()) {
                timerThread.interrupt();
                //evaluateFinalChallenge(overallSuccessColors);
            }
        }
        FinalTask finalTask = new FinalTask(1,"Final Color Sequence Challenge", overallSuccessColors);
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
        if (finalTask.validate(userColors)) {
            System.out.println(escapeRoom.getEscapeMessage());

        } else {
            System.out.println("Incorrect color sequence. Better luck next time!");
        }
    }
}
