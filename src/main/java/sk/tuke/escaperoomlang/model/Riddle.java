package sk.tuke.escaperoomlang.model;

//import java.util.Arrays;

public class Riddle { //Question Solution Hint Unlocks Clue Duration Lights

    private String title;

    private String question;

    private String solution;

    private String hint;

    private String unlocks;

    private String clue;

    private int duration;

    private Lights[] lights;

    public Riddle(String title, String question, String solution, String hint, String unlocks, String clue, int duration) {
        this.title = title;
        this.question = question;
        this.solution = solution;
        this.hint = hint;
        this.unlocks = unlocks;
        this.clue = clue;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public String getSolution() {
        return solution;
    }

    public String getHint() {
        return hint;
    }

    public String getUnlocks() {
        return unlocks;
    }

    public String getClue() {
        return clue;
    }

    public int getDuration() {
        return duration;
    }

    public Lights[] getLights() {
        return lights;
    }

    public void setLights(Lights[] lights) {
        this.lights = lights;
    }

    public void validate() {
        if (title == null || title.isEmpty())
            throw new RoomLanguageException("Place should have a name!");

        if (question == null || question.isEmpty())
            throw new RoomLanguageException("Place should have a description!");

        //TODO:call this after lights have a validate() func
        //Arrays.stream(lights).forEach(Riddle::validate);
    }
    
}
