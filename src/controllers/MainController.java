package controllers;


import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text wrongPassword;

    @FXML
    void loginBtn(ActionEvent event) {
//        System.out.println("TES LOGIN BUTTON");
//        System.out.println("Pass : " + passwordField.getText());
//        System.out.println("Username : " + usernameField.getText());
            try {
                if (usernameField.getText().equals("litbang")&&passwordField.getText().equals("litbang")){
                    Helper.changePage(event,"BLPdashboard");
                }else{
                    wrongPassword.setText("*Username atau Password anda salah");
                }
            }catch (Exception e){
                System.out.println("Error gan");
            }
    }
}
