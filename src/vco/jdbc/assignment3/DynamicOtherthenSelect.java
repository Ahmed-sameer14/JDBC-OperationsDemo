package vco.jdbc.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicOtherthenSelect 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conc = null;
		PreparedStatement psmt= null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dburl = "jdbc:mysql://localhost:3306/vco_db";
			 conc= DriverManager.getConnection(dburl, "root" , "RootPassword");
			
			// Step3:- create sql and select jdbc statement
			String query = "update student_inforamtion set stud_name =? where stud_ID =?";
			 psmt = conc.prepareStatement(query);
			 
			 //set the for palce holder
			 System.out.println("enter the student name");
			 psmt.setString(1, sc.next());
			 
			 System.out.println("enter the student id");
			 psmt.setInt(2, sc.nextInt());
			
			//Step4:- execute query
			 int count  = psmt.executeUpdate();
			
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
			if(psmt!=null)
			{
				try
				{
					psmt.close();
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
