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

import businesslogic.storagebl.StorageBL;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class StorageCheckUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JTextField timefield;
	private JLabel timelabel;
	private JButton returnbutton;
	private JButton checkbutton;
	private JTextField endfield;
	private JLabel endlabel;
	
	public StorageCheckUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		//标题
		titlelabel = new JLabel("库存查看");
	    titlelabel.setFont(new Font("幼圆",Font.BOLD,70));
	    titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
	    titlelabel.setBounds(135, 10, 600, 160);
	    add(titlelabel);
	    
	    //库存查看返回按钮
	    returnbutton = new JButton("返回");
	    returnbutton.setFont(new Font("幼圆", Font.BOLD, 15));
	    returnbutton.setBounds(5, 5, 80, 40);
	    add(returnbutton);
	    returnbutton.addActionListener(this);
	    
	    timelabel = new JLabel("请输入查询日期");
	    timelabel.setFont(new Font("幼圆",Font.BOLD,30));
	    timelabel.setHorizontalAlignment(SwingConstants.CENTER);
	    timelabel.setBounds(125,150,600,160);
	    add(timelabel);
	    
	    timefield = new JTextField("输入日期格式为XXXXXXXX");
	    timefield.setBounds(300,300,200,30);
	    add(timefield);
	    
	    endlabel = new JLabel("至");
	    endlabel.setFont(new Font("幼圆",Font.BOLD,20));
	    endlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    endlabel.setBounds(-20,310,600,160);
	    add(endlabel);
	    
	    endfield = new JTextField("输入日期格式为XXXXXXXX");
	    endfield.setBounds(300,375,200,30);
	    add(endfield);
	    
	    
	    checkbutton = new JButton("查询");
	    checkbutton.setFont(new Font("幼圆",Font.BOLD,25));
	    checkbutton.setBounds(510,370,100,35);
	    add(checkbutton);
	    checkbutton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==returnbutton){
			MainFrame.setContentPanel(new StorageOptionUI());
		}
		else if(e.getSource()==checkbutton){
			StorageBL sto = new StorageBL();
			int in=sto.getIn(Long.parseLong(timefield.getText().trim()),Long.parseLong(endfield.getText().trim()));
			int out=sto.getOut(Long.parseLong(timefield.getText().trim()),Long.parseLong(endfield.getText().trim()));
			
			
			StorageLookUI look = new StorageLookUI(in,out);
			
		}
	}

}