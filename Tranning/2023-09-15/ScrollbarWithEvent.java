// Scroll Bar with Adjustment Event 

import java.awt.*;
import java.awt.event.*;

public class ScrollbarWithEvent 
{
    Label label1;
    ScrollbarWithEvent()
    {
        Frame f = new Frame("Scrollbar With AdjustMent Event ");
        
        label1=new Label();
        label1.setBounds(200,300,300,200);
        f.add(label1);
        
        Scrollbar sb=new Scrollbar();
        sb.setBounds(200,100,50,200);
        f.add(sb);
        
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        
        
        sb.addAdjustmentListener(new AdjustmentListener(){
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
         
           
             //System.out.println(sb.getValue());
            label1.setText("ScrollBar Value : "+sb.getValue());
             
             
        }
        });
        
         sb.setValue(50);
        
        System.out.println("Maximum Value : "+ sb.getMaximum());
        System.out.println("Minumium Value : "+ sb.getMinimum());
        System.out.println("Orientation Value : "+ sb.getOrientation());
        System.out.println("Current Value : "+ sb.getValue());
       
         
    }

    public static void main(String args[]) 
    {
       
        ScrollbarWithEvent obj= new ScrollbarWithEvent();
    }
}
