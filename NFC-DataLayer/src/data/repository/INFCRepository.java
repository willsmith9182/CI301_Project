package data.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Function;

import security.User;

public interface INFCRepository {
	ArrayList<User> GetAllUsers(Function<ResultSet, ArrayList<User>> mapping) throws Exception;
	User GetMatchingUser(String username,Function<ResultSet, ArrayList<User>> mapping) throws Exception;
}
