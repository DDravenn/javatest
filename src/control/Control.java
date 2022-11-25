package control;

import java.sql.SQLException;
import java.util.List;

public interface Control {
	   List read(Object o) throws SQLException ;
	   
	   void insert(Object o) throws SQLException;
	   
	   boolean update(Object _if, Object _new) throws SQLException;
}