package presentation.mannagerui;

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

public class ManagerUI extends JPanel{

	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;

	RoleLabel roleicon;
	InfoLabel infoicon;
	logoutLabel logouticon;
	
	public ManagerUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		
		

		infoicon = new InfoLabel(50,0,"manager");
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

		
		a = new JButton("人员机构");
		a.setFont(new Font("幼圆", Font.BOLD, 15));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(300, 200, 100, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new MemberUI());
    		}
    	});
		
		b = new JButton("审批单据");
		b.setFont(new Font("幼圆", Font.BOLD, 15));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(500, 200, 100, 50);
		add(b);
		b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new CheckUI());
    	    }
    	});
		
		c = new JButton("查看报表");
		c.setFont(new Font("幼圆", Font.BOLD, 15));
		c.setHorizontalAlignment(SwingConstants.CENTER);
		c.setBounds(300, 300, 100, 50);
		add(c);
		c.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new FindUI());
    		}
    	});
		
		d = new JButton("策略制定");
		d.setFont(new Font("幼圆", Font.BOLD, 15));
		d.setHorizontalAlignment(SwingConstants.CENTER);
		d.setBounds(500, 300, 100, 50);
		add(d);
		d.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new doubleStrategyUI());
    		}
    	});
		
		setVisible(true);
	}
	
}
