package Server;



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


public class Publisher_Register implements Runnable
{
   ServerSocket socket1;
    
   Connection conn = null;

   PreparedStatement pst = null;
   
   ResultSet rs = null;
   
   int port = 2002; 
 
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
                    
                    String Company_name = p1.C_NAME;
                    
                    String Company_Symbol = p1.C_SYMBOL;
                                        
                    String price = p1.PRICE;
                    
                    String Security_number = p1.S_NUMBER;
                    
                    String profit = p1.PROFIT;
                                                            
                    String SQL = "INSERT INTO Company(SYMBOL,NAME_COMPANY,PRICE,SECURITY_NUMBER,PROFIT) VALUES(?,?,?,?,?);";
                    
                    String SQL_02 = "INSERT INTO Bidding_Data(Symbol,Price)VALUES('"+Company_Symbol+"','"+price+"');";
                    
                    String SQL_03 = "INSERT INTO Data(Symbol,Price,Security,Profit)VALUES('"+Company_Symbol+"','"+price+"','"+Security_number+"','"+profit+"');";
                    
                    PreparedStatement pst_01 = conn.prepareStatement(SQL_02);
                    
                    PreparedStatement pst_02 = conn.prepareStatement(SQL_03);
                    
                    try
                    {
                        pst_01.executeUpdate();
                        
                        pst_02.executeUpdate();
                        
                        System.out.println("Data Stored In Database");
                    }
                    catch(Exception ERROR_SQL)
                    {
                        System.out.println("Can't Store Data : "+ERROR_SQL);
                    }
                    
                    System.out.println(Company_Symbol+" "+Company_name);
                                                 
                    PreparedStatement preparedStatement = conn.prepareStatement(SQL);
                                      
                    preparedStatement.setString(1,Company_Symbol);
                    
                    preparedStatement.setString(2,Company_name);
                    
                    preparedStatement.setString(3,price);
                    
                    preparedStatement.setString(4,Security_number);
                    
                    preparedStatement.setString(5,profit);
                    
                    int row = preparedStatement.executeUpdate();
                    
                    if(row > 0)
                            {
                                out.writeObject("Registerd");
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


