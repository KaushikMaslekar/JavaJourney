/*
 Program : Applet Program 1 
Date : 11 / OCt / 2023 
Author ShriSoft

 */

import java.awt.Graphics;
import java.applet.Applet;

public class AppletExample1 extends Applet
{

    public void paint(Graphics g)
    {
        g.drawString("Welcome to YCP", 100, 100);
        g.drawRect(200, 200, 150, 80);
    }
}

/*
   <applet code="AppletExample1.class" width="500" height="500" >
    </applet>

*/