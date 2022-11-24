package manager;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class manager extends javax.swing.JFrame{
		
	public manager() {
		managerGUI();
	}
	
	public void managerGUI() {
		JFrame menu =new JFrame();
		menu.setLayout(null);//清空
		menu.setSize(600,800);//界面大小
		menu.setResizable(false);//界面大小不变
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setLayout(new BorderLayout()); // 新建BorderLayout布局
		
		JPanel Jpanel1 = new JPanel(new FlowLayout());
		JLabel JLabe1 = new JLabel("管理员界面");
		
		JLabe1.setFont(new Font("新宋体", Font.BOLD, 27));	
		Jpanel1.add(JLabe1);
		Jpanel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		menu.add(Jpanel1, BorderLayout.NORTH);
		JPanel panel2 = new JPanel(new GridLayout(5, 1));
		
	
}
}
