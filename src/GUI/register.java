package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.ExpandVetoException;
import javax.naming.*;
import javax.sound.sampled.EnumControl;
import control.Control;
import control.usercontrol;
import user.User;

public class register extends javax.swing.JFrame {
		
	JPanel ix_Panel=new JPanel();
	JLabel id_JLabel=new JLabel();
	JLabel name_JLabel=new JLabel();
	JLabel pwd_JLabel=new JLabel();
	JLabel phone_JLabel=new JLabel();
	JLabel balance_JLabel=new JLabel();
	JTextField id_textField=new JTextField();
	JTextField name_textField=new JTextField();
	JTextField pwd_textField=new JTextField();
	JTextField phone_textField=new JTextField();
	JTextField balance_textField=new  JTextField();
	JButton re_button=new JButton();
	JButton rn_button=new JButton();
	JOptionPane point_JOptionPane = new JOptionPane();
	Control control = usercontrol.getInstance();
	
	public register()throws PropertyVetoException, SQLException {
		try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            initComponents();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
	
	
	private void initComponents() {
		ix_Panel = (JPanel) getContentPane();
        ix_Panel.setLayout(null);
		setSize(new Dimension(400, 500));
		 setTitle("欢迎注册彩票系统");
		ix_Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("用户注册界面"));
		
		balance_JLabel.setText("余额:");
		balance_JLabel.setFont(new Font("Dialog",Font.BOLD,15));
		balance_JLabel.setBounds(new Rectangle(95,240,77,25));
		
		balance_textField.setText("0");
		balance_textField.setFont(new Font("Dialog",Font.BOLD,15));
		balance_textField.setBounds(new Rectangle(188,240,80,30));
		balance_textField.setEditable(false);
		
		id_JLabel.setText("用户id:");
		id_JLabel.setFont(new Font("Dialog",Font.BOLD,15));
		id_JLabel.setBounds(new Rectangle(95, 80, 77, 25));
		name_JLabel.setText("用户名:");
		name_JLabel.setFont(new Font("Dialog",Font.BOLD,15));
		name_JLabel.setBounds(new Rectangle(95, 120, 77, 25));
		pwd_JLabel.setText("用户密码:");
		pwd_JLabel.setFont(new Font("Dialog",Font.BOLD,15));
		pwd_JLabel.setBounds(new Rectangle(95, 160, 77, 25));
		phone_JLabel.setText("手机号码:");
		phone_JLabel.setFont(new Font("Dialog",Font.BOLD,15));
		phone_JLabel.setBounds(new Rectangle(95, 200, 77, 25));
		id_textField.setFont(new Font("Dialog",Font.PLAIN,15));
		id_textField.setBounds(new Rectangle(188, 80, 80, 30));
		name_textField.setFont(new Font("Dialog",Font.PLAIN,15));
		name_textField.setBounds(new Rectangle(188, 120, 80, 30));
		pwd_textField.setFont(new Font("Dialog",Font.BOLD,15));
		pwd_textField.setBounds(new Rectangle(188,160,80,30));
		phone_textField.setFont(new Font("Dialog",Font.BOLD,15));
		phone_textField.setBounds(new Rectangle(188,200,80,30));
		re_button.setText("注册");
		re_button.setFont(new Font("Dialog",Font.PLAIN,15));
		re_button.setBounds(95, 280, 40, 30);
		re_button.setBorder(BorderFactory.createRaisedBevelBorder());
		re_button.addActionListener(new register_re_button_actionAdapter(this));
		rn_button.setText("返回");
		rn_button.setFont(new Font("Dialog",Font.PLAIN,15));
		rn_button.setBounds(200, 280, 40, 30);
		rn_button.setBorder(BorderFactory.createRaisedBevelBorder());
		rn_button.addActionListener(new register_rn_button_actionAdapter(this));
		point_JOptionPane.setBounds(new Rectangle(50, 263, 262, 90));
        point_JOptionPane.setLayout(null);
		
		
		ix_Panel.add(id_JLabel);
		ix_Panel.add(id_textField);
		ix_Panel.add(name_JLabel);
		ix_Panel.add(name_textField);
		ix_Panel.add(pwd_JLabel);
		ix_Panel.add(pwd_textField);
		ix_Panel.add(phone_JLabel);
		ix_Panel.add(phone_textField);
		ix_Panel.add(re_button);
		ix_Panel.add(rn_button);
		ix_Panel.add(point_JOptionPane);
		ix_Panel.add(balance_JLabel);
		ix_Panel.add(balance_textField);
	}
	
	public void register_rn_button_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{

		login ln=new login();
		ln.setVisible(true);
		this.dispose();
	}
	//注册
	
	public void register_re_button_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
		boolean x=false;
		if(id_textField.getText().length()==0) {
			JOptionPane.showMessageDialog(this,"请输入用户id！", "Warning",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(id_textField.getText().length()>6) {
			JOptionPane.showMessageDialog(this,"请输入小于6位的用户id！", "Warning",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(name_textField.getText().length()==0){
			JOptionPane.showMessageDialog(this,"请输入用户名！", "Warning",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(pwd_textField.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "请输入密码！","Warning",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(pwd_textField.getText().length()>=15) {
			JOptionPane.showMessageDialog(this, "请输入小于15位的密码！","Warning",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(phone_textField.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "请输入手机号！","Warning",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(phone_textField.getText().length()>11) {
			JOptionPane.showMessageDialog(this, "请输入完整的11位手机号！", "Warning", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			insertuser();
		}
	}

//注册，将用户添加进数据库中
	private void insertuser() throws SQLException{
    User u = new User(id_textField.getText().trim(), name_textField.getText().trim(), pwd_textField.getText().trim(), phone_textField.getText().trim(),balance_textField.getText().trim());
    System.out.println(u);
    control.insert(u);
    JOptionPane.showMessageDialog(this, "注册成功", "Warning", JOptionPane.INFORMATION_MESSAGE);
    //清空文本框
    id_textField.setText("");
    name_textField.setText("");
    pwd_textField.setText("");
    phone_textField.setText("");
	}

}


//注册的监视器
class register_re_button_actionAdapter implements ActionListener{
	private final register adaptee;
	
	register_re_button_actionAdapter(register adaptee){
		this.adaptee=adaptee;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			adaptee.register_re_button_actionPerformed(e);
		}catch(PropertyVetoException ex){
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}

//返回的监视器
class register_rn_button_actionAdapter implements ActionListener{
	private final register adaptee;
	
	register_rn_button_actionAdapter(register adaptee){
		this.adaptee=adaptee;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			adaptee.register_rn_button_actionPerformed(e);
		}catch(PropertyVetoException ex){
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}

