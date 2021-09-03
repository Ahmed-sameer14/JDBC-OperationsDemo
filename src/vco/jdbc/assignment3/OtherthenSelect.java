package vco.jdbc.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OtherthenSelect 
{
	public static void main(String[] args) 
	{
		Connection conc = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dburl = "jdbc:mysql://localhost:3306/vco_db";
			 conc= DriverManager.getConnection(dburl, "root" , "RootPassword");
			
			// Step3:- create sql and select jdbc statement
			String query = "update student_inforamtion set stud_name = 'sakshi' where stud_ID = 2";
			 stmt = conc.createStatement();
			
			//Step4:- execute query
			 int count  = stmt.executeUpdate(query);
			
			//Step5:- process the result
			
			System.out.println("number of rows effected = "+count);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conc!=null)
			{
				try
				{
					conc.close();
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
