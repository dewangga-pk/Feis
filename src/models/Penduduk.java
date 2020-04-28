package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Penduduk {
    private IntegerProperty id;
    private StringProperty kota;
    private IntegerProperty jumlah;
    private StringProperty tahun;
    private StringProperty last_update;

    public Penduduk(int id,String kota,int jumlah,String tahun,String last_update){
        this.id = new SimpleIntegerProperty(id);
        this.kota = new SimpleStringProperty(kota);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.tahun = new SimpleStringProperty(tahun);
        this.last_update = new SimpleStringProperty(last_update);
    }
    public IntegerProperty getId(){
        return id;
    }
    public StringProperty getKota(){
        return kota;
    }
    public IntegerProperty getJumlah(){
        return jumlah;
    }
    public StringProperty getTahun(){
        return tahun;
    }
    public StringProperty getLast_update(){
        return last_update;
    }
}
