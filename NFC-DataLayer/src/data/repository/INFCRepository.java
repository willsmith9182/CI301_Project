package data.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Function;
import security.basic.BasicUser;

public interface INFCRepository {
	ArrayList<BasicUser> GetAllUsers(Function<ResultSet, ArrayList<BasicUser>> mapping) throws Exception;

	BasicUser GetMatchingUser(String username, Function<ResultSet, ArrayList<BasicUser>> mapping) throws Exception;
	
	boolean KeyTokenHasAccessToDoorToken(UUID keyToken, UUID doorToken) throws Exception;
}
