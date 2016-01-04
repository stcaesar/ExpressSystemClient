package presentation.administratorui;

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

public class AdministratorTableUI extends JPanel{
	public AdministratorTableUI(){

		AdministratorBL admin = new AdministratorBL();
		ArrayList<MemberPO> memberPOs = admin.getallUserInfo();
		init(memberPOs);
	}

	private void init(ArrayList<MemberPO> memberPOs) {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(createTable(memberPOs)); 
		add(scrollPane);
	}

	private JTable createTable(ArrayList<MemberPO> memberPOs) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"用户名","密码","权限"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);


		/******ת����Vector***********/
		for(int i = 0;i<memberPOs.size();i++){
			Vector v = new Vector();
			v.add(memberPOs.get(i).getadminid());
			v.add(memberPOs.get(i).getkey());
			v.add(memberPOs.get(i).getright());
			/********��ӽ�JTable��********/
			dtm.addRow(v);
		}
		

		
		



		return table;
	}
}
