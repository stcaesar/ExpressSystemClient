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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import businesslogic.mannagerbl.ManagerBL;
import presentation.businessui.ErrorUI;
import presentation.businessui.Table5UI;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
public class MemberUI extends JPanel{
	private JLabel titlelb;
	private JLabel aa;
	private JTextField ta;
	private JTextField tb;
	private JComboBox pName;
	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;
	
	private JButton logoutbt;

	public MemberUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelb= new JLabel("人员机构");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		
		a = new JButton("查看员工");
		a.setFont(new Font("幼圆", Font.BOLD, 15));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(320, 400, 100, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			String rank = (String)pName.getSelectedItem(); 
			    MainFrame.setContentPanel(new TableUI(rank));
    		}
    	});
		
		String[] rolelist = new String[]{"快递员","营业厅业务员", "中转中心业务员","中转中心仓库管理人员","财务人员","总经理","管理员"};
	    pName = new JComboBox(rolelist);
	    pName.setFont(new Font("幼圆", Font.BOLD, 30));
	    pName.setBounds(200,240,200,50);
	    add(pName);
		ta = new JTextField("工作单位");
		ta.setBounds(430, 250, 100, 30);
		add(ta);
		tb = new JTextField("员工姓名");
		tb.setBounds(560, 250, 100, 30);
		add(tb);
		b = new JButton("添加员工");
		b.setFont(new Font("幼圆", Font.BOLD, 15));
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setBounds(320,320, 100, 50);
		add(b);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ta.getText().trim().equals("")||tb.getText().trim().equals("")){
					MainFrame.showmessage("请填写完整");			
    		}
				else{
					String rank = (String)pName.getSelectedItem();
    		        String unit = ta.getText().trim();
    		        String name = tb.getText().trim();
    		        ManagerBL manager = new ManagerBL();
    		        if(manager.inputManagerMember(rank,unit,name)){
    		    	    MainFrame.showmessage("success");
    		    }
    		        else{
    		    	    MainFrame.showmessage("已存在");
    		    }
				}
    	    }
    	});
		
		c = new JButton("删除员工");
		c.setFont(new Font("幼圆", Font.BOLD, 15));
		c.setHorizontalAlignment(SwingConstants.CENTER);
		c.setBounds(480, 320, 100, 50);
		add(c);
		c.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					String rank = (String)pName.getSelectedItem();
    		    String unit = ta.getText().trim();
    		    String name = tb.getText().trim();
    		    ManagerBL manager = new ManagerBL();
    		    if(manager.deleteManagerMember(unit,name)){
    		    	MainFrame.showmessage("success");
    		    }
    		    else{
    		    	MainFrame.showmessage("failed");
    		    }
				}
    	    
    	});
		logoutbt = new JButton("退出");
		logoutbt.setFont(new Font("幼圆", Font.BOLD, 15));
		logoutbt.setHorizontalAlignment(SwingConstants.CENTER);
		logoutbt.setBounds(480, 400, 100, 50);
		add(logoutbt);
		logoutbt.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new ManagerUI());
    		}
    	});
		setVisible(true);
	}

	
}

