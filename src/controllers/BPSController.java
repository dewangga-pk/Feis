package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import helpers.DataAccessObject;
import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import models.Penduduk;

import java.net.URL;
import java.util.ResourceBundle;

public class BPSController implements Initializable {


    @FXML
    private AnchorPane anchor_headline;

    @FXML
    private AnchorPane DashboardView;

    @FXML
    private AnchorPane pendudukView;

    @FXML
    private TableView<Penduduk> tabel_penduduk;

    @FXML
    private TableColumn<Penduduk, Integer> col_pend_No;

    @FXML
    private TableColumn<Penduduk, String> col_pend_Kota;

    @FXML
    private TableColumn<Penduduk, Integer> col_pend_Jumlah;

    @FXML
    private TableColumn<Penduduk, String> col_penduduk_LastUpdate;

    @FXML
    private Pane paneAddUpdatePenduduk;

    @FXML
    private Label label_MenuManagement;

    @FXML
    private JFXComboBox<String> combobox_city_Penduduk;

    @FXML
    private TextField field_jumlahPenduduk;

    @FXML
    private TextField field_tahun_JumlahPenduduk;

    @FXML
    private JFXCheckBox check_policy_Penduduk;

    @FXML
    private AnchorPane konsumsiView;

    @FXML
    private TableView<?> tabel_konsumsi;

    @FXML
    private TableColumn<?, ?> col_kons_No;

    @FXML
    private TableColumn<?, ?> col_kons_Kota;

    @FXML
    private TableColumn<?, ?> col_kons_Jumlah;

    @FXML
    private TableColumn<?, ?> col_kons_LastUpdate;

    @FXML
    private Pane paneAddUpdateKonsumsi;

    @FXML
    private JFXComboBox<?> combobox_city_Konsumsi;

    @FXML
    private TextField field_jumlahKonsumsi;

    @FXML
    private JFXCheckBox check_policy_Konsumsi;

    @FXML
    private AnchorPane pertanianView;

    @FXML
    private Label label_table_pertanian;

    @FXML
    private Text menuID;

    @FXML
    private AnchorPane pertanian_DashboardMenu;

    @FXML
    private AnchorPane pertanian_HasilPanen;

    @FXML
    private TableView<?> tabel_HasilPanen;

    @FXML
    private TableColumn<?, ?> col_pert_HasilPanen_No;

    @FXML
    private TableColumn<?, ?> col_pert_HasilPanen_kota;

    @FXML
    private TableColumn<?, ?> col_pert_HasilPanen_Jumlah;

    @FXML
    private TableColumn<?, ?> col_pert_HasilPanen_LastUpdate;

    @FXML
    private Pane paneAddUpdateHasilPanen;

    @FXML
    private JFXComboBox<?> combobox_city_HasilPanen;

    @FXML
    private JFXComboBox<?> combobox_jenisPangan_HasilPanen;

    @FXML
    private TextField field_jumlahPanen;

    @FXML
    private JFXCheckBox check_policy_HasilPanen;

    @FXML
    private AnchorPane pertanian_LuasLahan;

    @FXML
    private TableView<?> tabel_LuasLahan;

    @FXML
    private TableColumn<?, ?> col_pert_LuasLahan_No;

    @FXML
    private TableColumn<?, ?> col_pert_LuasLahan_Kota;

    @FXML
    private TableColumn<?, ?> col_pert_LuasLahan_Jumlah;

    @FXML
    private TableColumn<?, ?> col_pert_LuaslLahan_LastUpdate;

    @FXML
    private Pane paneAddUpdateLuasLahan;

    @FXML
    private JFXComboBox<?> combobox_city_LuasLahan;

    @FXML
    private TextField field_pert_LuasLahan_Jumlah;

    @FXML
    private JFXCheckBox check_policy_LuasLahan;

