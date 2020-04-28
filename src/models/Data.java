package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data{
    private final IntegerProperty dId;
    private final StringProperty dNama;
    private final StringProperty dEmail;
    private final StringProperty dJenisKelamin;
    private final StringProperty dKota;
    private final StringProperty dDate;

    public Data(Integer id, String nama, String email, String jenis_kelamin, String kota, String dDate){
        this.dId = new SimpleIntegerProperty(id);
        this.dNama = new SimpleStringProperty(nama);
        this.dEmail = new SimpleStringProperty(email);
        this.dJenisKelamin = new SimpleStringProperty(jenis_kelamin);
        this.dKota = new SimpleStringProperty(kota);
        this.dDate = new SimpleStringProperty(dDate);
    }
    public IntegerProperty getdId(){
        return dId;
    }
    public StringProperty getdNama(){
        return dNama;
    }
    public StringProperty getdEmail(){
        return dEmail;
    }
    public StringProperty getdJenisKelamin(){
        return dJenisKelamin;
    }
    public StringProperty getdKota(){
        return dKota;
    }
    public StringProperty getdDate(){return dDate;}
}
