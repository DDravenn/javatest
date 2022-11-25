package GUI;

import java.awt.Button;
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

public class MainFrame extends javax.swing.JFrame {
		
	JPanel welcome_JPanel=new JPanel();
	JButton acbytk_JButton=new JButton();
	JButton hibytk_JButton=new JButton();
	JButton exit_JButton=new JButton();
	JButton info_JButton=new JButton();
	
	public MainFrame() throws PropertyVetoException, SQLException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
	
	private void initComponents() {
		welcome_JPanel=(JPanel) getContentPane();
		welcome_JPanel.setLayout(null);
		setSize(new Dimension(700,500));
		setTitle("欢迎进入彩票购买程序");
		
		welcome_JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("欢迎使用彩票购买程序"));
		acbytk_JButton.setText("开始选票");
		hibytk_JButton.setText("历史购票");
		exit_JButton.setText("退出程序");
		info_JButton.setText("个人信息");
		
		acbytk_JButton.setFont(new Font("黑体",Font.BOLD,15));
		acbytk_JButton.setBounds(new Rectangle(210, 60, 150, 40));
		acbytk_JButton.addActionListener(new MainFrame_acbytk_JButton_actionAdapter(this));
		
		hibytk_JButton.setFont(new Font("黑体",Font.BOLD,15));
		hibytk_JButton.setBounds(new Rectangle(210, 130, 150, 40));
		hibytk_JButton.addActionListener(new MainFrame_hibytk_JButton_actionAdapter(this));
		
		exit_JButton.setFont(new Font("黑体",Font.BOLD,15));
		exit_JButton.setBounds(new Rectangle(210, 270, 150, 40));
		exit_JButton.addActionListener(new MainFrame_exit_JButton_actionAdapter(this));
		
		info_JButton.setFont(new Font("黑体",Font.BOLD,15));
		info_JButton.setBounds(new Rectangle(210, 200, 150, 40));
		info_JButton.addActionListener(new MainFrame_info_JButton_actionAdapter(this));
		
		welcome_JPanel.add(acbytk_JButton);
		welcome_JPanel.add(hibytk_JButton);
		welcome_JPanel.add(exit_JButton);
		welcome_JPanel.add(info_JButton);
	}
	
	public void MainFrame_acbytk_JButton_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
			acselect ac=new acselect();
			ac.setVisible(true);
			this.dispose();
	}
	
	public void MainFrame_hibytk_JButton_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
		
	}
	
	public void MainFrame_exit_JButton_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
		System.exit(0);
	}
	
	public void MainFrame_info_JButton_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
		information in =new information();
		in.setVisible(true);
		this.dispose();
	}
	
}

	class MainFrame_acbytk_JButton_actionAdapter implements ActionListener{
		private final MainFrame adaptee;
		
		MainFrame_acbytk_JButton_actionAdapter(MainFrame adaptee) {
            this.adaptee = adaptee;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				adaptee.MainFrame_acbytk_JButton_actionPerformed(e);
			}catch(PropertyVetoException ex) {
				throw new RuntimeException(ex);
			}catch(SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
	
	
	class MainFrame_hibytk_JButton_actionAdapter implements ActionListener{
		private final MainFrame adaptee;
		
		MainFrame_hibytk_JButton_actionAdapter(MainFrame adaptee){
			this.adaptee=adaptee;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				adaptee.MainFrame_hibytk_JButton_actionPerformed(e);
			}catch(PropertyVetoException ex) {
					throw new RuntimeException(ex);
				}catch(SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		}
	
	class MainFrame_exit_JButton_actionAdapter implements ActionListener{
		private final MainFrame adaptee;
		
		MainFrame_exit_JButton_actionAdapter(MainFrame adaptee){
			this.adaptee=adaptee;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				adaptee.MainFrame_exit_JButton_actionPerformed(e);
			}catch(PropertyVetoException ex) {
					throw new RuntimeException(ex);
				}catch(SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		}
	
	class MainFrame_info_JButton_actionAdapter implements ActionListener{
		private final MainFrame adaptee;
		
		MainFrame_info_JButton_actionAdapter(MainFrame adaptee){
			this.adaptee=adaptee;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				adaptee.MainFrame_info_JButton_actionPerformed(e);
			}catch(PropertyVetoException ex) {
					throw new RuntimeException(ex);
				}catch(SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		}