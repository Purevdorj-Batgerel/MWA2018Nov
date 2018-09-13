package rulesets;

import Controllers.IController;

import java.awt.*;

public interface RuleSet {
    public void applyRules(IController ob) throws RuleException;
}
