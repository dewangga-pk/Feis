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
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import models.Konsumsi;
import models.Tanaman;

import java.net.URL;
import java.util.ResourceBundle;

public class LitbangTaniController implements Initializable {


    @FXML
    private AnchorPane anc_headBar;

    @FXML
    private AnchorPane tanaman_view;

    @FXML
    private TableView<Tanaman> tabel_jenis_tanaman;

    @FXML
    private TableColumn<Tanaman, Integer> col_id;

    @FXML
    private TableColumn<Tanaman, String> col_jenisTanaman;

    @FXML
    private TableColumn<Tanaman, String > col_namaPangan;

    @FXML
    private TableColumn<Tanaman, Double> col_RataHasil;

    @FXML
    private TableColumn<Tanaman, String> col_last_update;

    @FXML
    private Pane paneAddUpdate;

    @FXML
    private Label text_management;

    @FXML
    private TextField filed_namaPangan;

    @FXML
    private TextField field_rata_rataHasil;

    @FXML
    private JFXCheckBox check_policy;

    @FXML
    private Text text_formInfoUpdate;

    @FXML
    private TextField field_keterangan;

    @FXML
    private TextField field_jenisTanaman;

    @FXML
    private StackPane stackPane;

    private String query,jenis_tanaman,nama_pangan,rata_rataHasil,keterangan;
    private DataAccessObject dao;
    private Boolean check = false,update=false,add=false;
    private int ID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneAddUpdate.setVisible(false);
        dao = new DataAccessObject();
        refreshTabelTanaman();
    }
    private void initTabelTanaman(){
        col_id.setCellValueFactory(cell->cell.getValue().getId().asObject());
        col_jenisTanaman.setCellValueFactory(cell->cell.getValue().getJenis_tanaman());
        col_namaPangan.setCellValueFactory(cell->cell.getValue().getNama_pangan());
        col_RataHasil.setCellValueFactory(cell->cell.getValue().getPotensi_panen().asObject());
        col_last_update.setCellValueFactory(cell->cell.getValue().getLast_update());
    }
    private void refreshTabelTanaman(){
        initTabelTanaman();
        query= "SELECT*FROM tanaman";
        tabel_jenis_tanaman.setItems(dao.getDataTanaman(query));
    }
    private void insertNewData(){
        jenis_tanaman = field_jenisTanaman.getText();
        nama_pangan = filed_namaPangan.getText();
        rata_rataHasil = field_rata_rataHasil.getText();
        keterangan = field_keterangan.getText();
        check = (!jenis_tanaman.equals("")) && (!nama_pangan.equals("")) && (!rata_rataHasil.equals("")) && (check_policy.isSelected());
        try {
            if (check){
                if (keterangan.equals("")){keterangan="null";}
                query = "INSERT INTO tanaman VALUES(null,'"+jenis_tanaman+"','"+nama_pangan+"',"+rata_rataHasil+",'"+keterangan+"',NOW());";
                dao.saveData(query);
                field_jenisTanaman.setText("");
                filed_namaPangan.setText("");
                field_rata_rataHasil.setText("");
                field_keterangan.setText("");
                check_policy.setSelected(false);
                add=false;
            }else {
                text_formInfoUpdate.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelTanaman();
    }
    private void updateData(){
        jenis_tanaman = field_jenisTanaman.getText();
        nama_pangan = filed_namaPangan.getText();
        rata_rataHasil = field_rata_rataHasil.getText();
        keterangan = field_keterangan.getText();
        check = (!jenis_tanaman.equals("")) && (!nama_pangan.equals("")) && (!rata_rataHasil.equals("")) && (check_policy.isSelected());
        try {
            if (check){
                if (keterangan.equals("")){keterangan="null";}
                query = "UPDATE tanaman SET jenis_tanaman='"+jenis_tanaman+"', nama_pangan='"+nama_pangan+"', potensi_rata_rata_hasil="+rata_rataHasil+",keterangan='"+keterangan+"',last_update=NOW() WHERE id="+ID+"";
                dao.saveData(query);
                field_jenisTanaman.setText("");
                filed_namaPangan.setText("");
                field_rata_rataHasil.setText("");
                field_keterangan.setText("");
                check_policy.setSelected(false);
                update=false;
            }else {
                text_formInfoUpdate.setText("Form tidak lengkap");
                System.out.println("centangnya belum gan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        refreshTabelTanaman();
    }
    private void modalShow(){
        stackPane.setVisible(true);
        tanaman_view.setDisable(true);
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
            tanaman_view.setDisable(false);
            stackPane.setVisible(false);
        });
        layout.setActions(buttonYes);
        dialog.show();
    }

    @FXML
    void btn_cancel(ActionEvent event) {
        paneAddUpdate.setVisible(false);
        update=false;
        add=false;
        text_management.setText("");
    }

    @FXML
    void btn_editData(ActionEvent event) {
        try {
            add=false;
            update=true;
            text_management.setText("Edit Data");
            paneAddUpdate.setVisible(true);
            Tanaman selected = tabel_jenis_tanaman.getSelectionModel().getSelectedItem();
            ID = selected.getId().get();
            field_jenisTanaman.setText(selected.getJenis_tanaman().get());
            filed_namaPangan.setText(selected.getNama_pangan().get());
            field_rata_rataHasil.setText(String.valueOf(selected.getPotensi_panen().get()));
            field_keterangan.setText(selected.getKeterangan().get());
        }catch (Exception e){
            modalShow();
        }
    }

    @FXML
    void btn_submit(ActionEvent event) {
        if (add){
            insertNewData();
        }
        else if (update){
            updateData();
        }else{
            System.out.println("Ga ada yang bener");
        }
    }

    @FXML
    void btn_tambahData(ActionEvent event) {
        add=true;
        update=false;
        text_management.setText("Tambahkan Data");
        paneAddUpdate.setVisible(true);
        field_jenisTanaman.setText("");
        filed_namaPangan.setText("");
        field_rata_rataHasil.setText("");
        field_keterangan.setText("");
    }

    @FXML
    void logOutbtn(ActionEvent event) {
        Helper.changePage(event,"Main");
    }
}