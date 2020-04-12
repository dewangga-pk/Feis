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
            try {
                if (usernameField.getText().equals("litbang")&&passwordField.getText().equals("litbang")){
                    Helper.changePage(event,"/litbang/Dashboard");
                }else if(usernameField.getText().equals("bps")&&passwordField.getText().equals("bps")){
                    Helper.changePage(event,"/bps/Dashboard");
                }
                else{
                    wrongPassword.setText("*Username atau Password anda salah");
                }
            }catch (Exception e){
                System.out.println("Error gan");
            }
    }
}
