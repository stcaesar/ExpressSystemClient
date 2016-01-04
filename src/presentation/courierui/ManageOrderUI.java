package presentation.courierui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businesslogic.courierbl.CourierBL;
import po.OrderListPO;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class ManageOrderUI extends JPanel implements ActionListener{
	private JLabel titlelb;
	private JLabel ordlistlb;
	private JTextField ordlisttext;
	private JButton checkbt;
	private JButton delbt;
	private JButton backbt;
	
	public ManageOrderUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		titlelb= new JLabel("订单管理");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		
		ordlistlb= new JLabel("请输入订单号");
		ordlistlb.setFont(new Font("幼圆", Font.BOLD, 30));
		ordlistlb.setHorizontalAlignment(SwingConstants.CENTER);
		ordlistlb.setBounds(220, 150, 450, 160);
		add(ordlistlb);
		
		ordlisttext = new JTextField();
		ordlisttext.setBounds(350, 300, 200, 30);
		add(ordlisttext);
		
		checkbt = new JButton("查询/修改");
		checkbt.setFont(new Font("幼圆", Font.BOLD, 20));
		checkbt.setHorizontalAlignment(SwingConstants.CENTER);
		checkbt.setBounds(375, 350, 150, 50);
		checkbt.setFocusPainted(false);
		add(checkbt);
		checkbt.addActionListener(this);
		
		delbt = new JButton("删除");
		delbt.setFont(new Font("幼圆", Font.BOLD, 20));
		delbt.setHorizontalAlignment(SwingConstants.CENTER);
		delbt.setBounds(375, 410, 150, 50);
		delbt.setFocusPainted(false);
		add(delbt);
		delbt.addActionListener(this);
	
		backbt = new JButton("返回");
		backbt.setFont(new Font("幼圆", Font.BOLD, 20));
		backbt.setHorizontalAlignment(SwingConstants.CENTER);
		backbt.setBounds(375, 470, 150, 50);
		backbt.setFocusPainted(false);
		add(backbt);
		backbt.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==checkbt){
			String orderlistid = ordlisttext.getText().trim();
			OrderListPO orderlist = new OrderListPO();
			orderlist.setlistid(orderlistid);
			if(CourierBL.checkorderlist(orderlist)){
			MainFrame.setContentPanel(new ChangeOrderUI(orderlist));
			}
			else{
				MainFrame.showmessage("订单不存在");
			}
		}
		else if(e.getSource()==delbt){
			String orderlistid = ordlisttext.getText().trim();
			OrderListPO orderlist = new OrderListPO();
			orderlist.setlistid(orderlistid);
			if(CourierBL.delorderlist(orderlist)){
				MainFrame.showmessage("删除成功");
			}
			else{
				MainFrame.showmessage("无此订单");
			}
		}
		else if(e.getSource()==backbt){
			MainFrame.setContentPanel(new CourierUI());
		}
	}
}
