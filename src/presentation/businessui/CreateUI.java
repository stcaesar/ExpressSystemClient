package presentation.businessui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class CreateUI extends JPanel{
	private JLabel titlelb;

	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;
	private JButton e;
	private JButton f;
	private JButton logoutbt;

	public CreateUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		titlelb= new JLabel("新建");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		
		a = new JButton("接收单");
		a.setFont(new Font("幼圆", Font.BOLD, 20));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(300, 200, 120, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new ReceiveNew());
    		}
    	});
		
		b = new JButton("装车单");
		b.setFont(new Font("幼圆", Font.BOLD, 20));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(500, 200, 120, 50);
		add(b);
		b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new LoadNew());
    	    }
    	});
		
		c = new JButton("派件单");
		c.setFont(new Font("幼圆", Font.BOLD, 20));
		c.setHorizontalAlignment(SwingConstants.CENTER);
		c.setBounds(300, 300, 120, 50);
		add(c);
		c.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new DistributionNew());
    		}
    	});
		
		d = new JButton("新车注册");
		d.setFont(new Font("幼圆", Font.BOLD, 20));
		d.setHorizontalAlignment(SwingConstants.CENTER);
		d.setBounds(500, 300, 120, 50);
		add(d);
		d.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new CarNew());
    		}
    	});
		
		e = new JButton("司机注册");
		e.setFont(new Font("幼圆", Font.BOLD, 20));
		e.setHorizontalAlignment(SwingConstants.CENTER);
		e.setBounds(300, 400, 120, 50);
		add(e);
		e.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new DriverNew());
    		}
    	});
		
		f = new JButton("收款单");
		f.setFont(new Font("幼圆", Font.BOLD, 20));
		f.setHorizontalAlignment(SwingConstants.CENTER);
		f.setBounds(500, 400, 120, 50);
		add(f);
		f.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new MoneyNew());
    		}
    	});
		
		logoutbt = new JButton("退出");
		logoutbt.setFont(new Font("幼圆", Font.BOLD, 20));
		logoutbt.setHorizontalAlignment(SwingConstants.CENTER);
		logoutbt.setBounds(300, 500, 120, 50);
		add(logoutbt);
		logoutbt.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new BusinessUI());
    		}
    	});
		setVisible(true);
	}

	
}
