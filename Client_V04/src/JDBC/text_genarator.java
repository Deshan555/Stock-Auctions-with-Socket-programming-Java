package JDBC;

import java.io.BufferedWriter;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.PrintWriter;

public class text_genarator
{
    public static String add_data(String files,String details0,String details1,String details2,String details3,String details4,String details5) throws IOException
    {
        String file_name = files+".txt";
        
        FileOutputStream details = new FileOutputStream(file_name);

        PrintWriter file = new PrintWriter(details);

        BufferedWriter store = new BufferedWriter(file);

        store.write("User ID :"+details0+"\n\n"
                
                +"User Name :"+details1+"\n\n"
                
                +"Full Name :"+details2+"\n\n"
                
                +"E mail :"+details3+"\n\n"
                
                +"Mobile Number :"+details4+"\n\n"
                
                +"Password :"+details5+"\n\n"
        
        +"Backup By ZTOCK CLIENT V01");
                
        store.newLine();

        store.close();

        file.close();

        System.out.print("Data Successfully Entered To "+file_name+"\n");
        
        String message = "Data Successfully Entered To "+file_name;
        
        return message;

    }
}

