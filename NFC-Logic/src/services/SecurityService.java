package services;

import data.repository.INFCRepository;
import security.User;
import security.crypto.IPasswordHash;

public class SecurityService {
	private final INFCRepository _repo;
	private final IPasswordHash _hash;

	public SecurityService(INFCRepository repo, IPasswordHash hash) {
		_repo = repo;
		_hash = hash;
	}

	public Boolean UserIsAuthenticated(String username, String password) throws Exception {
		try {
			User user = _repo.GetMatchingUser(username, null);

			return _hash.Challenge(user.get_password(), "", password);
		} catch (Exception e) {
			if (e.getMessage() == "User not found.")
				return false;
			else
				throw e;
		}

	}

}
