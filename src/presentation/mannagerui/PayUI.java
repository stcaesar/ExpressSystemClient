package presentation.mannagerui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businesslogic.mannagerbl.ManagerBL;
import presentation.mainframe.MainFrame;
public class PayUI extends JPanel{
	private JComboBox rank;
	private JComboBox job;
	private JLabel titlelb;
	private JTextField aa;
	private JLabel ta;
	private JButton a;
	private JButton b;
	
	private JButton logoutbt;

	public PayUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		titlelb= new JLabel("薪金策略");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		aa = new JTextField("薪水金额");
		aa.setBounds(610, 250, 100, 30);
		add(aa);
		String[] ranklist = new String[]{"寄件人","快递员","营业厅业务员", "中转中心业务员","中转中心仓库管理人员","财务人员","总经理","管理员"};
	    rank = new JComboBox(ranklist);
	    rank.setFont(new Font("幼圆", Font.BOLD, 30));
	    rank.setBounds(150,240,200,50);
	    add(rank);
	    
	    String[] joblist = new String[]{"普通员工","资深员工","管理人员", "经理","总经理","管理员"};
	    job = new JComboBox(joblist);
	    job.setFont(new Font("幼圆", Font.BOLD, 30));
	    job.setBounds(380,240,200,50);
	    add(job);
	    
	    ta= new JLabel("薪金策略");
		ta.setFont(new Font("幼圆", Font.BOLD, 70));
		ta.setHorizontalAlignment(SwingConstants.CENTER);
		ta.setBounds(560, 250, 100,30 );
		add(ta);
		
		a = new JButton("添加/修改薪金");
		a.setFont(new Font("幼圆", Font.BOLD, 15));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(375, 320, 150, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){

    			System.out.println("fuck");
    			boolean isDelete = false ;
    			String ranklist = (String)rank.getSelectedItem();
    			String joblist = (String)job.getSelectedItem();
    			String money = aa.getText().trim();
    			ManagerBL manager = new ManagerBL();
    			
    			if(money.equals("")||money.equals("薪水金额")){
    				MainFrame.showmessage("请填写完整");
    			}
    			else{
    				manager.deleteManagerPay(ranklist,joblist);
    				manager.inputManagerPay(ranklist,joblist,money);
    				MainFrame.showmessage("Success");
    			}
    		}
    	});
		
		b = new JButton("查看薪金表");
		b.setFont(new Font("幼圆", Font.BOLD, 15));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(375, 420, 150, 50);
		add(b);
		b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new TablePayUI());
    	    }
    	});
		
		
	
		logoutbt = new JButton("退出");
		logoutbt.setFont(new Font("幼圆", Font.BOLD, 15));
		logoutbt.setHorizontalAlignment(SwingConstants.CENTER);
		logoutbt.setBounds(375, 520, 150, 50);
		add(logoutbt);
		logoutbt.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new ManagerUI());
    		}
    	});
		setVisible(true);
	}

	
}

