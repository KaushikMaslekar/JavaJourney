// TextArea Example to find number of words and characters 
import java.awt.*;
import java.awt.event.*;


public class TextAreaWithActionEvent extends Frame implements ActionListener
{
    TextArea t;
    Button b;
    Label l1;
    Label l2;
    
  
    TextAreaWithActionEvent()
    {
        t=new TextArea();
        b=new Button("Submit");
        l1=new Label();
        l2=new Label();
        
        t.setBounds(50,50,200,100);
        b.setBounds(50,200,100,50);
        l1.setBounds(50,300,300,50);
        l2.setBounds(50,400,300,50);
        
        add(t);
        add(b);
        add(l1);
        add(l2);
        
        b.addActionListener(this);
        
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String text=t.getText();
//        System.out.println(text);
        String var[]=text.split("\\s");
//        System.out.println(var.length);    
        l1.setText("Number of Words ===>  "+var.length);
        l2.setText("Number of Characters ===>  "+text.length());
    }

    public static void main(String args[]) 
    {
        TextAreaWithActionEvent obj=new TextAreaWithActionEvent();
        
    }
}
