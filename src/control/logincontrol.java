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
}
