package presentation.storageui;

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

import po.MemberPO;
import po.StorageInPO;

public class StorageTableUI extends JPanel{
	public StorageTableUI(Long time){

		StorageBL storage = new StorageBL();
		ArrayList<StorageInPO> memberPOs = storage.check(time);
		init(memberPOs);
		
	}

	private void init(ArrayList<StorageInPO> storage) {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(createTable(storage)); 
		add(scrollPane);
	}

	private JTable createTable(ArrayList<StorageInPO> storage) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"ID","入库时间","目的地","区号","排号","架号","位号"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);


		/******转化成Vector***********/
		for(int i = 0;i<storage.size();i++){
			Vector v = new Vector();
			v.add(storage.get(i).getid());
			v.add(storage.get(i).getintime());
			v.add(storage.get(i).getdestination());
			v.add(storage.get(i).getdistrict());
			v.add(storage.get(i).getrow());
			v.add(storage.get(i).getshelf());
			v.add(storage.get(i).getnumber());
			/********添加进JTable中********/
			dtm.addRow(v);
		}
		

		
		



		return table;
	}

	

}