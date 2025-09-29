/*
Program : JList Example 1 
Date : 09/Oct/2023 Morning Session 
Author : ShriSoft
 */
import javax.swing.*;

public class JListEx1 
{

    JListEx1()
    {
         JFrame f = new JFrame("JList Example 1 ");
         
        JList list1= new JList(); // Empty List 
        list1.setBounds(100,100,100,50);
        f.add(list1);
        
        String data[]={"Akanksha","Samyak","Gamesh","Poonam","Samrudhi","Tejashri"};
        JList list2= new JList(data);  // JList with Data in Array
        list2.setBounds(100,200,300,200);
        f.add(list2);
        
        
        
        DefaultListModel listmodel = new DefaultListModel();  // List MOdel
        listmodel.addElement("Computer");
        listmodel.addElement("Mech");
        listmodel.addElement("Civil");
        listmodel.addElement("Electronics");
        
        JList list = new JList(listmodel); // JList with ListModel 
        list.setBounds(100,450,300,200);
        f.add(list);
        
         
        f.setLayout(null);
        f.setSize(500,800);
        f.setVisible(true);
    }
   
    public static void main(String args[]) 
    {
    JListEx1 obj = new JListEx1();
    }
}
