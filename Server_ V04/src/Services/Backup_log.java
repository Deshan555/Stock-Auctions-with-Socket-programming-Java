package Services;

import java.io.*;

import java.util.*;

public class Backup_log 
{
    public static String backup(String data)
    {
        Create_file_name fname = new Create_file_name();
        
        String backup = fname.file_name();
                
        FileOutputStream details;
        
        try 
        {
            details = new FileOutputStream(backup,true);
            
            PrintWriter file = new PrintWriter(details);

            BufferedWriter store = new BufferedWriter(file);
            
            try 
            {
                store.write(data+"\n\n");
                
                store.newLine();

                store.close();

                file.close();
                
                String message = "Data Succesfully Backup Into\n FILE NAME :"+backup;
                
                return message;
            } 
            catch (IOException ex) 
            {
                    
                String message = "Backup Fail!!\nERROR :"+ex;
        
                return message;
            }
        } 
        catch (FileNotFoundException ex) 
        {
            
        }
        
        String message = "Data Succesfully Backup Into\n FILE NAME :"+backup;
        
        return message;
    }
}
