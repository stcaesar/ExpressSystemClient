package presentation.administratorui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
import businesslogic.storagebl.StorageBL;

public class AdministratorCheckUI extends JFrame implements ActionListener{
	private JLabel relabel;
	private JButton rebutton;
	
	public AdministratorCheckUI(){
		setBounds(500,300,300,150);
		setLayout(null);
		
		relabel = new JLabel("旧密码错误");
		relabel.setFont(new Font("幼圆",Font.BOLD,20));
	    relabel.setHorizontalAlignment(SwingConstants.CENTER);
	    relabel.setBounds(-150, -50, 600, 160);
	    add(relabel);
	    
	    rebutton = new JButton("确认");
	    rebutton.setFont(new Font("幼圆", Font.BOLD, 10));
	    rebutton.setBounds(110, 60, 60, 30);
	    add(rebutton);
	    rebutton.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==rebutton){
			dispose();
		}
	}

}