package login;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginCheck
{
	
	//cant have private classes and reference them from other classes
	//so made it protected (package only referencing)
	public static void Login(String username, String password) 
	{
		
		System.out.println("Username is " + username);
		System.out.println("Password is " + password);
		
	}

	
}
