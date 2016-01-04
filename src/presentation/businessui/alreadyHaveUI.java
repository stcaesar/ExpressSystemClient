package presentation.businessui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class alreadyHaveUI extends JPanel{
	private JLabel titlelb;
    private JComboBox pName;
	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;
	private JButton logoutbt;

	public alreadyHaveUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		titlelb= new JLabel("已有表单");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		
		String[] rolelist = new String[]{"接收单","派件单","装车单", "司机信息","车辆信息","收款单"};
	    pName = new JComboBox(rolelist);
	    pName.setFont(new Font("幼圆", Font.BOLD, 30));
	    pName.setBounds(250,250,200,50);
	    add(pName);
	    
		
		a = new JButton("查询");
		a.setFont(new Font("幼圆", Font.BOLD, 20));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(500, 250, 120, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(pName.getSelectedItem().toString().trim()=="接收单"){
    				MainFrame.setContentPanel(new ExistReceiveUI());
    				
    			}
    			else if(pName.getSelectedItem().toString().trim()=="派件单"){
    				MainFrame.setContentPanel(new ExistDistributionUI());
    			}
    			else if(pName.getSelectedItem().toString().trim()=="装车单"){
    				MainFrame.setContentPanel(new ExistLoadUI());
    				}
    			else if(pName.getSelectedItem().toString().trim()=="司机信息"){
    				MainFrame.setContentPanel(new ExistDriverUI());
    			}
    			else if(pName.getSelectedItem().toString().trim()=="车辆信息"){
    				MainFrame.setContentPanel(new ExistCarUI());
    			}
    			else if(pName.getSelectedItem().toString().trim()=="收款单"){
    				MainFrame.setContentPanel(new ExistMoneyUI());
    				}
    	    }
    	});
		
		
		
		
		
		logoutbt = new JButton("退出");
		logoutbt.setFont(new Font("幼圆", Font.BOLD, 20));
		logoutbt.setHorizontalAlignment(SwingConstants.CENTER);
		logoutbt.setBounds(300, 350, 120, 50);
		add(logoutbt);
		logoutbt.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new BusinessUI());
    		}
    	});
		setVisible(true);
	}

	
}
