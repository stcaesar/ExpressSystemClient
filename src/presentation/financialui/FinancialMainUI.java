package presentation.financialui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.factory.InfoLabel;
import presentation.factory.RoleLabel;
import presentation.factory.logoutLabel;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class FinancialMainUI extends JPanel implements ActionListener{

	private JButton accountarrange;
	private JButton calculate;
	private JButton cost;
	private JButton addreport;
	private JButton diary;
	private JButton newaccount;
	
	RoleLabel roleicon;
	InfoLabel infoicon;
	logoutLabel logouticon;

	public FinancialMainUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		infoicon = new InfoLabel(50,0,"financial");
		infoicon.setVisible(false);
		add(infoicon);
		
		
		roleicon = new RoleLabel(10,10);
		add(roleicon);
		roleicon.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				roleicon.setIcon(new ImageIcon("image\\role2.png"));
				infoicon.setVisible(true);
				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				roleicon.setIcon(new ImageIcon("image\\role1.png"));
				infoicon.setVisible(false);
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
			
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		
		
		logouticon = new logoutLabel();
		add(logouticon);
		
		calculate=new JButton("结算管理");
		calculate.setFont(new Font("幼圆", Font.BOLD, 20));
		calculate.setHorizontalAlignment(SwingConstants.CENTER);
		calculate.setBounds(500,150, 150, 30);
		add(calculate);
		calculate.addActionListener(this);
		
		addreport=new JButton("报表生成");
		addreport.setFont(new Font("幼圆", Font.BOLD, 20));
		addreport.setHorizontalAlignment(SwingConstants.CENTER);
		addreport.setBounds(500,275, 150, 30);
		add(addreport);
		addreport.addActionListener(this);
		
		newaccount=new JButton("期初建账");
		newaccount.setFont(new Font("幼圆", Font.BOLD, 20));
		newaccount.setHorizontalAlignment(SwingConstants.CENTER);
		newaccount.setBounds(500,400, 150, 30);
		add(newaccount);
		newaccount.addActionListener(this);
		
		accountarrange=new JButton("账户管理");
		accountarrange.setFont(new Font("幼圆", Font.BOLD, 20));
		accountarrange.setHorizontalAlignment(SwingConstants.CENTER);
		accountarrange.setBounds(225,150, 150, 30);
		add(accountarrange);
		accountarrange.addActionListener(this);
		
		cost=new JButton("成本管理");
		cost.setFont(new Font("幼圆", Font.BOLD, 20));
		cost.setHorizontalAlignment(SwingConstants.CENTER);
		cost.setBounds(225,275, 150, 30);
		add(cost);
		cost.addActionListener(this);
		
				
		diary=new JButton("日志查询");
		diary.setFont(new Font("幼圆", Font.BOLD, 20));
		diary.setHorizontalAlignment(SwingConstants.CENTER);
		diary.setBounds(225,400, 150, 30);
		add(diary);
		diary.addActionListener(this);
		
	
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == accountarrange){
				MainFrame.setContentPanel(new FinancialAccountArrangeUI());	
		}
		else if(e.getSource()==calculate){
			MainFrame.setContentPanel(new FinancialCalculateUI());
		}
		else if(e.getSource()==cost){
			MainFrame.setContentPanel(new FinancialCostMainUI());
		}
		else if(e.getSource()==addreport){
			MainFrame.setContentPanel(new FinancialAddReportUI());
		}
		else if(e.getSource()==diary){
			MainFrame.setContentPanel(new FinancialFindDiaryUI());
		}
		else if(e.getSource()==newaccount){
			MainFrame.setContentPanel(new FinancialNewAccountUI());
		}
	}

}
