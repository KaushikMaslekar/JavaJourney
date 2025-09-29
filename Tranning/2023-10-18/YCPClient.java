/*
Program : YCP Client. Java  Two Way Communication
Date : 18/Oct/2023 
Author : ShriSoft
 */
import java.net.*;
import java.io.*;

public class YCPClient 
{
    

    public static void main(String args[]) 
    {
        try
        {
            Socket s = new Socket("localhost",6666);
            DataInputStream datainput= new DataInputStream(s.getInputStream());
            DataOutputStream dataoutput = new DataOutputStream(s.getOutputStream());
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str1=""; // Data to be sent to the Server
            String str2=""; // Data From Server
            
            while(!str1.equals("stop"))
            {
                str1= br.readLine();
                dataoutput.writeUTF(str1);
                dataoutput.flush();
                
                str2 = datainput.readUTF();
                System.out.println("Server Says : "+str2);
                
            }
            
            dataoutput.close();
            s.close();  // Socket Close 
            
                  
            
        }catch(Exception e){System.out.println(e);}
            
    }
}
