/*
Program : Windows Listener Example 1
Date  : 15 / Oct / 2023 Afternoon Session 
Author  : ShriSoft 

 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class WindowListenerEx1 extends Frame implements WindowListener
{
   
    
    WindowListenerEx1()
    {
       
       setLayout(null);
       setSize(400,400);
       setVisible(true);
        
      addWindowListener(this);  
       
    }
    
   
    public void windowDeactivated(WindowEvent we)
    {
     System.out.println("Window is Deactivated");
    }
    
    public void windowActivated(WindowEvent we)
    {
        System.out.println("Window is Activated");
    }
    
     public void windowDeiconified(WindowEvent we )
     {
         System.out.println("Window is Diconified");
     }
     
     public void windowIconified(WindowEvent we )
     {
         System.out.println("Window is Iconified");
     }
     
    public void windowClosed(WindowEvent we)
    {
        System.out.println("Window is Closed");
    }
    
    public void windowClosing(WindowEvent we)
    {
        System.out.println("Window is Closing");
        dispose();
    }
    
    public void windowOpened(WindowEvent we)
    {
        System.out.println("Window is Openeds");
    }
     
    
    public static void main(String args[]) 
    {
    WindowListenerEx1 obj = new WindowListenerEx1();
    }
}
