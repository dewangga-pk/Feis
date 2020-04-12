package controllers;

import com.sun.tools.javac.Main;
import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddController{
    @FXML
    private Text userTitle;
    @FXML
    private Text menuID;
    @FXML
    void dashboardBtn(ActionEvent event) {
        Helper.changePage(event,checkUser()+"Dashboard");
    }

    @FXML
    void cancelBtn(ActionEvent event) {
        System.out.println(checkMenuID());
        Helper.changePage(event,checkUser()+checkMenuID());
    }

    @FXML
    void cancelBtnPertanian1(ActionEvent event) {
        Helper.changePage(event,checkUser()+"HasilPanen");
    }
    @FXML
    void cancelBtnPertanian2(ActionEvent event) {
        Helper.changePage(event,checkUser()+"LuasLahan");
    }

    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }


    public String checkUser(){
        String path;
        if(userTitle.getText().equals("Badan Litbang Pertanian"))path="litbang/";
        else if(userTitle.getText().equals("Badan Pusat Statistik"))path="bps/";
        else path="bappeda/";
        return path;
    }
    public String checkMenuID(){
        String path=null;
        try{
            path=menuID.getText();
        }catch (Exception e){
            path="Dashboard";
        }
        return path;
    }
}
