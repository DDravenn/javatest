package maGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI.login;
import GUI.register;
import control.seedata;

public class seeuser extends javax.swing.JFrame{
	
	JPanel welcome_JPanel=new JPanel();
	JLabel JL1=new JLabel();
	JTable JT1=new JTable();
	JButton quit=new JButton();
	DefaultTableModel tableModel;
	
	
	public seeuser() throws PropertyVetoException, SQLException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
	
	private void initComponents() {
		welcome_JPanel=(JPanel) getContentPane();
		welcome_JPanel.setLayout(new FlowLayout());
		setSize(new Dimension(700,500));
		setTitle("人员信息界面");
		
		JL1.setText("所有人员信息");
		JL1.setBounds(new Rectangle(350,10,200,30));
		quit.setText("返回");
		quit.setFont(new Font("黑体",Font.BOLD,15));
		quit.addActionListener(new seeuser_quit_actionAdapter(this));

		welcome_JPanel.add(JL1);
		welcome_JPanel.add(JT1);
		welcome_JPanel.add(quit);

		//获取数据库的各行数据和表头数据
		Vector rowData = seedata.getRows();
		Vector columnNames = seedata.getHead();
		
		// 新建表格
				tableModel = new DefaultTableModel(rowData,columnNames);	
				JT1 = new JTable(tableModel);
				
			JScrollPane s = new JScrollPane(JT1);		
			this.add(s);	
			this.setVisible(true);		// 显示窗体
	}
	
	public void seeuser_quit_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{

		MAFrame ma=new MAFrame();
		ma.setVisible(true);
		this.dispose();
	}
}

class seeuser_quit_actionAdapter implements ActionListener{
	private final seeuser adaptee;
	
	seeuser_quit_actionAdapter(seeuser adaptee){
		this.adaptee=adaptee;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			adaptee.seeuser_quit_actionPerformed(e);
		}catch(PropertyVetoException ex){
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}

