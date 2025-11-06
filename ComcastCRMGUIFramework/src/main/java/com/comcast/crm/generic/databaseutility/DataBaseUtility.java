package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection conn;
	
	public void getDbConnection(String url,String username,String password) throws Exception
	{
		try 
		{
			Driver drivRef = new Driver();
			DriverManager.registerDriver(drivRef);
			conn = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{}
	}
	
	public void getDbConnection() throws Exception  					// getDbConnection() method overloading
	{
		try 
		{
			Driver drivRef = new Driver();
			DriverManager.registerDriver(drivRef);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "1234");
		}
		catch(Exception e)
		{}
	}
	
	public void closeDbConnection() throws Exception 
	{
		try 
		{
			conn.close();
		}
		catch(Exception e)
		{}
	}
	
	public ResultSet executeSelectQuery(String query) throws Exception
	{
		ResultSet result=null;
		try {
		Statement stat = conn.createStatement();
		result = stat.executeQuery(query);
		
		}
		catch(Exception e)
		{}
		return result;
	}
	
	public int executeNonSelectQuery(String query) throws Exception
	{
		int result=0;
		try {
		Statement stat = conn.createStatement();
		result = stat.executeUpdate(query);
		
		}
		catch(Exception e)
		{}
		return result;
	}
}
