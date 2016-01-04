package presentation.administratorui;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import presentation.factory.InfoLabel;
import presentation.factory.RoleLabel;
import presentation.factory.logoutLabel;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
import presentation.registerui.RegisterUI;
import presentation.storageui.StorageAdjustUI;
import presentation.storageui.StorageCheckUI;
import presentation.storageui.StorageInUI;
import presentation.storageui.StorageOutUI;

public class AdministratorOptionUI extends JPanel implements ActionListener{

	private JButton checkbutton;
	private JButton keybutton;
	private JButton rightbutton;

	RoleLabel roleicon;
	InfoLabel infoicon;
	public AdministratorOptionUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		//����Աѡ�����

		infoicon = new InfoLabel(50,0,"admin");
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
	    
		logoutLabel logouticon = new logoutLabel();
		add(logouticon);
		
	    checkbutton = new JButton("查看账户信息");
	    checkbutton.setFont(new Font("幼圆",Font.BOLD,30));
	    checkbutton.setBounds(310,200,250,50);
	    add(checkbutton);
	    checkbutton.addActionListener(this);
	    
	    //�޸��ʻ�����
	    keybutton = new JButton("修改账号密码");
	    keybutton.setFont(new Font("幼圆",Font.BOLD,30));
	    keybutton.setBounds(310,300,250,50);
	    add(keybutton);
	    keybutton.addActionListener(this);
	    
	    //�޸��ʺ�Ȩ��
	    rightbutton = new JButton("修改账号权限");
	    rightbutton.setFont(new Font("幼圆",Font.BOLD,30));
	    rightbutton.setBounds(310,400,250,50);
	    add(rightbutton);
	    rightbutton.addActionListener(this);
	    
	    //���ذ�ť

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==checkbutton){
			MainFrame.setMemberPanel(new AdministratorTableUI());
		}
		else if(e.getSource()==keybutton){
			MainFrame.setContentPanel(new AdministratorKeyUI());
		}
		else if(e.getSource()==rightbutton){
			MainFrame.setContentPanel(new AdministratorRightUI());
		}

	}

}
