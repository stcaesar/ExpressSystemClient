package presentation.mannagerui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class doubleStrategyUI extends JPanel{
	private JLabel titlelb;

	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;
	private JButton logoutbt;

	public doubleStrategyUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		titlelb= new JLabel("策略制定");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);

		
		a = new JButton("薪金策略");
		a.setFont(new Font("幼圆", Font.BOLD, 15));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(300, 200, 100, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new PayUI());
    		}
    	});
		
		b = new JButton("常量策略");
		b.setFont(new Font("幼圆", Font.BOLD, 15));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(500, 200, 100, 50);
		add(b);
		b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new ConstantUI());
    	    }
    	});
		
		
		logoutbt = new JButton("退出");
		logoutbt.setFont(new Font("幼圆", Font.BOLD, 15));
		logoutbt.setHorizontalAlignment(SwingConstants.CENTER);
		logoutbt.setBounds(300, 300, 100, 50);
		add(logoutbt);
		logoutbt.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new ManagerUI());
    		}
    	});
		setVisible(true);
	}
	
}
