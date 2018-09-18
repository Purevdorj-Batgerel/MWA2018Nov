package rulesets;

import Controllers.AddMovieWindowController;
import Controllers.IController;

public class AddMovieRuleSet implements RuleSet {
    private AddMovieWindowController addMovieWindow;

    @Override
    public void applyRules(IController ob) throws RuleException {
        addMovieWindow = (AddMovieWindowController) ob;
        nonEmptyRule();
    }

    private void nonEmptyRule() throws RuleException {
        if (addMovieWindow.getDescriptionInput().isEmpty() ||
                addMovieWindow.getDirectorInput().isEmpty() ||
                addMovieWindow.getDurationInput().isEmpty() ||
                addMovieWindow.getTitleInput().isEmpty()
        ) {
            throw new RuleException("All fields must be non-empty!");
        }
    }
}
