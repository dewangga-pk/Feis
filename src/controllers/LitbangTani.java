package controllers;


import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LitbangTani {
    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }
    @FXML
    void addBtn(ActionEvent event) {
        Helper.changePage(event,"litbang/Add");
    }

}
