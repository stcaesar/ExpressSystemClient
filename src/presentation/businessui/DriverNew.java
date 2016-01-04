package presentation.businessui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import businesslogic.businessbl.BusinessBL;
import presentation.mainframe.MainFrame;




public class DriverNew extends JPanel{
	private JTextField ta;
	private JTextField tc;
	private JTextField td;
	private JTextField te;
	private JTextField tf;
	private JTextField tg;
	private JTextField th;
	private JButton b;
	private JButton c;
	private JLabel a; 
	private JLabel la;
	private JLabel lc;
	private JLabel ld;
	private JLabel le;
	private JLabel lf;
	private JLabel lg;
	private JLabel lh;
	public DriverNew(){
		setBounds(200,0,900,650);
		setLayout(null);
	    ta = new JTextField(40);
		ta.setBounds(500, 50, 200, 30);
		add(ta);
		la = new JLabel("司机编号");
		la.setFont(new Font("幼圆", Font.BOLD, 15));
		la.setHorizontalAlignment(SwingConstants.CENTER);
		la.setBounds(300,50,100,30);
		add(la);
		tc = new JTextField(40);
		tc.setBounds(500, 150, 200, 30);
		add(tc);
		lc = new JLabel("姓名");
		lc.setFont(new Font("幼圆", Font.BOLD, 15));
		lc.setHorizontalAlignment(SwingConstants.CENTER);
		lc.setBounds(300,150,100,30);
		add(lc);
		td = new JTextField(40);
		td.setBounds(500, 200, 200, 30);
		add(td);
		ld = new JLabel("出生日期");
		ld.setFont(new Font("幼圆", Font.BOLD, 15));
		ld.setHorizontalAlignment(SwingConstants.CENTER);
		ld.setBounds(300,200,100,30);
		add(ld);
		te = new JTextField(40);
		te.setBounds(500, 250, 200, 30);
		add(te);
		le = new JLabel("身份证号");
		le.setFont(new Font("幼圆", Font.BOLD, 15));
		le.setHorizontalAlignment(SwingConstants.CENTER);
		le.setBounds(300,250,100,30);
		add(le);
		tf = new JTextField(40);
		tf.setBounds(500, 300, 200, 30);
		add(tf);
		lf = new JLabel("手机");
		lf.setFont(new Font("幼圆", Font.BOLD, 15));
		lf.setHorizontalAlignment(SwingConstants.CENTER);
		lf.setBounds(300,300,100,30);
		add(lf);
		tg = new JTextField(40);
		tg.setBounds(500, 350, 200, 30);
		add(tg);
		lg = new JLabel("性别");
		lg.setFont(new Font("幼圆", Font.BOLD, 15));
		lg.setHorizontalAlignment(SwingConstants.CENTER);
		lg.setBounds(300,350,100,30);
		add(lg);
		th = new JTextField(40);
		th.setBounds(500, 400, 200, 30);
		add(th);
		lh = new JLabel("行驶证期限");
		lh.setFont(new Font("幼圆", Font.BOLD, 15));
		lh.setHorizontalAlignment(SwingConstants.CENTER);
		lh.setBounds(300,400,120,30);
		add(lh);
	    b = new JButton("确定");
		b.setFont(new Font("幼圆", Font.BOLD, 20));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(300, 500, 100, 50);
		add(b);
		b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			
    			BusinessBL in = new BusinessBL ();
    			boolean judge=false;
    			if(ta.getText().trim().equals("")||tc.getText().trim().equals("")||td.getText().trim().equals("")||te.getText().trim().equals("")||tf.getText().trim().equals("")||tg.getText().trim().equals("")||th.getText().trim().equals("")){
    				ErrorUI error = new ErrorUI();					
    		}
    			else {
    				judge=in.inputBusinessDriverManagement(ta.getText().trim(),tc.getText().trim(), td.getText().trim(),te.getText().trim(),tf.getText().trim(), tg.getText().trim(),th.getText().trim());
    			
    			if(judge){
    				SuccessUI success=new SuccessUI();
    				clearTextField();
    			}
    			else
    			{
    				ExistUI exist = new ExistUI(); 
    			}
    		}
    		}
		}
    			
    	);
		
		c = new JButton("取消");
		c.setFont(new Font("幼圆", Font.BOLD, 20));
		c.setHorizontalAlignment(SwingConstants.CENTER);
		c.setBounds(500, 500, 100, 50);
		add(c);
		c.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new CreateUI());
    		}
    	});
		
		
		
	  
		setVisible(true);
	}
	
	private void clearTextField(){
		ta.setText("");
		tc.setText("");
		td.setText("");
		te.setText("");
		tf.setText("");
		tg.setText("");
		th.setText("");
		
	}
}



