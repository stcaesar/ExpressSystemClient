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

import businesslogic.financialbl.FinancialBankaccountBL;

import po.FinancialBankaccountPO;
import presentation.mainframe.MainFrame;


public class FinancialAccountArrangeUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel accountidlabel;
	private JTextField accountidfield;
	private JButton savebutton;
	private JButton quitbutton;
	public JScrollPane scrollPane = new JScrollPane(); 
	public FinancialAccountArrangeUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("账户查询");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(337, 40, 250, 80);
		add(titlelabel);
		
		accountidlabel= new JLabel("账户编号:");
		accountidlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		accountidlabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountidlabel.setBounds(220, 150, 100, 30);
		add(accountidlabel);
		
		accountidfield=new JTextField();
		accountidfield.setBounds(350,150,300,30);
		add(accountidfield);
		
		savebutton=new JButton("查找");
		savebutton.setFont(new Font("幼圆", Font.BOLD, 20));
		savebutton.setHorizontalAlignment(SwingConstants.CENTER);
		savebutton.setBounds(250, 550, 100, 30);
		add(savebutton);
		savebutton.addActionListener(this);
		
		
		
		quitbutton=new JButton("退出");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(550, 550, 100, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		
		setVisible(true);
	}
	private void init(ArrayList<FinancialBankaccountPO> bankaccount) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTable(bankaccount)); 
		scrollPane.setBounds(50,200,750,300);
		add(scrollPane);
	}
	
	private JTable createTable(ArrayList<FinancialBankaccountPO> bankaccount) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"银行卡号","操作","金额","日期"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);

		/******转化成Vector***********/
		for(int i = 0;i<bankaccount.size();i++){
			Vector v = new Vector();
			v.add(bankaccount.get(i).getAccountNum());
			v.add(bankaccount.get(i).getOperation());
			v.add(bankaccount.get(i).getMoney());
			v.add(bankaccount.get(i).getDate());
		
		
			/********添加进JTable中********/
			dtm.addRow(v);
		}
	
		return table;
	}
public void actionPerformed(ActionEvent e){
	ArrayList<FinancialBankaccountPO> bankaccount=new ArrayList<FinancialBankaccountPO> ();
	double result=0;
	if(e.getSource() == quitbutton){
		MainFrame.setContentPanel(new FinancialMainUI());
	}
	else if(e.getSource() == savebutton){
		
		if(!accountidfield.getText().trim().equals("")){
		FinancialBankaccountBL bankaccountbl=new FinancialBankaccountBL();
		bankaccount=bankaccountbl.getAll(accountidfield.getText().trim());
		init(bankaccount);
		for(int i=0;i<bankaccount.size();i++){
			if(bankaccount.get(i).getOperation().equals("存入")){
				result=result+bankaccount.get(i).getMoney();
				
			}
			else{
				result=result-bankaccount.get(i).getMoney();
			}
		}
		if(result>=0){
			String output="";
			output=output+result;
			MainFrame.showmessage("盈余"+output+"元");
		}
		else{
			result=0-result;
			String output="";
			output=output+result;
			MainFrame.showmessage("透支"+output+"元");
		}
		}
		else{
			MainFrame.showmessage("请填写完整");
		}
		
	}
	
}
}
