package security;

import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import data.repository.INFCRepository;

public class SecurityService
{	
	private final INFCRepository _repo;
	private final IPasswordHash _hash;
	
	public SecurityService(INFCRepository repo){
		_repo = repo;
		_hash = new BaseEncryption();
	}
	
	public Boolean UserIsAuthenticated(String username, String password) throws Exception 
	{
		try{
			User user = _repo.GetMatchingUser(username,null);
			
			return  _hash.Challenge(user.get_password(), "", password);
		}
		catch(Exception e){
			if (e.getMessage() == "User not found.") 
				return false;
			else
				throw e;
		}
		
		
				
	
	}

	
}