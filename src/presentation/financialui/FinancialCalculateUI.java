package presentation.financialui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import javax.swing.table.DefaultTableModel;




import businesslogic.businessbl.BusinessBL;
import po.BusinessVoucher;
import presentation.mainframe.MainFrame;
public class FinancialCalculateUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel datelabel;
	private JLabel centeridlabel;
	private JButton savebutton;
	private JButton quitbutton;
	private JTextField datefield;
	private JTextField centeridfield;
	public JScrollPane scrollPane = new JScrollPane(); 
	public FinancialCalculateUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("结算管理");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(320, 40, 250, 80);
		add(titlelabel);
		
		datelabel= new JLabel("结算日期:");
		datelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		datelabel.setHorizontalAlignment(SwingConstants.CENTER);
		datelabel.setBounds(225, 130, 100, 30);
		add(datelabel);
		
		centeridlabel= new JLabel("营业厅号:");
		centeridlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		centeridlabel.setHorizontalAlignment(SwingConstants.CENTER);
		centeridlabel.setBounds(225, 180, 100, 30);
		add(centeridlabel);
		
		savebutton=new JButton("查询");
		savebutton.setFont(new Font("幼圆", Font.BOLD, 20));
		savebutton.setHorizontalAlignment(SwingConstants.CENTER);
		savebutton.setBounds(250, 550, 100, 30);
		add(savebutton);
		savebutton.addActionListener(this);
		
		datefield=new JTextField();
		datefield.setBounds(400,130,300,30);
		datefield.setText("");
		add(datefield);
		
		centeridfield=new JTextField();
		centeridfield.setBounds(400,180,300,30);
		add(centeridfield);
		
		quitbutton=new JButton("取消");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(500, 550, 100, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		setVisible(true);
	}
	private void init(ArrayList<BusinessVoucher> voucher) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTable(voucher)); 
		scrollPane.setBounds(50,240,750,300);
		add(scrollPane);
	}
	private JTable createTable(ArrayList<BusinessVoucher> voucher) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"项目","日期","金额","快递员","订单号"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);

		/******转化成Vector***********/
		for(int i = 0;i<voucher.size();i++){
			Vector v = new Vector();
			v.add("收款");
			v.add(voucher.get(i).getReceiptDate());
			v.add(voucher.get(i).getMoney());
			v.add(voucher.get(i).getCourier());
			v.add(voucher.get(i).getBarCode());	
			/********添加进JTable中********/
			dtm.addRow(v);
		}
	
		return table;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new FinancialMainUI());
		}
		else if(e.getSource() == savebutton){
			if(datefield.getText().trim().equals("")){
			BusinessBL business=new BusinessBL();
			ArrayList<BusinessVoucher> voucher=business.checkAllMoney();
			ArrayList<BusinessVoucher> output=new ArrayList<BusinessVoucher>();
			for(int i=0;i<voucher.size();i++){
				if(voucher.get(i).getCourier().equals(centeridfield.getText().trim())){				
					output.add(voucher.get(i));
				}
			}
			init(output);
			}
			else{
				String sdate="";
				long ndate=0;
				sdate=datefield.getText().trim().replace('/', '0');
				ndate=Long.parseLong(sdate);
				System.out.println(ndate);
				BusinessBL business=new BusinessBL();
				ArrayList<BusinessVoucher> voucher=business.checkAllMoney();
				ArrayList<BusinessVoucher> output=new ArrayList<BusinessVoucher>();
				for(int i=0;i<voucher.size();i++){
					if(ndate>=Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0'))&&
							voucher.get(i).getCourier().equals(centeridfield.getText().trim())){
						System.out.println(Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0')));
						output.add(voucher.get(i));
					}
				}
				init(output);
			}
		}
	}
}