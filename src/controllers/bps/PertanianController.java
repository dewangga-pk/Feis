package controllers.bps;


import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PertanianController {

    @FXML
    void dashboardBtn(ActionEvent event) {
        Helper.changePage(event,"bps/Dashboard");
    }

    @FXML
    void jumlahPanenBtn(ActionEvent event) {
        Helper.changePage(event,"bps/HasilPanen");
    }

    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }

    @FXML
    void luasLahanBtn(ActionEvent event) {
        Helper.changePage(event,"bps/LuasLahan");
    }

}
