package Services;

import java.net.Inet4Address;

import java.net.UnknownHostException;

public class get_ip
{

    public static String get_ip_address() throws UnknownHostException
    {
        String address = Inet4Address.getLocalHost().toString();

        return address;
    }
}
