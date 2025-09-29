/* Swing  - JButton Example 1 with Association 
 Date  : 02/Oct/2023 */

import javax.swing.*;

public class JButtonEx1  
{
    

    public static void main(String args[])
    {
       JButtonEx1 obj = new JButtonEx1();
    }
    
    JButtonEx1()
    {
        JFrame jf = new JFrame("Simple JButton Example1");
       
       // Default Constructor with no label and no icon 
       JButton jb1= new JButton();  
       jb1.setBounds(100,50,100,50);
       jf.add(jb1);
       
       // Parameterized Constructor with label 
       JButton jb2= new JButton("Submit");  
       jb2.setBounds(100,150,100,50);
       jf.add(jb2);
       
       
        // Parameterized Constructor with  icon 
       ImageIcon icon = new ImageIcon("reg_icon1.jpg"); 
       JButton jb3= new JButton(icon );  
       jb3.setBounds(100,250,260,75);
       jf.add(jb3);
       
       jf.setLayout(null);
       jf.setSize(500,500);
       jf.setVisible(true);
       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
    }
}
