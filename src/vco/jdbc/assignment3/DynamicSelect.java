package vco.jdbc.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicSelect 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Connection conc = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dburl = "jdbc:mysql://localhost:3306/vco_db";
			 conc= DriverManager.getConnection(dburl, "root" , "RootPassword");
			
			// Step3:- create sql and select jdbc statement
			String query = "select * from student_inforamtion where stud_ID>?";
			 psmt = conc.prepareStatement(query);
			 
			 //set the values for palce holder
//			 psmt.setInt(1, 1);
			 System.out.println("eneter the student Id");
			 psmt.setInt(1, sc.nextInt());
			
			//Step4:- execute query
			 res = psmt.executeQuery();
			
			//Step5:- process the result
			while(res.next())
			{
				System.out.println("student Id----->"+res.getInt(1));
				System.out.println("student name----->"+res.getString(2));
				System.out.println("student branch----->"+res.getString(3));
				System.out.println("student marks----->"+res.getDouble(4));
				System.out.println("student phone  number----->"+res.getString(5));
				System.out.println("student address----->"+res.getString(6)+"\n");
			}
			
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			if(res!=null)
			{
				try
				{
					res.close();
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
