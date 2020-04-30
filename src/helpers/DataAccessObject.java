package helpers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataAccessObject {
    private DBConnection database = new DBConnection();
    private ResultSet rs;
    private PreparedStatement pstmt;
    private Connection connect;

    public DataAccessObject(){

    }
    public void  saveData(String query){
        try{
            connect = database.connectDB();
            pstmt = connect.prepareStatement(query);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            database.close(connect,pstmt,null);
        }
    }
    public ObservableList<Kota> getDataKota(String query){
        ObservableList<Kota> list = FXCollections.observableArrayList();
        try{
            connect = database.connectDB();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new Kota(rs.getString(1)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ObservableList<String> getDataKotaCombobox(String query){
        ObservableList list = FXCollections.observableArrayList();
        try{
            connect = database.connectDB();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add((rs.getString(1)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ObservableList<Data> getData(String query){
        ObservableList list = FXCollections.observableArrayList();
        try{
            connect = database.connectDB();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new Data(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ObservableList<Penduduk> getDataPenduduk(String query){
        ObservableList list = FXCollections.observableArrayList();
        try {
            connect = database.connectDB();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new Penduduk(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ObservableList<String> getJenisPanganCombobox(String query){
        ObservableList list = FXCollections.observableArrayList();
        try{
            connect = database.connectDB();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add((rs.getString(1)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ObservableList<Konsumsi> getDataKonsumsi(String query){
        ObservableList list = FXCollections.observableArrayList();
        try {
            connect = database.connectDB();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new Konsumsi(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ObservableList<LahanPertanian> getDataLahanPertanian(String query){
        ObservableList list = FXCollections.observableArrayList();
        try {
            connect = database.connectDB();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new LahanPertanian(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ObservableList<HasilPanen> getDataHasilPanen(String query){
        ObservableList list = FXCollections.observableArrayList();
        try {
            connect = database.connectDB();
            pstmt = connect.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new HasilPanen(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
