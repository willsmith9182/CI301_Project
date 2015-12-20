package security.mappings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import mapping.IMapping;
import mapping.MappingBase;
import security.User;
import security.mappings.builder.KeyBuilder;
import security.mappings.builder.UserBuilder;

public class GetUserMapping extends MappingBase<User> implements IMapping<User> {

	private static User mapSingleUser(ResultSet rs) {

		try {
			return UserBuilder.New()
					.WithUserId(rs.getInt("_userID"))
					.WithUsername(rs.getString("_username"))
					.WithPassword(rs.getString("_password"))
					.WithKey(KeyBuilder.New()
							.WithId(rs.getInt("_keyId"))
							.WithToken(UUID.fromString(rs.getString("_keyToken")))
							.Make())
					.Make();
			
		} catch (SQLException e) {
			// cccan't map, can't throw (lambdas)
			// http://stackoverflow.com/questions/18198176/java-8-lambda-function-that-throws-exception
			// don't want functional interface as we want the mapping to be a
			// method call.
		}
		return null;
	}

	@Override
	public User MapSingle(ResultSet rs) throws Exception {
		return this.baseMapSingle(rs, i -> mapSingleUser(i));

	}

	@Override
	public ArrayList<User> MapCollection(ResultSet rs) throws Exception {
		return this.baseMapCollection(rs, i -> mapSingleUser(i));
	}
}
