package presentation.administratorui;

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

import businesslogic.administratorbl.AdministratorBL;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
import presentation.registerui.RegisterUI;
import presentation.storageui.StorageAdjustUI;
import presentation.storageui.StorageCheckUI;
import presentation.storageui.StorageErrorUI;
import presentation.storageui.StorageInUI;
import presentation.storageui.StorageOptionUI;
import presentation.storageui.StorageOutUI;

public class AdministratorKeyUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel idlabel;
	private JLabel oldlabel;
	private JLabel newlabel;
	private JLabel conflabel;
	private JButton okbutton;
	private JButton returnbutton;
	private JTextField idfield;
	private JPasswordField oldfield;
	private JPasswordField newfield;
	private JPasswordField conffield;
	
	public AdministratorKeyUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		//����
	    titlelabel = new JLabel("修改用户密码");
	    titlelabel.setFont(new Font("幼圆",Font.BOLD,70));
	    titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
	    titlelabel.setBounds(135, 10, 600, 160);
	    add(titlelabel);
	    
	    //�޸���
	    idlabel= new JLabel("用户账号");
		idlabel.setFont(new Font("幼圆", Font.BOLD, 30));
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setBounds(15, 125, 600, 160);
		add(idlabel);
		
		idfield = new JTextField();
		idfield.setBounds(410,190,200,35);
		add(idfield);
		
		oldlabel= new JLabel("旧的密码");
		oldlabel.setFont(new Font("幼圆", Font.BOLD, 30));
		oldlabel.setHorizontalAlignment(SwingConstants.CENTER);
		oldlabel.setBounds(15, 200, 600, 160);
		add(oldlabel);
		
		oldfield = new JPasswordField();
		oldfield.setBounds(410,265,200,35);
		add(oldfield);
		
		newlabel= new JLabel("新的密码");
		newlabel.setFont(new Font("幼圆", Font.BOLD, 30));
		newlabel.setHorizontalAlignment(SwingConstants.CENTER);
		newlabel.setBounds(15, 275, 600, 160);
		add(newlabel);
		
		newfield = new JPasswordField();
		newfield.setBounds(410,340,200,35);
		add(newfield);
		
		conflabel= new JLabel("确认密码");
		conflabel.setFont(new Font("幼圆", Font.BOLD, 30));
		conflabel.setHorizontalAlignment(SwingConstants.CENTER);
		conflabel.setBounds(15, 350, 600, 160);
		add(conflabel);
		
		conffield = new JPasswordField();
		conffield.setBounds(410,415,200,35);
		add(conffield);
		
		//ȷ�ϰ�ť
		okbutton = new JButton("确认");
	    okbutton.setFont(new Font("幼圆",Font.BOLD,25));
	    okbutton.setBounds(390,525, 100, 50);
	    add(okbutton);
	    okbutton.addActionListener(this);
	    
	    //���ذ�ť
	    returnbutton = new JButton("返回");
	    returnbutton.setFont(new Font("幼圆", Font.BOLD, 15));
	    returnbutton.setBounds(5, 5, 80, 40);
	    add(returnbutton);
	    returnbutton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==returnbutton){
			MainFrame.setContentPanel(new AdministratorOptionUI());
		}
		else if(e.getSource()==okbutton){

				AdministratorBL admin = new AdministratorBL();
				
				
				if(String.valueOf(newfield.getPassword()).equals("")||String.valueOf(oldfield.getPassword()).equals("")||String.valueOf(conffield.getPassword()).equals("")||idfield.getText().equals("")){
					AdministratorErrorUI errorframe = new AdministratorErrorUI();
				}
				else if(!(String.valueOf(newfield.getPassword()).trim().equals(String.valueOf(conffield.getPassword()).trim()))){

					AdministratorCorrectUI errorframe = new AdministratorCorrectUI();
			}
				else if(!admin.checkid(idfield.getText().trim(),String.valueOf(oldfield.getPassword()).trim())){
					AdministratorCheckUI checkframe = new AdministratorCheckUI();
				}
				else{
					admin.change(idfield.getText().trim(),String.valueOf(newfield.getPassword()));
					AdministratorSuccessUI successframe = new AdministratorSuccessUI();
				}
				
		}
		
	}

}
