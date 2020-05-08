package models;

import javafx.beans.property.*;

public class DataWilayah {
        private IntegerProperty no;
        private StringProperty kota;
        private IntegerProperty jumlah_penduduk;
        private DoubleProperty tingkat_konsumsi;
        private StringProperty jenis_pangan;
        private DoubleProperty luas_lahan;
        private StringProperty tahun;

        public DataWilayah(int no,String kota,int jumlah_penduduk,double tingkat_konsumsi,String jenis_pangan,double luas_lahan,String tahun){
                this.no = new SimpleIntegerProperty(no);
                this.kota = new SimpleStringProperty(kota);
                this.jumlah_penduduk = new SimpleIntegerProperty(jumlah_penduduk);
                this.tingkat_konsumsi = new SimpleDoubleProperty(tingkat_konsumsi);
                this.jenis_pangan = new SimpleStringProperty(jenis_pangan);
                this.luas_lahan = new SimpleDoubleProperty(luas_lahan);
                this.tahun = new SimpleStringProperty(tahun);
        }
        public IntegerProperty getNo(){
                return no;
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
        public StringProperty getJenis_pangan(){
                return jenis_pangan;
        }
        public DoubleProperty getLuas_lahan(){
                return luas_lahan;
        }
        public StringProperty getTahun(){
                return tahun;
        }

}
