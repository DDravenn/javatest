package maGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import GUI.MainFrame;
import control.Control;
import control.infocontrol;
import control.opencontrol;
import control.seedata;
import control.ticontrol;
import control.usercontrol;
import control.winticontrol;
import sql.connectSQL;
import user.User;
import user.buyTicket;
import user.winticket;

public class openticket extends javax.swing.JFrame {
	DefaultTableModel tableModel;
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
		welcome_JPanel.setLayout(new GridLayout(20,10));
		setSize(new Dimension(600,500));
		setTitle("开奖界面");
		setLocation(400,150);
		
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
		
		
		JB1.setFont(new Font("黑体",Font.BOLD,15));
		JB1.setBounds(new Rectangle(350,80,120,30));
		JB1.addActionListener(new openticket_JB1_actionAdapter(this));
		
		JB2.setFont(new Font("黑体",Font.BOLD,15));
		JB2.setBounds(new Rectangle(350,30,120,30));
		JB2.addActionListener(new openticket_JB2_actionAdapter(this));
		
		welcome_JPanel.add(JL2);
		welcome_JPanel.add(ticket_textField);
		welcome_JPanel.add(JB2);	
		welcome_JPanel.add(JB1);
		welcome_JPanel.add(JL1);
		welcome_JPanel.add(JT1);
		//获取数据库的各行数据和表头数据
				Vector rowData = opencontrol.getRows();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Vector columnNames = opencontrol.getHead();
				
				// 新建表格
						tableModel = new DefaultTableModel(rowData,columnNames);
						JT1 = new JTable(tableModel);
						
					JScrollPane s = new JScrollPane(JT1);		
					this.add(s);	
					this.setVisible(true);		// 显示窗体
	}
	
	public void openticket_JB1_actionPerformed(ActionEvent e)throws PropertyVetoException, SQLException {
		MAFrame MA=new MAFrame();
		MA.setVisible(true);
		this.dispose();
	}
	
	public void openticket_JB2_actionPerformed(ActionEvent e)throws PropertyVetoException, SQLException {
			String []cun = new String[7];
			String s=ticket_textField.getText();
			cun=s.split(",");
			winticket t =new winticket(cun);
			
			Control control = winticontrol.getInstance();
			Control control2 = ticontrol.getInstance();
			List<buyTicket> buyTickets = control2.read(null);
			control.insert(t);
			
			JOptionPane.showMessageDialog(null, "开奖成功！");
			
			
			
			
			
			
			String[] qu= buyTickets.get(0).getTickets();
			
    		int count=0;
    		int fail=0;
    		for (int i = 0; i < qu.length; i++) {
    			for(int j=0;j<qu.length;i++) {
				if(cun[i]==qu[i]){
					count++;
				}else{
					fail++;
				}
				if(fail>3){
					break;
				}
    			}
			}
    		if(count==4){
    			buyTickets.get(0).setGrade("三等價");
    		}
    		if(count==5){
    			buyTickets.get(0).setGrade("二等獎");

    		}
    		if(count==6){
    			buyTickets.get(0).setGrade("一等獎");

    		}
    		if(count==7){
    			buyTickets.get(0).setGrade("特等獎");
    		}
    		control2.update("123", buyTickets.get(0));
	}
	
}


//返回监视器
class openticket_JB1_actionAdapter implements ActionListener{
	private final openticket adaptee;
	
	openticket_JB1_actionAdapter(openticket adaptee){
		this.adaptee=adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.openticket_JB1_actionPerformed(e);
		}catch(PropertyVetoException ex) {
				throw new RuntimeException(ex);
			}catch(SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

//开奖监视器
class openticket_JB2_actionAdapter implements ActionListener{
	private final openticket adaptee;
	
	openticket_JB2_actionAdapter(openticket adaptee){
		this.adaptee=adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.openticket_JB2_actionPerformed(e);
		}catch(PropertyVetoException ex) {
				throw new RuntimeException(ex);
			}catch(SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
