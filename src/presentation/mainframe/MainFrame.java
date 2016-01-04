package presentation.mainframe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import presentation.loginui.LoginUI;

public class MainFrame{
	private static JFrame mainframe;
	private static JPanel contentpanel;
	private static JFrame memberframe;
	private static JPanel imagePanel;  
	private static ImageIcon background; 
	private LoginUI loginui;
	public MainFrame(){
		loginui = new LoginUI();
		contentpanel = loginui;
		mainframe = new JFrame();
		mainframe.setTitle("Express System");
		mainframe.setBounds(200,0,900,650);
		mainframe.setContentPane(loginui);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		background = new ImageIcon("image/mainframe.jpg"); 
		JLabel label = new JLabel(background); 
 
		label.setBounds(0, 0, background.getIconWidth(),  
		background.getIconHeight());   
		imagePanel = (JPanel) mainframe.getContentPane();  
		imagePanel.setOpaque(false);  
		  
		mainframe.getLayeredPane().setLayout(null);    
		mainframe.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		mainframe.setSize(background.getIconWidth(), background.getIconHeight());  
		mainframe.setResizable(false);  
		
		mainframe.setVisible(true);
		
		
	}
	
	public static void setContentPanel(JPanel panel){
		mainframe.dispose();
		mainframe = new JFrame();
		contentpanel = panel;
		mainframe.setTitle("Express System");
		mainframe.setBounds(200,0,900,650);
		mainframe.setContentPane(contentpanel);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		background = new ImageIcon("image/mainframe.jpg"); 
		JLabel label = new JLabel(background); 
 
		label.setBounds(0, 0, background.getIconWidth(),  
		background.getIconHeight());   
		imagePanel = (JPanel) mainframe.getContentPane();  
		imagePanel.setOpaque(false);  
		  
		mainframe.getLayeredPane().setLayout(null);    
		mainframe.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		mainframe.setSize(background.getIconWidth(), background.getIconHeight());  
		mainframe.setResizable(false);  
		mainframe.setVisible(true);
	}
	public static void showmessage(String str){
		JFrame mesframe = new JFrame("注意");
		JLabel meslb = new JLabel(str);
		meslb.setFont(new Font("幼圆", Font.BOLD, 40));
		meslb.setHorizontalAlignment(SwingConstants.CENTER);
		mesframe.setLayout(null);
		mesframe.setBounds(350,200,600,300);
		meslb.setBounds(0,0,600,250);
		mesframe.add(meslb);
		mesframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mesframe.setVisible(true);
		
	}
public static void setMemberPanel(JPanel panel){
		memberframe = new JFrame();
		memberframe.setTitle("账户信息查看");
		memberframe.setBounds(425,275,450,300);
		memberframe.setContentPane(panel);
		memberframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		memberframe.setVisible(true);
	}
	

	
}
