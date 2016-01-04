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

public class RecInputUI extends JPanel  implements ActionListener{
	private JLabel titlelb;
	
	private JLabel ordlistlb;
	private JTextField ordlisttext;
	private JLabel Recidlb;
	private JTextField Recidtf;
	private JLabel Recnamelb;
	private JTextField Recnametf;
	private JLabel Rectimelb;
	private JTextField Rectimetf;

	private JButton checkbt;
	private JButton backbt;
	
	public RecInputUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		titlelb= new JLabel("收件信息输入");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 100);
		add(titlelb);
		
		ordlistlb= new JLabel("收件订单号");
		ordlistlb.setFont(new Font("幼圆", Font.BOLD, 30));
		ordlistlb.setHorizontalAlignment(SwingConstants.CENTER);
		ordlistlb.setBounds(220, 160, 200, 50);
		add(ordlistlb);
		
		ordlisttext = new JTextField();
		ordlisttext.setBounds(420, 170, 200, 30);
		add(ordlisttext);
		
		Recidlb= new JLabel("收件编号");
		Recidlb.setFont(new Font("幼圆", Font.BOLD, 30));
		Recidlb.setHorizontalAlignment(SwingConstants.CENTER);
		Recidlb.setBounds(220, 240, 200, 50);
		add(Recidlb);
		
		Recidtf = new JTextField();
		Recidtf.setBounds(420, 250, 200, 30);
		add(Recidtf);
		
		Recnamelb= new JLabel("收件人");
		Recnamelb.setFont(new Font("幼圆", Font.BOLD, 30));
		Recnamelb.setHorizontalAlignment(SwingConstants.CENTER);
		Recnamelb.setBounds(220, 320, 200, 50);
		add(Recnamelb);
		
		Recnametf = new JTextField();
		Recnametf.setBounds(420, 330, 200, 30);
		add(Recnametf);
		
		Rectimelb= new JLabel("收件日期");
		Rectimelb.setFont(new Font("幼圆", Font.BOLD, 30));
		Rectimelb.setHorizontalAlignment(SwingConstants.CENTER);
		Rectimelb.setBounds(220, 400, 200, 50);
		add(Rectimelb);
		
		Rectimetf = new JTextField();
		Rectimetf.setBounds(420, 410, 200, 30);
		add(Rectimetf);
		
		checkbt = new JButton("确认输入");
		checkbt.setFont(new Font("幼圆", Font.BOLD, 20));
		checkbt.setHorizontalAlignment(SwingConstants.CENTER);
		checkbt.setBounds(300, 490, 120, 50);
		checkbt.setFocusPainted(false);
		add(checkbt);
		checkbt.addActionListener(this);
		
	
		backbt = new JButton("返回");
		backbt.setFont(new Font("幼圆", Font.BOLD, 20));
		backbt.setHorizontalAlignment(SwingConstants.CENTER);
		backbt.setBounds(480, 490, 120, 50);
		backbt.setFocusPainted(false);
		add(backbt);
		backbt.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==checkbt){
			saveRec();
		}
		else if(e.getSource()==backbt){
			MainFrame.setContentPanel(new CourierUI());
		}
	}
	
	public void saveRec(){
		String listid = ordlisttext.getText().trim();
		String Recid = Recidtf.getText().trim();
		String Recname = Recnametf.getText().trim();
		String Rectime = Rectimetf.getText().trim();
		
		OrderListPO orderlist = new OrderListPO();
		orderlist.setlistid(listid);
		orderlist = CourierBL.getorderlist(orderlist);
		orderlist.setreceiveid(Recid);
		orderlist.setreceivername(Recname);
		orderlist.setreceivertime(Rectime);
		if(!CourierBL.checkRec(orderlist)){
			if(CourierBL.delorderlist(orderlist)){
				if(CourierBL.saveorderlist(orderlist)){
					MainFrame.showmessage("收件成功");
				}	
			}
		}
		else{
			MainFrame.showmessage("收件编号重复");
		}
	}
}
