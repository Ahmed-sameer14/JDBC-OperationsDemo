package vco.jdbc.assignment3;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class step1way1 
{
	public static void main(String[] args) {
		try 
		{
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.getDrivers();
			
			Enumeration<java.sql.Driver> enumaration = DriverManager.getDrivers();
			{
				while(enumaration.hasMoreElements())
				{
					System.out.println(enumaration.nextElement());
				}

			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
