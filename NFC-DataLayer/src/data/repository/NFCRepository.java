package data.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Function;

import data.access.DBFactory;
import data.access.IUnitOfWork;
import security.basic.BasicUser;

public class NFCRepository implements INFCRepository {

	private final DBFactory _dbFactory;

	public NFCRepository(String connectionString, String username, String password) {
		_dbFactory = new DBFactory(connectionString, username, password);
	}

	// Function <Person, String> f

	@Override
	public ArrayList<BasicUser> GetAllUsers(Function<ResultSet, ArrayList<BasicUser>> mapping) throws Exception {
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
	public BasicUser GetMatchingUser(String username, Function<ResultSet, ArrayList<BasicUser>> mapping)
			throws Exception {
		// try and get a result set of all the users
		try {
			IUnitOfWork uow = _dbFactory.CreateUnitOfWork();
			// please don't pwn my system, have you heard of bobby tables?
			// https://xkcd.com/327/
			ArrayList<BasicUser> users = mapping
					.apply(uow.RunStatement("SELECT * FROM USERS where _username = '" + username + "'"));

			if (users.isEmpty())
				throw new Exception("User '" + username + "' not found");
			return users.get(0);
		} catch (ClassNotFoundException ex) {
			throw new Exception("Unable to query database", ex);
		}
	}

	@Override
	public boolean KeyTokenHasAccessToDoorToken(UUID keyToken, UUID doorToken) throws Exception {

		try {
			IUnitOfWork uow = _dbFactory.CreateUnitOfWork();

			String sql = "select 1 as match from [dbo].[Key] as k " 
					+ "inner join [dbo].[User] as u on u.keyId = k.keyId "
					+ "inner join [dbo].[UserRole] as ur on u.userId = ur.userId "
					+ "inner join [dbo].[Role] as r on ur.roleId = r.roleId "
					+ "inner join [dbo].[DoorGroupRole] as dgr on r.roleId = dgr.roleId "
					+ "inner join [dbo].[DoorGroup] as dg on dgr.doorGroupId = dg.doorGroupId "
					+ "inner join [dbo].[DoorGroupDoor] as dgd on dg.doorGroupId = dgd.doorGroupId "
					+ "inner join [dbo].[Door] as d on dgd.doorId = d.doorId " 
					+ "where k.keyToken = '" + keyToken.toString() + "'" 
					+ "AND d.doorToken = '" + doorToken.toString() + "'";

			ResultSet results = uow.RunStatement(sql);

			return results.next();

		} catch (ClassNotFoundException ex) {
			throw new Exception("Unable to query database", ex);
		} catch (SQLException e) {
			return false;
		}

	}
}
