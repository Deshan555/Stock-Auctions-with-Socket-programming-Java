package Services;

public class Create_file_name 
{
    public static String file_name()
    {
        Current_Date my_object = new Current_Date();
        
        String file_name = my_object.date()+"_backup.txt";
        
        return file_name;
    }
    
    public static void main(String[] args)
    {
        System.out.println(file_name());
    }
    
}
