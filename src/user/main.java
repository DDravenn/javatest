package user;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import GUI.MainFrame;
import GUI.acselect;
import GUI.information;
import GUI.login;
import GUI.recharge;
import GUI.register;
import maGUI.MAFrame;
import maGUI.historybuy;
import maGUI.openticket;
import maGUI.seeuser;
import sql.connectSQL;

public class main {
	public static void main(String[] args) throws PropertyVetoException, SQLException {
/*		connectSQL c = new connectSQL();
		Connection cc = c.getCon();
		String sql = "select * from Account";
        PreparedStatement pre = cc.prepareStatement(sql);
        ResultSet rest = pre.executeQuery();
        rest.next();
		System.out.println(rest.getString("username"));
*/
		
//		MAFrame ma=new MAFrame();
//		ma.setVisible(true);
//		
//		seeuser se=new seeuser();
//		se.setVisible(true);
//		
//		recharge re=new recharge();
//		re.setVisible(true);
		
		login ln=new login("");
		ln.setVisible(true);
		
//		information ma=new information();
//		ma.setVisible(true);
		
//		openticket op = new openticket();
//		op.setVisible(true);
//		
//		String str="1,2,3,4,5,6,7";
//		String []s=new String[7];
//		s=str.split(",");
//		for(int i=0;i<s.length;i++) {
//			System.out.println(s[i]);
//		}
		
		
//		acselect ac =new acselect("123");
//		ac.setVisible(true);

}
}
