package database.types.mappings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Function;

public abstract class MappingBase<T> {
	
	protected T baseMapSingle(ResultSet rs, Function<ResultSet, T> mapping) throws Exception  {
		T result = null;
		boolean single = false;
		
		try {
			while(rs.next()){
				
				if(single == true){
					throw new Exception ("Unable to Map, expected single element");
				}
				
				result=mapping.apply(rs);
				if (result == null) 
					throw new Exception ("Unable to Map, erorr occcoured when mapping");
				single = true;
				
			}
		} catch (SQLException e) {
			throw new Exception ("Unable to Map.", e);
		}
		
		return result;
	}
	
	protected ArrayList<T> baseMapCollection(ResultSet rs, Function<ResultSet, T> mapping) throws Exception {
		ArrayList<T> results = new ArrayList<T>();
		
		try {
			while(rs.next()){
				T result = mapping.apply(rs);
				if (result == null) 
					throw new Exception ("Unable to Map, erorr occcoured when mapping");
				else
					results.add(result);
			}
		} catch (SQLException e) {
			throw new Exception ("Unable to Map.", e);
		}
		
		return results;
	}	
	

}