    private boolean anc_dashboard=false,anc_penduduk=false,anc_konsumsi=false,anc_pertanian=false;
    private boolean form_add_update = false;
    private boolean anc_pert_hasilPanen = false,anc_pert_Luaslahan=false,anc_pert_dashboard=false;
    private String query;
    private DataAccessObject dao;
    private String menu = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dao = new DataAccessObject();
        initCity();
        refreshTabelPenduduk();
    }
    private void initCity(){
        combobox_city_Penduduk.getSelectionModel().clearSelection();
        query = "SELECT nama_kota FROM kota";
        combobox_city_Penduduk.setItems(dao.getDataKotaCombobox(query));
    }
    private void initTabelPenduduk(){
        col_pend_No.setCellValueFactory(cell->cell.getValue().getId().asObject());
        col_pend_Kota.setCellValueFactory(cell->cell.getValue().getKota());
        col_pend_Jumlah.setCellValueFactory(cell->cell.getValue().getJumlah().asObject());
        col_penduduk_LastUpdate.setCellValueFactory(cell->cell.getValue().getLast_update());
    }
    private void refreshTabelPenduduk(){
        initTabelPenduduk();
        query ="SELECT p.id,k.nama_kota,p.jumlah_penduduk,p.tahun,p.last_update FROM penduduk as p JOIN kota as k ON p.kota_id=k.id ORDER BY p.id";
        tabel_penduduk.setItems(dao.getDataPenduduk(query));
    }
    private void insertNewPenduduk(){
        String kota_id = combobox_city_Penduduk.getSelectionModel().getSelectedIndex()+1+"";
        String jumlah_penduduk = field_jumlahPenduduk.getText();
        String tahun = field_tahun_JumlahPenduduk.getText();
        Boolean check = false;
        if ((!kota_id.equals("")) && (!jumlah_penduduk.equals("")) && (!tahun.equals("")) && (check_policy_Penduduk.isSelected())){
            check = true;
        }else {
            check = false;
        }
        try {
            if (check){
                query = "INSERT INTO penduduk VALUES(null,"+kota_id+","+jumlah_penduduk+","+tahun+",NOW());";
                dao.saveData(query);
                combobox_city_Penduduk.getSelectionModel().clearSelection();
                field_jumlahPenduduk.setText("");
                field_tahun_JumlahPenduduk.setText("");
                check_policy_Penduduk.setSelected(false);
            }else {
                label_MenuManagement.setText("Kurang Lengkap Gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelPenduduk();
    }

    @FXML
    void btn_beranda(ActionEvent event) {
        anc_dashboard=true;
        chekMenuScene();
        anc_dashboard=false;
    }
    @FXML
    void btn_konsumsi(ActionEvent event) {
        anc_konsumsi=true;
        chekMenuScene();
        anc_konsumsi=false;
    }
    @FXML
    void btn_penduduk(ActionEvent event) {
        menu = "penduduk";
        anc_penduduk=true;
        chekMenuScene();
        anc_penduduk=false;
    }
    @FXML
    void btn_pertanian(ActionEvent event) {
        anc_pertanian=true;
        chekMenuScene();
        anc_pertanian=false;
    }
    @FXML
    void btn_cancel_penduduk(ActionEvent event) {
        paneAddUpdatePenduduk.setVisible(false);
    }



    @FXML
    void btn_konsumsi_cancel(ActionEvent event) {

    }

    @FXML
    void btn_konsumsi_deleteData(ActionEvent event) {

    }

    @FXML
    void btn_konsumsi_editData(ActionEvent event) {

    }

    @FXML
    void btn_konsumsi_submit(ActionEvent event) {

    }

    @FXML
    void btn_konsumsi_tambahData(ActionEvent event) {

    }

    @FXML
    void btn_pend_deleteData(ActionEvent event) {

    }

    @FXML
    void btn_pend_editData(ActionEvent event) {

    }

    @FXML
    void btn_pend_tambahData(ActionEvent event) {
        form_add_update=true;
        chekMenuUpdate();
        form_add_update=false;
    }



    @FXML
    void btn_pert_HasilPanen_DeleteData(ActionEvent event) {

    }

    @FXML
    void btn_pert_HasilPanen_EditData(ActionEvent event) {

    }

    @FXML
    void btn_pert_HasilPanen_tambahData(ActionEvent event) {

    }

    @FXML
    void btn_pert_LuasLahan_Cancel(ActionEvent event) {

    }

    @FXML
    void btn_pert_LuasLahan_Editdata(ActionEvent event) {

    }

    @FXML
    void btn_pert_LuasLahan_Submit(ActionEvent event) {

    }

    @FXML
    void btn_pert_LuasLahan_TambahData(ActionEvent event) {

    }

    @FXML
    void btn_pert_LuashLahan_DeleteData(ActionEvent event) {

    }



    @FXML
    void btn_pertanian_HasilPanen(ActionEvent event) {

    }

    @FXML
    void btn_pertanian_HasilPanen_cancel(ActionEvent event) {

    }

    @FXML
    void btn_pertanian_HasilPanen_submit(ActionEvent event) {

    }

    @FXML
    void btn_pertanian_LuasLahan(ActionEvent event) {

    }

    @FXML
    void btn_profile(ActionEvent event) {

    }

    @FXML
    void btn_submit_penduudk(ActionEvent event) {
        insertNewPenduduk();
    }

    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }

    private void chekMenuScene(){
        if (anc_dashboard){
            DashboardView.setVisible(true);
            pendudukView.setVisible(false);
            konsumsiView.setVisible(false);
            pertanianView.setVisible(false);
        }else if (anc_penduduk){
            DashboardView.setVisible(false);
            pendudukView.setVisible(true);
            konsumsiView.setVisible(false);
            pertanianView.setVisible(false);
        }else if (anc_konsumsi){
            DashboardView.setVisible(false);
            pendudukView.setVisible(false);
            konsumsiView.setVisible(true);
            pertanianView.setVisible(false);
        }else if (anc_pertanian){
            DashboardView.setVisible(false);
            pendudukView.setVisible(false);
            konsumsiView.setVisible(false);
            pertanianView.setVisible(true);
        }
    }
    private void chekMenuUpdate(){
        if (form_add_update && menu.equals("penduduk") ){
            paneAddUpdatePenduduk.setVisible(true);
        }else {
            paneAddUpdatePenduduk.setVisible(false);
        }
    }
}
