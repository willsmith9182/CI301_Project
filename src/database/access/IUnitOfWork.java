package database.access;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IUnitOfWork {
	public ResultSet RunStatement(String sql) throws SQLException;	
	public ResultSet ExecuteSproc(String sprocName, String[] parameters, int[] returnColumnTypes) throws SQLException;
	public void Done() throws SQLException;
}
