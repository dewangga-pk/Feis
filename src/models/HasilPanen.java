package models;

import javafx.beans.property.*;

public class HasilPanen {
    private IntegerProperty id;
    private StringProperty kota;
    private StringProperty jenis_tanaman;
    private DoubleProperty jumlah_panen;
    private StringProperty tahun;
    private StringProperty last_update;

    public HasilPanen(int id,String kota,String jenis_tanaman,double jumlah_panen,String tahun,String last_update){
        this.id = new SimpleIntegerProperty(id);
        this.kota = new SimpleStringProperty(kota);
        this.jenis_tanaman = new SimpleStringProperty(jenis_tanaman);
        this.jumlah_panen = new SimpleDoubleProperty(jumlah_panen);
        this.tahun = new SimpleStringProperty(tahun);
        this.last_update = new SimpleStringProperty(last_update);
    }

    public IntegerProperty getId(){
        return id;
    }
    public StringProperty getKota(){
        return kota;
    }
    public StringProperty getJenis_tanaman(){
        return jenis_tanaman;
    }
    public DoubleProperty getJumlah_panen(){
        return jumlah_panen;
    }
    public StringProperty getTahun(){
        return tahun;
    }
    public StringProperty getLast_update(){
        return last_update;
    }
}
