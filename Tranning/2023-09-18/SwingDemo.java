import java.awt.*;
import javax.swing.*;

public class SwingDemo 
{
    SwingDemo()
    {
        JFrame f =  new JFrame("Simple Swing Demo ");
        
        JTextField tf= new JTextField();
        tf.setBounds(100,100,300,50);
         f.add(tf);
        
        JButton b1= new JButton("Submit");
        b1.setBounds(100,150,100,50);
         f.add(b1);
       
        
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    public static void main(String args[]) 
    {
    SwingDemo obj=new SwingDemo();    
    }
}
