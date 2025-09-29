/*
Program : JPanel Examaple 1 
Date  : 11/Oct/2023
Author : ShriSoft

 */

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class JPanelEx1 
{
    JPanelEx1()
    {
        JFrame f =  new JFrame("JPanel Example 1");
        JPanel panel1 = new JPanel();
        panel1.setBounds(50,50,250,250);
               
        // You can set here the Layout Manager by the below statement
        //panel1.setLayout(new GridLayout(3,2)); 

        f.add(panel1);
        panel1.setBackground(Color.yellow);
        
        JLabel l1 = new JLabel("Username");
        //l1.setBounds(100,100,100,50);
        panel1.add(l1);
        
        JTextField t1= new JTextField(10);
        panel1.add(t1);
        
        JLabel l2 = new JLabel("Password");
        panel1.add(l2);
        
        JPasswordField pass= new JPasswordField(10);
        panel1.add(pass);
        
        JButton loginbutton = new JButton("Login");
        loginbutton.setBackground(Color.red);
        panel1.add(loginbutton);
        
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);
    }
            
    
    public static void main(String args[])
    {
      JPanelEx1 obj =  new JPanelEx1();
    }
}
