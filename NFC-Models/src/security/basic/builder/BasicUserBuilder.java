package security.basic.builder;

import security.basic.BasicUser;

public class BasicUserBuilder {

	private String _username;
	private String _password;
	private int _userId;

	private BasicUserBuilder() {
		_username = "";
		_userId = -1;
		_password = "";
	}

	// create the User object from the local state.
	public BasicUser Make() {
		return new BasicUser(_userId, _username, _password);
	}

	// static method begins the fluent api chain.
	public static BasicUserBuilder New() {
		return new BasicUserBuilder();
	}

	// chained calls, returns the instance of the builder after modifying local
	// state.
	public BasicUserBuilder WithUserId(int userId) {
		_userId = userId;
		return this;
	}

	public BasicUserBuilder WithUsername(String username) {
		_username = username;
		return this;
	}

	public BasicUserBuilder WithPassword(String password) {
		_password = password;
		return this;
	}
}
