package presentation.courierui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import presentation.factory.InfoLabel;
import presentation.factory.RoleLabel;
import presentation.factory.logoutLabel;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
import presentation.registerui.RegisterUI;

public class CourierUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JButton createOrderbt;
	private JButton changeOrderbt;
	private JButton recInputbt;

	RoleLabel roleicon;
	InfoLabel infoicon;
	logoutLabel logouticon;
	public CourierUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		infoicon = new InfoLabel(50,0,"courier");
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

		createOrderbt = new JButton("创建订单");
		createOrderbt.setFont(new Font("幼圆", Font.BOLD, 20));
		createOrderbt.setHorizontalAlignment(SwingConstants.CENTER);
		createOrderbt.setBounds(350, 180, 200, 50);
		createOrderbt.setFocusPainted(false);
		add(createOrderbt);
		createOrderbt.addActionListener(this);
		
		changeOrderbt = new JButton("订单管理");
		changeOrderbt.setFont(new Font("幼圆", Font.BOLD, 20));
		changeOrderbt.setHorizontalAlignment(SwingConstants.CENTER);
		changeOrderbt.setBounds(350, 280, 200, 50);
		changeOrderbt.setFocusPainted(false);
		add(changeOrderbt);
		changeOrderbt.addActionListener(this);
		
		
		
		recInputbt = new JButton("收件信息输入");
		recInputbt.setFont(new Font("幼圆", Font.BOLD, 20));
		recInputbt.setHorizontalAlignment(SwingConstants.CENTER);
		recInputbt.setBounds(350, 380, 200, 50);
		recInputbt.setFocusPainted(false);
		add(recInputbt);
		recInputbt.addActionListener(this);
		
		
		setVisible(true);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createOrderbt){
			MainFrame.setContentPanel(new CreateOrderUI());
		}
		else if(e.getSource() == changeOrderbt){
			MainFrame.setContentPanel(new ManageOrderUI());
		}
		else if(e.getSource() == recInputbt){
			MainFrame.setContentPanel(new RecInputUI());
		}

	}
	
}
