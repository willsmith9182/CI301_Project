package services;

import java.util.UUID;

public interface ISecurityService {

	boolean UserIsAuthenticated(String username, String password) throws Exception;

	boolean UserDoorAccessChallenge(UUID doorToken, UUID keyToken);
}