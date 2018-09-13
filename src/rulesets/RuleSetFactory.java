package rulesets;

import Controllers.IController;
import Controllers.LoginWindowController;

import java.util.HashMap;


final public class RuleSetFactory {
    static HashMap<Class<? extends IController>, RuleSet> map = new HashMap<>();

    static {
        map.put(LoginWindowController.class, new LoginRuleSet());
    }

    private RuleSetFactory() {
    }

    public static RuleSet getRuleSet(IController c) {
        Class<? extends IController> cl = c.getClass();
        if (!map.containsKey(cl)) {
            throw new IllegalArgumentException(
                    "No RuleSet found for this Component");
        }
        return map.get(cl);
    }
}
