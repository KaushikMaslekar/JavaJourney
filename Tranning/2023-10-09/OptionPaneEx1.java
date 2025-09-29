/*
Program : Option Pane Example 1  : Message Dialog Box 
Date : 09/Oct/2023 Afternoon Session 
Author : ShriSoft
 */
import javax.swing.*;


public class OptionPaneEx1 
{
    OptionPaneEx1()
    {
        JFrame f = new JFrame("JOptionPane Example 1");
        
        JOptionPane.showMessageDialog(f, "Welcome to AJP Training");
        JOptionPane.showMessageDialog(f, "Please Try again...", "Error",
                JOptionPane.WARNING_MESSAGE);
//        f.setLayout(null);
//        f.setSize(400,400);
//        f.setVisible(true);
    }
   
    public static void main(String args[]) 
    {
       OptionPaneEx1 obj = new OptionPaneEx1();
    }
}
