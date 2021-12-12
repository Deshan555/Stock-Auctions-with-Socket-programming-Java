package Core;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class cache_reader 
{
    public static String reader(String db_name) throws FileNotFoundException
    {   
        FileInputStream fis = new FileInputStream(db_name);

        Scanner output = new Scanner(fis);
        
        String text = null;

        while (output.hasNext())
        {
            text = output.nextLine();
            
            System.out.print(text);            
        }
        
        return text;
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        reader("ip_address.dat");
    }
}
