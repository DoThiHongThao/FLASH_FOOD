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
    private static String userName = "SA";
    private static String password = "123456";
    
    public Connect() throws SQLException  {
    	String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
  	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
  	 
   		connect = DriverManager.getConnection(connectionURL, userName, password);
  	     
   		statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
}
