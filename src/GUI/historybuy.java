package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class historybuy extends javax.swing.JFrame{
	JPanel welcome_JPanel=new JPanel();
	JTable JT1=new JTable();
	
	public historybuy()throws PropertyVetoException, SQLException {
		try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            initComponents();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
	private void initComponents() {
		JT1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] {"用户id","购买彩票","下注数"}));
		
		welcome_JPanel = (JPanel) getContentPane();
		welcome_JPanel.setLayout(null);
		setSize(new Dimension(600, 500));
		 setTitle("历史购买");
		 welcome_JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("历史记录"));
		 
		 JT1.setFont(new Font("黑体",Font.BOLD,15));
		 JT1.setBounds(new Rectangle(10,30,500,400));
		welcome_JPanel.add(JT1);
		
	}
}
