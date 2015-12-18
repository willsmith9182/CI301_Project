package main;

import database.repository.NFCRepository;
import security.SecurityService;

public class Main 
{

	
	public static void main(String[] args) throws Exception 
	{
		
		NFCRepository nfcRepo = new NFCRepository("jdbc:mysql://51.255.42.59:3306/NFC" , "jroot"  , "javapassword");
		
		/*ArrayList<User> allUsers = nfcRepo.GetAllUsers();
		
		for(User u: allUsers){
			System.out.println("UUID: '"+u.getId()+"', Un: '"+u.getUsername()+"', Pw: '"+u.getPassword()+"'" );
		}
		*/
		
		
			SecurityService ss = new SecurityService(nfcRepo);
			
			Boolean isEltReal= ss.UserIsAuthenticated("Elliott", "neerG");
			
			System.out.println("Is elt real?? " + isEltReal);
	
		System.in.read();
		
	}

}
