package Controllers;

import Main.MainWindow;
import domain.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import rulesets.RuleException;
import rulesets.RuleSet;
import rulesets.RuleSetFactory;

public class LoginWindowController implements IController {
    @FXML
    private Text actionTarget;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public String getUsernameValue() {
        return username.getText();
    }

    public String getPasswordValue() {
        return password.getText();
    }

    @FXML
    public void handleSubmitButtonAction(ActionEvent event) {
        login();
    }


    private void login() {
        actionTarget.setText("");
        try {
            RuleSet rules = RuleSetFactory.getRuleSet(LoginWindowController.this);
            rules.applyRules(LoginWindowController.this);

            if (checkValid()) {
                MainWindow.changeScene("Main");
            } else {
                password.setText("");
                actionTarget.setText("authentication failed");
            }
        } catch (RuleException e) {
            actionTarget.setText(e.getMessage());
        }
    }

    private boolean checkValid() {
        Person user = new Person();
        if (user.login(username.getText(), password.getText())) {
            MainWindow.currentUser = user;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setData(String key, Object value) {

    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            login();
        }
    }
}
