import builder.EscapeRoomBuild;
import model.*;

public class Main {
    public static void main(String[] args) {
        EscapeRoomBuild escapeRoom = new EscapeRoomBuild.EscapeRoomBuilder()
                .setWelcomeMessage("Welcome to the mysterious escape room adventure!")
                .setEscapeMessage("You've successfully escaped the room!")
                .addRoom("Entrance Hall", "You are in a dark hall with ancient paintings on the wall.", 120)
                .addTask(1, "Find the Code", "Complete the sequence to unlock the door!", Task.taskType.LOGIC_PUZZLE, "The sequence is: 0, 1, 1, 2, 3, 5, 8, 13... What is the next number?", "Red")
                .addSolution("21")
                .addHint("The sequence is Fibonacci.")
                .finishTask()
                .addTask(2, "Light Memory Challenge", "Remember the light sequence carefully.", Task.taskType.LIGHT_PUZZLE, "Which of the color was displayed after the red?", "Green")
                .addLight("Red")
                .addLight("Orange")
                .addLight("Yellow")
                .addSolution("orange")
                .addHint("fruit similar to tangerine")
                .finishTask()
                .finishRoom()
                .build();

        escapeRoom.validate();
        escapeRoom.play();
    }
}
