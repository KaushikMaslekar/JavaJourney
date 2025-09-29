/*
Program : Simple Login Validation 
Date  : 27/Sept/ 2023 


*/
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class LoginValidationFinal  implements ActionListener
{
    JLabel jresult;
    JTextField usertext; 
    JPasswordField passtext;
    LoginValidationFinal()
    {
     
        JFrame jf= new JFrame("Login Validation");
       
        JLabel juser = new JLabel("Username");   
        usertext = new JTextField();   
        JLabel jpass = new JLabel("Password");   
        passtext = new JPasswordField();  
        
        
        
        JButton jb1 = new JButton("Login");
        jresult= new JLabel("");
        
        jf.add(juser);
        jf.add(usertext);
        jf.add(jpass);
        jf.add(passtext);
        jf.add(jb1);
        jf.add(jresult);
        
        jb1.addActionListener(this);
        
        jf.setLayout(new GridLayout(3,2));
        
        jf.setSize(400,200);
        jf.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String user= usertext.getText();
        String pass=passtext.getText();
        
        if((user.equals("Admin")) && (pass.equals("123456")))
        {
            jresult.setForeground(Color.blue);
            jresult.setText("Valid User");
            
            /*JFrame newFrame= new JFrame("Welcome User");
            newFrame.setSize(600,600);
            newFrame.setVisible(true);*/
            
        }
        else
        {
          jresult.setForeground(Color.red);
          jresult.setText("Invalid User");
              
        }
    }
    
    
    public static void main(String args[])
    {
        LoginValidationFinal obj = new LoginValidationFinal();
    }
}
