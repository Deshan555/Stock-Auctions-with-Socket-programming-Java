package Server;

import Publisher.Publisher;

import java.io.*;

import java.sql.*;

import java.net.*;

import java.util.*;

public class table_send extends Thread {

    Statement stmt=null;
    
    Vector records = new Vector(10,10);
    
    ResultSet rs = null;
    
    ServerSocket server = null;
    
    Socket client = null;
    
    Connection con = null;
    
    ObjectOutputStream out =null;
    
    String str = null;
    
    Publisher pub = null;
    
    static int port_num = 2005; 

    public table_send()
    {
        try 
        {
            server = new ServerSocket(port_num);
                    
            start();
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }

    }

    public void run()
    {
        while(true)
        {
            try 
            {
                int CC;
            
                client = server.accept();

                out = new ObjectOutputStream(client.getOutputStream());

                try {
                    String databaseURL = "jdbc:ucanaccess://Stock_Market_Database.accdb";

                    con = DriverManager.getConnection(databaseURL);

                    stmt = con.createStatement();

                    rs = stmt.executeQuery("SELECT * FROM Data");

                    records.removeAllElements();

                    ResultSetMetaData RSMD = rs.getMetaData();

                    CC = RSMD.getColumnCount();

                    while(rs.next())
                    {
                        pub = new Publisher();

                        pub.SYMBOL = rs.getString(1);

                        pub.PRICE = rs.getString(2);

                        pub.Security = rs.getString(3);

                        pub.Profit = rs.getString(4);

                        records.addElement(pub);

                    }

                    out.writeObject(records);

                    out.close();

                } 
                catch (SQLException ex) 
                {
                   System.out.println(ex);
                }

            } 
            catch (IOException ex) 
            {
                System.out.println(ex);
            }

        }
    }
    public static String access_port()
    {
        String port_number = String.valueOf(port_num);
        
        return port_number;
    }
}

