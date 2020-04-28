package controllers;

import helpers.DataAccessObject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.Kota;

import java.net.URL;
import java.util.ResourceBundle;

public class KotaController implements Initializable {

    @FXML
    private TableView<Kota> table_ciity;

    @FXML
    private TableColumn<Kota, String> column_city;

    private String query;
    private DataAccessObject dao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dao = new DataAccessObject();
        refreshDataKota();
    }
    private void initTable(){
        column_city.setCellValueFactory(cell->cell.getValue().getkKota());
    }

    private void refreshDataKota(){
        initTable();
        query= "SELECT nama_kota FROM kota";
        table_ciity.setItems(dao.getDataKota(query));
    }
}
