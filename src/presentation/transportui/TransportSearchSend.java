package presentation.transportui;

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


import businesslogic.transportbl.TransportSendBL;
import po.TransportSendPO;
import presentation.mainframe.MainFrame;

public class TransportSearchSend extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel serviselabel;
	private JButton allbutton;
	private JButton partbutton;
	private JButton savebutton;
	private JButton quitbutton;
	private JTable table = null;
	public JScrollPane scrollPane = new JScrollPane(); 
	public TransportSearchSend(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("装运单查询");
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
	private void init(ArrayList<TransportSendPO> transportsend) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTable(transportsend)); 
		scrollPane.setBounds(50,150,750,350);
		add(scrollPane);
	}
	private JTable createTable(ArrayList<TransportSendPO> transportsend) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"装运单号","装运方式","航班号","装运日期","出发地","目的地","监装员","运费","审批状态"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);

		/******转化成Vector***********/
		for(int i = 0;i<transportsend.size();i++){
			Vector v = new Vector();
			v.add(transportsend.get(i).getSendtranscodeid());
			v.add(transportsend.get(i).getWay());
			v.add(transportsend.get(i).getFlightcode());
			v.add(transportsend.get(i).getSenddate());
			v.add(transportsend.get(i).getStartaddress());
			v.add(transportsend.get(i).getEndaddress());
			v.add(transportsend.get(i).getWatcherid());
			v.add(transportsend.get(i).getFare());
			v.add(transportsend.get(i).getRead());
		
			/********添加进JTable中********/
			dtm.addRow(v);
		}
	
		return table;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new TransportMainUI());
		}
		else if(e.getSource() == allbutton){
			TransportSendBL transportsendbl=new TransportSendBL();
			ArrayList<TransportSendPO> transportsendall=transportsendbl.getAll();
			init(transportsendall);
			savebutton.setBounds(390, 5000, 150, 30);
		}
		else if(e.getSource() == partbutton){
			TransportSendBL transportsendbl=new TransportSendBL();
			ArrayList<TransportSendPO> transportsendpart=transportsendbl.getPart("unchecked");		
			init(transportsendpart);
			savebutton.setBounds(390, 550, 150, 30);
		}
		else if(e.getSource() == savebutton){
			TransportSendBL transportsendbl=new TransportSendBL();
			ArrayList<TransportSendPO> transportsend=transportsendbl.getPart("unchecked");
			if(transportsend.size()!=0){
			for(int i=0;i<transportsend.size();i++){
				transportsend.get(i).setRead("checked");
				transportsendbl.update(transportsend.get(i));
			}
			MainFrame.showmessage("保存成功");
			}
			else{
				MainFrame.showmessage("无未审批单据");
			}
			
		}
	}
}
