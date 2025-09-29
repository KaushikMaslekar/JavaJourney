
/*
Program : DB Program 2  
Date  : 30/Oct/2023 Evening Session 

*/

import java.sql.*;

public class MyDBProgram2 
{

    public static void main(String[] args) 
    {
       try
       {
           // step 1 : register Driver
           Class.forName("com.mysql.jdbc.Driver");  
           
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
		   
		   //Step 5  Delete 5th Record having Rollno 1205
		   int result = stmt.executeUpdate("delete from stud_m where srollno=1205");
		   System.out.println("Total Number of Records Deleted : " + result);
		   
		   
		   //Step 6  Update 4th Record having Rollno 1204 and set Name as Naha Maske
		   int result2 = stmt.executeUpdate("update stud_m set sname='Neha Maske' where srollno=1204");
		   System.out.println("Total Number of Records updated : " + result2);
		   
		   
		   //Step 7  Insert New  Record having StudID 7  Rollno 1207 Name Prachi Kharat
		   int result3 = stmt.executeUpdate("insert into stud_m(sid,srollno,sname) values(7,1207,'Prachi Kharat') ");
		   System.out.println("Total Number of Records inserted : " + result3);
		   
           con.close();
           
       }catch(Exception e){System.out.println(e);}
    }
    
}
