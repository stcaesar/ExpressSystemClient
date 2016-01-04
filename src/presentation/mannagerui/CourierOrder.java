package presentation.mannagerui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;







import businesslogic.businessbl.BusinessBL;
import businesslogic.courierbl.CourierBL;
import businesslogic.transportbl.TransportRecvBL;
import po.BusinessReceive;
import po.OrderListPO;
import po.TransportRecvPO;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class CourierOrder extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel serviselabel;
	private JButton allbutton;
	private JButton partbutton;
	private JButton savebutton;
	private JButton quitbutton;
	private JTable table = null;
	public JScrollPane scrollPane = new JScrollPane(); 
	public CourierOrder(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("寄件单查询");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(320, 40, 300, 80);
		add(titlelabel);
		
		savebutton=new JButton("确定审批");
		savebutton.setFont(new Font("幼圆", Font.BOLD, 20));
		savebutton.setHorizontalAlignment(SwingConstants.CENTER);
		savebutton.setBounds(390, 5000, 150, 30);
		add(savebutton);
		savebutton.addActionListener(this);
		
		
		allbutton=new JButton("显示所有");
		allbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		allbutton.setHorizontalAlignment(SwingConstants.CENTER);
		allbutton.setBounds(150, 500, 150, 30);
		add(allbutton);
		allbutton.addActionListener(this);
		
		partbutton=new JButton("显示未审批");
		partbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		partbutton.setHorizontalAlignment(SwingConstants.CENTER);
		partbutton.setBounds(390, 500, 150, 30);
		add(partbutton);
		partbutton.addActionListener(this);
		
		quitbutton=new JButton("退出");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(630, 500, 150, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		
		setVisible(true);
	}
	private void init(ArrayList<OrderListPO> orderlist) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTable(orderlist)); 
		scrollPane.setBounds(50,150,750,350);
		add(scrollPane);
	}
	
	private JTable createTable(ArrayList<OrderListPO> orderlist) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"订单号","寄件人姓名","收件人姓名","寄件人地址","收件人地址","寄件人单位","收件人单位","寄件人电话","收件人电话","寄件人手机","收件人手机","数量","质量","体积","种类","尺寸","包装","快递","合计费用","状态"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);

		/******转化成Vector***********/
		for(int i = 0;i<orderlist.size();i++){
			Vector v = new Vector();

			v.add(orderlist.get(i).getlistid());
			v.add(orderlist.get(i).getSname());
			v.add(orderlist.get(i).getRname());
			v.add(orderlist.get(i).getSaddress());
			v.add(orderlist.get(i).getRaddress());
			v.add(orderlist.get(i).getSworkp());
			v.add(orderlist.get(i).getRworkp());
			v.add(orderlist.get(i).getSphone());
			v.add(orderlist.get(i).getRphone());
			v.add(orderlist.get(i).getSmoblie());
			v.add(orderlist.get(i).getRmoblie());
			v.add(orderlist.get(i).getgoodnum());
			v.add(orderlist.get(i).getgoodM());
			v.add(orderlist.get(i).getgoodV());
			v.add(orderlist.get(i).getgoodsytle());
			v.add(orderlist.get(i).getgoodsize());
			v.add(orderlist.get(i).getpackagetype());
			v.add(orderlist.get(i).getexpresstype());
			v.add(orderlist.get(i).getallcost());

			v.add(orderlist.get(i).getstate());
			dtm.addRow(v);
		}
		return table;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new CheckUI());
		}
		else if(e.getSource() == allbutton){

			ArrayList<OrderListPO> orderlist=CourierBL.getall();
			init(orderlist);
			savebutton.setBounds(390, 5000, 150, 30);
		}
		else if(e.getSource() == partbutton){
			ArrayList<OrderListPO> orderlist=CourierBL.getallunchecked();
			init(orderlist);
			savebutton.setBounds(390, 550, 150, 30);
		}
		else if(e.getSource() == savebutton){
			
			ArrayList<OrderListPO> orderlist=CourierBL.getallunchecked();
			if(orderlist.size()!=0){
			for(int i=0;i<orderlist.size();i++){
				orderlist.get(i).setstate("checked");
				if(CourierBL.delorderlist(orderlist.get(i))){
	        		if(CourierBL.saveorderlist(orderlist.get(i))){
	        			
	        		}
	        	}
			}
			MainFrame.showmessage("保存成功");
			}
			else{
				MainFrame.showmessage("无未审批单据");
			}
			
		}
	}
}

