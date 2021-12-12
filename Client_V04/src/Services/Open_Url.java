package Services;

import java.awt.Desktop;

import java.io.IOException;

import java.net.URI;

import java.net.URISyntaxException;

public class Open_Url 
{
    public static void visit(String URL) throws IOException
    {
        Desktop desktop = java.awt.Desktop.getDesktop();
		
        try 
        {
	//specify the protocol along with the URL
            			
            URI oURL = new URI(URL);
			
            desktop.browse(oURL);
		
        } 
        catch (URISyntaxException e) 
        {		
            // TODO Auto-generated catch block
	    
            e.printStackTrace();
	}
	
    }
    
}