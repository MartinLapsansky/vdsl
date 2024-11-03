package sk.tuke.escaperoomlang.model;

import java.util.Arrays;

//Visualisation -> Title Message Lights Duration;
public class Visualisation{

    private String title;

    private String message;

    private Lights[] lights;

    private int duration;

    public Visualisation(String title, String message, Lights[] lights, int duration){
        this.title = title;
        this.message = message;
        this.lights = lights;
        this.duration = duration;
    }

    public String getTitle(){
        return title;
    };

    public String getMessage(){
        return message;
    };

    public Lights[] getLights(){
        return lights;
    };

    public int getDuration(){
        return duration;
    };

    public void validate() {
        if (title == null || title.isEmpty())
            throw new RoomLanguageException("Visualisation should have a title!");

        if (message == null || message.isEmpty())
            throw new RoomLanguageException("Visualisation should have a message for the player!");

        if (lights == null || lights.length == 0)
            throw new RoomLanguageException("Define at least one light for the visualisation!");

        for (Lights light : lights) {
            if (!light.getMode().equals("all") && lights.length > 1) {
                throw new RoomLanguageException("Only one light can be defined for 'all' lights mode!");
            }
        }

        if (duration == 0 || duration < 0)
            throw new RoomLanguageException("Define a positive, non-zero duration for the visualisation!");

        Arrays.stream(lights).forEach(Lights::validate);

    }

}