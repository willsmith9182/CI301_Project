package main;

import java.sql.SQLException;

import database.DBConnect;
import database.DBQueries;
import login.LoginView;

public class Main 
{

	public static void main(String[] args) throws SQLException 
	{
		//Create the GUI
		LoginView.main(args);
		//init db
		DBConnect db = new DBConnect();
		DBConnect.basicLogin("Elliott", "dick");
		
	}

}
