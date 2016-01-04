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
import presentation.storageui.StorageInUI;
import presentation.storageui.StorageOptionUI;
import presentation.storageui.StorageOutUI;

public class AdministratorRightUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel idlabel;
	private JLabel keylabel;
	private JLabel rightlabel;
	private JTextField idfield;
	private JPasswordField keyfield;
	private JComboBox rightbox;
	private JButton returnbutton;
	private JButton okbutton;
	
	public AdministratorRightUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		//����
	    titlelabel = new JLabel("修改账户权限");
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
		
		keylabel= new JLabel("输入密码");
		keylabel.setFont(new Font("幼圆", Font.BOLD, 30));
		keylabel.setHorizontalAlignment(SwingConstants.CENTER);
		keylabel.setBounds(15, 200, 600, 160);
		add(keylabel);
		
		keyfield = new JPasswordField();
		keyfield.setBounds(410,265,200,35);
		add(keyfield);
		
		rightlabel= new JLabel("新的权限");
		rightlabel.setFont(new Font("幼圆", Font.BOLD, 30));
		rightlabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightlabel.setBounds(15, 275, 600, 160);
		add(rightlabel);
		
		String[] rolelist = new String[]{"寄件人","快递员","营业厅业务员","中转中心业务员","仓库管理员","财务人员","总经理","管理员"};
		rightbox = new JComboBox(rolelist);
		rightbox.setFont(new Font("幼圆", Font.BOLD, 30));
		rightbox.setBounds(410,340,255,35);
		add(rightbox);
		
		//���ذ�ť
		returnbutton = new JButton("返回");
	    returnbutton.setFont(new Font("幼圆", Font.BOLD, 15));
	    returnbutton.setBounds(5, 5, 80, 40);
	    add(returnbutton);
	    returnbutton.addActionListener(this);
	    
	    //ȷ���޸İ�ť
	    okbutton = new JButton("确认");
	    okbutton.setFont(new Font("幼圆",Font.BOLD,25));
	    okbutton.setBounds(390,450, 100, 50);
	    add(okbutton);
	    okbutton.addActionListener(this);
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==returnbutton){
			MainFrame.setContentPanel(new AdministratorOptionUI());
		}
		else if(e.getSource()==okbutton){
			AdministratorBL admin = new AdministratorBL();
			if(idfield.getText().equals("")||String.valueOf(keyfield.getPassword()).trim().equals("")){
				AdministratorErrorUI errorframe = new AdministratorErrorUI();
			}
			else if(!admin.checkid(idfield.getText().trim(),String.valueOf(keyfield.getPassword()).trim())){
				AdministratorCheckUI checkframe = new AdministratorCheckUI();
			}
			else{
				if(rightbox.getSelectedItem().toString().trim()=="�ļ���")admin.changeright(idfield.getText().trim(), "sender");
				if(rightbox.getSelectedItem().toString().trim()=="���Ա")admin.changeright(idfield.getText().trim(), "courier");
				if(rightbox.getSelectedItem().toString().trim()=="��ת����ҵ��Ա")admin.changeright(idfield.getText().trim(), "transport");
				if(rightbox.getSelectedItem().toString().trim()=="�ֿ����Ա")admin.changeright(idfield.getText().trim(), "storage");
				if(rightbox.getSelectedItem().toString().trim()=="������Ա")admin.changeright(idfield.getText().trim(), "financial");
				if(rightbox.getSelectedItem().toString().trim()=="�ܾ���")admin.changeright(idfield.getText().trim(), "manager");
				if(rightbox.getSelectedItem().toString().trim()=="����Ա")admin.changeright(idfield.getText().trim(), "administrator");
				AdministratorSuccessUI successframe = new AdministratorSuccessUI();
			}
		}
	}

}
