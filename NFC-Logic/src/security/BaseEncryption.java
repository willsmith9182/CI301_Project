package security;

public class BaseEncryption implements IPasswordHash{

	@Override
	public String CreateHash(String password, String saltine) {
		return new StringBuilder(password).reverse().toString();
	}

	@Override
	public Boolean Challenge(String passwordHash, String saltine, String challenge) {
		String hashedChallenge = CreateHash(challenge, saltine);
		
		return hashedChallenge.equals(passwordHash);
	}

}
