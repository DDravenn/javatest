package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Control;
import control.logincontrol;
import control.usercontrol;
import user.Loginuser;
import user.User;

public class information extends javax.swing.JFrame{
	
	JPanel welcome_JPanel = new JPanel();
	JLabel id1=new JLabel();
	JLabel name1=new JLabel();
	JLabel phone1=new JLabel();
	JLabel balance1=new JLabel();
	JLabel id2=new JLabel();
	JLabel name2=new JLabel();
	JLabel phone2=new JLabel();
	JLabel balance2=new JLabel();
	JLabel pwd2=new JLabel();
	JButton re=new JButton();
	JButton quit=new JButton();
	
	public information() throws PropertyVetoException, SQLException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
	
	private void initComponents() throws SQLException, PropertyVetoException {
		Control control=usercontrol.getInstance();
		List<User> user = control.read(id1.getText().toString().trim());
		String id= user.get(0).getUserid();
		String name= user.get(0).getUsername();
		String telephone= user.get(0).getUsertelephone();
		String balance= user.get(0).getUserbalance();
		

		welcome_JPanel=(JPanel) getContentPane();
		welcome_JPanel.setLayout(null);
		setSize(new Dimension(400,500));
		setTitle("个人信息界面");
		welcome_JPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("个人信息表"));
		
		id1.setText("用户id:");
		name1.setText("用户名:");
		phone1.setText("电话号码:");
		balance1.setText("当前余额:");
		re.setText("充值");
		quit.setText("返回");
		
		id2.setText(id);
		name2.setText(name);
		phone2.setText(telephone);
		balance2.setText(balance);
		
		id1.setFont(new Font("黑体",Font.BOLD,15));
		id1.setBounds(new Rectangle(100,100,80,30));
		
		name1.setFont(new Font("黑体",Font.BOLD,15));
		name1.setBounds(new Rectangle(100,150,120,30));
		
		phone1.setFont(new Font("黑体",Font.BOLD,15));
		phone1.setBounds(new Rectangle(80,200,120,30));
		
		balance1.setFont(new Font("黑体",Font.BOLD,15));
		balance1.setBounds(new Rectangle(80,250,120,30));
		
		id2.setFont(new Font("黑体",Font.BOLD,15));
		id2.setBounds(new Rectangle(160,100,120,30));
		
		name2.setFont(new Font("黑体",Font.BOLD,15));
		name2.setBounds(new Rectangle(160,150,120,30));
		
		phone2.setFont(new Font("黑体",Font.BOLD,15));
		phone2.setBounds(new Rectangle(160,200,120,30));
		
		balance2.setFont(new Font("黑体",Font.BOLD,15));
		balance2.setBounds(new Rectangle(160,250,120,30));
		
		re.setFont(new Font("黑体",Font.BOLD,15));
		re.setBounds(new Rectangle(80,290,80,30));
		re.addActionListener(new information_re_actionAdapter(this));
		
		quit.setFont(new Font("黑体",Font.BOLD,15));
		quit.setBounds(new Rectangle(180,290,80,30));
		quit.addActionListener(new information_quit_actionAdapter(this));
		
		
		welcome_JPanel.add(id1);
		welcome_JPanel.add(id2);
		welcome_JPanel.add(name1);
		welcome_JPanel.add(name2);
		welcome_JPanel.add(phone1);
		welcome_JPanel.add(phone2);
		welcome_JPanel.add(balance1);
		welcome_JPanel.add(balance2);
		welcome_JPanel.add(re);
		welcome_JPanel.add(quit);

	}
	
public void information_re_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
		recharge rec = new recharge();
		rec.setVisible(true);
		this.dispose();
	}



public void information_quit_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException{
	MainFrame ma=new MainFrame();
	ma.setVisible(true);
	this.dispose();
	}
}


//充值的监视器
class information_re_actionAdapter implements ActionListener{
	private final information adaptee;
	
	information_re_actionAdapter(information adaptee) {
        this.adaptee = adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.information_re_actionPerformed(e);
		}catch(PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}


//返回的监视器
class information_quit_actionAdapter implements ActionListener{
	private final information adaptee;
	
	information_quit_actionAdapter(information adaptee) {
        this.adaptee = adaptee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adaptee.information_quit_actionPerformed(e);
		}catch(PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
