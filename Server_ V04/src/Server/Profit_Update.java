package Server;

import static Interfaces.Bidding_Home.log_area;
import JDBC.db_conn;
import Publisher_Obj.Publisher;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Profit_Update implements Runnable
{
   ServerSocket socket1;
    
   Connection conn = null;

   PreparedStatement pst = null;
   
   ResultSet rs = null;
   
   int port = 2001;
 
    @Override
    public void run() 
    {
        try {
            socket1 = new ServerSocket(port);

            
            while (true) {
                Socket clientconnection = socket1.accept();

                Thread.sleep(0);

                Handler handler1 = new Handler(clientconnection);

                handler1.start();
            }
        } 
        catch (Exception ioe) 
        {
            System.out.println("error");
            
            log_area.append("Error :"+ioe+"\n\n");
        }
    }
    
    class Handler extends Thread 
    {
        ObjectInputStream in = null;

        ObjectOutputStream out = null;

        public Handler(Socket request)
        {
            try 
            {
                in = new ObjectInputStream(request.getInputStream());

                out = new ObjectOutputStream(request.getOutputStream());
            } 
            catch (IOException io) 
            {
                System.out.println("can't take i/o stream");
                
                log_area.append("Error :"+io+"\n\n");
                               
            }
        }
        public void run( )
        {
            try{
                while(true)
                {
                    Publisher  p1=(Publisher)in.readObject();

                    Connection conn = null;

                    PreparedStatement pst = null;

                    db_conn db = new db_conn();

                    conn = db.connect();
                    
                    String Company_Symbol = p1.C_SYMBOL;
                                                            
                    String Security_number = p1.S_NUMBER;
                    
                    String profit = p1.PROFIT;
                    
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                    Date date = new Date();
                    
                    String time_details = formatter.format(date);
                    
                    log_area.append("NEW PROFIT UPDATE\nTime :"+time_details+"\nSymbol : "+Company_Symbol+"\nUpdate Price : "+profit+"\n\n");
                                        
                    String SQL = "UPDATE DATA SET Profit = '"+profit+"' WHERE Symbol = '"+Company_Symbol+"' AND Security = '"+Security_number+"';";
                    
                    String SQL_02 = "UPDATE Company SET PROFIT = '"+profit+"' WHERE SYMBOL = '"+Company_Symbol+"';";
                                        
                    PreparedStatement pst_01 = conn.prepareStatement(SQL_02);
                    
                    PreparedStatement pst_02 = conn.prepareStatement(SQL);
                    
                    try
                    {
                        pst_01.executeUpdate();
                        
                        pst_02.executeUpdate();
                        
                        out.writeObject("PROFIT UPTO DATE");
                    }
                    catch(Exception ERROR_SQL)
                    {
                        System.out.println("Can't Store Data : "+ERROR_SQL);
                    }
                }                        
            }
            catch(Exception ERROR)
            {
                System.out.print("ERROR : "+ERROR);
            }
        }
    }
}

