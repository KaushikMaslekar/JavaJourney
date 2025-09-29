
// Button Class Exaple : to create simple button 
import java.awt.*;
import java.awt.event.*;

public class ButtonEvent2 extends Frame{
    
    TextField tf=new TextField();
    Button b = new Button("Submit");
    Button b2 = new Button("Discard");
     
    ButtonEvent2()
    {
        
       
        tf.setBounds(100,100,200,40);
        add(tf);
        
        
        b.setBounds(100,150,100,40);
        add(b);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
                {
                tf.setText("Welcome to YCP ");
                }
            });
        
        
        
        b2.setBounds(250,150,100,40);
        add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
                {
                tf.setText("");
                }
            });
    
        
        
        
        
       
        
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }
                
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        ButtonEvent2 myobj = new ButtonEvent2();
    }
}
