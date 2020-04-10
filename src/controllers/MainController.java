package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginBtn(ActionEvent event) {
        System.out.println("TES LOGIN BUTTON");
        System.out.println("Pass : " + passwordField.getText());
        System.out.println("Username : " + usernameField.getText());
    }
}
