package Services;

import java.io.IOException;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;

public class connection 
{
   public static String net_connection() 
   {
      try 
      {
         URL url = new URL("http://www.google.com");
         
         URLConnection connection = url.openConnection();
         
         connection.connect();
         
         System.out.println("Internet is connected");
         
         String message = "Internet is connected";
         
         return message;
         
      } 
      catch (MalformedURLException e) 
      {
         System.out.println("Internet is not connected");
         
         String message = "Internet is Disable";
         
         return message;
      } 
      catch (IOException e)
      {
         System.out.println("Internet is not connected");
         
         String message = "Internet is Disable";
         
         return message;
      }
       
   }
   
   public static void main(String[] args)
   {
       net_connection();
   }
}
