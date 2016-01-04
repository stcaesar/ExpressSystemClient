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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import businesslogic.businessbl.BusinessBL;
import businesslogic.financialbl.SalaryHistoryBL;
import businesslogic.transportbl.TransportSendBL;
import po.BusinessVoucher;
import po.SalaryHistoryPO;
import po.TransportSendPO;
import presentation.mainframe.MainFrame;

public class FinancialFindDiaryUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel datelabel;
	private JTextField datefield;
	private JButton savebutton;
	private JButton quitbutton;
	public JScrollPane scrollPane = new JScrollPane(); 
	public FinancialFindDiaryUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		titlelabel= new JLabel("日志查询");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(320, 40, 250, 80);
		add(titlelabel);
		
		datelabel= new JLabel("查询日期:");
		datelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		datelabel.setHorizontalAlignment(SwingConstants.CENTER);
		datelabel.setBounds(225,130, 100, 30);
		add(datelabel);
		
		datefield=new JTextField();
		datefield.setBounds(400,130,300,30);
		datefield.setText("日期格式：XXXX/XX/XX");
		add(datefield);
		
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
	private void initCost(ArrayList<BusinessVoucher> voucher,ArrayList<TransportSendPO> sendpo,ArrayList<SalaryHistoryPO> salary) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTableCost(voucher,sendpo,salary)); 
		scrollPane.setBounds(50,240,750,250);
		add(scrollPane);
	}
	private JTable createTableCost(ArrayList<BusinessVoucher> voucher,ArrayList<TransportSendPO> sendpo,ArrayList<SalaryHistoryPO> salary) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"收支","项目","日期","金额","人员"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);

		/******转化成Vector***********/
		for(int i = 0;i<voucher.size();i++){
			Vector v = new Vector();
			v.add("收款");
			v.add("营业厅收款");
			v.add(voucher.get(i).getReceiptDate());
			v.add(voucher.get(i).getMoney());
			v.add(voucher.get(i).getCourier());

			/********添加进JTable中********/
			dtm.addRow(v);
		}
	for(int j=0;j<sendpo.size();j++){
		Vector v = new Vector();
		v.add("付款");
		v.add("运费");
		v.add(sendpo.get(j).getSenddate());
		v.add(sendpo.get(j).getFare());
		v.add(sendpo.get(j).getWatcherid());
		dtm.addRow(v);
	}
	for(int j=0;j<salary.size();j++){
		Vector v = new Vector();
		v.add("付款");
		v.add("工资");
		v.add(salary.get(j).getDate());
		v.add(salary.get(j).getMoney());
		v.add(salary.get(j).getName());

		dtm.addRow(v);
	}
		return table;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new FinancialMainUI());
		}
		else if(e.getSource() == savebutton){
			BusinessBL business=new BusinessBL();
			ArrayList<BusinessVoucher> voucher=business.checkAllMoney();
			ArrayList<BusinessVoucher> outvoucher=new ArrayList<BusinessVoucher> ();
			
			TransportSendBL transportsendbl=new TransportSendBL();
			ArrayList<TransportSendPO> send=transportsendbl.getAll();
			ArrayList<TransportSendPO> outsend=new ArrayList<TransportSendPO>();
			
			SalaryHistoryBL salarybl=new SalaryHistoryBL();
			ArrayList<SalaryHistoryPO> salary=salarybl.getAll();
			ArrayList<SalaryHistoryPO> outsalary=new ArrayList<SalaryHistoryPO>();
			for(int i=0;i<voucher.size();i++){
			
					if(voucher.get(i).getReceiptDate().equals(datefield.getText().trim())){
					outvoucher.add(voucher.get(i));}
				
			}
			for(int i=0;i<send.size();i++){
				
				if(send.get(i).getSenddate().equals(datefield.getText().trim())){
					outsend.add(send.get(i));}
				
		}
			for(int i=0;i<salary.size();i++){
				if(salary.get(i).getDate().equals(datefield.getText().trim())){
					outsalary.add(salary.get(i));}
				}
		
			initCost(outvoucher,outsend,outsalary);
		}
	}
}
