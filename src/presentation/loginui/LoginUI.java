package presentation.loginui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import businesslogic.loginbl.LoginBL;
import presentation.administratorui.AdministratorOptionUI;
import presentation.businessui.BusinessUI;
import presentation.courierui.CourierUI;
import presentation.factory.SetLabel;
import presentation.financialui.FinancialMainUI;
import presentation.mainframe.MainFrame;
import presentation.mannagerui.ManagerUI;
import presentation.registerui.RegisterUI;
import presentation.senderui.SenderUI;
import presentation.storageui.StorageOptionUI;
import presentation.transportui.TransportMainUI;



public class LoginUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel actlabel;
	private JLabel pwdlabel;

	private JTextField actfield;
	private JPasswordField pwdfield;
	private JButton loginbutton;
	private JButton registerbutton;
	
	SetLabel seticon;
	
	public LoginUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		seticon =new SetLabel();
		add(seticon);
		
		titlelabel= new JLabel("快递物流系统");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(245, 40, 450, 160);
		add(titlelabel);
		
		
		
		actlabel= new JLabel("账号");
		actlabel.setFont(new Font("幼圆", Font.BOLD, 40));
		actlabel.setHorizontalAlignment(SwingConstants.CENTER);
		actlabel.setBounds(285, 220, 100, 50);
		add(actlabel);
		
		pwdlabel= new JLabel("密码");
		pwdlabel.setFont(new Font("幼圆", Font.BOLD, 40));
		pwdlabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwdlabel.setBounds(285, 320, 100, 50);
		add(pwdlabel);

		actfield = new JTextField();
//		actfield.addCaretListener(new CaretListener() {
//
//			@Override
//			public void caretUpdate(CaretEvent e) {
//				// TODO Auto-generated method stub
//				actfield.setText(actfield.getText());
//			}
//		});
		actfield.setBounds(410, 235, 200, 30);
		add(actfield);
		
		pwdfield = new JPasswordField();
		pwdfield.setBounds(410, 335, 200, 30);
		add(pwdfield);
		
		registerbutton = new JButton("注册");
		registerbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		registerbutton.setHorizontalAlignment(SwingConstants.CENTER);
		registerbutton.setBounds(320, 450, 100, 50);
		registerbutton.setFocusPainted(false);
		add(registerbutton);
		registerbutton.addActionListener(this);
		
		loginbutton = new JButton("登录");
		loginbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		loginbutton.setHorizontalAlignment(SwingConstants.CENTER);
		loginbutton.setBounds(480, 450, 100, 50);
		loginbutton.setFocusPainted(false);
		add(loginbutton);	
		loginbutton.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == loginbutton){
			login();
			

		}
		else if(e.getSource() == registerbutton){
			MainFrame.setContentPanel(new RegisterUI());
		}
	}
	
	
	private void login(){
		final String userName = actfield.getText().trim();
		final String password = String.valueOf(pwdfield.getPassword()).trim();
		if (userName.length() == 0 || password.length() == 0) {

		}
		new Thread(new Runnable(){
			@Override
			public void run() {
				if (LoginBL.check(userName, password)) {
					if(LoginBL.getright(userName, password).equals("sender")){
						MainFrame.setContentPanel(new SenderUI());
						clearText();
					}
					else if(LoginBL.getright(userName, password).equals("courier")){
						MainFrame.setContentPanel(new CourierUI());
						clearText();
					}
					else if(LoginBL.getright(userName, password).equals("business")){
						MainFrame.setContentPanel(new BusinessUI());
						clearText();
					}
					else if(LoginBL.getright(userName, password).equals("transport")){
						MainFrame.setContentPanel(new TransportMainUI());
						clearText();
					}
					else if(LoginBL.getright(userName, password).equals("storage")){
						MainFrame.setContentPanel(new StorageOptionUI());
						clearText();
					}
					else if(LoginBL.getright(userName, password).equals("financial")){
						MainFrame.setContentPanel(new FinancialMainUI());
						clearText();
					}
					else if(LoginBL.getright(userName, password).equals("manager")){
						MainFrame.setContentPanel(new ManagerUI());
						clearText();
					}
					else if(LoginBL.getright(userName, password).equals("administrator")){
						MainFrame.setContentPanel(new AdministratorOptionUI());
						clearText();
					}
				}
				else{
					MainFrame.showmessage("密码有误！");
				}
			}
				

			
		}).start();
	
	
	}

	private void clearText() {
		// TODO Auto-generated method stub
		actfield.setText("");
		pwdfield.setText("");
	}


}
