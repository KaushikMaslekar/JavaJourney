/*
Program : YCPServer. Java  Two Way Communication
Date : 18/Oct/2023 
Author : ShriSoft
 */
import java.net.*;
import java.io.*;

public class YCPServer 
{

     public static void main(String args[]) 
    {
        try 
        {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream datainput= new DataInputStream(s.getInputStream());
            DataOutputStream dataoutput = new DataOutputStream(s.getOutputStream());
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String str1="";  // Data From Client 
            String str2="";  // Data to be sent to Client
            
            while(!str1.equals("stop"))
            {
                str1 = datainput.readUTF();
                System.out.println("Client Says : "+str1);
                
                str2= br.readLine();
                dataoutput.writeUTF(str2);
                dataoutput.flush();
                
               
                
            }
            datainput.close();
            s.close();
            ss.close();
            
        }catch(Exception e){System.out.println(e);}
        
    }
}
