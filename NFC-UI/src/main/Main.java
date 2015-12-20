package main;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) throws Exception {

		// NFCRepository nfcRepo = new
		// NFCRepository("jdbc:mysql://51.255.42.59:3306/NFC" , "jroot" ,
		// "javapassword");

		/*
		 * ArrayList<User> allUsers = nfcRepo.GetAllUsers();
		 * 
		 * for(User u: allUsers){ System.out.println("UUID: '"+u.getId()+
		 * "', Un: '"+u.getUsername()+"', Pw: '"+u.getPassword()+"'" ); }
		 */

		/*
		 * SecurityService ss = new SecurityService(nfcRepo);
		 * 
		 * Boolean isEltReal= ss.UserIsAuthenticated("Elliott", "neerG");
		 */

		/*
		 * User thing = new User(1,"twat", "fuck off eclipse"); User otherThing
		 * = new User(2, "two", "twat");
		 * 
		 * boolean test = Test(thing,otherThing, i -> i.getUsername());
		 */

		System.out.println("Is elt real?? " + false);

		System.in.read();

	}

	/*public static boolean Test(User user1, User user2, Function<User, String> test1, Function<User, String> test2) {

		String value1 = test1.apply(user1);
		String value2 = test2.apply(user2);

		return value1 == value2;

	}*/
}
