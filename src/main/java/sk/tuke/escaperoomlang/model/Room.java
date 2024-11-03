package sk.tuke.escaperoomlang.model;

//import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

//Room -> Title Intro Riddle Riddle Riddle+ Puzzle* Visualisation+ TerminationCondition;
public class Room {
    
    private String title;

    private String intro;

    private Riddle begin;

    private Riddle[] riddles;

    private Riddle mainRiddle;

    private Puzzle[] puzzles;

    private Visualisation[] visualisations;

    private TerminationCondition terminationCondition;

    public Room(String title, String intro, Riddle begin, Riddle[] riddles, Riddle mainRiddle, Puzzle[] puzzles, Visualisation[] visualisations, TerminationCondition terminationCondition){
        this.title = title;
        this.intro = intro;
        this.begin = begin;
        this.riddles = riddles;
        this.mainRiddle = mainRiddle;
        this.puzzles = puzzles;
        this.visualisations = visualisations;
        this.terminationCondition = terminationCondition;
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
        return visualisations;
    }

    public TerminationCondition getTerminationCondition(){
        return terminationCondition;
    };

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

        if (visualisations == null || visualisations.length == 0)
            throw new RoomLanguageException("Define at least one visualisation for the escape room!");

        if (terminationCondition == null)
            throw new RoomLanguageException("The escape room must have a termination condition!");

        Arrays.stream(riddles).forEach(Riddle::validate);
        Arrays.stream(puzzles).forEach(Puzzle::validate);
        Arrays.stream(visualisations).forEach(Visualisation::validate);
        terminationCondition.validate();

        //Implemented sophisticated domain validation, e.g.
        // - Could we reach surely the final item?
        // - Are there unreachable places in a game?
    }

}
