package database.types;

public class User {

	private final String _username;
	private final String _password;
	private final Integer _userId;
	
	public User(int userId, String username, String password){
		_userId = userId;
		_password = password;
		_username =username;		
	}
	
	public String getUsername(){
		return _username;
	}
	
	public String getPassword(){
		return _password;
	}

	public Integer getId() {
		return _userId;
	}
		
}
