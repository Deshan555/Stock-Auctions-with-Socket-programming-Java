package Server;

import JDBC.db_conn;

import Publisher.Subscriber;

import java.io.*;

import java.net.*;

import java.sql.*;

import java.util.Vector;


public class Subscription_push extends Thread
{
    Statement stmt=null;
    
    Vector records = new Vector(10,10);
    
    ResultSet rs = null;
    
    ServerSocket server = null;
    
    Socket client = null;
    
    Connection con = null;
    
    ObjectOutputStream out =null;
    
    String str = null;
    
    Subscriber pub = null;
    
    static int port_num = 2004; 

    public Subscription_push()
    {
        try 
        {
            server = new ServerSocket(port_num);
                        
            start();
        } 
        catch (IOException error) 
        {
            System.out.print("ERROR : "+error);            
        }

    }

    public void run()
    {
        ObjectInputStream in = null;
        
        while(true)
        {
            try {
                int CC;
                
                client = server.accept();
                
                DataInputStream dis=new DataInputStream(client.getInputStream());  

                String query =(String)dis.readUTF();  
                
                out = new ObjectOutputStream(client.getOutputStream());
                                
                try 
                {                    
                    PreparedStatement pst = null;
                    
                    con = db_conn.connect();
                    
                    String sql = query;

                    pst = con.prepareStatement(sql);
        
                    rs = pst.executeQuery();

                    records.removeAllElements();

                    ResultSetMetaData RSMD = rs.getMetaData();

                    CC = RSMD.getColumnCount();

                    while(rs.next())
                    {
                        pub = new Subscriber();

                        pub.SYMBOL = rs.getString(1);

                        pub.PRICE = rs.getString(2);

                        pub.BIDDER = rs.getString(3);

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
}
