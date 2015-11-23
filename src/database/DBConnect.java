package database;

import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class DBConnect 
{
	  /*
	   * Database information
	   */
	  private final String username = "admin"; 
	  private final String password = "1234"; //all passwords are 1234 in test
	  private final String serverName = "localhost";
	  private final int portNumber = 10061;
	  private final String dbName = "nfc_users";
	  
	  /*
	   * Database Objects
	   */
	  private static Connection conn = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private Properties connectionProps = new Properties(); 

	  /*
	   * Constructor
	   */
	  public DBConnect()  
	  {
	    try 
	    {
	      getConnection();
	      System.out.println("You was connected to the DB successfully.");
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }

	  }
	  
	  /*
	   * Closes DB once app is finished
	   */
	  private void closeDB() throws SQLException
		{
			conn.close();
		}
			
	  
	  /*
	   * Gets and returns a new database connection
	   */
	private Connection getConnection() throws SQLException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:10061/nfc_database" , "admin"  , "1234");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Unsucessful Connection");
		}
		System.out.println("Successfully connected to: " + conn + " on port " + portNumber + " using username :" + username);
		return conn;
		
	}
	
	/*
	 * returns all the _userID's in the users table
	 */
	public static ResultSet selectAll() throws SQLException 
	{ 
		ResultSet ResultSet = null;
		PreparedStatement preparedStatement = null;
		String sql;
		String id = null;
		//try and get a result set of all the users
		try 
		{
			 sql = "SELECT _userID FROM USERS";
			 preparedStatement = conn.prepareStatement(sql);
			 ResultSet = preparedStatement.executeQuery();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//****************************************************************
		System.out.println("Results from SELECT * FROM USERS :");
		while(ResultSet.next()) 
		{
			id = ResultSet.getString("_userID");
			System.out.println(id);
		}

		return ResultSet;
			
	}
	
	/*
	 * returns all the _passwords from the users table 
	 */
	public static ResultSet selectPass() throws SQLException 
	{ 
		ResultSet ResultSet = null;
		PreparedStatement preparedStatement = null;
		String sql;
		String id = null;
		//try and get a result set of all the users
		try 
		{
			 sql = "SELECT _password FROM USERS";
			 preparedStatement = conn.prepareStatement(sql);
			 ResultSet = preparedStatement.executeQuery();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//****************************************************************
		System.out.println("Results from SELECT _password FROM USERS :");
		while(ResultSet.next()) 
		{
			id = ResultSet.getString("_password");
			System.out.println(id);
		}

		
		return ResultSet;
			
	}
		
		
}

	


	
	
	
		

