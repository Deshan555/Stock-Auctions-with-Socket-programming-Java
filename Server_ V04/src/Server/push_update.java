package Server;

import JDBC.db_conn;

import Publisher_Obj.Send_Update;

import java.io.*;

import java.net.*;

import java.sql.*;

import java.util.Vector;


public class push_update extends Thread
{
    Statement stmt=null;
    
    Vector records = new Vector(10,10);
    
    ResultSet rs = null;
    
    ServerSocket server = null;
    
    Socket client = null;
    
    Connection con = null;
    
    ObjectOutputStream out =null;
    
    String str = null;
    
    Send_Update pub = null;
    
    static int port_num = 2003; 

    public push_update()
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
                        pub = new Send_Update();

                        pub.PRICE = rs.getString(1);

                        pub.BIDDER = rs.getString(2);

                        records.addElement(pub);                        
                    }

                    out.writeObject(records);
                    
                    out.close();
                    
                } 
                catch (SQLException ex) 
                {
                    System.out.println("Error Code : "+ex);
                }

            } 
            catch (IOException ex) 
            {
                System.out.println("Error Code : "+ex);
            }

        }
    }
}
