package Services;

import java.io.*;

public class Subscribers_Handler 
{
    public static void Subscribers(String subscriber_name,String symbol)
    {
        
        String file_name  = symbol+".txt";
                
        FileOutputStream details;
        
        try 
        {
            details = new FileOutputStream(file_name,true);
            
            PrintWriter file = new PrintWriter(details);

            BufferedWriter store = new BufferedWriter(file);
            
            try 
            {
                store.write(subscriber_name+"\n");
                
                store.newLine();

                store.close();

                file.close();
                
                System.out.print("Subscription Add");
                
            } 
            catch (IOException ex) 
            {
               System.out.print("ERROR = "+ex);
            }
        } 
        catch (FileNotFoundException ex_02) 
        {
            System.out.print("ERROR = "+ex_02);
        }        
    }    
}
