package Services;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.util.Scanner;

import Interfaces.Summery;

import static Interfaces.Summery.log;

public class text_reader 
{
    public static void reader(String db_name) throws FileNotFoundException
    {        
        FileInputStream fis = new FileInputStream(db_name);

        Scanner output = new Scanner(fis);
        
        String logs = null;

        while (output.hasNext())
        {
            logs = output.nextLine()+"\n";
            
            System.out.print(logs);
            
            log.append(logs);
        }
    }
}