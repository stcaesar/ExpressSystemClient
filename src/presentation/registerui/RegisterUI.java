package presentation.registerui;

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

import businesslogic.registerbl.RegisterBL;
import po.MemberPO;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class RegisterUI extends JPanel implements ActionListener{
	private JLabel titlelb;
	private JLabel actlabel;
	private JLabel pwdlabel;
	private JLabel statuslabel;
	private JLabel checklabel;
	private JComboBox roleBox;
	private JTextField actfield;
	private JPasswordField pwdfield1;
	private JPasswordField pwdfield2;
	private JButton regbutton;
	private JButton backbutton;
	
	public RegisterUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		titlelb= new JLabel("欢迎注册");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 10, 450, 160);
		add(titlelb);
		
		statuslabel= new JLabel("身份");
		statuslabel.setFont(new Font("幼圆", Font.BOLD, 40));
		statuslabel.setHorizontalAlignment(SwingConstants.CENTER);
		statuslabel.setBounds(225, 170, 100, 50);
		add(statuslabel);
		
		actlabel= new JLabel("账号");
		actlabel.setFont(new Font("幼圆", Font.BOLD, 40));
		actlabel.setHorizontalAlignment(SwingConstants.CENTER);
		actlabel.setBounds(225, 230, 100, 50);
		add(actlabel);
		
		pwdlabel= new JLabel("密码");
		pwdlabel.setFont(new Font("幼圆", Font.BOLD, 40));
		pwdlabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwdlabel.setBounds(225, 290, 100, 50);
		add(pwdlabel);
		
		checklabel= new JLabel("确认密码");
		checklabel.setFont(new Font("幼圆", Font.BOLD, 40));
		checklabel.setHorizontalAlignment(SwingConstants.CENTER);
		checklabel.setBounds(190, 350, 250, 50);
		add(checklabel);
		
		String[] roleList = new String[]{"寄件人","快递员","营业厅业务员","中转中心业务员","仓库管理员","财务人员","总经理","管理员"};
		roleBox = new JComboBox(roleList);
		roleBox.setFont(new Font("幼圆", Font.BOLD, 40));
		roleBox.setBounds(350, 170, 350, 50);
		add(roleBox);
		
		actfield = new JTextField();
//		actfield.addCaretListener(new CaretListener() {
//
//			@Override
//			public void caretUpdate(CaretEvent e) {
//				// TODO Auto-generated method stub
//				actfield.setText(actfield.getText());
//			}
//		});
		actfield.setBounds(350, 240, 200, 30);
		add(actfield);
		
		pwdfield1 = new JPasswordField();
		pwdfield1.setBounds(350, 300, 200, 30);
		add(pwdfield1);
		
		pwdfield2 = new JPasswordField();
		pwdfield2.setBounds(410, 360, 200, 30);
		add(pwdfield2);
		
		regbutton = new JButton("注册");
		regbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		regbutton.setHorizontalAlignment(SwingConstants.CENTER);
		regbutton.setBounds(280, 450, 100, 50);
		regbutton.setFocusPainted(false);
		add(regbutton);
		regbutton.addActionListener(this);
		
		backbutton = new JButton("返回");
		backbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		backbutton.setHorizontalAlignment(SwingConstants.CENTER);
		backbutton.setBounds(480, 450, 100, 50);
		backbutton.setFocusPainted(false);
		add(backbutton);
		backbutton.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==regbutton){
			register();
		}
		else if(e.getSource()==backbutton){
			MainFrame.setContentPanel(new LoginUI());
		}
	}
	private void register(){
		String userName = actfield.getText().trim();
		if(userName.equals("")){
			MainFrame.showmessage( "用户名不为空！");
			return;
		}
		
		String password1 = String.valueOf(pwdfield1.getPassword()).trim();
		String password2 = String.valueOf(pwdfield2.getPassword()).trim();
		if(!password1.equals(password2)){
			MainFrame.showmessage("您两次输入的密码不一致！");
		}
		else if(password1.length() < 6 || password1.length() > 30){
			MainFrame.showmessage("密码应为6~30位！");
			return;
		}
		else{
			String right1 = (String)roleBox.getSelectedItem();
			String right="";
			switch (right1) {
				case "寄件人":
					right = "sender";
					break;
				case "快递员":
					right = "courier";
					break;
				case "营业厅业务员":
					right = "business";
					break;
				case "中转中心业务员":
					right = "transport";
					break;
				case "仓库管理员":
					right = "storage";
					break;
				case "财务人员":
					right = "financial";
					break;
				case "总经理":
					right = "manager";
					break;
				case "管理员":
					right = "administrator";
					break;
				default:
					break;
			}
			if(RegisterBL.register(userName,password1,right)){
				MainFrame.showmessage("注册成功！");
				clearTextField();
			}
			else{
				MainFrame.showmessage("用户已存在！");
			}
		}
	}
	
	private void clearTextField(){
		actfield.setText("");
		pwdfield1.setText("");
		pwdfield2.setText("");
	}
	
}
