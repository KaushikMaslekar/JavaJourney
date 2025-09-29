// Border Layout Example 2 without Regions 
// 25/Sept/2023 

import java.awt.BorderLayout; // If Error while accessing tthe Class 
import java.awt.*;
import javax.swing.*;
public class BorderExampleWithoutRegion
{
    BorderExampleWithoutRegion()
    {
        JFrame f = new JFrame("Border Layout Example 2 ");
        
        JButton b1 = new JButton("NORTH");
        JButton b2 = new JButton("SOUTH");
        JButton b3 = new JButton("EAST");
        JButton b4 = new JButton("WEST");
        JButton b5 = new JButton("CENTER");
        
        /// Before adding Componenets  we have to set Layput 
        f.setLayout(new BorderLayout(20,10)); 
       
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
//        
        
       
        f.setSize(400,400);
        f.setVisible(true);
        
    }

   
    public static void main(String args[]) 
    {
        BorderExampleWithoutRegion obj= new BorderExampleWithoutRegion();
    }
}
