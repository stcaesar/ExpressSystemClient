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
import businesslogic.courierbl.CourierBL;
import po.OrderListPO;
import presentation.mainframe.MainFrame;




public class LoadNew extends JPanel{
	private JTextField ta;
	private JTextField tb;
	private JTextField tc;
	private JTextField td;
	private JTextField te;
	private JTextField tf;
	private JTextField tg;
	private JTextField th;
	private JTextField txt;
	private JButton b;
	private JButton c;
	private JButton d;
	private JLabel a; 
	private JLabel la;
	private JLabel lb;
	private JLabel lc;
	private JLabel ld;
	private JLabel le;
	private JLabel lf;
	private JLabel lg;
	private JLabel lh;
	public LoadNew(){
		setBounds(200,0,900,650);
		setLayout(null);
	ta = new JTextField(40);
	ta.setBounds(500, 50, 200, 30);
	add(ta);
	la = new JLabel("装车日期");
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
	lc = new JLabel("汽运编号");
	lc.setFont(new Font("幼圆", Font.BOLD, 15));
	lc.setHorizontalAlignment(SwingConstants.CENTER);
	lc.setBounds(300,150,100,30);
	add(lc);
	td = new JTextField(40);
	td.setBounds(500, 200, 200, 30);
	add(td);
	ld = new JLabel("到达地");
	ld.setFont(new Font("幼圆", Font.BOLD, 15));
	ld.setHorizontalAlignment(SwingConstants.CENTER);
	ld.setBounds(300,200,100,30);
	add(ld);
	te = new JTextField(40);
	te.setBounds(500, 250, 200, 30);
	add(te);
	le = new JLabel("车辆代号");
	le.setFont(new Font("幼圆", Font.BOLD, 15));
	le.setHorizontalAlignment(SwingConstants.CENTER);
	le.setBounds(300,250,100,30);
	add(le);
	tf = new JTextField(40);
	tf.setBounds(500, 300, 200, 30);
	add(tf);
	lf = new JLabel("监装员");
	lf.setFont(new Font("幼圆", Font.BOLD, 15));
	lf.setHorizontalAlignment(SwingConstants.CENTER);
	lf.setBounds(300,300,100,30);
	add(lf);
	tg = new JTextField(40);
	tg.setBounds(500, 350, 200, 30);
	add(tg);
	lg = new JLabel("押运员");
	lg.setFont(new Font("幼圆", Font.BOLD, 15));
	lg.setHorizontalAlignment(SwingConstants.CENTER);
	lg.setBounds(300,350,100,30);
	add(lg);
	th = new JTextField(40);
	th.setBounds(500, 400, 200, 30);
	add(th);
	lh = new JLabel("条形码号");
	lh.setFont(new Font("幼圆", Font.BOLD, 15));
	lh.setHorizontalAlignment(SwingConstants.CENTER);
	lh.setBounds(300,400,120,30);
	add(lh);
    b = new JButton("确认");
	b.setFont(new Font("幼圆", Font.BOLD, 20));
	b.setHorizontalAlignment(SwingConstants.CENTER);
	b.setBounds(300, 530, 100, 50);
	add(b);
	b.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			BusinessBL in = new BusinessBL ();
			boolean judge=false;
			
			if(ta.getText().trim().equals("")||tb.getText().trim().equals("")||tc.getText().trim().equals("")||td.getText().trim().equals("")||te.getText().trim().equals("")||tf.getText().trim().equals("")||tg.getText().trim().equals("")||th.getText().trim().equals("")||txt.getText().trim().equals("")){
								
			ErrorUI error = new ErrorUI();	
			}
			else{
			judge=in.inputBusinessLoad(ta.getText().trim(), tb.getText().trim(),tc.getText().trim(), td.getText().trim(),te.getText().trim(), tf.getText().trim(),tg.getText().trim(), th.getText().trim(),txt.getText().trim());
		
			if(judge){
				SuccessUI success = new SuccessUI();
			}
			else{
				ExistUI exist = new ExistUI();
			}
		}
		}
	}
			
	);
			
		
	c = new JButton("取消");
	c.setFont(new Font("幼圆", Font.BOLD, 20));
	c.setHorizontalAlignment(SwingConstants.CENTER);
	c.setBounds(500,530, 100, 50);
	add(c);
	c.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			MainFrame.setContentPanel(new CreateUI());
		}
	});
	d = new JButton("生成运费");
	d.setFont(new Font("幼圆", Font.BOLD, 15));
	d.setHorizontalAlignment(SwingConstants.CENTER);
	d.setBounds(300, 450, 100, 50);
	add(d);
	d.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String barCode = th.getText().trim();
			OrderListPO orderlist = new OrderListPO();
			orderlist.setlistid(barCode);
			OrderListPO order=CourierBL.getorderlist(orderlist);

			String packagetype = "";

	    	switch (order.getpackagetype()) {
				case "zhixiang":
					packagetype = "纸箱";
					break;
				case "muxiang":
					packagetype = "木箱";		
					break;
				case "kuaididai":
					packagetype = "快递袋";
					break;
				case "other":
					packagetype	="其他";			
					break;
				default:
					break;
			}
			String money = String.valueOf(order.getallcost()-CourierBL.getpcost(packagetype));
			txt.setText(money);
		}
	});
	txt = new JTextField(40);
	txt.setBounds(500, 450 ,100, 30);
	add(txt);
	setVisible(true);
}
	
}

