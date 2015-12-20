package security.crypto;

public interface IPasswordHash {
	public Boolean Challenge(String passwordHash, String saltine, String challenge);

	public String CreateHash(String password, String saltine);
}
