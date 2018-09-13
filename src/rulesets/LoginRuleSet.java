package rulesets;


import Controllers.IController;
import Controllers.LoginWindowController;

public class LoginRuleSet implements RuleSet {
    private LoginWindowController loginWindow;

    @Override
    public void applyRules(IController ob) throws RuleException {
        loginWindow = (LoginWindowController) ob;
        nonEmptyRule();
    }

    private void nonEmptyRule() throws RuleException {
        if (loginWindow.getUsernameValue().isEmpty() ||
                loginWindow.getPasswordValue().isEmpty()) {
            throw new RuleException("All fields must be non-empty!");
        }
    }
}
