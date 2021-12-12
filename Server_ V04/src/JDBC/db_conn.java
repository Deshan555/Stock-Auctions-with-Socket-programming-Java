/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jayashanka Deshan
 */
public class db_conn 
{
    public static Connection connect()
    {
        Connection conn = null;

        try
        {
            String databaseURL = "jdbc:ucanaccess://Stock_Market_Database.accdb";

            conn = DriverManager.getConnection(databaseURL);

            System.out.println("Connected!!");

        }
        catch (Exception e)
        {
            //System.out.println(e);
            
            System.out.println("DB Fail To Connect \nError : "+e);

        }
        
        return conn;
    }
    
     public static void main(String[] args) throws SQLException
    {
        Connection conn = null;

        PreparedStatement pst = null;

        connect();
        
    }
    
}
