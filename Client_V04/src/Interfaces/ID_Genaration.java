package Interfaces;

import java.util.Random;

public class ID_Genaration 
{
    protected static String generate_Id()
    {
        Random rand = new Random();

        int random_id = rand.nextInt(99999);

        String ID = String.valueOf(random_id);

        String std_id = "ZTOCK"+ID;

        return std_id;
    }
    
    public static void main(String[] args)
    {
       
        
        System.out.print( generate_Id());
    }
        
}