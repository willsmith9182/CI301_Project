package security.full.builder;

import java.util.ArrayList;

import security.Key;
import security.Role;
import security.full.FullUser;

// Builder pattern with fluent api. 
// Sample Usage:
/*
 * User newUser = UserBuilder.New().WithUserId(1).WithUsername("BuilderPattern").Make();
 * 
 * Because each method returns a UserBuilder you are able to chain 'With***' methods
 * the settings you apply are stored inside the instance of the builder
 * the make method creates a user from the local state. 
 * you never keep a reference to the builder, it is discarded as soon as you call make.
 * Private constructors prevent creating one, static New() method provides access to the fluent api of the builder.
 * 
 * You can now use a UserBuilder in unit tests to create a user when you want to test things :)
 */
public class FullUserBuilder {

	private String _username;
	private String _password;
	private int _userId;
	private ArrayList<Role> _roles;
	private Key _key;
	
	// can only be created in this class. prevents anyone creating a new user builder. 
	private FullUserBuilder(){
		_username ="";
		_userId = -1;
		_password ="";
		_roles = new ArrayList<Role>();
		_key = null;
	}
	
	// create the User object from the local state. 	
	public FullUser Make(){
		return new FullUser(_userId,_username,_password,_key,_roles);
	}
	
	
	// static method begins the fluent api chain. 
	public static FullUserBuilder New(){
		return new FullUserBuilder();
	}
	
	// chained calls, returns the instance of the builder after modifying local state.
	public FullUserBuilder WithUserId(int userId){
		_userId = userId;
		return this;
	}
	
	public FullUserBuilder WithUsername(String username){
		_username = username;
		return this;
	}
	
	public FullUserBuilder WithPassword(String password){
		_password = password;
		return this;
	}
	
	public FullUserBuilder WithRole(Role role){
		if(!_roles.contains(role))
				_roles.add(role);
		
		return this;
	}
	
	public FullUserBuilder WithRoles(ArrayList<Role> roles){
		_roles = roles;		
		return this;
	}
	
	public FullUserBuilder WithKey(Key key){
		_key = key;
		return this;
	}
	
}
