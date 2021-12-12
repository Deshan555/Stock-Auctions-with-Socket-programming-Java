package JDBC;

import java.io.*;

import java.text.SimpleDateFormat;

import java.util.Date;

public class bidding_history
{
    public static void record(String data_01,String data_02) throws IOException
    {                         
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date date = new Date();
                    
        String time_details = formatter.format(date);
        
        String file_name = "Bidding_History.ZTOCK";
        
        FileOutputStream details = new FileOutputStream(file_name,true);

        PrintWriter file = new PrintWriter(details);

        BufferedWriter store = new BufferedWriter(file);

        store.write("\n"+time_details+"\t"+data_01+"\t"+data_02);
                
        store.newLine();

        store.close();

        file.close();
    }
}