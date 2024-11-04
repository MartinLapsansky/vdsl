package model;

public class Solution {
    private String correctAnswer;

    public Solution(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public boolean checkAnswer(String question, String answer) {
        return correctAnswer.equals(question) && answer.equals(correctAnswer);
    }

    public String getAnswer() {
        return correctAnswer;
    }
}
