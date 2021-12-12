package Core;

import java.io.BufferedWriter;

import java.io.FileOutputStream;

import java.io.PrintWriter;

public class cache_writer 
{
    public static void writer(String file_name,String data)
    {
        try
        {        
        FileOutputStream details = new FileOutputStream(file_name);

        PrintWriter file = new PrintWriter(details);

        BufferedWriter store = new BufferedWriter(file);

        store.write(data);
                
        //store.newLine();

        store.close();

        file.close();
        }
        catch(Exception error)
        {
            System.out.println("ERROR : "+error);
        }
    }
    
    public static void main(String args[])
    {
        writer("ip_address.dat","localhost");
    }
    
}
