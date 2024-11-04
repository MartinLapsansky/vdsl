package model;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private int index; // Index for the task
    private String name;
    private String description;
    private taskType type;
    private List<Hint> hints;
    private Solution solution;
    private String taskDetails;
    private int attempts;
    private long startTime;
    boolean isSolved;
    private List<String> lightSequence;
    private String successColor;

    public boolean isSolved() {
        return isSolved;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public enum taskType {
        LOGIC_PUZZLE,
        VOICE_PUZZLE,
        CODE_PUZZLE,
        LIGHT_PUZZLE,
        RIDDLE_PUZZLE
    }

    public Task(int index, String name, String description, taskType type, Solution solution, String taskDetails, String successColor) {
        this.index = index; // Initialize the index
        this.name = name;
        this.description = description;
        this.type = type;
        this.solution = solution;
        this.hints = new ArrayList<>();
        this.taskDetails = taskDetails;
        this.successColor = successColor;
        this.attempts = 0;
        this.isSolved = false;

        if (type == taskType.LIGHT_PUZZLE) {
            this.lightSequence = new ArrayList<>();
        }
    }

    public Task addLight(String lightColor) {
        if (this.type == taskType.LIGHT_PUZZLE && this.lightSequence != null) {
            this.lightSequence.add(lightColor);
        }
        return this;
    }

    public List<String> getLightSequence() {
        return lightSequence;
    }
    public String getSuccessColor() {
        return successColor;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public String getPuzzleDetails() {
        return taskDetails;
    }

    public String getName() {
        return name;
    }
    public int getAttempts() { // Added getter for attempts
        return attempts;
    }

    public int getIndex() {
        return index;
    }

    public Task addHint(Hint hint) {
        hints.add(hint);
        return this;
    }

    public void startTask() {
        this.startTime = System.currentTimeMillis();
        this.attempts = 0;
        this.isSolved = false;
    }

    public String getHint() {
        if (!hints.isEmpty()) {
            return hints.get(0).getHintText();
        }
        return "No hints available.";
    }

    public boolean execute(String userAnswer) {
        boolean result = false;

        if (this.type == taskType.LOGIC_PUZZLE) {
            result = executeLogicPuzzle(userAnswer);
        }
        if (this.type == taskType.LIGHT_PUZZLE) {
            result = executeLightPuzzle(userAnswer);
        }
        if (result) {
            this.isSolved = true;
        }
        else {
            this.isSolved = false;
            attempts++;
        }
        return result;
    }

    private boolean executeLogicPuzzle(String userAnswer) {
        return userAnswer.equals(this.solution.getAnswer());
    }

    private boolean executeLightPuzzle(String userAnswer) {
        return userAnswer.equals(this.solution.getAnswer());
    }

    private boolean executeCodePuzzle(String userAnswer) {
        return userAnswer.equals(this.solution.getAnswer());
    }
}
