package presentation.businessui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class CarUI extends JPanel{
	private JLabel titlelb;
	private JButton a;
	private JButton b;
	private JButton c;
	private JButton logoutbt;

	public CarUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		titlelb= new JLabel("车辆管理");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		
		a = new JButton("新车注册");
		a.setFont(new Font("幼圆", Font.BOLD, 15));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(300, 250, 100, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new CarNew());
    		}
    	});
		
		b = new JButton("修改车辆信息");
		b.setFont(new Font("幼圆", Font.BOLD, 15));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(500, 250, 130, 50);
		add(b);
		b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new BusinessUI());
    	    }
    	});
		
		c = new JButton("删除车辆信息");
		c.setFont(new Font("幼圆", Font.BOLD, 15));
		c.setHorizontalAlignment(SwingConstants.CENTER);
		c.setBounds(300, 350, 130, 50);
		add(c);
		c.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new BusinessUI());
    		}
    	});
		
		logoutbt = new JButton("退出");
		logoutbt.setFont(new Font("幼圆", Font.BOLD, 20));
		logoutbt.setHorizontalAlignment(SwingConstants.CENTER);
		logoutbt.setBounds(500, 350, 100, 50);
		add(logoutbt);
		logoutbt.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new BusinessUI());
    		}
    	});
		setVisible(true);
	}

	
}
