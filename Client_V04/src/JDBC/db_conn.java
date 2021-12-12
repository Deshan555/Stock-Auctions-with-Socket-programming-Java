package JDBC;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

public class db_conn 
{
    public static Connection connect()
    {
        Connection conn = null;

        try
        {
            String databaseURL = "jdbc:ucanaccess://UserData.accdb";

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