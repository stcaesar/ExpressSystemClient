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




public class CarNew extends JPanel{
	private JTextField ta;
	private JTextField tb;
	private JTextField tc;
	private JTextField td;
	private JButton b;
	private JButton c;
	private JLabel a; 
	private JLabel la;
	private JLabel lb;
	private JLabel lc;
	private JLabel ld;
	
	public CarNew(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		ta = new JTextField(40);
		ta.setBounds(500, 50, 200, 30);
		add(ta);
		la = new JLabel("车辆代号");
		la.setFont(new Font("幼圆", Font.BOLD, 15));
		la.setHorizontalAlignment(SwingConstants.CENTER);
		la.setBounds(300,50,100,30);
		add(la);
		tb = new JTextField(40);
		tb.setBounds(500, 100, 200, 30);
		add(tb);
		lb = new JLabel("营业厅编号");
		lb.setFont(new Font("幼圆", Font.BOLD, 15));
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setBounds(300,100,120,30);
		add(lb);
		tc = new JTextField(40);
		tc.setBounds(500, 150, 200, 30);
		add(tc);
		lc = new JLabel("车牌号");
		lc.setFont(new Font("幼圆", Font.BOLD, 15));
		lc.setHorizontalAlignment(SwingConstants.CENTER);
		lc.setBounds(300,150,100,30);
		add(lc);
		td = new JTextField(40);
		td.setBounds(500, 200, 200, 30);
		add(td);
		ld = new JLabel("服役时间");
		ld.setFont(new Font("幼圆", Font.BOLD, 15));
		ld.setHorizontalAlignment(SwingConstants.CENTER);
		ld.setBounds(300,200,100,30);
		add(ld);
	    b = new JButton("确定");
		b.setFont(new Font("幼圆", Font.BOLD, 20));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(300, 300, 100, 50);
		add(b);
		b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			BusinessBL in = new BusinessBL ();
    			boolean judge=false;
    			if(ta.getText().trim().equals("")||tb.getText().trim().equals("")||tc.getText().trim().equals("")||td.getText().trim().equals("")){
    				ErrorUI error = new ErrorUI();					
    		}
    			else {
    				judge=in.inputBusinessCarManagement(ta.getText().trim(), tb.getText().trim(),tc.getText().trim(), td.getText().trim());
    			
    			if(judge){
    				SuccessUI success=new SuccessUI();}
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
		c.setBounds(500, 300, 100, 50);
		add(c);
		c.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new CreateUI());
    		}
    	});
		setVisible(true);
	}
}


