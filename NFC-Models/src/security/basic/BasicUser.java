package security.basic;

import java.util.ArrayList;

import security.Key;
import security.Role;

public class BasicUser {

	private final String _username;
	private final String _password;
	private final Integer _userId;

	public BasicUser(int userId, String username, String password) {
		_userId = userId;
		_password = password;
		_username = username;
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
}
