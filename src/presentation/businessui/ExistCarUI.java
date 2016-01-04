package presentation.businessui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businesslogic.businessbl.BusinessBL;
import presentation.businessui.CreateUI;
import presentation.businessui.alreadyHaveUI;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class ExistCarUI extends JPanel{
	private JLabel titlelb;
	private JTextField ta;
	private JButton a;
	private JButton b;
	private JButton c;
	private JButton logoutbt;

	public ExistCarUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelb= new JLabel("汽车查询");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		
		 ta = new JTextField("请输入汽车编号");
			ta.setBounds(250, 250, 200, 30);
			add(ta);
		a = new JButton("查询");
		a.setFont(new Font("幼圆", Font.BOLD, 15));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(500, 250, 120, 50);
		add(a);
		a.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
    			String carNumber = ta.getText().trim();
 
			     MainFrame.setContentPanel(new Table6UI(carNumber));
    		}
    	});
		
		b = new JButton("删除");
		b.setFont(new Font("幼圆", Font.BOLD, 20));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(300, 350, 120, 50);
		add(b);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
    			BusinessBL business = new BusinessBL(); 
    			String carNumber = ta.getText().trim();
    			if(business.deleteBusinessCarManagement(carNumber)){
    				SuccessUI success = new SuccessUI();}

    	    }
    	});
		
		c = new JButton("修改");
		c.setFont(new Font("幼圆", Font.BOLD, 20));
		c.setHorizontalAlignment(SwingConstants.CENTER);
		c.setBounds(500, 350, 120, 50);
		add(c);
		c.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
    			BusinessBL business = new BusinessBL(); 
    			String carNumber = ta.getText().trim();
    			if(business.deleteBusinessCarManagement(carNumber)){
    			MainFrame.setContentPanel(new CarNew());}
    	    }
    	});
		
		logoutbt = new JButton("退出");
		logoutbt.setFont(new Font("幼圆", Font.BOLD, 20));
		logoutbt.setHorizontalAlignment(SwingConstants.CENTER);
		logoutbt.setBounds(300, 450, 120, 50);
		add(logoutbt);
		logoutbt.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new alreadyHaveUI());
    		}
    	});
		setVisible(true);
	}

	
}


