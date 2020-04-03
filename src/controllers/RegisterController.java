package controllers;


import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RegisterController {

    @FXML
    void loginBtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }

}
