package models;


import javafx.beans.property.*;

public class Konsumsi {
    private IntegerProperty id;
    private StringProperty nama_pangan;
    private DoubleProperty besar_konsumsi;
    private StringProperty tahun;
    private StringProperty last_update;

    public Konsumsi(int id,String nama_pangan,double besar_konsumsi,String tahun,String last_update){
        this.id = new SimpleIntegerProperty(id);
        this.nama_pangan = new SimpleStringProperty(nama_pangan);
        this.besar_konsumsi = new SimpleDoubleProperty(besar_konsumsi);
        this.tahun = new SimpleStringProperty(tahun);
        this.last_update = new SimpleStringProperty(last_update );
    }
    public IntegerProperty getId(){
        return id;
    }
    public DoubleProperty getBesar_konsumsi(){
        return besar_konsumsi;
    }
    public StringProperty getNama_pangan(){
        return nama_pangan;
    }
    public StringProperty getTahun(){
        return tahun;
    }
    public StringProperty getLast_update(){
        return last_update;
    }
}
