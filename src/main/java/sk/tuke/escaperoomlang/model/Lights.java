package sk.tuke.escaperoomlang.model;

//Lights ->  Mode RowNumber Color;
public class Lights {

    private String mode;

    private int rowNumber;

    private String color;

    public Lights(String mode, int rowNumber, String color ){
        this.mode = mode;
        this.rowNumber = rowNumber;
        this.color = color;
    }

    public String getMode(){
        return mode;
    };

    public int getRowNumber(){
        return rowNumber;
    };

    public String getColor(){
        return color;
    };

    public void validate(){
        if (mode == null || mode.isEmpty())
            throw new RoomLanguageException("Lights must have a mode!");

        //check no of lightrows in openlab
        if (rowNumber <= 0 || rowNumber > 3)
            throw new RoomLanguageException("Number of a row must be between 1 and 3!");

        //check available colors
        if (color == null || color.isEmpty())
            throw new RoomLanguageException("Lights must have a color defined!");

    }
    
}
