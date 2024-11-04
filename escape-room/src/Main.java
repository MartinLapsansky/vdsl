import model.*;

public class Main {
    public static void main(String[] args) {
        EscapeRoomImpl escapeRoom = new EscapeRoomImpl.EscapeRoomBuilder()
                .setWelcomeMessage("Welcome to the mysterious escape room adventure!")
                .setEscapeMessage("You've successfully escaped the room!")
                .addRoom("Entrance Hall", "You are in a dark hall with ancient paintings on the wall.", 120)
                .addTask(1, "Find the Code", "Complete the sequence to unlock the door!", Task.taskType.LOGIC_PUZZLE, new Solution("21"), "The sequence is: 0, 1, 1, 2, 3, 5, 8, 13... What is the next number?", "Red")
                .addHint("The sequence is Fibonacci.")
                .finishTask()
                .addTask(2, "Light Memory Challenge", "Remember the light sequence carefully.", Task.taskType.LIGHT_PUZZLE, new Solution("yellow"), "Which of the colors was displayed third in order ", "Green")
                .addLight("Red")
                .addLight("Orange")
                .addLight("Yellow")
                .addHint("sun")
                .finishTask()
                .finishRoom()
                .build();
        escapeRoom.play();
    }
}
