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
public class ConstantUI extends JPanel{
	private JComboBox rank;
	private JComboBox job;
	private JLabel titlelb;
	private JTextField aa;
	private JTextField bb;
	private JTextField cc;
	private JTextField dd;
	private JLabel ta;
	private JButton a;
	private JButton b;
	
	private JButton logoutbt;

	public ConstantUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		
		
		titlelb= new JLabel("常量制定");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		aa = new JTextField("距离");
		aa.setBounds(610, 250, 100, 30);
		add(aa);
		bb = new JTextField("经济快递");
		bb.setBounds(250, 320, 100, 30);
		add(bb);
		cc = new JTextField("标准快递");
		cc.setBounds(400, 320, 100, 30);
		add(cc);
		dd = new JTextField("特快");
		dd.setBounds(550, 320, 100, 30);
		add(dd);
		String[] ranklist = new String[]{"北京","上海","福建", "广州","郑州","驻马店","洛阳","开封"};
	    rank = new JComboBox(ranklist);
	    rank.setFont(new Font("幼圆", Font.BOLD, 30));
	    rank.setBounds(150,240,200,50);
	    add(rank);
	    
	    String[] joblist = new String[]{"北京","上海","福建", "广州","郑州","驻马店","洛阳","开封"};
	    job = new JComboBox(joblist);
	    job.setFont(new Font("幼圆", Font.BOLD, 30));
	    job.setBounds(380,240,200,50);
	    add(job);
	    
	    
		
		a = new JButton("添加/修改常量");
		a.setFont(new Font("幼圆", Font.BOLD, 15));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(375, 400, 150, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			String ranklist = (String)rank.getSelectedItem();
    			String joblist = (String)job.getSelectedItem();
    			String distance = aa.getText().trim();
    			String save = bb.getText().trim();
    			String standard = cc.getText().trim();
    			String fast = dd.getText().trim();
    			
    			ManagerBL manager = new ManagerBL();
    			
    			if(distance.equals("")||distance.equals("距离")||save.equals("")||save.equals("经济快递")||standard.equals("")||standard.equals("标准快递")||fast.equals("")||fast.equals("特快")){
    				MainFrame.showmessage("请填写完整");
    			}
    			else{
    				manager.deleteManagerConstant(ranklist,joblist);
    				manager.inputManagerConstant(ranklist,joblist,distance,save,standard,fast);
    				MainFrame.showmessage("Success");
    			}
    		}
    	});
		
		b = new JButton("查看常量表");
		b.setFont(new Font("幼圆", Font.BOLD, 15));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(375, 500, 150, 50);
		add(b);
		b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new TableConstantUI());
    	    }
    	});
		
		
	
		logoutbt = new JButton("退出");
		logoutbt.setFont(new Font("幼圆", Font.BOLD, 15));
		logoutbt.setHorizontalAlignment(SwingConstants.CENTER);
		logoutbt.setBounds(375, 600, 150, 50);
		add(logoutbt);
		logoutbt.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new ManagerUI());
    		}
    	});
		setVisible(true);
	}

	
}

