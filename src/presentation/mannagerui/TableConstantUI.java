package presentation.mannagerui;

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
import businesslogic.mannagerbl.ManagerBL;
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

import po.BusinessReceive;
import po.ManagerConstant;
import po.ManagerMember;
import po.ManagerPay;
import po.MemberPO;
import po.StorageInPO;

public class TableConstantUI extends JPanel{
	private JButton bl;
	public TableConstantUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		bl = new JButton("返回");
		bl.setFont(new Font("幼圆", Font.BOLD, 20));
		bl.setHorizontalAlignment(SwingConstants.CENTER);
		bl.setBounds(400, 535, 100, 50);
		add(bl);
		bl.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			MainFrame.setContentPanel(new ConstantUI());
    	    }
    	});
		ManagerBL manager = new ManagerBL();
		ArrayList<ManagerConstant> memberPOs = manager.getAllConstantPO();
		init(memberPOs);

		
		setVisible(true);
	}

	private void init(ArrayList<ManagerConstant> memberPOs) {
		// TODO Auto-generated method stub

		JScrollPane scrollPane = new JScrollPane(createTable(memberPOs)); 
		scrollPane.setBounds(50, 0, 800, 520);
		add(scrollPane);
	}

	private JTable createTable(ArrayList<ManagerConstant> memberPOs) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"出发城市","到达城市","距离","经济快递","标准快递","特快"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);


		/******转化成Vector***********/
		for(int i = 0;i<memberPOs.size();i++){
			Vector v = new Vector();
			v.add(memberPOs.get(i).getCity1());
			v.add(memberPOs.get(i).getCity2());
			v.add(memberPOs.get(i).getDistance());
			v.add(memberPOs.get(i).getSave());
			v.add(memberPOs.get(i).getStandard());
			v.add(memberPOs.get(i).getFast());
			dtm.addRow(v);
		}

		return table;
	}

	

}

