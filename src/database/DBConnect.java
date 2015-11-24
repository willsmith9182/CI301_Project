package database;

import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class DBConnect 
{

	  
	  private static Connection conn = null;
	  private Statement statement = null;

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
	  public void closeDB() throws SQLException
		{
			conn.close();
		}
			
	  
	  /*
	   * Gets and returns a new database connection
	   */
	static Connection getConnection() throws SQLException 
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
		System.out.println("Successfully connected to: " + conn + " on port " + conn.toString() + " using username :" + conn.getCatalog());
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
		
		
		public static ResultSet basicLogin(String username, String password) throws SQLException 
		  {
			ResultSet ResultSet = null;
			PreparedStatement preparedStatement = null;
			String sql;
			String id;
			String basicName = username;
			String basicPass = password;
			//try and get a result set of all the users
				try 
				{
					 sql = "SELECT _username, _password FROM USERS"; 
					 preparedStatement = conn.prepareStatement(sql);
					 ResultSet = preparedStatement.executeQuery();
					 
					 while(ResultSet.next()) 
						{
							id = ResultSet.getString("_password");
							if(id.equals(basicPass))
									{
								System.out.println("You're the fucking best!!!");
									}
							else
							{
								System.out.println("nah");
							}
						}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				
				return ResultSet;
		  }

		
}

	


	
	
	
		

