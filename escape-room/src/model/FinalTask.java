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
        if (userColors.length != successColors.size()) {
            return false;
        }

        for (int i = 0; i < successColors.size(); i++) {
            if (!successColors.get(i).equalsIgnoreCase(userColors[i])) {
                return false;
            }
        }

        return true; // All colors match
    }
}
