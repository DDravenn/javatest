package control;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sql.connectSQL;
import user.Loginuser;
import user.User;

public class usercontrol implements Control{
	 public static usercontrol usercontrol;
	    private final Connection con;
	    
	    public static usercontrol getInstance() throws PropertyVetoException, SQLException {
	        return usercontrol == null ? new usercontrol() : usercontrol;
	    }

	    //获得实例
	    private usercontrol() throws PropertyVetoException, SQLException {
	        connectSQL conSQL = new connectSQL();
	        con =  connectSQL.getCon();
	    }
	    
	  //读取
	    public List<User> read(Object o) throws SQLException{
	        if (o == null) {
	            return read(null);
	        } else if (o.getClass() == Long.class) {
	            return read((long) o);
	        } else if (o.getClass() == String.class) {
	            return read((String) o);
	        }
	        return null;
	    }
	    
	    private List<Loginuser> read() throws SQLException {
	        String sql = "select * from Account";
	        PreparedStatement pre = con.prepareStatement(sql);
	        ResultSet rest = pre.executeQuery();
	        List<Loginuser> users = new ArrayList<>();
	        while (rest.next()) {
	            Loginuser lu = new Loginuser(rest.getString("userid"),
	                    rest.getString("userpassowrd"));
	            users.add(lu);

	        }
	        return users;
	    }
	    private List<User> read2() throws SQLException {
	        String sql = "select * from loginuser";
	        PreparedStatement prq = con.prepareStatement(sql);
	        ResultSet rest = prq.executeQuery();
	        List<User> users = new ArrayList<>();
	        while (rest.next()) {
	            User u = new User(rest.getString("userid"),
	                    rest.getString("username"),
	                    rest.getString("userpassowrd"),
	                    rest.getString("usertelephone"));
	            users.add(u);

	        }
	        return users;
	    }
	    
	    private List<User> read(String userid) throws SQLException{
	        String sql = "select * from Account where userid=?";
	        PreparedStatement pre = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        pre.setString(1, userid);
	        ResultSet rest = pre.executeQuery();
	        List<User> users = new ArrayList<>();
	        if (!rest.next()) {
	        	JOptionPane.showMessageDialog(null, "用户id不存在");
	        }
	        rest.beforeFirst();
	        while (rest.next()) {
	            User u = new User(rest.getString("userid"),
	                    rest.getString("username"),
	                    rest.getString("userpassword"),
	                    rest.getString("usertelephone"));
	            users.add(u);
	        }
	        return users;
	    }
	    
	    public void insert(Object o) throws SQLException {
	        User s = (User) o;
	        insert(s);
	    }
	    
	    private void insert(User s) throws SQLException {
	        String sql = "insert into Account(userid,username,userpassword,usertelephone)values(?,?,?,?)";
	        PreparedStatement psr = con.prepareStatement(sql);
	        psr.setString(1, s.getUserid());
	        psr.setString(2, s.getUsername());
	        psr.setString(3, s.getUserpassword());
	        psr.setString(4, s.getUsertelephone());
	        psr.execute();
	        
	        String sql2="insert into loginuser(userid,userpassword)values(?,?)";
	        PreparedStatement pst = con.prepareStatement(sql2);
	        pst.setString(1, s.getUserid());
	        pst.setString(2, s.getUserpassword());
	        pst.execute();
	    }
}
