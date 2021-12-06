package com.gymmanagement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCHelper {
	
	public static void close(ResultSet x)
	{
		
		if(x!=null)
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public static void close(Statement x)
	{
		
		if(x!=null)
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public static void close(Connection x)
	{
		
		if(x!=null)
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public static Connection getConnection(){
		
		Connection con = null;
		try
		{
			Class.forName(Constants.DRIVERNAME);    									 //Registration of the driver in DriverManger
			con = DriverManager.getConnection(Constants.URL,Constants.UID,Constants.PWD);	//DriverManager take care of driver to make connection
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return con;
		
	}

}
