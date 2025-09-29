/*
Program : JPasswordField Example 1 
Date :  04 Oct 2023 
Author  : ShriSoft

 */

import javax.swing.*;
import java.awt.*;

public class JPasswordFieldEx1 
{

    
    JPasswordFieldEx1()
    {
      JFrame f = new JFrame("JPasswordField Example 1 ");  
      
      JLabel l = new JLabel("Password");
      l.setBounds(50,100,100,30);
      f.add(l);
      
      JPasswordField pass = new JPasswordField();
      pass.setBounds(150, 100 , 150, 30);
      f.add(pass);
      
      
      
      //How to set AWT Password Field using TextField Class 
      /*TextField pass2 = new TextField();
      pass2.setBounds(150, 200 , 150, 30);
      f.add(pass2);
      pass2.setEchoChar('*');*/
      
      f.setLayout(null);
      f.setSize(400,400);
      f.setVisible(true);
    }
    public static void main(String args[])
    {
    JPasswordFieldEx1 obj = new JPasswordFieldEx1();   
    }
}
