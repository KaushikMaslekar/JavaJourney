
// Button Class Exaple : to create simple button 
import java.awt.*;
import java.awt.event.*;

public class ButtonEvent1 extends Frame implements ActionListener{
    
    TextField tf=new TextField();
     
    ButtonEvent1()
    {
        
       
        tf.setBounds(100,100,200,40);
        add(tf);
        
        Button b = new Button("Submit");
        b.setBounds(100,150,100,40);
        b.addActionListener(this); // Important line of code 
        add(b);
        
        
       
        
        setSize(400,400);
        setLayout(null);
        setVisible(true);
                
    }
    
    public void actionPerformed(ActionEvent e)
    {
        tf.setText("Welcome to YCP ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        ButtonEvent1 myobj = new ButtonEvent1();
    }
}
