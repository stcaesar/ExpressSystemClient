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
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class ExistDistributionUI extends JPanel{
	private JLabel titlelb;
	private JTextField ta;
	private JButton a;
	private JButton b;
	private JButton c;
	private JButton logoutbt;

	public ExistDistributionUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelb= new JLabel("派件单查询");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		
		 ta = new JTextField("请输入条形码号");
			ta.setBounds(250, 250, 200, 30);
			add(ta);
		a = new JButton("查询");
		a.setFont(new Font("幼圆", Font.BOLD, 15));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(500, 250, 120, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			String barCode = ta.getText().trim();
    			String readState = "unchecked";
			     MainFrame.setContentPanel(new Table2UI(barCode,readState));
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
    			String barCode = ta.getText().trim();
    			if(business.deleteBusinessDistribution(barCode)){
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
    			String barCode = ta.getText().trim();
    			if(business.deleteBusinessDistribution(barCode)){
    			MainFrame.setContentPanel(new DistributionNew());}
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


