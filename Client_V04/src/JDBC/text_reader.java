package JDBC;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class text_reader 
{
    public static String reader() throws FileNotFoundException
    {
        String db_name = "USER.ZTOCK";
        
        FileInputStream fis = new FileInputStream(db_name);

        Scanner output = new Scanner(fis);
        
        String user_name = null;

        while (output.hasNext())
        {
            user_name = output.nextLine();
            
            System.out.print(user_name);            
        }
        
        return user_name;
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        reader();
    }
    

}
