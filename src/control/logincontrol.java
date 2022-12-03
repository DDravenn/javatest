package control;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sql.connectSQL;
import user.Loginuser;
import user.User;

public class logincontrol  implements Control{
	public static logincontrol logincontrol;
    private final Connection conn;
    
    public static logincontrol getInstance() throws PropertyVetoException, SQLException {
        return logincontrol == null ? new logincontrol() : logincontrol;
    }
    
    private logincontrol() throws PropertyVetoException, SQLException {
        connectSQL source = new connectSQL();
        conn = connectSQL.getCon();

    }
    
 
    
    public List read(Object o) throws SQLException {
        Loginuser user = (Loginuser) o;
        List<Loginuser> result = new ArrayList<>();
        String sql = "select * from loginuser where userid=? and userpassword=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, user.getUserid());
        pre.setString(2, user.getUserpassword());
        ResultSet resultSet = pre.executeQuery();
        while (resultSet.next()) {
            result.add(new Loginuser(resultSet.getString("userid"),
                    resultSet.getString("userpassword")));
        }
        return result;
    }
    
    private List<Loginuser> read(String userid) throws SQLException {
        String sql = "select * from loginuser where userid=?";
        PreparedStatement pre = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pre.setString(1, userid);
        ResultSet rest = pre.executeQuery();
        List<Loginuser> loginusers = new ArrayList<>();
        
        while (rest.next()) {
        	Loginuser u = new Loginuser(rest.getString("userid"),
        			rest.getString("userpassword"));
        	loginusers.add(u);
        }
        return loginusers;
    }
    
    
    public void insert(Object o) throws SQLException {
        if (o.getClass() == User.class) {
            User user = (User) o;
            String sql = "insert into loginuser(userid,userpassword)values(?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, user.getUserid());
            pre.setString(2, user.getUserpassword());
            pre.execute();
        }
    }

	@Override
	public boolean update(Object _if, Object _new) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}  
    
    
}
