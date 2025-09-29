// GridBagLayout Example 1 
// Date  1/Oct/2023 

import java.awt.*;
import javax.swing.*;

public class GridBagLayoutEx1 extends JFrame 
{

   GridBagLayoutEx1()
   {
       
       Container cpane= getContentPane();
       GridBagLayout gb = new GridBagLayout();
       GridBagConstraints  c1 = new GridBagConstraints();
       
       c1.insets = new Insets(5,5,5,5);
       c1.ipadx=10;
       c1.ipady=10;
       
       JPanel jp = new JPanel();
       jp.setBackground(Color.pink);
       
       Font f1 = new Font("Verdana", Font.PLAIN, 22);
       Font f2 = new Font("Verdana", Font.PLAIN, 16);
              
       JLabel lreg= new JLabel("Registration Form"); 
       lreg.setFont(f1);
       
       JLabel lname= new JLabel("Name");
       lname.setFont(f2);
       
       JLabel lmobile= new JLabel("Mobile");
       lmobile.setFont(f2);
       
       JLabel lemail= new JLabel("Email");
       lemail.setFont(f2);
       
       JLabel laddress= new JLabel("Address");
       laddress.setFont(f2);
       
       
       JTextField tname = new JTextField(20);
       JTextField tmobile = new JTextField(20);
       JTextField temail = new JTextField(20);
       JTextArea taddress = new JTextArea(4,20);
       
       JButton jsignup= new JButton("Sign Up");
       jsignup.setBackground(Color.blue);
       
       jsignup.setFont(f1);
       
/// setLayout method must be called before adding the components to Jpanel
       jp.setLayout(gb); 
                
                
        c1.gridx=0;c1.gridy=0;jp.add(lreg, c1);
        
       c1.gridx=0;c1.gridy=1; jp.add(lname, c1);
        c1.gridx=0;c1.gridy=2;jp.add(lmobile, c1);
        c1.gridx=0;c1.gridy=3;jp.add(lemail, c1);
        c1.gridx=0;c1.gridy=4;jp.add(laddress, c1);
        
        
         c1.gridx=1;c1.gridy=1;jp.add(tname, c1);
         c1.gridx=1;c1.gridy=2;jp.add(tmobile, c1);
         c1.gridx=1;c1.gridy=3;jp.add(temail, c1);
         c1.gridx=1;c1.gridy=4;jp.add(taddress, c1);
         
          c1.gridx=1;c1.gridy=5;jp.add(jsignup, c1);
       
       
       
       cpane.add(jp);
       
       setTitle("Grid Bag Layout Example ");
       setSize(700,700);
       setVisible(true);
       
       
   }
   
    public static void main(String args[])
    {
        GridBagLayoutEx1 obj = new GridBagLayoutEx1();
    }
}
