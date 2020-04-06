package controllers;


import com.jfoenix.controls.JFXCheckBox;
import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    private TextField noIndukText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField userNameText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private PasswordField passwordReText;

    @FXML
    private TextField namaLengkapText;

    @FXML
    private TextField noTelpText;

    @FXML
    private JFXCheckBox checkListRegister;

    @FXML
    void loginBtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }
    @FXML
    void resetBtn(ActionEvent event) {
        noIndukText.setText("");
        emailText.setText("");
        userNameText.setText("");
        passwordText.setText("");
        passwordReText.setText("");
        namaLengkapText.setText("");
        noTelpText.setText("");
        checkListRegister.setSelected(false);
    }
}
