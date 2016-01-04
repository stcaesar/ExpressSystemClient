package presentation.factory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import po.OrderListPO;
import presentation.courierui.ChangeOrderUI;
import presentation.courierui.CourierUI;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
import IPadress.IP;
import businesslogic.courierbl.CourierBL;

public class SetUI extends JPanel implements ActionListener{
	private JLabel titlelb;
	private JLabel ordlistlb;
	private JTextField iptext;
	private JButton checkbt;

	private JButton backbt;
	
	public SetUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		titlelb= new JLabel("IP");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		
		iptext = new JTextField(IP.ip);
		iptext.setBounds(350, 300, 200, 30);
		add(iptext);
		
		checkbt = new JButton("连接");
		checkbt.setFont(new Font("幼圆", Font.BOLD, 20));
		checkbt.setHorizontalAlignment(SwingConstants.CENTER);
		checkbt.setBounds(375, 350, 150, 50);
		checkbt.setFocusPainted(false);
		add(checkbt);
		checkbt.addActionListener(this);
		
	
	
		backbt = new JButton("返回");
		backbt.setFont(new Font("幼圆", Font.BOLD, 20));
		backbt.setHorizontalAlignment(SwingConstants.CENTER);
		backbt.setBounds(375, 430, 150, 50);
		backbt.setFocusPainted(false);
		add(backbt);
		backbt.addActionListener(this);
		
		setVisible(true);
	} 
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==checkbt){
			IP.ip = iptext.getText().trim();
		}

		else if(e.getSource()==backbt){
			MainFrame.setContentPanel(new LoginUI());
		}
	}
}
