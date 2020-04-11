package controllers;


import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BLPdashboardController {

    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }

}
