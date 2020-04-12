package controllers.bappeda;


import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WilayahController {

    @FXML
    void dashboardBtn(ActionEvent event) {
        Helper.changePage(event,"bappeda/Dashboard");
    }

    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }

}
