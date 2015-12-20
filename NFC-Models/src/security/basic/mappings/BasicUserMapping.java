package security.basic.mappings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mapping.IMapping;
import mapping.MappingBase;
import security.basic.BasicUser;
import security.basic.builder.BasicUserBuilder;


public class BasicUserMapping extends MappingBase<BasicUser> implements IMapping<BasicUser> {

	private static BasicUser mapSingleUser(ResultSet rs) {

		try {
			return BasicUserBuilder.New()
					.WithUserId(rs.getInt("_userID"))
					.WithUsername(rs.getString("_username"))
					.WithPassword(rs.getString("_password"))					
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
	public BasicUser MapSingle(ResultSet rs) throws Exception {
		return this.baseMapSingle(rs, i -> mapSingleUser(i));

	}

	@Override
	public ArrayList<BasicUser> MapCollection(ResultSet rs) throws Exception {
		return this.baseMapCollection(rs, i -> mapSingleUser(i));
	}
}
