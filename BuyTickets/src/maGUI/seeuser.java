package maGUI;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class seeuser extends javax.swing.JFrame{
	
	JPanel welcome_JPanel=new JPanel();
	JLabel JL1=new JLabel();
	JTable JT1=new JTable();
	
	public seeuser() throws PropertyVetoException, SQLException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
	
	private void initComponents() {
		welcome_JPanel=(JPanel) getContentPane();
		welcome_JPanel.setLayout(null);
		setSize(new Dimension(700,500));
		setTitle("人员信息界面");
		
		welcome_JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("人员信息界面"));
		JL1.setText("所有人员信息");
		JL1.setBounds(new Rectangle(350,10,200,30));
		
		JT1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] {"用户id","用户名","用户密码","用户电话","用户余额"}));
		welcome_JPanel.add(JL1);
		welcome_JPanel.add(JT1);
	}
}
