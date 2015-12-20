package security;

import java.util.ArrayList;

public class User {

	private final String _username;
	private final String _password;
	private final Integer _userId;
	private final Key _key;
	private final ArrayList<Role> _roles;
	
	
	public User(int userId, String username, String password, Key key, ArrayList<Role> roles){
		_userId = userId;
		_password = password;
		_username =username;	
		_key = key;
		_roles = roles;
	}
	
	
	public ArrayList<Role> get_Roles(){
		return _roles;
	}


	public String get_username() {
		return _username;
	}


	public String get_password() {
		return _password;
	}


	public Integer get_userId() {
		return _userId;
	}


	public Key get_key() {
		return _key;
	}
		
}
