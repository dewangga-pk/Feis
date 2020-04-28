package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import helpers.DBConnection;
import helpers.DataAccessObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Data;
import models.Kota;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableTestController implements Initializable {

    @FXML
    private AnchorPane updatePane;

    @FXML
    private TableView<Data> dataTable;

    @FXML
    private TableColumn<Data, String> column_nama;

    @FXML
    private TableColumn<Data, String> column_email;

    @FXML
    private TableColumn<Data, String> column_jenisKelamin;

    @FXML
    private TableColumn<Data, String> column_kota;

    @FXML
    private TableColumn<Data, Integer> column_id;

    @FXML
    private TableColumn<Data, String> col_date;

    @FXML
    private JFXButton btn_submit;

    @FXML
    private TextField name_field;

    @FXML
    private TextField email_field;

    @FXML
    private JFXButton btn_listCity;

    @FXML
    private JFXComboBox<String> combo_city;
    @FXML
    private JFXComboBox<String> combo_gender;

    @FXML
    private JFXButton btn_edit;

    @FXML
    private JFXButton btn_delete;

    @FXML
    private JFXButton btn_update;

    private final String agender[] = {"Laki-Laki","Perempuan"};
    private FXMLLoader loader;
    private String query,nama,email,gender,idKota;
    private DataAccessObject dao;
    private int ID;
    private boolean updateMenu = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updatePane.setVisible(updateMenu);
        initGender();
        dao = new DataAccessObject();
        btn_listCity.setOnAction(e->{
            showCity();
        });
        combo_city.setOnMouseClicked(e->{
            initCity();
        });
        btn_submit.setOnAction(e->{
            insertNewTest();
        });
        btn_edit.setOnAction(e->{
            editTest();
        });
        btn_update.setOnAction(e->{
            updateTest();
        });
        btn_delete.setOnAction(e->{
            deleteTest();
        });

        initCity();
        combo_gender.getSelectionModel().clearSelection();
        combo_city.getSelectionModel().clearSelection();

        refreshTableTest();
    }

    private void initTableTest(){
        column_nama.setCellValueFactory(cell->cell.getValue().getdNama());
        column_email.setCellValueFactory(cell->cell.getValue().getdEmail());
        column_jenisKelamin.setCellValueFactory(cell->cell.getValue().getdJenisKelamin());
        column_kota.setCellValueFactory(cell->cell.getValue().getdKota());
        column_id.setCellValueFactory(cell->cell.getValue().getdId().asObject());
        col_date.setCellValueFactory(cell->cell.getValue().getdDate());
    }
    private void refreshTableTest(){
        initTableTest();
        query ="SELECT d.id,d.nama,d.email,d.jenis_kelamin,k.nama_kota,d.Terakhir_Update FROM data as d JOIN kota as k ON d.id_kota=k.id ORDER by d.nama";
        dataTable.setItems(dao.getData(query));
    }

    private void initCity(){
        combo_city.getSelectionModel().clearSelection();
        query = "SELECT nama_kota FROM kota";
        combo_city.setItems(dao.getDataKotaCombobox(query));
    }

    private void showCity(){
        try{
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/Kota.fxml"));
            loader.load();
            Scene scene = new Scene(loader.getRoot());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initGender(){
        List<String> list = new ArrayList<String>();

        for (String content:agender){
            list.add(content);
        }
        ObservableList oblist = FXCollections.observableArrayList(list);
        combo_gender.setItems(oblist);
    }

    private void insertNewTest(){
            nama = name_field.getText();
            email = email_field.getText();
            gender = combo_gender.getSelectionModel().getSelectedItem();
            idKota = combo_city.getSelectionModel().getSelectedIndex()+1+"";

            query = "INSERT INTO data VALUES(null,'"+nama+"','"+email+"','"+gender+"',"+idKota+",NOW());";
            dao.saveData(query);
            name_field.setText("");
            email_field.setText("");
            combo_gender.getSelectionModel().clearSelection();
            combo_city.getSelectionModel().clearSelection();
            refreshTableTest();
    }
    private void editTest(){
            updateMenu=true;
            updatePane.setVisible(updateMenu);

            Data selected = dataTable.getSelectionModel().getSelectedItem();
            ID = selected.getdId().get();
            name_field.setText(selected.getdNama().get());
            email_field.setText(selected.getdEmail().get());
            combo_gender.getSelectionModel().select(selected.getdJenisKelamin().get());
            combo_city.getSelectionModel().select(selected.getdKota().get());
    }
    private void updateTest(){
        nama = name_field.getText();
        email = email_field.getText();
        gender = combo_gender.getSelectionModel().getSelectedItem();
        idKota = combo_city.getSelectionModel().getSelectedIndex()+1+"";

        query = "UPDATE data SET nama='"+nama+"', email='"+email+"', jenis_kelamin='"+gender+"', id_kota="+idKota+",Terakhir_Update=NOW() WHERE id="+ID+"";
        dao.saveData(query);
        name_field.setText("");
        email_field.setText("");
        combo_gender.getSelectionModel().clearSelection();
        combo_city.getSelectionModel().clearSelection();
        refreshTableTest();
        updateMenu=false;
        updatePane.setVisible(updateMenu);
    }
    private void deleteTest(){
        Data selected = dataTable.getSelectionModel().getSelectedItem();
        ID = selected.getdId().get();
        query = "DELETE FROM  data WHERE id="+ID+"";
        dao.saveData(query);
        refreshTableTest();
    }
}