package models;

import javafx.beans.property.*;

public class Tanaman {
    private IntegerProperty id;
    private StringProperty jenis_tanaman;
    private StringProperty nama_pangan;
    private DoubleProperty potensi_panen;
    private StringProperty keterangan;
    private StringProperty last_update;

    public Tanaman(int id,String jenis_tanaman,String nama_pangan,double potensi_panen,String keterangan,String last_update){
        this.id = new SimpleIntegerProperty(id);
        this.jenis_tanaman = new SimpleStringProperty(jenis_tanaman);
        this.nama_pangan = new SimpleStringProperty(nama_pangan);
        this.potensi_panen = new SimpleDoubleProperty(potensi_panen);
        this.keterangan = new SimpleStringProperty(keterangan);
        this.last_update = new SimpleStringProperty(last_update);
    }
    public IntegerProperty getId(){
        return id;
    }
    public StringProperty getJenis_tanaman(){
        return jenis_tanaman;
    }
    public StringProperty getNama_pangan(){
        return nama_pangan;
    }
    public DoubleProperty getPotensi_panen(){
        return potensi_panen;
    }
    public StringProperty getKeterangan(){
        return keterangan;
    }
    public StringProperty getLast_update(){
        return last_update;
    }
}
