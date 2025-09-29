/*
Program : Myclient. Java 
Date : 18/Oct/2023 
Author : ShriSoft
 */
import java.net.*;
import java.io.*;

public class MyClient 
{
    
    
    public static void main(String args[]) 
    {
        try
        {
        Socket s = new Socket("localhost",5555); // Creating Socket for Client
        
        DataOutputStream dataoutput = new DataOutputStream(s.getOutputStream());
        dataoutput.writeUTF("Hello I Am Client");
        dataoutput.flush();
        s.close();
                
        }catch(Exception e ){System.out.println(e);}
        
    
    }
}
