package models;

import javafx.beans.property.*;

public class LahanPertanian {
    private IntegerProperty id;
    private StringProperty kota;
    private DoubleProperty luas_lahan;
    private StringProperty tahun;
    private StringProperty last_update;

    public LahanPertanian(int id,String kota,double luas_lahan,String tahun,String last_update){
        this.id = new SimpleIntegerProperty(id);
        this.kota = new SimpleStringProperty(kota);
        this.luas_lahan = new SimpleDoubleProperty(luas_lahan);
        this.tahun = new SimpleStringProperty(tahun);
        this.last_update = new SimpleStringProperty(last_update);
    }

    public IntegerProperty getId(){
        return id;
    }
    public StringProperty getKota(){
        return kota;
    }
    public DoubleProperty getLuas_lahan(){
        return luas_lahan;
    }
    public StringProperty getTahun(){
        return tahun;
    }
    public StringProperty getLast_update(){
        return last_update;
    }
}
