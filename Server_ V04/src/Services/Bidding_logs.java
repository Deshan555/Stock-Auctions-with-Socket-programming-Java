package Services;

import java.io.BufferedWriter;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.PrintWriter;

public class Bidding_logs 
{
    public static String bid_backup(String file_name,String id,String date,String Symbol,String price)
    {
                
        FileOutputStream details;
        
        try 
        {
            details = new FileOutputStream(file_name,true);
            
            PrintWriter file = new PrintWriter(details);

            BufferedWriter store = new BufferedWriter(file);
            
            try 
            {
                store.write(id+"\t"+date+"\t"+Symbol+"\t"+price+"\n\n");
                
                store.newLine();

                store.close();

                file.close();
                
                String message = "Data Succesfully Backup Into\n FILE NAME :"+file_name;
                
                return message;
            } 
            catch (IOException ex) 
            {
                    
                String message = "Fail!!\nERROR :"+ex;
        
                return message;
            }
        } 
        catch (FileNotFoundException ex) 
        {
            
        }
        
        String message = "Data Succesfully Backup Into\n FILE NAME :"+file_name;
        
        return message;
    }
    
}
