package data.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Function;

import data.access.DBFactory;
import data.access.IUnitOfWork;
import security.User;

public class NFCRepository implements INFCRepository {

	private final DBFactory _dbFactory;

	public NFCRepository(String connectionString, String username, String password) {
		_dbFactory = new DBFactory(connectionString, username, password);
	}

	// Function <Person, String> f

	@Override
	public ArrayList<User> GetAllUsers(Function<ResultSet, ArrayList<User>> mapping) throws Exception {
		// try and get a result set of all the users
		IUnitOfWork uow = null;
		try {
			uow = _dbFactory.CreateUnitOfWork();
			return mapping.apply(uow.RunStatement("SELECT * FROM USERS"));

		} catch (ClassNotFoundException ex) {
			throw new Exception("Unable to query database", ex);
		} finally {
			uow.Done();
		}
	}

	@Override
	public User GetMatchingUser(String username, Function<ResultSet, ArrayList<User>> mapping) throws Exception {
		// try and get a result set of all the users
		try {
			IUnitOfWork uow = _dbFactory.CreateUnitOfWork();
			// please don't pwn my system, have you heard of bobby tables?
			// https://xkcd.com/327/
			ArrayList<User> users = mapping
					.apply(uow.RunStatement("SELECT * FROM USERS where _username = '" + username + "'"));

			if (users.isEmpty())
				throw new Exception("User '" + username + "' not found");
			return users.get(0);
		} catch (ClassNotFoundException ex) {
			throw new Exception("Unable to query database", ex);
		}
	}
}
