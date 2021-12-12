package Services;

import java.util.Random;

public class Genarete_ID
{
    public static String generate_Id()
    {
        Random rand = new Random();

        int random_id = rand.nextInt(99999);

        String ID = String.valueOf(random_id);

        String std_id = "ADMIN"+ID;

        return std_id;
    }
}

