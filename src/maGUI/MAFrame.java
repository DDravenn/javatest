package maGUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.MainFrame;
import GUI.acselect;

public class MAFrame extends javax.swing.JFrame{
		JPanel welcome_JPanel = new JPanel();
		JButton open_JButton = new JButton();
		JButton alluser_JButton = new JButton();
		JButton exit_JButton = new JButton();
		JButton historybuy_JButton=new JButton();
		
		public MAFrame() throws PropertyVetoException, SQLException {

	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        initComponents();
	    }
		
		private void initComponents() {
			welcome_JPanel=(JPanel) getContentPane();
			welcome_JPanel.setLayout(null);
			setSize(new Dimension(600,500));
			setTitle("欢迎进入管理员界面");
			setLocation(400,150);
			
			welcome_JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("欢迎进入管理员界面"));
			
			open_JButton.setText("开奖");
			alluser_JButton.setText("人员信息");
			historybuy_JButton.setText("用户彩票");
			exit_JButton.setText("退出程序");
			
			open_JButton.setFont(new Font("黑体",Font.BOLD,15));
			open_JButton.setBounds(new Rectangle(200,100,130,30));
			open_JButton.addActionListener(new MAFrame_open_JButton_actionAdapter(this));
			
			alluser_JButton.setFont(new Font("黑体",Font.BOLD,15));
			alluser_JButton.setBounds(new Rectangle(200,150,130,30));
			alluser_JButton.addActionListener(new MAFrame_alluser_JButton_actionAdapter(this));
			
			exit_JButton.setFont(new Font("黑体",Font.BOLD,15));
			exit_JButton.setBounds(new Rectangle(200,250,130,30));
			exit_JButton.addActionListener(new MAFrame_exit_JButton_actionAdapter(this));
			
			historybuy_JButton.setFont(new Font("黑体",Font.BOLD,15));
			historybuy_JButton.setBounds(new Rectangle(200,200,130,30));
			historybuy_JButton.addActionListener(new MAFrame_his_JButton_actionAdapter(this));
			
			welcome_JPanel.add(open_JButton);
			welcome_JPanel.add(alluser_JButton);
			welcome_JPanel.add(exit_JButton);
			welcome_JPanel.add(historybuy_JButton);
			
		}
		
		public void MAFrame_open_JButton_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
			openticket op = new openticket();
			op.setVisible(true);
			this.dispose();
	}
		
		public void MAFrame_alluser_JButton_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
			seeuser se = new seeuser();
			se.setVisible(true);
			this.dispose();
	}
		
		public void MAFrame_exit_JButton_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
			System.exit(0);
	}
		
		public void MAFrame_his_JButton_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
			historybuy hi = new historybuy();
			hi.setVisible(true);
			this.dispose();
	}
		
}

class MAFrame_open_JButton_actionAdapter implements ActionListener{
	private final MAFrame adaptee;
	
	MAFrame_open_JButton_actionAdapter(MAFrame adaptee) {
        this.adaptee = adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.MAFrame_open_JButton_actionPerformed(e);
		}catch(PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}

class MAFrame_alluser_JButton_actionAdapter implements ActionListener{
	private final MAFrame adaptee;
	
	MAFrame_alluser_JButton_actionAdapter(MAFrame adaptee) {
        this.adaptee = adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.MAFrame_alluser_JButton_actionPerformed(e);
		}catch(PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}

class MAFrame_exit_JButton_actionAdapter implements ActionListener{
	private final MAFrame adaptee;
	
	MAFrame_exit_JButton_actionAdapter(MAFrame adaptee) {
        this.adaptee = adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.MAFrame_exit_JButton_actionPerformed(e);
		}catch(PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}

class MAFrame_his_JButton_actionAdapter implements ActionListener{
	private final MAFrame adaptee;
	
	MAFrame_his_JButton_actionAdapter(MAFrame adaptee) {
        this.adaptee = adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.MAFrame_his_JButton_actionPerformed(e);
		}catch(PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}