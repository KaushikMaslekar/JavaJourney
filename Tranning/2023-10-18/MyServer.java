/*
Program : MyServer. Java  One Way Communication
Date : 18/Oct/2023 
Author : ShriSoft
 */
import java.net.*;
import java.io.*;
public class MyServer 
{

    public static void main(String args[]) 
    {
        
    try
    {
    ServerSocket ss = new ServerSocket(5555); // Server Socket object creation
    Socket s = ss.accept(); // Coonection is established 
    
    DataInputStream datainput = new DataInputStream(s.getInputStream());
    String text= datainput.readUTF();
    System.out.println(text);
    ss.close();
    
    }catch(Exception e){System.out.println(e);}
    
    }
}
