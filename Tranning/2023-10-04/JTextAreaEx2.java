/*
Program : Swing TextArea Example 2 with Action Listener 
to count no of words and no of characters 
Date   : 04th OCt 2023
Author : Shrisoft
 */

import javax.swing.*;
import java.awt.event.*;

public class JTextAreaEx2 implements ActionListener 
{
  JTextArea t; JButton b; JLabel l1,l2 ; 
  
   JTextAreaEx2()
   {
       JFrame f = new JFrame("Swing TextArea Example 1");
       
       t= new JTextArea(); 
       t.setBounds(100,100,200,100);
       f.add(t);
       
       b=new JButton("Count");
       b.setBounds(100,200,100,50);
       f.add(b);
       b.addActionListener(this);

       l1=new JLabel();
       l1.setBounds(100,250,200,50);
       f.add(l1);
       
       l2=new JLabel();
       l2.setBounds(100,300,200,50);
       f.add(l2);
        
       f.setLayout(null);
       f.setSize(400,400);
       f.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e)
   {
       String data = t.getText();
       String words[] = data.split("\\s");
       
       l1.setText("Number of Words : "+words.length);
       
       l2.setText("Number of Characters : "+ data.length());
   }
   
    
    public static void main(String args[]) 
    {
       JTextAreaEx2 obj = new JTextAreaEx2();
    }
}
