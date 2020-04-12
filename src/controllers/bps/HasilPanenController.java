package controllers.bps;


import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HasilPanenController {

    @FXML
    void addBtn(ActionEvent event) {
        Helper.changePage(event,"bps/AddHasilPanen");
    }

    @FXML
    void dashboardBtn(ActionEvent event) {
        Helper.changePage(event,"bps/Dashboard");
    }

    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }

}
