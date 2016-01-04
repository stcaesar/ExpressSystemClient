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
import businesslogic.transportbl.TransportRecvBL;
import po.BusinessReceive;
import po.TransportRecvPO;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class BusinessRecv extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel serviselabel;
	private JButton allbutton;
	private JButton partbutton;
	private JButton savebutton;
	private JButton quitbutton;
	private JTable table = null;
	public JScrollPane scrollPane = new JScrollPane(); 
	public BusinessRecv(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("接收单查询");
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
	private void init(ArrayList<BusinessReceive> businessreceive) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTable(businessreceive)); 
		scrollPane.setBounds(50,150,750,350);
		add(scrollPane);
	}
	
	private JTable createTable(ArrayList<BusinessReceive> businessreceive) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"到达日期","中转单编号","出发地","货物到达状态","单据状态"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);

		/******转化成Vector***********/
		for(int i = 0;i<businessreceive.size();i++){
			Vector v = new Vector();
			v.add(businessreceive.get(i).getDate());
			v.add(businessreceive.get(i).getIdentifier());
			v.add(businessreceive.get(i).getOrigin());
			v.add(businessreceive.get(i).getState());
			v.add(businessreceive.get(i).getReadState());
			dtm.addRow(v);
		}
		return table;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new CheckUI());
		}
		else if(e.getSource() == allbutton){
			BusinessBL businessreceive=new BusinessBL();
			ArrayList<BusinessReceive> BusinessBL=businessreceive.checkReceive();
			init(BusinessBL);
			savebutton.setBounds(390, 5000, 150, 30);
		}
		else if(e.getSource() == partbutton){
			BusinessBL businessreceive=new BusinessBL();
			ArrayList<BusinessReceive> businessbl=businessreceive.checkReceive("unchecked");		
			init(businessbl);
			savebutton.setBounds(390, 550, 150, 30);
		}
		else if(e.getSource() == savebutton){
			BusinessBL businessreceive=new BusinessBL();
			ArrayList<BusinessReceive> businessbl=businessreceive.checkReceive("unchecked");
			if(businessbl.size()!=0){
			for(int i=0;i<businessbl.size();i++){
				businessreceive.update(businessbl.get(i));
			}
			MainFrame.showmessage("保存成功");
			}
			else{
				MainFrame.showmessage("无未审批单据");
			}
			
		}
	}
}

