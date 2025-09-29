// Program : Flow Layout Example 1 
// Date  : 26/Sept/2023
import java.awt.*;
import javax.swing.*;

public class FlowLayoutEx1 
{
    FlowLayoutEx1()
    {
        JFrame  jf = new JFrame("Flow Layout Example 1");
        
        JButton jb1= new JButton("B1");
        JButton jb2= new JButton("B2");
        JButton jb3= new JButton("B3");
        JButton jb4= new JButton("B4");
        JButton jb5= new JButton("B5");
        JButton jb6= new JButton("B6");
        JButton jb7= new JButton("B7");
        JButton jb8= new JButton("B8");
        JButton jb9= new JButton("B9");
        
        
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(jb4);
        jf.add(jb5);
        jf.add(jb6);
        jf.add(jb7);
        jf.add(jb8);
        jf.add(jb9);
        
        
        
        jf.setLayout(new FlowLayout());        
        jf.setSize(400,400);
        jf.setVisible(true);
        
    }

   
    public static void main(String args[]) 
    {
        FlowLayoutEx1 obj = new FlowLayoutEx1(); // Craeted here object of class 
    }
}
