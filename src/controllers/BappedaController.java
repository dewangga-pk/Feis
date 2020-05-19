package controllers;

import helpers.DataAccessObject;
import helpers.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import models.*;

import javax.xml.crypto.Data;
import java.net.URL;
import java.util.ResourceBundle;

public class BappedaController implements Initializable {

    @FXML
    private AnchorPane anchor_head;

    @FXML
    private AnchorPane view_beranda;

    @FXML
    private AnchorPane view_dataWilayah;

    @FXML
    private TableView<DataWilayah> tabel_data_wilayah;

    @FXML
    private TableColumn<DataWilayah, Integer> wil_col_id;

    @FXML
    private TableColumn<DataWilayah, String> wil_col_kota;

    @FXML
    private TableColumn<DataWilayah, Integer> wil_col_jumlahPenduduk;

    @FXML
    private TableColumn<DataWilayah, Double> wil_col_tingkatKonsumsi;

    @FXML
    private TableColumn<DataWilayah, String> wil_col_JenisPangan;

    @FXML
    private TableColumn<DataWilayah, Double> wil_col_luasLahan;

    @FXML
    private TableColumn<DataWilayah, String> wil_col_tahun;

    @FXML
    private AnchorPane view_tanamanPangan;

    @FXML
    private TableView<Tanaman> tabel_TanamanPangan;

    @FXML
    private TableColumn<Tanaman, Integer> pangan_col_id;

    @FXML
    private TableColumn<Tanaman, String> pangan_col_jenisTanaman;

    @FXML
    private TableColumn<Tanaman, String> pangan_col_namaPangan;

    @FXML
    private TableColumn<Tanaman, Double> pangan_col_rataHasil;

    @FXML
    private TableColumn<Tanaman, String> pangan_col_lastUpdate;

    @FXML
    private AnchorPane view_calculator;

    @FXML
    private Text menuID;

    @FXML
    private ComboBox<String> cal_comboBox_JenisTanaman;

    @FXML
    private TextField cal_textfield_LuasLahan;

    @FXML
    private Text cal_result_text;

    @FXML
    private AnchorPane view_pemerataan;

    @FXML
    private TableView<Pemerataan> tabel_pemerataan;

    @FXML
    private TableColumn<Pemerataan, Integer> rata_col_id;

    @FXML
    private TableColumn<Pemerataan, String> rata_col_kota;

    @FXML
    private TableColumn<Pemerataan, Integer> rata_col_jumlahPenduduk;

    @FXML
    private TableColumn<Pemerataan, String> rata_col_jenisPangan;

    @FXML
    private TableColumn<Pemerataan, Double> rata_col_tingkatKonsumsi;

    @FXML
    private TableColumn<Pemerataan, Double> rata_col_JumlahProduksi;

    @FXML
    private TableColumn<Pemerataan, String> rata_col_status;

    @FXML
    private TableColumn<Pemerataan, String> rata_col_tahun;

    @FXML
    void btn_beranda(ActionEvent event) {
        resetView();
    }

    @FXML
    void btn_calculator(ActionEvent event) {
        view_beranda.setVisible(false);
        view_calculator.setVisible(true);
        cal_comboBox_JenisTanaman.getSelectionModel().clearSelection();
        query = "SELECT jenis_tanaman FROM tanaman";
        cal_comboBox_JenisTanaman.setItems(dao.getJenisPanganCombobox(query));
        cal_textfield_LuasLahan.clear();
        cal_result_text.setText("");
    }

    @FXML
    void btn_dataWilayah(ActionEvent event) {
        view_beranda.setVisible(false);
        view_dataWilayah.setVisible(true);
        refreshTabelDataWilayah();
    }

    @FXML
    void btn_logOut(ActionEvent event) {
        Helper.changePage(event,"Main");
    }

    @FXML
    void btn_pemerataan(ActionEvent event) {
        view_beranda.setVisible(false);
        view_pemerataan.setVisible(true);
        refreshTabelPemerataan();
    }

    @FXML
    void btn_tanamanPangan(ActionEvent event) {
        view_beranda.setVisible(false);
        view_tanamanPangan.setVisible(true);
        refreshTabelTanaman();
    }

    @FXML
    void cal_btn_hitung(ActionEvent event) {
        String id_tanaman;
        double potensi,luaslahan;
        try{
            id_tanaman = cal_comboBox_JenisTanaman.getSelectionModel().getSelectedIndex()+1+"";
            query= "SELECT potensi_rata_rata_hasil FROM tanaman where id="+id_tanaman+"";
            potensi = Double.parseDouble(dao.getCustomData(query));
            luaslahan = Double.parseDouble(cal_textfield_LuasLahan.getText());
            cal_result_text.setText(String.valueOf(potensi*luaslahan)+" ton");
        }catch (Exception e){
            cal_result_text.setText("Pastikan Semua Data sudah terisi");
        }
    }

