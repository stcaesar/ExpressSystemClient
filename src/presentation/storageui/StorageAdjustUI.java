package presentation.storageui;

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

import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class StorageAdjustUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel adjustedlabel;
	private JTextField adjustedfield;
	private JLabel adjustinglabel;
	private JTextField adjustingfield;
	private JLabel percentlabel;
	private JTextField percentfield;
	private JButton adjustbutton;
	private JButton returnbutton;
	
	public StorageAdjustUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		//库存调整标题
		titlelabel = new JLabel("库存调整");
	    titlelabel.setFont(new Font("幼圆",Font.BOLD,70));
	    titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
	    titlelabel.setBounds(135, 10, 600, 160);
	    add(titlelabel);
	    
	    //返回按钮
	    returnbutton = new JButton("返回");
	    returnbutton.setFont(new Font("幼圆", Font.BOLD, 15));
	    returnbutton.setBounds(5, 5, 80, 40);
	    add(returnbutton);
	    returnbutton.addActionListener(this);
	    
	    //需转区
	    adjustedlabel = new JLabel("待转区号");
	    adjustedlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    adjustedlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    adjustedlabel.setBounds(15, 150, 600, 160);
	    add(adjustedlabel);
	    
	    adjustedfield = new JTextField();
	    adjustedfield.setBounds(410,215, 200, 35);
	    add(adjustedfield);
	    
	    //待转区
	    adjustinglabel = new JLabel("需转区号");
	    adjustinglabel.setFont(new Font("幼圆",Font.BOLD,30));
	    adjustinglabel.setHorizontalAlignment(SwingConstants.CENTER);
	    adjustinglabel.setBounds(15, 250, 600, 160);
	    add(adjustinglabel);
	    
	    adjustingfield = new JTextField();
	    adjustingfield.setBounds(410, 315, 200, 35);
	    add(adjustingfield);
	    
	    //转入比例
	    percentlabel = new JLabel("转入比例");
	    percentlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    percentlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    percentlabel.setBounds(15, 350, 600, 160);
	    add(percentlabel);
	    
	    percentfield = new JTextField();
	    percentfield.setBounds(410, 415,200,35);
	    add(percentfield);
	    
	    //转入按钮
	    adjustbutton = new JButton("转入");
	    adjustbutton.setFont(new Font("幼圆",Font.BOLD,25));
	    adjustbutton.setBounds(390,525, 100, 50);
	    add(adjustbutton);
	    adjustbutton.addActionListener(this);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==returnbutton){
			MainFrame.setContentPanel(new StorageOptionUI());
		}
	}
	

}
