package vco.jdbc.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class step1way2 
{
	public static void main(String[] args) {
		try
		{
			// this is most recomended way
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2 :- get the connection dia driver
			
			//way1
			
//			String dburl = "jdbc:mysql://localhost:3306/vco_db?user=root&password=RootPassword";
//			Connection conc = DriverManager.getConnection(dburl);
			
			//way2
			
			String dburl = "jdbc:mysql://localhost:3306/vco_db";
			Connection conc= DriverManager.getConnection(dburl, "root" , "RootPassword");
			
			
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
