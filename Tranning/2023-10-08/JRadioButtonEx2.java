/*
Program : JRadioButton With Action Listener and JOptionPane
Date  : 08/10/2023   Evening Session 
Author : ShriSOft
 */
import javax.swing.*;
import java.awt.event.*;

public class JRadioButtonEx2 extends JFrame implements ActionListener 
{
     JButton b ;
     JRadioButton male , female ;
     JLabel  l ;
    JRadioButtonEx2()
    {
       
        
        b = new JButton("Submit");
        b.setBounds(100,180,100,50);
        add(b);
        
        b.addActionListener(this);
        
        
        JLabel l1= new JLabel("Select Gender");       
        l1.setBounds(50,50,100,50);      
        add(l1);
      
       // JRadio Button        
        male = new JRadioButton("Male");
        male.setBounds(100,100,100,50);
        
        female = new JRadioButton("Female");
        female.setBounds(200,100,100,50);
        
        // Button Group 
        ButtonGroup genderbg = new ButtonGroup();
        genderbg.add(male);
        genderbg.add(female);
        
        
        add(male);
        add(female);
        
        /// Label for Showeing Messgwe
        l = new JLabel();
        l.setBounds(100,230,300,50);
        add(l);
        
       
        setTitle("JRadioButton With Action Listener and JOptionPane");
        setLayout(null);
       setSize(400,350);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(male.isSelected())
        {
           // l.setText("You Selected Male");
           JOptionPane.showMessageDialog(this,"You have selected Male Gender");
          
        }
        
        else if(female.isSelected())
        {
            //l.setText("You Selected Female");
           JOptionPane.showMessageDialog(this,"You have selected Female Gender");
           
        }
    }
   
    public static void main(String args[]) 
    {
        JRadioButtonEx2 obj =  new JRadioButtonEx2();
    }
}
