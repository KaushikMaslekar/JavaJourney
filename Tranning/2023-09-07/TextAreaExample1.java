// TextArea Simple Example 1 

import java.awt.*;


public class TextAreaExample1 
{
    
    TextAreaExample1()
    {
       Frame f= new Frame("TextArea Example 1");
       
       TextArea area1= new TextArea();       
       area1.setBounds(10,50,200,100);
       f.add(area1);
       
       TextArea area2= new TextArea("Welcome to YCP");       
       area2.setBounds(10,200,200,100);
       f.add(area2);
       area2.setLocation(250,50); // setLocation method is used to move the component to new position
       
       
       TextArea area3= new TextArea("Hello",50,50,3);       
       area3.setBounds(10,200,200,100);
       f.add(area3);
       
       f.setSize(500,500);
       f.setLayout(null);
       f.setVisible(true);
    }
 
    public static void main(String args[]) 
    {
       TextAreaExample1 myobj=new TextAreaExample1(); 
    }
}
