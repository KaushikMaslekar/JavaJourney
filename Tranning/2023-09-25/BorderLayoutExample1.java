// Border Layout Example 1 
// 25/Sept/2023 

import java.awt.BorderLayout; // USe this Stmt If Error while accessing tthe Class BorderLayout
import java.awt.*;
import javax.swing.*;
public class BorderLayoutExample1
{
    BorderLayoutExample1()
    {
        JFrame f = new JFrame("Border Layout Example 1 ");
        
        JButton b1 = new JButton("NORTH");
        JButton b2 = new JButton("SOUTH");
        JButton b3 = new JButton("EAST");
        JButton b4 = new JButton("WEST");
        JButton b5 = new JButton("CENTER");
        
        /// Before adding Componenets  we have to set Layput 
        f.setLayout(new BorderLayout()); 
       
        f.add(b1,BorderLayout.NORTH);
        f.add(b2,BorderLayout.SOUTH);
        f.add(b3,BorderLayout.EAST);
        f.add(b4,BorderLayout.WEST);
        f.add(b5,BorderLayout.CENTER);
        
        
       
        f.setSize(400,400);
        f.setVisible(true);
        
    }

   
    public static void main(String args[]) 
    {
        BorderLayoutExample1 obj= new BorderLayoutExample1();
    }
}
