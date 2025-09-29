
package ycpapp1;

import java.sql.*;

public class YCPApp1 
{

    public static void main(String[] args) 
    {
       try
       {
           // step 1 : register Driver
           Class.forName("com.mysql.cj.jdbc.Driver");  
           
           // Step 2 : Create Connection object
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ycp_db","root",""); 
           
            // Step 3 : Create Statement objet
           Statement stmt = con.createStatement();
           
           // Step 4 : Execute query : it will return resultset object
           ResultSet rs = stmt.executeQuery("select * from stud_m");
           
           while(rs.next())
           {
               System.out.println(rs.getInt(1)+" "+ rs.getInt(2) + " "+rs.getString(3));
           }
           con.close();
           
       }catch(Exception e){System.out.println(e);}
    }
    
}
