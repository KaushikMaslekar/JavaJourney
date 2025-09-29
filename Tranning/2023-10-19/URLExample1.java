/*
Program : URL Class Example 1
Date : 19/Oct/2023  Afternoon Session
Author : ShriSoft
 */
import java.net.*;

public class URLExample1 
{

    public static void main(String args[]) 
    {
        try
        {
        URL url = new URL("https://www.yogeshwaripolytechnic.com/contact.php?act=save&name=Hello");
        
        System.out.println("Protocol --> "+url.getProtocol());
        System.out.println("Host Name --> "+url.getHost());
        System.out.println("Port Number --> "+url.getPort());
        System.out.println("File Name --> "+url.getFile());
        
        System.out.println("Defualt Port --> "+url.getDefaultPort());
        System.out.println("Path --> "+url.getPath());
        System.out.println("Query  --> "+url.getQuery());
        
        
        

        
        
        }catch(Exception e){System.out.println(e);}
        
        
    }
}
