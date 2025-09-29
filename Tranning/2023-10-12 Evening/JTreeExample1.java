/*
Program : Jtree Example1  Evening Session 
Date : 12 / Oct / 2023 
Authore : ShriSoft
 
 */

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeExample1 
{
    
    JTreeExample1()
    {
     JFrame f = new JFrame("JTree Example 1 ");
     
     DefaultMutableTreeNode top = new DefaultMutableTreeNode("TOP");
     
     DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
     DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
     
     DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
     DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
     
     DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
     DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
     DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B3");
     
     a.add(a1);  a.add(a2);
     
     b.add(b1); b.add(b2); b.add(b3);
     
     top.add(a);  top.add(b);
     
     JTree tree = new JTree(top);
     
     f.add(tree);
     
     f.setSize(500,500);
     f.setVisible(true);
    }
            
    public static void main(String args[]) 
    {
    JTreeExample1 obj = new JTreeExample1();
    }
}
