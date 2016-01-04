package presentation.storageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StorageLookUI extends JFrame implements ActionListener{
	private JLabel relabel;
	private JButton rebutton;
	private JLabel inlabel;
	private JLabel infield;
	private JLabel outlabel;
	private JLabel outfield;
//	private String inpo;
//	private String outpo;
	
	public StorageLookUI(int in,int out){
		setBounds(500,300,400,200);
		setLayout(null);
//		inpo=""+in;
//		outpo=""+out;
		setTitle("checkResult");
		
		relabel = new JLabel("查询此段时间结果为");
		relabel.setFont(new Font("幼圆",Font.BOLD,20));
	    relabel.setHorizontalAlignment(SwingConstants.CENTER);
	    relabel.setBounds(-100, -50, 600, 160);
	    add(relabel);
	    
	    inlabel = new JLabel("入库数量");
		inlabel.setFont(new Font("幼圆",Font.BOLD,15));
	    inlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    inlabel.setBounds(-200, -20, 600, 160);
	    add(inlabel);
	    
	    infield = new JLabel(""+in);
		infield.setFont(new Font("幼圆",Font.BOLD,15));
	    infield.setHorizontalAlignment(SwingConstants.CENTER);
	    infield.setBounds(-100, -20, 600, 160);
	    add(infield);
	    
	    outfield = new JLabel(""+out);
	    outfield.setFont(new Font("幼圆",Font.BOLD,15));
	    outfield.setHorizontalAlignment(SwingConstants.CENTER);
	    outfield.setBounds(-100, 10, 600, 160);
	    add(outfield);
	    
	   
	    
	    outlabel = new JLabel("出库数量");
		outlabel.setFont(new Font("幼圆",Font.BOLD,15));
	    outlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    outlabel.setBounds(-200, 10, 600, 160);
	    add(outlabel);
	    
	    
	    
	    rebutton = new JButton("确认");
	    rebutton.setFont(new Font("幼圆", Font.BOLD, 10));
	    rebutton.setBounds(160, 110, 60, 30);
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
	
//	public static void main(String[] args){
//		StorageLookUI test=new StorageLookUI(3,6);
//	}

}
