/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author David
 */
public class ConexionSQLServer {
    private static String ipAddress;
    private static String dbName;
    private static String user;
    private static String password;
    private static String service;
    private static String url;
    private static ResourceBundle propertiesBD;
    
    public static Connection getConnection()
            throws SQLException{
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException e){
        e.printStackTrace();
            System.out.println("error"+e);
        }
        if (propertiesBD==null) {
            propertiesBD=ResourceBundle.getBundle("PropertiesBD");
            ipAddress=propertiesBD.getString("ipAddress");
            dbName=propertiesBD.getString("dbName");
            user=propertiesBD.getString("user");
            password=propertiesBD.getString("password");
            service=propertiesBD.getString("service");
            
            url="jdbc:sqlserver://"+ipAddress+":"+service+";databaseName="+dbName;
        }
        return DriverManager.getConnection(url, user,password);
    }
   public static void main(String[] args) throws SQLException {
        getConnection();
        System.out.println("Conexión exitosa");
    }
    
}
