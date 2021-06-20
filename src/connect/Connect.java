/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
/**
 *
 * @author DELL
 */
public class Connect {
    private Connection connect;
    private ResultSet result;
    private Statement statement;

    private static String hostName = "localhost";
    private static String sqlInstanceName = "SQLEXPRESS";
    private static String database = "FLASH_FOOD";
    
//    Chá»‰nh sá»­a láº¡i user_name vÃ  password cá»§a pháº§n má»�m sql server á»Ÿ Ä‘Ã¢y.
    private static String userName = "sa";
    private static String password = "123456";
    
    public Connect() throws SQLException  {
    	String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
  	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
  	 
   		connect = DriverManager.getConnection(connectionURL, userName, password);
  	     
   		statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    
    public User getUser(String email, String password){
       User user = new User();
        try {
            result = statement.executeQuery("SELECT * FROM NHANVIEN WHERE email = '"+email+"' AND password ='"+password+"'");
            if (result.next()) {
                user.setMaNV(result.getString("MaNV"));
                user.setHoTen(result.getString("HoTen"));
                user.setNgaySinh(result.getString("NgaySinh"));
                user.setDiaChi(result.getString("DiaChi"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public String[][] get_Types() {
        
        int index = 0;
        
        try {
            statement = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = statement.executeQuery("SELECT * FROM LOAISANPHAM;");
            
            result.last();
            int size = result.getRow();
            String[][] datas = new String[size][3];
            result.beforeFirst();
            while(result.next()) {
                datas[index][0] = result.getString("MaLoai");
                datas[index][1] = result.getString("TenLoai");
                datas[index][2] = result.getString("GhiChu");
                
                index++;
            }
            
            return datas;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new String[1][5];
    }
    
    public String[][] get_Staff() {
        
        int index = 0;
        
        try {
            statement = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = statement.executeQuery("SELECT email, MaNV, HoTen, NgaySinh, DiaChi FROM NHANVIEN;");
            
            result.last();
            int size = result.getRow();
            String[][] datas = new String[size][5];
            result.beforeFirst();
            while(result.next()) {
                datas[index][0] = result.getString("MaNV");
                datas[index][1] = result.getString("email");
                datas[index][2] = result.getString("HoTen");
                datas[index][3] = result.getString("NgaySinh");
                datas[index][4] = result.getString("DiaChi");
                
                index++;
            }
            
            return datas;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new String[1][5];
    }
    
    public String[][] get_Foods() {
 
        int index = 0;
        try {
            statement = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = statement.executeQuery("SELECT MONAN.*, LOAISANPHAM.TenLoai FROM MONAN JOIN LOAISANPHAM ON MONAN.MaLoai = LOAISANPHAM.MaLoai;");
            
            result.last();
            int size = result.getRow();
            String[][] datas = new String[size][4];
            result.beforeFirst();
            while(result.next()) {
                datas[index][0] = result.getString("MaMon");
                datas[index][1] = result.getString("TenMon");
                datas[index][2] = ""+result.getInt("Gia");
                datas[index][3] = result.getString("TenLoai");
                
                index++;
            }
            
            return datas;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new String[1][4];
    }
    
    public HashMap<String, String> getTypes() {
        HashMap<String, String> types = new HashMap<>();
        
        try {
            result = statement.executeQuery("SELECT MaLoai, TenLoai FROM LOAISANPHAM;");
            
            while(result.next()) {
                types.put(result.getString("TenLoai"), result.getString("MaLoai"));
            }
            
            return types;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public String createFood(String[] values) {
        String message = "";
        
        try {
            statement.executeUpdate("INSERT INTO MONAN "
                    + "([MaMon]\n" +",[TenMon]\n" +",[Gia]\n" +",[Anh]\n" +",[MaLoai])\n"
                    + "VALUES('"+values[0]+"','"+values[1]+"',"+Integer.parseInt(values[2])+",'"+values[3]+"','"+values[4]+"')");
            
            return "Created Food";
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  "Create Fail";
    }
    
}
