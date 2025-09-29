/*
Program : Cricket DB Program 2 with Statement Interface 
Show Data and Update and delete Data 
Date : 3/Nov/2023
Author : ShriSoft
 */

import java.sql.*;

public class Cricket2 
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
            
            
            // delete data 
            int res = stmt.executeUpdate("delete from player_m where pid= 4");
            System.out.println("No of Records deleted : " + res);
            
            showplayers();
             
            
             // update data 
            res = stmt.executeUpdate("update player_m  set pname='Ravindra Jadeja' where pid= 5");
            System.out.println("No of Records updated : " + res);
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
