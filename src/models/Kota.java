package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Kota {

    private final StringProperty kKota;

    public Kota(String kKota){
        this.kKota = new SimpleStringProperty(kKota);
    }
    public StringProperty getkKota(){
        return kKota;
    }
}
