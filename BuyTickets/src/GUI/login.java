package GUI;

import user.Loginuser;
import user.Ticket;
import user.User;
import javax.swing.*;

import control.Control;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.List;
import control.Control;
import control.usercontrol;
import control.logincontrol;
import user.Loginuser;

public class login extends javax.swing.JFrame {
	
	JPanel jPanel_welcome;
	JLabel jlabel_id=new JLabel();
	JLabel jlabel_pwd=new JLabel();
	JTextField id_textField=new JTextField();
	JTextField pwd_textField=new JTextField();
	JButton login_button=new JButton();
	JButton register_button=new JButton();
	JButton exit_button=new JButton();
	Control control = logincontrol.getInstance();

	
	public  login() throws PropertyVetoException, SQLException {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            initComponents();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
	
	
	 private void initComponents() throws Exception {
		 jPanel_welcome = (JPanel) getContentPane();
		 jPanel_welcome.setLayout(null);
	        setSize(new Dimension(400, 500));
	        setTitle("欢迎使用彩票购买程序");
		
	    jPanel_welcome.setBorder(javax.swing.BorderFactory.createTitledBorder("彩票登录界面"));
		jlabel_id.setText("用户id");
		jlabel_pwd.setText("用户密码");
		login_button.setText("登录");
		register_button.setText("注册");
		exit_button.setText("退出");
		
		jlabel_id.setFont(new Font("黑体",Font.BOLD,15));//字体，风格，字号
		jlabel_id.setBounds(new Rectangle(95, 123, 77, 25));//设置X,Y坐标，宽，高
		jlabel_pwd.setFont(new Font("黑体",Font.BOLD,15));
		jlabel_pwd.setBounds(new Rectangle(95, 163, 77, 25));
		id_textField.setFont(new Font("Dialog",Font.PLAIN,15));
		id_textField.setBounds(new Rectangle(195, 123, 80, 30));
		pwd_textField.setFont(new Font("Dialog",Font.PLAIN,15));
		pwd_textField.setBounds(new Rectangle(195, 163, 80, 30));
		login_button.setFont(new Font("Dialog",Font.BOLD,15));
		login_button.setBounds(new Rectangle(95, 223, 80, 30));
		login_button.addActionListener(new login_login_button_actionAdapter(this));//添加监视器
		register_button.setFont(new Font("Dialog",Font.BOLD,15));
		register_button.setBounds(new Rectangle(195, 223, 80, 30));
		register_button.addActionListener(new login_register_button_actionAdapter(this));
		exit_button.setFont(new Font("Dialog",Font.BOLD,15));
		exit_button.setBounds(new Rectangle(160, 280, 80, 30));
		exit_button.addActionListener(new login_exit_button_actionAdapter(this));
		//将组件加入到Panel界面中
		jPanel_welcome.add(jlabel_id);
		jPanel_welcome.add(jlabel_pwd);
		jPanel_welcome.add(id_textField);
		jPanel_welcome.add(pwd_textField);
		jPanel_welcome.add(login_button);
		jPanel_welcome.add(exit_button);
		jPanel_welcome.add(register_button);
	 }
 
		//登录
		public void login_button_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException {
	        boolean x = false;
	        Control control = logincontrol.getInstance();
	        if (id_textField.getText().length() == 0) {
	            JOptionPane.showMessageDialog(this, "用户名不能为空！", "Warning",JOptionPane.INFORMATION_MESSAGE);
	        } 
	        else if(pwd_textField.getText().length()==0){
	        		JOptionPane.showMessageDialog(this, "密码不能为空！","Warning",JOptionPane.INFORMATION_MESSAGE);}
	        else {
	            List<Loginuser> loginuser = control.read(new Loginuser(id_textField.getText(), pwd_textField.getText()));
	            if(id_textField.getText()=="123" && pwd_textField.getText()=="123") {
	            	
	            }
	            else if (loginuser.size() > 0) {
	                MainFrame ma = new MainFrame();
	                ma.setVisible(true);
	                ma.validate();
	                this.dispose();
	            }else{
	                JOptionPane.showMessageDialog(this, "用户名或密码错误！", "Warning",
	                        JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
		}
		
		
		
		   //注册按钮功能
		 public void register_button_actionPerformed(ActionEvent e) throws PropertyVetoException, SQLException {
		        register re = new register();
		        re.setLocation(200, 40);
		        re.setSize(500, 400);
		        re.setVisible(true);
		        re.setResizable(false);
		        re.validate();
		        this.dispose();
		 }
		//退出按钮功能
		 public void exit_button_actionPerfromed(ActionEvent e) throws PropertyVetoException, SQLException{
			 System.exit(0);
		 }
		
		//登录按钮监视器	
				class  login_login_button_actionAdapter implements ActionListener{
					private final login adaptee;
					login_login_button_actionAdapter(login adaptee) {
				        this.adaptee = adaptee;
				    }
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							adaptee.login_button_actionPerformed(e);
						}catch(PropertyVetoException ex){
							 throw new RuntimeException(ex);
					}catch(SQLException ex) {
						 throw new RuntimeException(ex);
							}
						}		
					}
				}
				
				//注册按钮监视器
				class login_register_button_actionAdapter implements ActionListener {
				    private final login adaptee;

				    login_register_button_actionAdapter(login adaptee) {
				        this.adaptee = adaptee;
				    }

				    public void actionPerformed(ActionEvent e) {
				        try {
				            adaptee.register_button_actionPerformed(e);
				        } catch (PropertyVetoException ex) {
				            throw new RuntimeException(ex);
				        } catch (SQLException ex) {
				            throw new RuntimeException(ex);
				        }
				    }
				}
				//退出按钮监视器
				class login_exit_button_actionAdapter implements ActionListener {
					private final login adaptee;
					login_exit_button_actionAdapter(login adaptee){
						this.adaptee=adaptee;
					}
				public void actionPerformed(ActionEvent e) {
					try {
						adaptee.exit_button_actionPerfromed(e);
					}catch(PropertyVetoException ex) {
						throw new RuntimeException(ex);
					}catch(SQLException ex) {
						throw new RuntimeException(ex);
					}
				}
			}