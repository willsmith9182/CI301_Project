package services;

import java.util.UUID;

import data.repository.INFCRepository;
import security.basic.BasicUser;
import security.crypto.IPasswordHash;

public class SecurityService implements ISecurityService {
	private final INFCRepository _repo;
	private final IPasswordHash _hash;

	public SecurityService(INFCRepository repo, IPasswordHash hash) {
		_repo = repo;
		_hash = hash;
	}

	@Override
	public boolean UserIsAuthenticated(String username, String password) throws Exception {
		try {
			BasicUser user = _repo.GetMatchingUser(username, null);

			return _hash.Challenge(user.get_password(), "", password);
		} catch (Exception e) {
			if (e.getMessage() == "User not found.")
				return false;
			else
				throw e;
		}

	}

	@Override
	public boolean UserDoorAccessChallenge(UUID doorToken, UUID keyToken) {

		try {
			return _repo.KeyTokenHasAccessToDoorToken(keyToken, doorToken);
		} catch (Exception e) {
			return false;
		}
	}

}
