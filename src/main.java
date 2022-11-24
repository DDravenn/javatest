

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import GUI.login;
import manager.manager;
import sql.connectSQL;

public class main {
	public static void main(String[] args) throws PropertyVetoException, SQLException {
		connectSQL c = new connectSQL();
		Connection cc = c.getCon();
		String sql = "select * from Account";
        PreparedStatement pre = cc.prepareStatement(sql);
        ResultSet rest = pre.executeQuery();
        rest.next();
		System.out.println(rest.getString("username"));
		
		manager.getOwnerlessWindows();
	}
}
