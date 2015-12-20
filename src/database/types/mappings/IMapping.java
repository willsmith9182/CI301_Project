package database.types.mappings;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface IMapping<T> {
	
	public T MapSingle(ResultSet rs) throws Exception;
	public ArrayList<T> MapCollection(ResultSet rs) throws Exception;
}
