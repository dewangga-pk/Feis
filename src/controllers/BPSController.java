package controllers;

import com.jfoenix.controls.*;
import helpers.DataAccessObject;
import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import models.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BPSController implements Initializable {

    @FXML
    private StackPane stackPane;

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
    private TableColumn<Penduduk, String> col_pend_Tahun;

    @FXML
    private TableColumn<Penduduk, String> col_penduduk_LastUpdate;

    @FXML
    private Pane paneAddUpdatePenduduk;

    @FXML
    private Label label_MenuManagementPend;

    @FXML
    private JFXComboBox<String> combobox_city_Penduduk;

    @FXML
    private TextField field_jumlahPenduduk;

    @FXML
    private TextField field_tahun_JumlahPenduduk;

    @FXML
    private JFXCheckBox check_policy_Penduduk;

    @FXML
    private Text text_infoFormPenduduk;

    @FXML
    private AnchorPane konsumsiView;


    @FXML
    private TableView<Konsumsi> tabel_konsumsi;

    @FXML
    private TableColumn<Konsumsi, Integer> col_kons_No;

    @FXML
    private TableColumn<Konsumsi, String> col_kons_JenisPangan;

    @FXML
    private TableColumn<Konsumsi, Double> col_kons_Jumlah;

    @FXML
    private TableColumn<Konsumsi, String> col_kons_Tahun;

    @FXML
    private TableColumn<Konsumsi, String> col_kons_LastUpdate;

    @FXML
    private Pane paneAddUpdateKonsumsi;

    @FXML
    private Label label_MenuManagementKonsumsi;

    @FXML
    private JFXComboBox<String> combobox_jenispangan_Konsumsi;

    @FXML
    private TextField field_jumlahKonsumsi;

    @FXML
    private JFXCheckBox check_policy_Konsumsi;

    @FXML
    private TextField field_tahun_Konsumsi;

    @FXML
    private Text text_infoFormKonsumsi;

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
    private TableView<HasilPanen> tabel_HasilPanen;

    @FXML
    private TableColumn<HasilPanen, Integer> col_pert_HasilPanen_No;

    @FXML
    private TableColumn<HasilPanen, String> col_pert_HasilPanen_kota;

    @FXML
    private TableColumn<HasilPanen, String> col_pert_HasilPanen_JenisTanaman;

    @FXML
    private TableColumn<HasilPanen, Double> col_pert_HasilPanen_Jumlah;

    @FXML
    private TableColumn<HasilPanen, String> col_pert_HasilPanen_Tahun;

    @FXML
    private TableColumn<HasilPanen, String > col_pert_HasilPanen_LastUpdate;

    @FXML
    private Pane paneAddUpdateHasilPanen;

    @FXML
    private Label label_MenuManagementHasilPanen;

    @FXML
    private JFXComboBox<String> combobox_city_HasilPanen;

    @FXML
    private JFXComboBox<String> combobox_jenisPangan_HasilPanen;

    @FXML
    private TextField field_jumlahPanen;
    @FXML
    private TextField field_tahun_HasilPanen;

    @FXML
    private JFXCheckBox check_policy_HasilPanen;

    @FXML
    private Text text_infoFormHasilPanen;

    @FXML
    private AnchorPane pertanian_LuasLahan;

    @FXML
    private TableView<LahanPertanian> tabel_LuasLahan;

    @FXML
    private TableColumn<LahanPertanian, Integer> col_pert_LuasLahan_No;

    @FXML
    private TableColumn<LahanPertanian, String> col_pert_LuasLahan_Kota;

    @FXML
    private TableColumn<LahanPertanian, Double> col_pert_LuasLahan_Jumlah;

    @FXML
    private TableColumn<LahanPertanian, String> col_pert_LuaslLahan_Tahun;

    @FXML
    private TableColumn<LahanPertanian, String> col_pert_LuaslLahan_LastUpdate;

    @FXML
    private Pane paneAddUpdateLuasLahan;

    @FXML
    private Label label_MenuManagementLuasLahan;

    @FXML
    private JFXComboBox<String> combobox_city_LuasLahan;

    @FXML
    private TextField field_pert_LuasLahan_Jumlah;

    @FXML
    private TextField field_tahun_LuasLahan;

    @FXML
    private JFXCheckBox check_policy_LuasLahan;

    @FXML
    private Text text_infoFormLuasLahan;

    private boolean anc_dashboard=false,anc_penduduk=false,anc_konsumsi=false,anc_pertanian=false;
    private boolean form_add_update = false;
    private boolean anc_pert_hasilPanen = false,anc_pert_Luaslahan=false,anc_pert_Dashboard=false;
    private String query;
    private DataAccessObject dao;
    private String menu,menu_pertanian,kota_id,jumlah_penduduk,tahun,jumlahKonsumsi,pangan_id,jumlah_produksi,luas_lahan;
    private Boolean check = false,update=false,add=false;
    private int ID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dao = new DataAccessObject();
    }

    private void initCity(){
        combobox_city_Penduduk.getSelectionModel().clearSelection();
        query = "SELECT nama_kota FROM kota";
        combobox_city_Penduduk.setItems(dao.getDataKotaCombobox(query));
        combobox_city_HasilPanen.setItems(dao.getDataKotaCombobox(query));
        combobox_city_LuasLahan.setItems(dao.getDataKotaCombobox(query));
    }
    private void initJenisPangan(){
        combobox_jenispangan_Konsumsi.getSelectionModel().clearSelection();
        query="SELECT nama_pangan FROM tanaman";
    }
    private void initJenisTanaman(){
        query="SELECT jenis_tanaman FROM tanaman";
        combobox_jenispangan_Konsumsi.setItems(dao.getJenisPanganCombobox(query));
        combobox_jenisPangan_HasilPanen.setItems(dao.getJenisPanganCombobox(query));
    }
    private void initTabelPenduduk(){
        col_pend_No.setCellValueFactory(cell->cell.getValue().getId().asObject());
        col_pend_Kota.setCellValueFactory(cell->cell.getValue().getKota());
        col_pend_Jumlah.setCellValueFactory(cell->cell.getValue().getJumlah().asObject());
        col_pend_Tahun.setCellValueFactory(cell->cell.getValue().getTahun());
        col_penduduk_LastUpdate.setCellValueFactory(cell->cell.getValue().getLast_update());
    }
    private void refreshTabelPenduduk(){
        initTabelPenduduk();
        query ="SELECT p.id,k.nama_kota,p.jumlah_penduduk,p.tahun,p.last_update FROM penduduk as p JOIN kota as k ON p.kota_id=k.id ORDER BY p.id";
        tabel_penduduk.setItems(dao.getDataPenduduk(query));
    }
    private void insertNewPenduduk(){
        kota_id = combobox_city_Penduduk.getSelectionModel().getSelectedIndex()+1+"";
        jumlah_penduduk = field_jumlahPenduduk.getText();
        tahun = field_tahun_JumlahPenduduk.getText();
        check = (!kota_id.equals("")) && (!jumlah_penduduk.equals("")) && (!tahun.equals("")) && (check_policy_Penduduk.isSelected());
        try {
            if (check){
                query = "INSERT INTO penduduk VALUES(null,"+kota_id+","+jumlah_penduduk+","+tahun+",NOW());";
                dao.saveData(query);
                combobox_city_Penduduk.getSelectionModel().clearSelection();
                field_jumlahPenduduk.setText("");
                field_tahun_JumlahPenduduk.setText("");
                check_policy_Penduduk.setSelected(false);
                text_infoFormPenduduk.setText("");
                add=false;
            }else {
                text_infoFormPenduduk.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelPenduduk();
    }
    private void updatePenduduk(){
        kota_id=combobox_city_Penduduk.getSelectionModel().getSelectedIndex()+1+"";
        jumlah_penduduk=field_jumlahPenduduk.getText();
        tahun = field_tahun_JumlahPenduduk.getText();
        check = (!kota_id.equals("")) && (!jumlah_penduduk.equals("")) && (!tahun.equals("")) && (check_policy_Penduduk.isSelected());
        try {
            if (check){
                query = "UPDATE penduduk SET kota_id="+kota_id+", jumlah_penduduk="+jumlah_penduduk+", tahun="+tahun+", last_update=NOW() WHERE id="+ID+"";
                dao.saveData(query);
                combobox_city_Penduduk.getSelectionModel().clearSelection();
                field_jumlahPenduduk.setText("");
                field_tahun_JumlahPenduduk.setText("");
                check_policy_Penduduk.setSelected(false);
                text_infoFormPenduduk.setText("");
                update=false;
            }else {
                text_infoFormPenduduk.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelPenduduk();
    }
    private void initTabelKonsumsi(){
        col_kons_No.setCellValueFactory(cell->cell.getValue().getId().asObject());
        col_kons_JenisPangan.setCellValueFactory(cell->cell.getValue().getNama_pangan());
        col_kons_Jumlah.setCellValueFactory(cell->cell.getValue().getBesar_konsumsi().asObject());
        col_kons_Tahun.setCellValueFactory(cell->cell.getValue().getTahun());
        col_kons_LastUpdate.setCellValueFactory(cell->cell.getValue().getLast_update());
    }
    private void refreshTabelKonsumsi(){
        initTabelKonsumsi();
        query="SELECT k.id,t.nama_pangan,k.besar_konsumsi,k.tahun,k.last_update FROM konsumsi as k JOIN tanaman as t ON k.jenis_tanaman_id=t.id";
        tabel_konsumsi.setItems(dao.getDataKonsumsi(query));
    }
    private void insertNewKonsumsi(){
        pangan_id = combobox_jenispangan_Konsumsi.getSelectionModel().getSelectedIndex()+1+"";
        jumlahKonsumsi = field_jumlahKonsumsi.getText();
        tahun = field_tahun_Konsumsi.getText();
        check = (!pangan_id.equals("")) && (!jumlahKonsumsi.equals("")) && (!tahun.equals("")) && (check_policy_Konsumsi.isSelected());
        try {
            if (check){
                query = "INSERT INTO konsumsi VALUES(null,"+jumlahKonsumsi+","+pangan_id+","+tahun+",NOW());";
                dao.saveData(query);
                combobox_jenispangan_Konsumsi.getSelectionModel().clearSelection();
                field_jumlahKonsumsi.setText("");
                field_tahun_Konsumsi.setText("");
                check_policy_Konsumsi.setSelected(false);
                text_infoFormKonsumsi.setText("");
                add=false;
            }else {
                text_infoFormKonsumsi.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelKonsumsi();
    }
    private void updateKonsumsi(){
        pangan_id = combobox_jenispangan_Konsumsi.getSelectionModel().getSelectedIndex()+1+"";
        jumlahKonsumsi = field_jumlahKonsumsi.getText();
        tahun = field_tahun_Konsumsi.getText();
        check = (!pangan_id.equals("")) && (!jumlahKonsumsi.equals("")) && (!tahun.equals("")) && (check_policy_Konsumsi.isSelected());
        try {
            if (check){
                query = "UPDATE konsumsi SET besar_konsumsi="+jumlahKonsumsi+", jenis_tanaman_id="+pangan_id+", tahun="+tahun+", last_update=NOW() WHERE id="+ID+"";
                dao.saveData(query);
                combobox_jenispangan_Konsumsi.getSelectionModel().clearSelection();
                field_jumlahKonsumsi.setText("");
                field_tahun_Konsumsi.setText("");
                check_policy_Konsumsi.setSelected(false);
                text_infoFormKonsumsi.setText("");
                update=false;
            }else {
                text_infoFormKonsumsi.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelKonsumsi();
    }
    private void initTabelLuasLahan(){
        col_pert_LuasLahan_No.setCellValueFactory(cell->cell.getValue().getId().asObject());
        col_pert_LuasLahan_Kota.setCellValueFactory(cell->cell.getValue().getKota());
        col_pert_LuasLahan_Jumlah.setCellValueFactory(cell->cell.getValue().getLuas_lahan().asObject());
        col_pert_LuaslLahan_Tahun.setCellValueFactory(cell->cell.getValue().getTahun());
        col_pert_LuaslLahan_LastUpdate.setCellValueFactory(cell->cell.getValue().getLast_update());
    }
    private void initTabelHasilPanen(){
        col_pert_HasilPanen_No.setCellValueFactory(cell->cell.getValue().getId().asObject());
        col_pert_HasilPanen_kota.setCellValueFactory(cell->cell.getValue().getKota());
        col_pert_HasilPanen_JenisTanaman.setCellValueFactory(cell->cell.getValue().getJenis_tanaman());
        col_pert_HasilPanen_Jumlah.setCellValueFactory(cell->cell.getValue().getJumlah_panen().asObject());
        col_pert_HasilPanen_Tahun.setCellValueFactory(cell->cell.getValue().getTahun());
        col_pert_HasilPanen_LastUpdate.setCellValueFactory(cell->cell.getValue().getLast_update());
    }
    private void refreshTabelLuasLahan(){
        initTabelLuasLahan();
        query="SELECT lp.id,k.nama_kota,lp.luas_lahan,lp.tahun,lp.last_update FROM lahan_pertanian as lp JOIN kota as k ON lp.kota_id=k.id";
        tabel_LuasLahan.setItems(dao.getDataLahanPertanian(query));
    }
    private void refreshTabelHasilPanen(){
        initTabelHasilPanen();
        query="SELECT p.id,k.nama_kota,t.jenis_tanaman,p.jumlah_produksi,p.tahun,p.last_update FROM produksi as p JOIN kota as k ON p.kota_id=k.id JOIN tanaman as t ON p.jenis_tanaman_id=t.id";
        tabel_HasilPanen.setItems(dao.getDataHasilPanen(query));
    }
    private void insertNewHasilPanen(){
        kota_id = combobox_city_HasilPanen.getSelectionModel().getSelectedIndex()+1+"";
        pangan_id = combobox_jenisPangan_HasilPanen.getSelectionModel().getSelectedIndex()+1+"";
        jumlah_produksi = field_jumlahPanen.getText();
        tahun = field_tahun_HasilPanen.getText();
        check = (!kota_id.equals("")) && (!jumlah_produksi.equals("")) && (!tahun.equals("")) && (check_policy_HasilPanen.isSelected() && (!pangan_id.equals("")));
        try {
            if (check){
                query = "INSERT INTO produksi VALUES(null,"+kota_id+","+pangan_id+","+jumlah_produksi+","+tahun+",NOW());";
                dao.saveData(query);
                combobox_city_HasilPanen.getSelectionModel().clearSelection();
                combobox_jenisPangan_HasilPanen.getSelectionModel().clearSelection();
                field_tahun_HasilPanen.setText("");
                field_jumlahPanen.setText("");
                check_policy_HasilPanen.setSelected(false);
                text_infoFormHasilPanen.setText("");
                add=false;
            }else {
                text_infoFormHasilPanen.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelHasilPanen();
    }
    private void insertNewLuasLahan(){
        kota_id = combobox_city_LuasLahan.getSelectionModel().getSelectedIndex()+1+"";
        luas_lahan = field_pert_LuasLahan_Jumlah.getText();
        tahun = field_tahun_LuasLahan.getText();
        check = (!kota_id.equals("")) && (!luas_lahan.equals("")) && (!tahun.equals("")) && (check_policy_LuasLahan.isSelected());
        try {
            if (check){
                query = "INSERT INTO lahan_pertanian VALUES(null,"+kota_id+","+luas_lahan+","+tahun+",NOW());";
                dao.saveData(query);
                combobox_city_LuasLahan.getSelectionModel().clearSelection();
                field_tahun_LuasLahan.setText("");
                field_pert_LuasLahan_Jumlah.setText("");
                check_policy_LuasLahan.setSelected(false);
                text_infoFormLuasLahan.setText("");
                add=false;
            }else {
                text_infoFormLuasLahan.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
                add=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelLuasLahan();
    }
    private void updateHasilPanen(){
        kota_id = combobox_city_HasilPanen.getSelectionModel().getSelectedIndex()+1+"";
        pangan_id = combobox_jenisPangan_HasilPanen.getSelectionModel().getSelectedIndex()+1+"";
        jumlah_produksi = field_jumlahPanen.getText();
        tahun = field_tahun_HasilPanen.getText();
        check = (!kota_id.equals("")) && (!jumlah_produksi.equals("")) && (!tahun.equals("")) && (check_policy_HasilPanen.isSelected());
        try {
            if (check){
                query = "UPDATE produksi SET kota_id="+kota_id+", jenis_tanaman_id="+pangan_id+", jumlah_produksi="+jumlah_produksi+", tahun="+tahun+", last_update=NOW() WHERE id="+ID+"";
                dao.saveData(query);
                combobox_city_HasilPanen.getSelectionModel().clearSelection();
                combobox_jenisPangan_HasilPanen.getSelectionModel().clearSelection();
                field_tahun_HasilPanen.setText("");
                field_jumlahPanen.setText("");
                check_policy_HasilPanen.setSelected(false);
                text_infoFormHasilPanen.setText("");
                update=false;
            }else {
                text_infoFormHasilPanen.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelHasilPanen();
    }
    private void updateLuasLahan(){
        kota_id = combobox_city_LuasLahan.getSelectionModel().getSelectedIndex()+1+"";
        luas_lahan = field_pert_LuasLahan_Jumlah.getText();
        tahun = field_tahun_LuasLahan.getText();
        check = (!kota_id.equals("")) && (!luas_lahan.equals("")) && (!tahun.equals("")) && (check_policy_LuasLahan.isSelected());
        try {
            if (check){
                query = "UPDATE lahan_pertanian SET kota_id="+kota_id+", luas_lahan="+luas_lahan+", tahun="+tahun+", last_update=NOW() WHERE id="+ID+"";
                dao.saveData(query);
                combobox_city_LuasLahan.getSelectionModel().clearSelection();
                field_tahun_LuasLahan.setText("");
                field_pert_LuasLahan_Jumlah.setText("");
                check_policy_LuasLahan.setSelected(false);
                text_infoFormLuasLahan.setText("");
                update=false;
            }else {
                text_infoFormLuasLahan.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelLuasLahan();
    }
    @FXML
    void btn_konsumsi(ActionEvent event) {
        menu = "konsumsi";
        anc_konsumsi=true;
        initJenisPangan();
        refreshTabelKonsumsi();
        chekMenuScene();
        anc_konsumsi=false;
    }
    @FXML
    void btn_penduduk(ActionEvent event) {
        menu = "penduduk";
        initCity();
        refreshTabelPenduduk();
        anc_penduduk=true;
        chekMenuScene();
        anc_penduduk=false;
    }
    @FXML
    void btn_pertanian(ActionEvent event) {
        anc_pertanian=true;
        menu="pertanian";
        chekMenuScene();
        anc_pertanian=false;
    }
    @FXML
    void btn_cancel_penduduk(ActionEvent event) {
        paneAddUpdatePenduduk.setVisible(false);
        text_infoFormPenduduk.setText("");
        add=false;
        update=false;
    }
    @FXML
    void btn_konsumsi_cancel(ActionEvent event) {
        paneAddUpdateKonsumsi.setVisible(false);
        text_infoFormKonsumsi.setText("");
        check_policy_Konsumsi.setSelected(false);
        add=false;
        update=false;
    }
    @FXML
    void btn_konsumsi_editData(ActionEvent event) {
        try {
            form_add_update=true;
            update=true;
            label_MenuManagementKonsumsi.setText("Edit Data");

            Konsumsi selected = tabel_konsumsi.getSelectionModel().getSelectedItem();
            ID = selected.getId().get();
            combobox_jenispangan_Konsumsi.getSelectionModel().select(selected.getNama_pangan().get());
            field_jumlahKonsumsi.setText(String.valueOf(selected.getBesar_konsumsi().get()));
            field_tahun_Konsumsi.setText(selected.getTahun().get());
            chekMenuUpdate();
            form_add_update=false;
        }catch (Exception e){
            modalShow();
        }
    }
    @FXML
    void btn_konsumsi_submit(ActionEvent event) {
        if (add){
            insertNewKonsumsi();
        }else if (update){
            updateKonsumsi();
        }else {
            System.out.println("Ga Ada yang bener");
        }
    }
    @FXML
    void btn_konsumsi_tambahData(ActionEvent event) {
        add=true;
        form_add_update=true;
        label_MenuManagementPend.setText("Data Baru");
        combobox_jenispangan_Konsumsi.getSelectionModel().clearSelection();
        field_tahun_Konsumsi.setText("");
        field_jumlahKonsumsi.setText("");
        chekMenuUpdate();
        form_add_update=false;
    }
    @FXML
    void btn_pend_editData(ActionEvent event) {
        try {
            form_add_update=true;
            update=true;
            label_MenuManagementPend.setText("Edit Data");

            Penduduk selected = tabel_penduduk.getSelectionModel().getSelectedItem();
            ID = selected.getId().get();
            combobox_city_Penduduk.getSelectionModel().select(selected.getKota().get());
            field_tahun_JumlahPenduduk.setText(selected.getTahun().get());
            field_jumlahPenduduk.setText(String.valueOf(selected.getJumlah().get()));

            chekMenuUpdate();
            form_add_update=false;
        }catch (Exception e){
            modalShow();
        }
    }
    @FXML
    void btn_pend_tambahData(ActionEvent event) {
        form_add_update=true;
        add=true;
        label_MenuManagementPend.setText("Data Baru");
        combobox_city_Penduduk.getSelectionModel().clearSelection();
        field_tahun_JumlahPenduduk.setText("");
        field_jumlahPenduduk.setText("");
        chekMenuUpdate();
        form_add_update=false;
    }
    @FXML
    void btn_submit_penduudk(ActionEvent event) {
        if (add){
            insertNewPenduduk();
        }else if (update){
            updatePenduduk();
        }else {
            System.out.println("Ga Ada yang bener");
        }
    }
    @FXML
    void btn_pertaninanDashboard(MouseEvent event) {
        menu_pertanian="";
        anc_pert_Dashboard=true;
        chekMenuScene();
        anc_pert_Dashboard=false;
    }
    @FXML
    void btn_pertanian_LuasLahan(ActionEvent event) {
        anc_pert_Luaslahan = true;
        chekMenuScene();
        anc_pert_Luaslahan = false;
        initCity();
        initJenisTanaman();
        refreshTabelLuasLahan();
        menu_pertanian = "luas lahan";
    }
    @FXML
    void btn_pertanian_HasilPanen(ActionEvent event) {
        anc_pert_hasilPanen = true;
        chekMenuScene();
        anc_pert_hasilPanen = false;
        initCity();
        initJenisTanaman();
        refreshTabelHasilPanen();
        menu_pertanian = "hasil panen";
    }
    @FXML
    void btn_pertanian_HasilPanen_cancel(ActionEvent event) {
        paneAddUpdateHasilPanen.setVisible(false);
        combobox_jenisPangan_HasilPanen.getSelectionModel().clearSelection();
        combobox_city_HasilPanen.getSelectionModel().clearSelection();
        field_jumlahPanen.setText("");
        field_tahun_HasilPanen.setText("");
        check_policy_HasilPanen.setSelected(false);
        add=false;
        update=false;
    }
    @FXML
    void btn_pert_HasilPanen_EditData(ActionEvent event) {
        try {
            update=true;
            add=false;
            form_add_update=true;
            label_MenuManagementHasilPanen.setText("Edit Data");
            HasilPanen selected = tabel_HasilPanen.getSelectionModel().getSelectedItem();
            ID = selected.getId().get();
            combobox_city_HasilPanen.getSelectionModel().select(selected.getKota().get());
            combobox_jenisPangan_HasilPanen.getSelectionModel().select(selected.getJenis_tanaman().get());
            field_jumlahPanen.setText(String.valueOf(selected.getJumlah_panen().get()));
            field_tahun_HasilPanen.setText(selected.getTahun().get());
            chekMenuUpdate();
            form_add_update=false;
        }catch (Exception e){
            modalShow();
        }
    }
    @FXML
    void btn_pert_HasilPanen_tambahData(ActionEvent event) {
        add=true;
        update=false;
        form_add_update=true;
        label_MenuManagementHasilPanen.setText("Data Baru");
        combobox_jenisPangan_HasilPanen.getSelectionModel().clearSelection();
        combobox_city_HasilPanen.getSelectionModel().clearSelection();
        field_jumlahPanen.setText("");
        field_tahun_HasilPanen.setText("");
        chekMenuUpdate();
        form_add_update=false;
    }

    @FXML
    void btn_pert_LuasLahan_Cancel(ActionEvent event) {
        paneAddUpdateLuasLahan.setVisible(false);
        combobox_city_LuasLahan.getSelectionModel().clearSelection();
        field_pert_LuasLahan_Jumlah.setText("");
        field_tahun_LuasLahan.setText("");
        check_policy_LuasLahan.setSelected(false);
        add=false;
        update=false;
    }

    @FXML
    void btn_pert_LuasLahan_Editdata(ActionEvent event) {
        try {
            update=true;
            add=false;
            form_add_update=true;
            label_MenuManagementLuasLahan.setText("Edit Data");
            LahanPertanian selected = tabel_LuasLahan.getSelectionModel().getSelectedItem();
            ID = selected.getId().get();
            combobox_city_LuasLahan.getSelectionModel().select(selected.getKota().get());
            field_pert_LuasLahan_Jumlah.setText(String.valueOf(selected.getLuas_lahan().get()));
            field_tahun_LuasLahan.setText(selected.getTahun().get());
            chekMenuUpdate();
            form_add_update=false;
        }catch (Exception e){
            modalShow();
        }
    }

    @FXML
    void btn_pert_LuasLahan_Submit(ActionEvent event) {
        if (add){
            insertNewLuasLahan();
        }else if (update){
            updateLuasLahan();
        }else {
            System.out.println("Ga Ada yang bener");
        }
    }

    @FXML
    void btn_pert_LuasLahan_TambahData(ActionEvent event) {
        add=true;
        update=false;
        form_add_update=true;
        label_MenuManagementLuasLahan.setText("Data Baru");
        combobox_city_LuasLahan.getSelectionModel().clearSelection();
        field_pert_LuasLahan_Jumlah.setText("");
        field_tahun_LuasLahan.setText("");
        chekMenuUpdate();
        form_add_update=false;
    }
    @FXML
    void btn_pertanian_HasilPanen_submit(ActionEvent event) {
        if (add){
            insertNewHasilPanen();
        }else if (update){
            updateHasilPanen();
        }else {
            System.out.println("Ga Ada yang bener");
        }
    }
    @FXML
    void btn_beranda(ActionEvent event) {
        anc_dashboard=true;
        chekMenuScene();
        anc_dashboard=false;
    }
    @FXML
    void btn_profile(ActionEvent event) {

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
            pertanian_DashboardMenu.setVisible(true);
            label_table_pertanian.setVisible(false);
            pertanian_LuasLahan.setVisible(false);
            pertanian_HasilPanen.setVisible(false);
            label_table_pertanian.setText("");
        }else if(anc_pert_Luaslahan){
            label_table_pertanian.setVisible(true);
            label_table_pertanian.setText("Data Luas Lahan Pertanian Jawa Timur");
            pertanian_DashboardMenu.setVisible(false);
            pertanian_LuasLahan.setVisible(true);
        }else if(anc_pert_hasilPanen){
            label_table_pertanian.setVisible(true);
            label_table_pertanian.setText("Data Hasil Panen Pangan Jawa Timur");
            pertanian_DashboardMenu.setVisible(false);
            pertanian_HasilPanen.setVisible(true);
        }else if(anc_pert_Dashboard){
            label_table_pertanian.setVisible(false);
            pertanian_DashboardMenu.setVisible(true);
            pertanian_LuasLahan.setVisible(false);
            pertanian_HasilPanen.setVisible(false);
            label_table_pertanian.setText("");
        }
    }
    private void chekMenuUpdate(){
        paneAddUpdatePenduduk.setVisible(form_add_update && menu.equals("penduduk"));
        paneAddUpdateKonsumsi.setVisible(form_add_update && menu.equals("konsumsi"));
        paneAddUpdateHasilPanen.setVisible(form_add_update && menu.equals("pertanian") && menu_pertanian.equals("hasil panen"));
        paneAddUpdateLuasLahan.setVisible(form_add_update && menu.equals("pertanian") && menu_pertanian.equals("luas lahan"));
    }
    private void modalShow(){
        stackPane.setVisible(true);
        pendudukView.setDisable(true);
        konsumsiView.setDisable(true);
        pertanian_LuasLahan.setDisable(true);
        pertanian_HasilPanen.setDisable(true);
        JFXDialogLayout layout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(stackPane,layout, JFXDialog.DialogTransition.CENTER);
        layout.setHeading(new Text("PERINGATAN"));
        layout.setBody(new Text("Silahkan pilih data yang akan diedit terlebih dahulu"));
        JFXButton buttonYes = new JFXButton("OK");
        buttonYes.setBackground(new Background(new BackgroundFill(Paint.valueOf("#4e73df"), CornerRadii.EMPTY,null)));
        buttonYes.setCursor(Cursor.HAND);
        buttonYes.setTextFill(Paint.valueOf("#ffffff"));
        buttonYes.setOnAction(event1 -> {
            dialog.close();
            stackPane.setVisible(false);
            pendudukView.setDisable(false);
            konsumsiView.setDisable(false);
            pertanian_LuasLahan.setDisable(false);
            pertanian_HasilPanen.setDisable(false);
            stackPane.setVisible(false);
        });
        layout.setActions(buttonYes);
        dialog.show();
    }
}
