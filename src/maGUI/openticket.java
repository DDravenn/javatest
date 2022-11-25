package maGUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class openticket extends javax.swing.JFrame {
	
	JPanel welcome_JPanel = new JPanel();
	JTable JT1=new JTable();
	JLabel JL1=new JLabel();
	JLabel JL2=new JLabel();
	JTextField ticket_textField=new JTextField();
	JButton JB1=new JButton();
	JButton JB2=new JButton();
	
	public openticket() throws PropertyVetoException, SQLException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
	
	private void initComponents() {
		welcome_JPanel=(JPanel) getContentPane();
		welcome_JPanel.setLayout(null);
		setSize(new Dimension(600,500));
		setTitle("开奖界面");
		
		welcome_JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("开奖界面"));
		
		JL1.setText("获奖情况");
		JL2.setText("本期号码:");
		JB1.setText("返回");
		JB2.setText("确定");
		
		JL1.setFont(new Font("黑体",Font.BOLD,15));
		JL1.setBounds(new Rectangle(200,80,120,30));
		
		JL2.setFont(new Font("黑体",Font.BOLD,15));
		JL2.setBounds(new Rectangle(30,30,120,30));
		
		ticket_textField.setFont(new Font("Dialog",Font.BOLD,15));
		ticket_textField.setBounds(new Rectangle(100,30,220,30));
		
		JT1.setFont(new Font("黑体",Font.BOLD,15));
		JT1.setBounds(new Rectangle(10,150,550,200));
		
		JB1.setFont(new Font("黑体",Font.BOLD,15));
		JB1.setBounds(new Rectangle(350,80,120,30));
		
		JB2.setFont(new Font("黑体",Font.BOLD,15));
		JB2.setBounds(new Rectangle(350,30,120,30));
		JT1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] {"用户id","所购彩票","获奖等级"}));
		
		welcome_JPanel.add(JB1);
		welcome_JPanel.add(JL1);
		welcome_JPanel.add(JL2);
		welcome_JPanel.add(JT1);
		welcome_JPanel.add(ticket_textField);
		welcome_JPanel.add(JB2);
		
		
		
		
		
		
		
	}
	
}
