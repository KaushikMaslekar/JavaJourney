/*
Program : Applet with Painting using MouseMotionListener Evening Session 
Date : 12 / Oct / 2023 
Authore : ShriSoft
 */

// import packages 
import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class AppletPainting extends Applet implements MouseMotionListener
{
  
   
    public void init()
    {   
        addMouseMotionListener(this);
    }
    
   
    
    public void mouseDragged(MouseEvent e)
    {
       Graphics g = getGraphics();
       g.setColor(Color.blue);
        g.fillOval(e.getX(), e.getY(), 10, 10);
    }
    
    public void mouseMoved(MouseEvent e)
    {
         
    }
    
    
}


/*
<applet code= "AppletPainting.class" width= "500" height="500">
</applet>
*/
