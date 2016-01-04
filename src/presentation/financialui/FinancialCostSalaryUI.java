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
import businesslogic.financialbl.SalaryHistoryBL;
import po.SalaryHistoryPO;
import presentation.mainframe.MainFrame;
public class FinancialCostSalaryUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel idlabel;
	private JTextField idfield;
	private JLabel datelabel;
	private JTextField datefield;
	private JButton savebutton;
	private JButton quitbutton;
	public JScrollPane scrollPane = new JScrollPane(); 
	public FinancialCostSalaryUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("工资查询");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(320, 40, 250, 80);
		add(titlelabel);
		
		idlabel= new JLabel("员工编号:");
		idlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setBounds(225, 130, 100, 30);
		add(idlabel);
		
		idfield=new JTextField();
		idfield.setBounds(400,130,300,30);
		add(idfield);
		
		datelabel= new JLabel("查询日期:");
		datelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		datelabel.setHorizontalAlignment(SwingConstants.CENTER);
		datelabel.setBounds(225, 170, 100, 30);
		add(datelabel);
		
		datefield=new JTextField();
		datefield.setBounds(400,170,300,30);
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
	private void init(ArrayList<SalaryHistoryPO> salary) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTable(salary)); 
		scrollPane.setBounds(50,210,750,280);
		add(scrollPane);
	}
	
	private JTable createTable(ArrayList<SalaryHistoryPO> salary) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"员工姓名","金额","日期"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);

		/******转化成Vector***********/
		for(int i = 0;i<salary.size();i++){
			Vector v = new Vector();
			v.add(salary.get(i).getName());
			v.add(salary.get(i).getMoney());
			v.add(salary.get(i).getDate());
			
		
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
		if(datefield.getText().trim().equals("")||idfield.getText().trim().equals("")){
			MainFrame.showmessage("请输入完整");
		}
		else{
		
			long enddate=0;
			
			enddate=Long.parseLong(datefield.getText().trim().replace('/','0'));
			SalaryHistoryBL salaryBL=new SalaryHistoryBL();
			ArrayList<SalaryHistoryPO> salary=salaryBL.getAll();
			ArrayList<SalaryHistoryPO> outsalary=new ArrayList<SalaryHistoryPO>();
			for(int i=0;i<salary.size();i++){
				if(idfield.getText().trim().equals(salary.get(i).getName())&&enddate>=Long.parseLong(salary.get(i).getDate().replace('/', '0'))){					
					outsalary.add(salary.get(i));
				}
		}
			init(outsalary);
		}
	}
}
}