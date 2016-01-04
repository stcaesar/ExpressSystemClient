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
public class CheckUI extends JPanel{
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

	public CheckUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelb= new JLabel("审批单据");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(225, 40, 450, 160);
		add(titlelb);
		
		a = new JButton("查看");
		a.setFont(new Font("幼圆", Font.BOLD, 15));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setBounds(320, 400, 100, 50);
		add(a);
		a.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			String rank = (String)pName.getSelectedItem(); 
    			String paper = (String)pName.getSelectedItem();
    			if(paper.equals("寄件单")){
    				MainFrame.setContentPanel(new CourierOrder());
    			}
    			if(paper.equals("装车单")){
    				MainFrame.setContentPanel(new BusinessLd());
    			}
    			if(paper.equals("营业厅到达单")){
    				MainFrame.setContentPanel(new BusinessRecv());
    			}
    			if(paper.equals("收款单")){
    				MainFrame.setContentPanel(new BusinessVouch());
    			}
    			if(paper.equals("派件单")){
    				MainFrame.setContentPanel(new BusinessDis());
    			}
    			if(paper.equals("中转中心到达单")){
    				MainFrame.setContentPanel(new TransportSearchRecv());
    			}
    			if(paper.equals("入库单")){
    				MainFrame.setContentPanel(new StorageInUI());
    			}
    			
    			if(paper.equals("出库单")){
    				MainFrame.setContentPanel(new StorageOutUI());
    			}
    			
    		}
    	});
		
		String[] rolelist = new String[]{"寄件单","装车单", "营业厅到达单","收款单","派件单","中转中心到达单","入库单","出库单"};
	    pName = new JComboBox(rolelist);
	    pName.setFont(new Font("幼圆", Font.BOLD, 30));
	    pName.setBounds(300,240,350,50);
	    add(pName);
	    
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

