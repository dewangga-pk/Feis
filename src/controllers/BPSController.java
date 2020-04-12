package controllers;

import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class BPSController {

    @FXML
    void konsumsiBtn(ActionEvent event) {
        Helper.changePage(event,"bps/Konsumsi");
    }
    @FXML
    void pendudukBtn(ActionEvent event) {
        Helper.changePage(event,"bps/Penduduk");
    }

    @FXML
    void pertanianBtn(ActionEvent event) {
        Helper.changePage(event,"bps/Pertanian");
    }
    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }


}
