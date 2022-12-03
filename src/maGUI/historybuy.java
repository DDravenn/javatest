package maGUI;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI.register;
import control.hisdata;
import control.seedata;

public class historybuy extends javax.swing.JFrame{
	JPanel welcome_JPanel=new JPanel();
	JTable JT1=new JTable();
	JButton quit=new JButton();
	DefaultTableModel tableModel;
	
	public historybuy()throws PropertyVetoException, SQLException {
		try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            initComponents();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
	private void initComponents() throws PropertyVetoException, SQLException {
		
		
		welcome_JPanel = (JPanel) getContentPane();
		welcome_JPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		setSize(new Dimension(600, 500));
		setTitle("历史购买");
		setLocation(400,150);
		welcome_JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("历史记录"));
		
		quit.setText("返回");
		quit.setFont(new Font("黑体",Font.BOLD,15));
		quit.addActionListener(new historybuy_quit_actionAdapter(this));
		 
		welcome_JPanel.add(JT1);
		welcome_JPanel.add(quit);
		
		//获取数据库的各行数据和表头数据
			Vector rowData = hisdata.getRows();
			Vector columnNames = hisdata.getHead();
				
		// 新建表格
			tableModel = new DefaultTableModel(rowData,columnNames);	
			JT1 = new JTable(tableModel);
						
			JScrollPane s = new JScrollPane(JT1);		
			this.add(s);	
			this.setVisible(true);		// 显示窗体
	}
	
	public void historybuy_quit_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
		MAFrame MA=new MAFrame();
		MA.setVisible(true);
		this.dispose();
	}

}

class historybuy_quit_actionAdapter implements ActionListener{
	private final historybuy adaptee;
	
	historybuy_quit_actionAdapter(historybuy adaptee){
		this.adaptee=adaptee;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			adaptee.historybuy_quit_actionPerformed(e);
		}catch(PropertyVetoException ex){
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
