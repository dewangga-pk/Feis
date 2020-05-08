package models;

import javafx.beans.property.*;

public class Pemerataan {
    private IntegerProperty id;
    private StringProperty kota;
    private IntegerProperty jumlah_penduduk;
    private StringProperty jenis_pangan;
    private DoubleProperty tingkat_konsumsi;
    private DoubleProperty jumlah_produksi;
    private StringProperty status;
    private StringProperty tahun;

    public Pemerataan(int id,String kota,int jumlah_penduduk,String jenis_pangan,double tingkat_konsumsi,double jumlah_produksi,String tahun){
        this.id = new SimpleIntegerProperty(id);
        this.kota = new SimpleStringProperty(kota);
        this.jumlah_penduduk = new SimpleIntegerProperty(jumlah_penduduk);
        this.jenis_pangan = new SimpleStringProperty(jenis_pangan);
        this.tingkat_konsumsi = new SimpleDoubleProperty(tingkat_konsumsi);
        this.jumlah_produksi = new SimpleDoubleProperty(jumlah_produksi);
        this.status = new SimpleStringProperty(cekStatus(jumlah_penduduk,tingkat_konsumsi,jumlah_produksi));
        this.tahun = new SimpleStringProperty(tahun);
    }
    private String cekStatus(int jumlah_penduduk,double tingkat_konsumsi,double jumlah_produksi){
        String result;
        double temp = jumlah_penduduk*tingkat_konsumsi;
        if (temp>=jumlah_produksi){
            result = "Tercukupi";
        }else {
            result = "Tidak Tercukupi";
        }
        return result;
    }
    public IntegerProperty getId(){
        return id;
    }
    public StringProperty getKota(){
        return kota;
    }
    public IntegerProperty getJumlah_penduduk(){
        return jumlah_penduduk;
    }
    public DoubleProperty getTingkat_konsumsi(){
        return tingkat_konsumsi;
    }
    public DoubleProperty getJumlah_produksi(){
        return jumlah_produksi;
    }
    public StringProperty getStatus(){
        return status;
    }
    public StringProperty getTahun(){
        return tahun;
    }
    public StringProperty getJenis_pangan(){
        return jenis_pangan;
    }
}
