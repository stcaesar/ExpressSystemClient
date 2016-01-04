package presentation.businessui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import presentation.factory.InfoLabel;
import presentation.factory.RoleLabel;
import presentation.factory.logoutLabel;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class BusinessUI extends JPanel{


	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;
	private JButton e;
	private JButton f;

	
	RoleLabel roleicon;
	InfoLabel infoicon;

	public BusinessUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		infoicon = new InfoLabel(50,0,"business");
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
		
		a = new JButton("新建表单");
		a.setFont(new Font("幼圆", Font.BOLD, 20));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(400, 200, 120, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new CreateUI());
    		}
    	});
		
		b = new JButton("已有表单");
		b.setFont(new Font("幼圆", Font.BOLD, 20));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(400, 300, 120, 50);
		add(b);
		b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new alreadyHaveUI());
    	    }
    	});
		
		logoutLabel logouticon = new logoutLabel();
		add(logouticon);
		
		setVisible(true);
	}

	
}
