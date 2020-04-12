package controllers.bappeda;

import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CalculatorController {

    @FXML
    private Text userTitle;

    @FXML
    private Text menuID;

    @FXML
    void dashboardBtn(ActionEvent event) {
        Helper.changePage(event,"bappeda/Dashboard");
    }

    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }

}
