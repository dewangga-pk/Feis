package controllers.bps;


import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class KonsumsiController {

    @FXML
    void addBtn(ActionEvent event) {
        Helper.changePage(event,"bps/AddKonsumsi");
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
