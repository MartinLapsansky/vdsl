package model;

import java.util.List;

public class FinalTask extends Task {
    private List<String> successColors;

    public FinalTask(int id, String description, List<String> successColors) {
        super(id, "Final Task", description, null, null, null, null);
        this.successColors = successColors;
    }

    public List<String> getSuccessColors() {
        return successColors;
    }

    // Method to validate the user's input
    public boolean validate(String[] userColors) {
        // Check if the userColors array length matches the successColors list size
        if (userColors.length != successColors.size()) {
            return false; // The sequences are not the same length
        }

        // Compare each color in the userColors with the successColors
        for (int i = 0; i < successColors.size(); i++) {
            if (!successColors.get(i).equalsIgnoreCase(userColors[i])) {
                return false; // A color does not match
            }
        }

        return true; // All colors match
    }
}
