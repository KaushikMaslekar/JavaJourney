/*
Program : JCheckBox Example 1 
Date :  04 Oct 2023 
Author  : ShriSoft

 */

import javax.swing.*;

public class JCheckBoxEx1 
{
    JCheckBoxEx1()
    {
      JFrame f = new JFrame("JCheckBox Example 1 ");  
      
      JCheckBox c1 = new JCheckBox();
      c1.setBounds(100,100,100,30);
      f.add(c1);
      
      JCheckBox c2 = new JCheckBox("AJP Training");
      c2.setBounds(100,150,100,30);
      f.add(c2);
      
      JCheckBox c3 = new JCheckBox("Python Training" , true);
      c3.setBounds(100,200,150,30);
      f.add(c3);
      
      f.setLayout(null);
      f.setSize(400,400);
      f.setVisible(true);
    }
  
    public static void main(String args[]) 
    {
        JCheckBoxEx1 obj = new JCheckBoxEx1();
    }
}
