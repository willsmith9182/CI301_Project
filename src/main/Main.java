package main;

import java.sql.SQLException;

import database.DBConnect;
import login.LoginView;

public class Main {

	public static void main(String[] args) {
		//Create the GUI
		LoginView.main(args);
		
		DBConnect db = new DBConnect();
		
		
	}

}
