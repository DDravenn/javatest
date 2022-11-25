package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.User;


public class acselect extends javax.swing.JFrame{
	
	private String url = "jdbc:mysql://localhost:1433/message?useUnicode=true&characterEncoding=GBK&useSSL=false";
	private String userName = "sa";
	private String password = "czy6220303";
	private String driverName = "com.mysql.jdbc.Driver";
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
		
	JPanel welcome_JPanel=new JPanel();
		JLabel tip=new JLabel();
		JLabel JL1=new JLabel();
		JLabel JL2=new JLabel();
		JLabel JL3=new JLabel();
		JLabel JL4=new JLabel();
		JLabel JL5=new JLabel();
		JLabel JL6=new JLabel();
		JLabel JL7=new JLabel();
		JLabel zhu=new JLabel();
		JLabel wr=new JLabel();
		
		
		JTextField JF1=new JTextField();
		JTextField JF2=new JTextField();
		JTextField JF3=new JTextField();
		JTextField JF4=new JTextField();
		JTextField JF5=new JTextField();
		JTextField JF6=new JTextField();
		JTextField JF7=new JTextField();
		JTextField xiazhu=new JTextField();
		JTextField BillField =new JTextField();
		
		JButton ok =new JButton();
		JButton exit=new JButton();
		JButton Bill=new JButton();
		JButton ran=new JButton();
	
