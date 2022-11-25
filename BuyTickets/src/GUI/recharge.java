package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sql.connectSQL;

public class recharge extends javax.swing.JFrame {
		
		JPanel welcome_JPanel=new JPanel();
		JLabel JL1=new JLabel();
		JLabel JL2=new JLabel();
		JLabel JL3=new JLabel();
		JTextField JT1=new JTextField();
		JButton rec=new JButton();
		JButton quit=new JButton();
		
		

		
		public recharge()throws PropertyVetoException, SQLException {
			try {
	            setDefaultCloseOperation(EXIT_ON_CLOSE);
	            initComponents();
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	    }
		
		private void initComponents() {
			welcome_JPanel = (JPanel) getContentPane();
	        welcome_JPanel.setLayout(null);
			setSize(new Dimension(400, 500));
			 setTitle("充值界面");
			 welcome_JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("用户充值界面"));
			 
			 JL1.setText("当前余额为:");
			 JL2.setText("qwe");
			 JL3.setText("需要充值多少:");
			 rec.setText("确认");
			 quit.setText("返回");
			 
			 
			 JL1.setFont(new Font("黑体",Font.BOLD,15));
			 JL1.setBounds(new Rectangle(100,150,180,30));
			 
			 JL2.setFont(new Font("黑体,",Font.BOLD,15));
			 JL2.setBounds(new Rectangle(200,150,80,30));
			 
			 JL3.setFont(new Font("黑体",Font.BOLD,15));
			 JL3.setBounds(new Rectangle(85,190,200,30));
			 
			 JT1.setFont(new Font("Dialog",Font.BOLD,15));
			 JT1.setBounds(new Rectangle(200,190,80,30));
			 
			 rec.setFont(new Font("黑体",Font.BOLD,15));
			 rec.setBounds(new Rectangle(90,250,80,40));
			 rec.addActionListener(new recharge_rec_actionAdapter(this));
			 
			 quit.setFont(new Font("黑体",Font.BOLD,15));
			 quit.setBounds(new Rectangle(220,250,80,40));
			 quit.addActionListener(new recharge_quit_actionAdapter(this));
			 
			 welcome_JPanel.add(JL1);
			 welcome_JPanel.add(JL2);
			 welcome_JPanel.add(JL3);
			 welcome_JPanel.add(JT1);
			 welcome_JPanel.add(rec);
			 welcome_JPanel.add(quit);
		}
		//返回个人信息界面
		public void recharge_quit_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{

			information in=new information();
			in.setVisible(true);
			this.dispose();
		}
		
		//充值操作
		public void recharge_rec_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{

			information in=new information();
			in.setVisible(true);
			this.dispose();
		}
		
}

class recharge_quit_actionAdapter implements ActionListener{
	private final recharge adaptee;
	
	recharge_quit_actionAdapter(recharge adaptee) {
        this.adaptee = adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.recharge_quit_actionPerformed(e);
		}catch(PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}


//充值的监视器
class recharge_rec_actionAdapter implements ActionListener{
	private final recharge adaptee;
	
	recharge_rec_actionAdapter(recharge adaptee) {
        this.adaptee = adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.recharge_rec_actionPerformed(e);
		}catch(PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}