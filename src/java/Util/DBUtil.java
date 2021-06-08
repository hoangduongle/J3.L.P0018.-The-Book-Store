/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DBUtil {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection cn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=UserManagerment";
        cn = DriverManager.getConnection(url, "sa", "123");
        return cn;
    }
   
}