		public  acselect() throws PropertyVetoException, SQLException {
	        try {
	            setDefaultCloseOperation(EXIT_ON_CLOSE);
	            initComponents();
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	    }
		
		private void initComponents() throws Exception {
			 welcome_JPanel = (JPanel) getContentPane();
			 welcome_JPanel.setLayout(null);
		        setSize(new Dimension(600, 500));
		        setTitle("欢迎来到下注界面");
		        
		        welcome_JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("欢迎下注"));
		        tip.setText("Tips:请从1-36中选中7个填入文本框中");
		        JL1.setText("1号彩票");
		        JL2.setText("2号彩票");
		        JL3.setText("3号彩票");
		        JL4.setText("4号彩票");
		        JL5.setText("5号彩票");
		        JL6.setText("6号彩票");
		        JL7.setText("7号彩票");
		        zhu.setText("下注数");
		        ok.setText("确定");
		        exit.setText("返回");
		        wr.setText("注意:每注5元!");
		        ran.setText("随机选号");
		        Bill.setText("计算金额");
		        
		        tip.setFont(new Font("黑体",Font.BOLD,15));
		        tip.setBounds(new Rectangle(70,40,300,25));
		        
		        JL1.setFont(new Font("黑体",Font.BOLD,15));
		        JL1.setBounds(new Rectangle(35, 100, 77, 25));
		        
		        JL2.setFont(new Font("黑体",Font.BOLD,15));
		        JL2.setBounds(new Rectangle(130, 100, 77, 25));
		        
		        JL3.setFont(new Font("黑体",Font.BOLD,15));
		        JL3.setBounds(new Rectangle(225, 100, 77, 25));
		        
		        JL4.setFont(new Font("黑体",Font.BOLD,15));
		        JL4.setBounds(new Rectangle(325, 100, 77, 25));
		        
		        JL5.setFont(new Font("黑体",Font.BOLD,15));
		        JL5.setBounds(new Rectangle(90, 200, 77, 25));
		        
		        JL6.setFont(new Font("黑体",Font.BOLD,15));
		        JL6.setBounds(new Rectangle(190, 200, 77, 25));
		        
		        JL7.setFont(new Font("黑体",Font.BOLD,15));
		        JL7.setBounds(new Rectangle(290, 200, 77, 25));
		        
		        JF1.setFont(new Font("Dialog",Font.BOLD,15));
		        JF1.setBounds(new Rectangle(35,140,50,30));
		        
		        JF2.setFont(new Font("Dialog",Font.BOLD,15));
		        JF2.setBounds(new Rectangle(130,140,50,30));
		        
		        JF3.setFont(new Font("Dialog",Font.BOLD,15));
		        JF3.setBounds(new Rectangle(225,140,50,30));
		        
		        JF4.setFont(new Font("Dialog",Font.BOLD,15));
		        JF4.setBounds(new Rectangle(325,140,50,30));
		        
		        JF5.setFont(new Font("Dialog",Font.BOLD,15));
		        JF5.setBounds(new Rectangle(90,230,50,30));
		      
		        JF6.setFont(new Font("Dialog",Font.BOLD,15));
		        JF6.setBounds(new Rectangle(190,230,50,30));
		        
		        JF7.setFont(new Font("Dialog",Font.BOLD,15));
		        JF7.setBounds(new Rectangle(290,230,50,30));
		        
		        BillField.setFont(new Font("Dialog",Font.BOLD,15));
		        BillField.setBounds(new Rectangle(450,240,50,30));
		        
		        zhu.setFont(new Font("黑体",Font.BOLD,15));
		        zhu.setBounds(new Rectangle(450,100,77,25));
		        
		        xiazhu.setFont(new Font("Dialog",Font.BOLD,15));
		        xiazhu.setBounds(new Rectangle(450,140,50,30));
		        
		        wr.setFont(new Font("黑体",Font.BOLD,15));
		        wr.setBounds(new Rectangle(430,60,150,25));
		        
		        ok.setFont(new Font("黑体",Font.BOLD,15));
		        ok.setBounds(new Rectangle(180,300,80,30));
		        ok.addActionListener(new acselect_ok_actionAdapter(this));
		        
		        exit.setFont(new Font("黑体",Font.BOLD,15));
		        exit.setBounds(new Rectangle(280,300,80,30));
		        exit.addActionListener(new acselect_exit_actionAdapter(this));
		        
		        Bill.setFont(new Font("黑体",Font.BOLD,15));
		        Bill.setBounds(new Rectangle(420,200,100,30));
		        Bill.addActionListener(new acselect_Bill_actionAdapter(this));
		        
		        ran.setFont(new Font("黑体",Font.BOLD,15));
		        ran.setBounds(new Rectangle(10,300,120,30));
		        ran.addActionListener(new acselect_ran_actionAdapter(this));
		        
		        welcome_JPanel.add(JF1);
		        welcome_JPanel.add(JF2);
		        welcome_JPanel.add(JF3);
		        welcome_JPanel.add(JF4);
		        welcome_JPanel.add(JF5);
		        welcome_JPanel.add(JF6);
		        welcome_JPanel.add(JF7);
		        welcome_JPanel.add(zhu);
		        welcome_JPanel.add(JL1);
		        welcome_JPanel.add(JL2);
		        welcome_JPanel.add(JL3);
		        welcome_JPanel.add(JL4);
		        welcome_JPanel.add(JL5);
		        welcome_JPanel.add(JL6);
		        welcome_JPanel.add(JL7);
		        welcome_JPanel.add(xiazhu);
		        welcome_JPanel.add(ok);
		        welcome_JPanel.add(exit);
		        welcome_JPanel.add(wr);
		        welcome_JPanel.add(tip);
		        welcome_JPanel.add(ran);
		        welcome_JPanel.add(Bill);
		        welcome_JPanel.add(BillField);
		}
		
