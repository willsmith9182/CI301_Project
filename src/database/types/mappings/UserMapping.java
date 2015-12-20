package database.types.mappings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.types.User;

public class UserMapping extends MappingBase<User> implements IMapping<User> {

	
	private static User mapSingleUser(ResultSet rs){
	
		try {
			Integer id= rs.getInt("_userID");		
			String un =rs.getString("_username");
			String pw =rs.getString("_password");
		return new User(id,un,pw);
		} catch (SQLException e) {	
			// cccan't map, can't throw (lambdas)	
			// http://stackoverflow.com/questions/18198176/java-8-lambda-function-that-throws-exception
			// don't want functional interface as we want the mapping to be a method call. 
		}
		return null;
		}

	@Override
	public User MapSingle(ResultSet rs) throws Exception {	
				return this.baseMapSingle(rs, i -> mapSingleUser(i));
		
	}

	@Override
	public ArrayList<User> MapCollection(ResultSet rs) throws Exception{		
		return	this.baseMapCollection(rs, i -> mapSingleUser(i));		
	}
}
