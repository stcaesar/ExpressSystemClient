package presentation.transportui;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;





import presentation.factory.InfoLabel;
import presentation.factory.RoleLabel;
import presentation.factory.logoutLabel;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
public class TransportMainUI extends JPanel implements ActionListener{

	private JLabel serviselabel;
	private JComboBox servisebox;
	private JButton savebutton;

	
	RoleLabel roleicon;
	InfoLabel infoicon;
	
	public TransportMainUI(){
		setBounds(200,0,900,650);
		setLayout(null);



		infoicon = new InfoLabel(50,0,"transport");
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
		
		serviselabel= new JLabel("选择业务:");
		serviselabel.setFont(new Font("幼圆", Font.BOLD, 40));
		serviselabel.setHorizontalAlignment(SwingConstants.CENTER);
		serviselabel.setBounds(200, 180, 200, 60);
		add(serviselabel);
		
		String[] serviselist = new String[]{"接收货物","装运货物","接收单查询","装运单查询"};
		servisebox = new JComboBox(serviselist);
		servisebox.setFont(new Font("幼圆", Font.BOLD, 40));
		servisebox.setBounds(425, 180, 250, 60);
		add(servisebox);
		
		savebutton=new JButton("确定");
		savebutton.setFont(new Font("幼圆", Font.BOLD, 30));
		savebutton.setHorizontalAlignment(SwingConstants.CENTER);
		savebutton.setBounds(420, 430, 100, 60);
		add(savebutton);
		savebutton.addActionListener(this);
		
		logoutLabel logouticon = new logoutLabel();
		add(logouticon);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==savebutton&&servisebox.getSelectedItem().equals("接收货物")){
			MainFrame.setContentPanel(new TransportRecvUI());
		}
		else if(e.getSource()==savebutton&&servisebox.getSelectedItem().equals("装运货物")){
			MainFrame.setContentPanel(new TransportSendUI());
		}
		else if(e.getSource()==savebutton&&servisebox.getSelectedItem().equals("接收单查询")){
			MainFrame.setContentPanel(new TransportSearchRecv());
		}
		else if(e.getSource()==savebutton&&servisebox.getSelectedItem().equals("装运单查询")){
			MainFrame.setContentPanel(new TransportSearchSend());
		}
	}
}