		public void ok_actionPerformed(ActionEvent e)throws PropertyVetoException, SQLException {
				 if(BillField.getText().length() != 0){
		            ArrayList<Integer> list = new ArrayList<>();
		            int[] notes = new int[7];
		            notes[0] = Integer.parseInt(JF1.getText());
		            notes[1] = Integer.parseInt(JF2.getText());
		            notes[2] = Integer.parseInt(JF3.getText());
		            notes[3] = Integer.parseInt(JF4.getText());
		            notes[4] = Integer.parseInt(JF5.getText());
		            notes[5] = Integer.parseInt(JF6.getText());
		            notes[6] = Integer.parseInt(JF7.getText());
		            for (int i = 0; i < notes.length; i++) {
		                if(notes[i]<1 || notes[i]>36){
		                    JOptionPane.showMessageDialog(null, "请输入<1,36>范围的数！");
		                }else if(!list.contains(notes[i])){
		                    list.add(notes[i]);
		                }
		            }
		            if(list.size() < 7){
		                JOptionPane.showMessageDialog(null, "请勿输入重复数字！");
		            }
		            User.setNotes(notes);}
		           User.setNum(Integer.parseInt(xiazhu.getText()));
		}
		           
		
		public void exit_actionPerformed(ActionEvent e)throws PropertyVetoException, SQLException {
			MainFrame ma=new MainFrame();
			ma.setVisible(true);
			this.dispose();
		}
		
		
		public void Bill_actionPerformed(ActionEvent e)throws PropertyVetoException, SQLException {
			int times = Integer.parseInt(xiazhu.getText());
	        if(JF1.getText().length()==0 || JF2.getText().length()==0 || 
	                JF3.getText().length()==0 || JF4.getText().length()==0 || 
	                JF5.getText().length()==0 || JF6.getText().length()==0 || 
	                JF7.getText().length()==0){
	            JOptionPane.showMessageDialog(null, "请输入有效号码！");
	        } else {
	            int bill = 5 * times;
	            User.setNum(User.getNum() + times);
	            System.out.println(User.getNum());
	            BillField.setText(bill + "");
	        }
	    }       
		
		public void ran_actionPerformed(ActionEvent e)throws PropertyVetoException, SQLException {                                      
		        ArrayList<Integer> list = new ArrayList<>();
		        Random random = new Random();
		        int i = 0, num = 0;
		        while (i < 7) {
		                num = random.nextInt(35) + 1;
		                if (!list.contains(num)) {
		                        list.add(num);
		                } else continue;
		                i++;
		        }
		        System.out.println(list.size());

		        JF1.setText(list.remove(0) + "");
		        JF2.setText(list.remove(0) + "");
		        JF3.setText(list.remove(0) + "");
		        JF4.setText(list.remove(0) + "");
		        JF5.setText(list.remove(0) + "");
		        JF6.setText(list.remove(0) + "");
		        JF7.setText(list.remove(0) + "");
		        
		    } 
		}


//確定監視器
 class acselect_ok_actionAdapter implements ActionListener{

	 private final acselect adaptee;
	 
	 acselect_ok_actionAdapter(acselect adaptee){
		 this.adaptee=adaptee;
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.ok_actionPerformed(e);
		}catch(PropertyVetoException ex){
			 throw new RuntimeException(ex);
	}catch(SQLException ex) {
		 throw new RuntimeException(ex);
			}
	}
 }
 
 //退出
 class acselect_exit_actionAdapter implements ActionListener{

	 private final acselect adaptee;
	 
	 acselect_exit_actionAdapter(acselect adaptee){
		 this.adaptee=adaptee;
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.exit_actionPerformed(e);
		}catch(PropertyVetoException ex){
			 throw new RuntimeException(ex);
	}catch(SQLException ex) {
		 throw new RuntimeException(ex);
			}
	}
 }
 
 //计算金额
 class acselect_Bill_actionAdapter implements ActionListener{

	 private final acselect adaptee;
	 
	 acselect_Bill_actionAdapter(acselect adaptee){
		 this.adaptee=adaptee;
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.Bill_actionPerformed(e);
		}catch(PropertyVetoException ex){
			 throw new RuntimeException(ex);
	}catch(SQLException ex) {
		 throw new RuntimeException(ex);
			}
	}
 }
 
 //随机选数
 class acselect_ran_actionAdapter implements ActionListener{

	 private final acselect adaptee;
	 
	 acselect_ran_actionAdapter(acselect adaptee){
		 this.adaptee=adaptee;
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.ran_actionPerformed(e);
		}catch(PropertyVetoException ex){
			 throw new RuntimeException(ex);
	}catch(SQLException ex) {
		 throw new RuntimeException(ex);
			}
	}
 }