    private String query;
    DataAccessObject dao;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dao = new DataAccessObject();
    }

    private void initTabelDataWilayah(){
        wil_col_id.setCellValueFactory(cell->cell.getValue().getNo().asObject());
        wil_col_kota.setCellValueFactory(cell->cell.getValue().getKota());
        wil_col_jumlahPenduduk.setCellValueFactory(cell->cell.getValue().getJumlah_penduduk().asObject());
        wil_col_tingkatKonsumsi.setCellValueFactory(cell->cell.getValue().getTingkat_konsumsi().asObject());
        wil_col_JenisPangan.setCellValueFactory(cell->cell.getValue().getJenis_pangan());
        wil_col_luasLahan.setCellValueFactory(cell->cell.getValue().getLuas_lahan().asObject());
        wil_col_tahun.setCellValueFactory(cell->cell.getValue().getTahun());
    }

    private void initTabelTanamanPangan(){
        pangan_col_id.setCellValueFactory(cell->cell.getValue().getId().asObject());
        pangan_col_jenisTanaman.setCellValueFactory(cell->cell.getValue().getJenis_tanaman());
        pangan_col_namaPangan.setCellValueFactory(cell->cell.getValue().getNama_pangan());
        pangan_col_rataHasil.setCellValueFactory(cell->cell.getValue().getPotensi_panen().asObject());
        pangan_col_lastUpdate.setCellValueFactory(cell->cell.getValue().getLast_update());
    }

    private void initTabelPemerataan(){
        rata_col_id.setCellValueFactory(cell->cell.getValue().getId().asObject());
        rata_col_jumlahPenduduk.setCellValueFactory(cell->cell.getValue().getJumlah_penduduk().asObject());
        rata_col_kota.setCellValueFactory(cell->cell.getValue().getKota());
        rata_col_jenisPangan.setCellValueFactory(cell->cell.getValue().getJenis_pangan());
        rata_col_tingkatKonsumsi.setCellValueFactory(cell->cell.getValue().getTingkat_konsumsi().asObject());
        rata_col_JumlahProduksi.setCellValueFactory(cell->cell.getValue().getJumlah_produksi().asObject());
        rata_col_status.setCellValueFactory(cell->cell.getValue().getStatus());
        rata_col_tahun.setCellValueFactory(cell->cell.getValue().getTahun());
    }

    private void refreshTabelDataWilayah(){
        initTabelDataWilayah();
        query = "SELECT k.nama_kota,p.jumlah_penduduk,ko.besar_konsumsi,t.nama_pangan,lp.luas_lahan,p.tahun FROM penduduk AS p JOIN kota AS k ON p.kota_id=k.id\n" +
                "JOIN lahan_pertanian AS lp on lp.kota_id=k.id\n" +
                "JOIN produksi as pr on pr.kota_id=k.id\n" +
                "JOIN tanaman as t on pr.jenis_tanaman_id=t.id\n" +
                "JOIN konsumsi as ko on ko.jenis_tanaman_id=t.id";
        tabel_data_wilayah.setItems(dao.getDataWilayah(query));
    }

    private void refreshTabelTanaman(){
        initTabelTanamanPangan();
        query= "SELECT*FROM tanaman";
        tabel_TanamanPangan.setItems(dao.getDataTanaman(query));
    }

    private void refreshTabelPemerataan(){
        initTabelPemerataan();
        query="SELECT k.nama_kota,p.jumlah_penduduk,t.nama_pangan,ko.besar_konsumsi,pr.jumlah_produksi,p.tahun FROM penduduk AS p JOIN kota AS k ON p.kota_id=k.id\n" +
                "JOIN lahan_pertanian AS lp on lp.kota_id=k.id\n" +
                "JOIN produksi as pr on pr.kota_id=k.id\n" +
                "JOIN tanaman as t on pr.jenis_tanaman_id=t.id\n" +
                "JOIN konsumsi as ko on ko.jenis_tanaman_id=t.id";
        tabel_pemerataan.setItems(dao.getDataPemerataan(query));
    }

    private void resetView(){
        view_beranda.setVisible(true);
        view_calculator.setVisible(false);
        view_dataWilayah.setVisible(false);
        view_pemerataan.setVisible(false);
        view_tanamanPangan.setVisible(false);

        cal_textfield_LuasLahan.setText("");
        cal_result_text.setText("");
        cal_comboBox_JenisTanaman.getSelectionModel().clearSelection();
    }
}
