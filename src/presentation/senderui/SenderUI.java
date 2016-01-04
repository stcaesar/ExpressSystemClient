package presentation.senderui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businesslogic.courierbl.CourierBL;
import businesslogic.senderbl.SenderBL;
import po.OrderListPO;
import po.StorageInPO;
import presentation.courierui.ChangeOrderUI;
import presentation.factory.CheckLabel;
import presentation.factory.InfoLabel;
import presentation.factory.RoleLabel;
import presentation.factory.logoutLabel;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class SenderUI extends JPanel{
	private JLabel titlelb;
	private JLabel ordlistlb;
	private JLabel timelb1;
	private JLabel timelb2;
	private JLabel timelb3;
	private JTextField ordlisttext;


	JScrollPane scrollPane;
	RoleLabel roleicon;
	InfoLabel infoicon;
	logoutLabel logouticon;
	CheckLabel checkicon;
	public SenderUI (){
		setBounds(200,0,900,650);
		setLayout(null);
		
		checkicon= new CheckLabel(570, 50);
		add(checkicon);
		checkicon.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				checkicon.setIcon(new ImageIcon("image\\check2.png"));
				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				checkicon.setIcon(new ImageIcon("image\\check1.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
			String orderid = ordlisttext.getText().trim();
				OrderListPO orderlist = new OrderListPO();
				orderlist.setlistid(orderid);
				orderlist = CourierBL.getorderlist(orderlist);
				System.out.println(orderlist.getexcepttime());
				String[] sadd = orderlist.getSaddress().split("/");
				String[] radd = orderlist.getRaddress().split("/");
				timelb2.setText(CourierBL.getexpecttime(sadd[0], radd[0], orderlist.getexcepttime()));
				
				if(CourierBL.checkorderlist(orderlist)){
					ArrayList<String> message = SenderBL.check(orderid);
						init(message);
					}
					else{
						MainFrame.showmessage("订单不存在");
					}
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });

		infoicon = new InfoLabel(50,0,"sender");
		infoicon.setVisible(false);
		add(infoicon);
		
		
		roleicon = new RoleLabel(10,10);
		
		roleicon.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				roleicon.setIcon(new ImageIcon("image\\role2.png"));
				infoicon.setVisible(true);
				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				roleicon.setIcon(new ImageIcon("image\\role1.png"));
				infoicon.setVisible(false);
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(roleicon);
		
		logouticon = new logoutLabel();
		add(logouticon);
		
		
		timelb1= new JLabel("预计");
		timelb1.setFont(new Font("幼圆", Font.BOLD, 40));
		timelb1.setHorizontalAlignment(SwingConstants.CENTER);
		timelb1.setBounds(0, 230, 450, 60);
		add(timelb1);
		
		timelb2= new JLabel("");
		timelb2.setFont(new Font("幼圆", Font.BOLD, 50));
		timelb2.setHorizontalAlignment(SwingConstants.CENTER);
		timelb2.setBounds(0, 320, 450, 60);
		add(timelb2);
		
		timelb3= new JLabel("到达");
		timelb3.setFont(new Font("幼圆", Font.BOLD, 40));
		timelb3.setHorizontalAlignment(SwingConstants.CENTER);
		timelb3.setBounds(0, 410, 450, 60);
		add(timelb3);
		
		ordlistlb= new JLabel("订单号");
		ordlistlb.setFont(new Font("幼圆", Font.BOLD, 30));
		ordlistlb.setHorizontalAlignment(SwingConstants.CENTER);
		ordlistlb.setBounds(230, 60, 100, 30);
		add(ordlistlb);
		
		ordlisttext = new JTextField();
		ordlisttext.setBounds(340, 60, 200, 30);
		add(ordlisttext);
		
		
	
		
		ArrayList<String> temp = new ArrayList();
		scrollPane = new JScrollPane(createTable(temp)); 
		scrollPane.setBounds(450,150,400,400);
		add(scrollPane);
		
		setVisible(true);
	}

	private void init(ArrayList<String> message) {
		JScrollPane scrollPane = new JScrollPane(createTable(message)); 
		scrollPane.setBounds(450,150,400,400);
		add(scrollPane);
	}

	private JTable createTable(ArrayList<String> message) {
		JTable table = new JTable();
	
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class,r);
		String[] tableHeads = new String[]{"物流信息"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setFont(new Font("幼圆", Font.BOLD, 20));
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("幼圆", Font.BOLD, 30));
		/******转化成Vector***********/
		for(int i = 0;i<message.size();i++){
			Vector v = new Vector();
			v.add(message.get(i));
			dtm.addRow(v);
		}
		

		
		



		return table;
	}
}
