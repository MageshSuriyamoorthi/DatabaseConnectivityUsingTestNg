package com.atmecs.task;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
	public class DataBaseThroughTestNg {
		 Connection con=null;
			Statement stmt=null;
			ResultSet res=null;
    @BeforeMethod
    void connection()
	{ 
   
	try
	{
	DriverManager.registerDriver(new SQLServerDriver());
	System.out.println("Loading database is successfull");
	}
	catch(SQLException e)
	{
	System.out.println("Problem in loading the database");
	}
	try
	{
	con=DriverManager.getConnection("jdbc:sqlserver://ATMECSINLT-084\\SQL2012:1433;database=JDBCconn;integratedSecurity=true");
	
	}
	catch (Exception d)
	{
	
	d.printStackTrace();
	}
	}
    @Test
    void getInfo() {
	try
	{
	stmt=con.createStatement();
	res=  stmt.executeQuery("select * from jdbc");
	System.out.println("Database loaded successfully");
	}
	catch(SQLException f)
	{
	System.out.println("Database doesn't loaded");
	f.printStackTrace();
	}
	try
	{
	while(res.next())
	{
	int id=res.getInt(1);
	String name=res.getString(2);
	System.out.println(id+" "+name);
	}
	}
	
	catch(Exception f)
	{
	System.out.println("*****ERROR*****");
	f.printStackTrace();
	}

	}
    @AfterMethod
    void close()
    {
    	System.out.println("over");
    }
    
	}

}
