/*
Program : Applet with Event  Afternoon Session 
Date : 12 / Oct / 2023 
Authore : ShriSoft
 */
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

public class AppletEventEx1 extends Applet implements ActionListener
{

    TextField tf; 
    Button  b1; 
    
    // Init () method of Applet
    public void init()
    {
        tf = new TextField();
        tf.setBounds(100,100,300,50);
        
        b1= new Button("Submit");
        b1.setBounds(100,200,100,50);
        b1.addActionListener(this);
        
        add(tf);
        add(b1);
        
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent e )
    {
     tf.setText("Welcome to YCP ");
    }
   
    
    
}

// Applet Tag as below 
/*
<applet code = "AppletEventEx1.class" width="500" height="500">
</applet>


*/