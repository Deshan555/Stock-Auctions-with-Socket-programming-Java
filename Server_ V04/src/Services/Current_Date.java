package Services;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class Current_Date 
{

    public static String date() 
    {
        LocalDateTime current = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String formatted = current.format(formatter);

        return formatted;
    }
}
