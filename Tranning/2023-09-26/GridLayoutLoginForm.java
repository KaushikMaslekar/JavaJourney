// Progra, : Grid Layout Login Form
// Date  : 26/Sept/2023 12:49 pm

import java.awt.*;
import javax.swing.*;

public class GridLayoutLoginForm 
{
    GridLayoutLoginForm()
    {
        JFrame jf = new JFrame("Login Form with Grid Layout ");
        JLabel userlabel = new JLabel("Username ");
        JTextField usertext = new JTextField();
        
        JLabel passlabel = new JLabel("Password ");
        JPasswordField passtext = new JPasswordField();
        
        JButton loginbutton = new JButton("Login");
        
//        TextField tf= new TextField();
//        tf.setEchoChar('*');
        
     
        jf.setLayout(new GridLayout(3,2));
       
        jf.add(userlabel);
        jf.add(usertext);
        
        jf.add(passlabel);
        jf.add(passtext);
        
        jf.add(loginbutton); 
//        jf.add(tf);
        
        
        
        
        jf.setSize(500,200);
        jf.setVisible(true);
    }

    public static void main(String args[]) 
    {
     
        GridLayoutLoginForm obj = new GridLayoutLoginForm();
    }
}
