package JDBC;

import java.io.BufferedWriter;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.PrintWriter;

public class run_time_log 
{
        public static void add_data(String user) throws IOException
    {
        String file_name = "USER.ZTOCK";
        
        FileOutputStream details = new FileOutputStream(file_name);

        PrintWriter file = new PrintWriter(details);

        BufferedWriter store = new BufferedWriter(file);

        store.write(user);
                
        //store.newLine();

        store.close();

        file.close();

        System.out.print("Data Successfully Entered To "+file_name+"\n");
        
    }
}
