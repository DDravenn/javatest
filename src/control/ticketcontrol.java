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
import user.buyticket;

public class ticketcontrol implements Control{
	public static ticketcontrol ticketcontrol;
    private final Connection conn;
    
    public static ticketcontrol getInstance() throws PropertyVetoException, SQLException {
        return ticketcontrol == null ? new ticketcontrol() : ticketcontrol;
    }
    
    private ticketcontrol() throws PropertyVetoException, SQLException {
        connectSQL source = new connectSQL();
        conn = connectSQL.getCon();
    }
    
    public List read(Object o) throws SQLException {
        buyticket bytk = (buyticket) o;
        List<buyticket> result = new ArrayList<>();
        String sql = "select * from userticket where userid=? and ticket=? and amount=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, bytk.getUserid());
        pre.setInt(2, bytk.getTicket());
        pre.setString(3, bytk.getAmount());
        ResultSet resultSet = pre.executeQuery();
        while (resultSet.next()) {
            result.add(new buyticket(resultSet.getString("userid"),
                    resultSet.getString("ticket"),
                    resultSet.getString("amount")));
        }
        return result;
    }
    
    public void insert(Object o) throws SQLException {
        if (o.getClass() == User.class) {
        	buyticket bytk = (buyticket) o;
            String sql = "insert into userticket(userid,ticket,amount)values(?,?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, bytk.getUserid());
            pre.setInt(2, bytk.getTicket());
            pre.setString(3, bytk.getAmount());
            pre.execute();
        }
    }  
}
