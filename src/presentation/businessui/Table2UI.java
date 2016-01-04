package presentation.businessui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import businesslogic.administratorbl.AdministratorBL;
import businesslogic.businessbl.BusinessBL;
import businesslogic.storagebl.StorageBL;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
import presentation.registerui.RegisterUI;
import presentation.storageui.StorageAdjustUI;
import presentation.storageui.StorageCheckUI;
import presentation.storageui.StorageInUI;
import presentation.storageui.StorageOptionUI;
import presentation.storageui.StorageOutUI;

import java.util.ArrayList;
import java.util.Vector;

import po.BusinessDistribution;
import po.BusinessReceive;
import po.MemberPO;
import po.StorageInPO;

public class Table2UI extends JPanel{
	private JButton bl;
	public Table2UI(String barCode,String readState){
		setBounds(200,0,900,650);
		setLayout(null);
		bl = new JButton("返回");
		bl.setFont(new Font("幼圆", Font.BOLD, 20));
		bl.setHorizontalAlignment(SwingConstants.CENTER);
		bl.setBounds(400, 535, 100, 50);
		add(bl);
		bl.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new ExistDistributionUI());
    	    }
    	});
		BusinessBL business = new BusinessBL();
		ArrayList<BusinessDistribution> memberPOs = business.checkDistribution(barCode,readState);
		init(memberPOs);

		
		setVisible(true);
	}

	public Table2UI() {
		// TODO Auto-generated constructor stub
	}

	private void init(ArrayList<BusinessDistribution> memberPOs) {
		// TODO Auto-generated method stub

		JScrollPane scrollPane = new JScrollPane(createTable(memberPOs)); 
		scrollPane.setBounds(50, 0, 800, 520);
		add(scrollPane);
	}

	private JTable createTable(ArrayList<BusinessDistribution> memberPOs) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"到达日期","托运订单条形码号","派送员","单据状态"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);


		/******转化成Vector***********/
		for(int i = 0;i<memberPOs.size();i++){
			Vector v = new Vector();
			v.add(memberPOs.get(i).getArrivalDate());
			v.add(memberPOs.get(i).getBarCode());
			v.add(memberPOs.get(i).getDispatcher());
			v.add(memberPOs.get(i).getReadState());
			dtm.addRow(v);
		}

		return table;
	}
public static void main(String args[]){
	Table2UI test=new Table2UI();
	BusinessBL business = new BusinessBL();
	ArrayList<BusinessDistribution> memberPOs = business.checkDistribution("liuqin","unchecked");
	System.out.println(memberPOs.size());
}
	

}
