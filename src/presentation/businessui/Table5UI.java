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

import po.BusinessDriverManagement;
import po.BusinessLoad;
import po.BusinessReceive;
import po.BusinessVoucher;
import po.MemberPO;
import po.StorageInPO;

public class Table5UI extends JPanel{
	private JButton bl;
	public Table5UI(String driverNumber){
		setBounds(200,0,900,650);
		setLayout(null);
		bl = new JButton("返回");
		bl.setFont(new Font("幼圆", Font.BOLD, 20));
		bl.setHorizontalAlignment(SwingConstants.CENTER);
		bl.setBounds(400, 535, 100, 50);
		add(bl);
		bl.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new ExistDriverUI());
    	    }
    	});
		BusinessBL business = new BusinessBL();
		ArrayList<BusinessDriverManagement> memberPOs = business.checkDriver(driverNumber);
		init(memberPOs);

		
		setVisible(true);
	}

	private void init(ArrayList<BusinessDriverManagement> memberPOs) {
		// TODO Auto-generated method stub

		JScrollPane scrollPane = new JScrollPane(createTable(memberPOs)); 
		scrollPane.setBounds(50, 0, 800, 520);
		add(scrollPane);
	}

	private JTable createTable(ArrayList<BusinessDriverManagement> memberPOs) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"司机编号","姓名","出生日期","身份证号","手机","性别","行驶证期限"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);


		/******转化成Vector***********/
		for(int i = 0;i<memberPOs.size();i++){
			Vector v = new Vector();
			v.add(memberPOs.get(i).getDriverNumber());
			v.add(memberPOs.get(i).getName());
			v.add(memberPOs.get(i).getBirthDate());
			v.add(memberPOs.get(i).getIdentifyNumber());
			v.add(memberPOs.get(i).getPhoneNumber());
			v.add(memberPOs.get(i).getGender());
			v.add(memberPOs.get(i).getRegistrarionDeadline());
			dtm.addRow(v);
		}

		return table;
	}

	

}



