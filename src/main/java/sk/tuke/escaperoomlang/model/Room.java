//import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

public class Room {
    
    private String title;

    private String intro;

    private Riddle begin;

    private Riddle[] riddles;

    private Riddle mainRiddle;

    private Puzzle[] puzzles;

    private Visualisation[] visualisation;

    public Room(String title, String intro, Riddle begin, Riddle[] riddles, Riddle mainRiddle, Puzzle[] puzzles, Visualisation[] visualisation){
        this.title = title;
        this.intro = intro;
        this.begin = begin;
        this.riddles = riddles;
        this.mainRiddle = mainRiddle;
        this.puzzles = puzzles;
        this.visualisation = visualisation;
    }

    public String getTitle(){
        return title;
    };

    public String getIntro(){
        return intro;
    };

    public Riddle getBegin(){
        return begin;
    };

    public Riddle[] getRiddles(){
        return riddles;
    };

    public Riddle getMainRiddle(){
        return mainRiddle;
    };

    public Puzzle[] getPuzzles(){
        return puzzles;
    };

    public Visualisation[] getVisualisation(){
        return visualisation;
    }

    public void validate() {
        if (title == null || title.isEmpty())
            throw new RoomLanguageException("Room should have a title!");

        if (intro == null || intro.isEmpty())
            throw new RoomLanguageException("Room should have an intro!");

        if (begin == null)
            throw new RoomLanguageException("Escape room begin point is undefined!");

        if (riddles == null || riddles.length == 0)
            throw new RoomLanguageException("Define at least one riddle for the escape room!");

        if (mainRiddle == null)
            throw new RoomLanguageException("Define precisely one main riddle for the escape room!");

        //pridat, ak by boli puzzle+
        //if (puzzles == null || places.length == 0)
            //throw new RoomLanguageException("Game should have at least one place!");

        Arrays.stream(riddles).forEach(Riddle::validate);
        //TODO:call for puzzles too, after theyre implemented
        //Arrays.stream(puzzles).forEach(Puzzle::validate);

        //Implemented sophisticated domain validation, e.g.
        // - Could we reach surely the final item?
        // - Are there unreachable places in a game?
    }

}
