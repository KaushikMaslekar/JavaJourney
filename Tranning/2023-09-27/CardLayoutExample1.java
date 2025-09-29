/*
Program Name  : Card Layout Example 1 
Date  : 27/Sept/2023

*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CardLayoutExample1 extends JFrame implements ActionListener
{
    CardLayout crd; 
    JButton b1,b2,b3,b4;
    Container cpane;
    
    CardLayoutExample1()
    {
     
        cpane = getContentPane(); 
        crd= new CardLayout();  // Default Constructors : it covers whole area
        cpane.setLayout(crd);
        
        b1=new JButton("Mercedeze");
        b2=new JButton("BMW");
        b3=new JButton("Audi");
        b4=new JButton("Rollys Roys");
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        cpane.add(b1);
        cpane.add(b2);
        cpane.add(b3);
        cpane.add(b4);
        
        setTitle("Card Layout Example 1 ");
        setSize(400,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        crd.next(cpane);
    }
    
    

    public static void main(String args[]) 
    {
        CardLayoutExample1  obj = new CardLayoutExample1();
    }
}
