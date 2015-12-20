package database.access;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UnitOfWork implements IUnitOfWork {

	private final Connection _conn;
	
	public UnitOfWork(Connection conn){
		_conn = conn;
	}

	@Override
	public ResultSet RunStatement(String sql) throws SQLException {
	
		if(_conn.isClosed()){
			throw new SQLException("Connection was already closed");
		}
		
		try{
			ResultSet rs = null;
			
			PreparedStatement statement = _conn.prepareStatement(sql);
			
			rs = statement.executeQuery();
			
			
			return rs;
		}
		catch(SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
			}

	@Override
	public ResultSet ExecuteSproc(String sprocName, String[] parameters, int[] returnColumnTypes)	throws SQLException {
		if(_conn.isClosed()){
			throw new SQLException("Connection was already closed");
		}
		
		try{
			
			String paramsList ="";
			
			int listSize = parameters.length;			
			for (int i = 0; i< listSize; i++){
				paramsList += parameters[i];				
				if(i != listSize - 1){
					paramsList +=", ";
				}				
			}		
			
			CallableStatement statement = _conn.prepareCall("{call "+sprocName + "(" +paramsList+")}");
			
			for(int i= 0; i< returnColumnTypes.length;i++){
				statement.registerOutParameter(i+1, returnColumnTypes[i]);				
			}		
			
			return statement.executeQuery();
		}
		catch(SQLException ex){
			throw ex;
		}		
	}

	@Override
	public void Done() throws SQLException {		
		_conn.close();
		System.out.println("Connection closed");
	}	
}
