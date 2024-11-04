package model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int  timeLimit;
    private String name;
    private String description;
    private List<Task> tasks;
    private int solvedTasksCount;
    private int hintsTaken;
    private List<String> successColors;

    // Constructor
    public Room(int timeLimit, String name, String description) {
        this.timeLimit = timeLimit;
        this.name = name;
        this.description = description;
        this.tasks = new ArrayList<>();
        this.solvedTasksCount = 0;
        this.hintsTaken = 0;
        this.successColors = new ArrayList<>();
    }

    // Method to add a task (returns this for method chaining)
    public Room addTask(Task task) {
        this.tasks.add(task);
        return this;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    public int getTimeLimit() {
        return timeLimit;
    }
    public void incrementSolvedTasks() {
        solvedTasksCount++;
    }

    public void incrementHintsTaken() {
        hintsTaken++;
    }
    public void addSuccessColor(String color) {
        if (color != null && !color.isEmpty()) {
            successColors.add(color);
        }
    }
    public List<String> getSuccessColors() {
        return successColors;
    }
    public boolean areAllTasksSolved() {
        return solvedTasksCount == tasks.size();
    }

    public int calculateScore() {
        int totalAttempts = tasks.stream().mapToInt(Task::getAttempts).sum();
        int score = (solvedTasksCount * 100) - (hintsTaken * 10) - (totalAttempts * 10);
        return Math.max(score, 0);
    }

}
