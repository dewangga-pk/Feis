package controllers;


import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BappedaController {

    @FXML
    void calculatorBtn(ActionEvent event) {
        Helper.changePage(event,"bappeda/Calculator");
    }

    @FXML
    void dataWilayahBtn(ActionEvent event) {
        Helper.changePage(event,"bappeda/Wilayah");
    }

    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }

    @FXML
    void pemerataanBtn(ActionEvent event) {
        Helper.changePage(event,"bappeda/Pemerataan");
    }

    @FXML
    void tanamanPanganBtn(ActionEvent event) {
        Helper.changePage(event,"bappeda/Tanaman");
    }

}
