package helpers;

import java.sql.*;

public class DBConnection {
    private static final String HOSTNAME = "localhost";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE = "panganan";
    private static final int PORT = 3306;
    private static String URI = String.format("jdbc:mysql://%s:%d/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
            HOSTNAME, PORT, DATABASE);

    public static Connection connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URI, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Package mysql connector tidak ditemukan");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Koneksi database gagal");
            e.printStackTrace();
            return null;
        }
    }

    public void close(Connection connect, PreparedStatement pstmt, ResultSet rs){
        try {
            if (connect != null)connect.close();
            if (pstmt != null)pstmt.close();
            if (rs != null)rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void close(Connection connect,PreparedStatement pstmt){
        try {
            close(connect,pstmt,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void close(PreparedStatement pstmt){
        try {
            close(null,pstmt,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}