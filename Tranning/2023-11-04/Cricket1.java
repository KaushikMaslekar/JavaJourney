/*
Program : Cricket DB Program 1 with Statement Interface 
Select Data and Insert Data 
Date : 3/Nov/2023
Author : ShriSoft
 */

import java.sql.*;

public class Cricket1 
{
    static Statement stmt;

    public static void main(String args[]) 
    {
        
        try 
        {
            // Register Driver 
            Class.forName("com.mysql.jdbc.Driver");
            
            // Connection interface object 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket_db","root","");
            
            // Statement Interface object 
            stmt = con.createStatement();
            
            // Data Read / Retrive using Select Query  
            // create Resultset Interface Object
            showplayers();
            
            
            
            int res = stmt.executeUpdate("insert into player_m values(5 , 'R Jadeja', 'India' ,156 )");
            System.out.println("No of Records inserted : " + res);
            
            showplayers();
             
            
            
        }catch(Exception ex){System.out.println(ex);}
    
    }
    
    public static void showplayers()
    {
        System.out.println("Player Information");
        try{
         ResultSet rs1= stmt.executeQuery("Select * from player_m");
            
            while(rs1.next())
            {
                System.out.println(rs1.getInt(1) + " " + rs1.getString(2)
                + " " + rs1.getString(3)+ " " + rs1.getInt(4));
            }
        }catch(Exception ex){System.out.println(ex);}
    }
}
