package presentation.financialui;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import businesslogic.transportbl.TransportSendBL;
import po.TransportSendPO;
import presentation.mainframe.MainFrame;

public class FinancialCostFareUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel idlabel;
	private JTextField idfield;
	
	private JButton savebutton;
	private JButton quitbutton;
	public JScrollPane scrollPane = new JScrollPane(); 
	public FinancialCostFareUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("运费查询");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(320, 40, 250, 80);
		add(titlelabel);
		
		idlabel= new JLabel("包裹编号:");
		idlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setBounds(225, 130, 100, 30);
		add(idlabel);
		
		idfield=new JTextField();
		idfield.setBounds(400,130,300,30);
		idfield.setText("七位数字");
		add(idfield);
	
		savebutton=new JButton("确定");
		savebutton.setFont(new Font("幼圆", Font.BOLD, 20));
		savebutton.setHorizontalAlignment(SwingConstants.CENTER);
		savebutton.setBounds(250, 550, 100, 30);
		add(savebutton);
		savebutton.addActionListener(this);
		
		quitbutton=new JButton("取消");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(500, 550, 100, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		
		setVisible(true);
	}
	private void init(ArrayList<TransportSendPO> transportsend) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTable(transportsend)); 
		scrollPane.setBounds(50,170,750,350);
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
			MainFrame.setContentPanel(new FinancialCostMainUI());
		}
		else if(e.getSource() == savebutton){
			TransportSendBL transportsendbl=new TransportSendBL();
			ArrayList<TransportSendPO> transportsendpart=transportsendbl.searchSend(idfield.getText().trim());		
			init(transportsendpart);
		}
	}
}
