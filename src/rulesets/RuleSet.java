package rulesets;

import Controllers.IController;

public interface RuleSet {
    public void applyRules(IController ob) throws RuleException;
}
