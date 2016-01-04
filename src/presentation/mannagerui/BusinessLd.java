package presentation.mannagerui;

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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import po.BusinessLoad;
import po.BusinessReceive;
import presentation.mainframe.MainFrame;
import businesslogic.businessbl.BusinessBL;

public class BusinessLd extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel serviselabel;
	private JButton allbutton;
	private JButton partbutton;
	private JButton savebutton;
	private JButton quitbutton;
	private JTable table = null;
	public JScrollPane scrollPane = new JScrollPane(); 
	public BusinessLd(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("装车单查询");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(320, 40, 300, 80);
		add(titlelabel);
		
		savebutton=new JButton("确定审批");
		savebutton.setFont(new Font("幼圆", Font.BOLD, 20));
		savebutton.setHorizontalAlignment(SwingConstants.CENTER);
		savebutton.setBounds(390, 5000, 150, 30);
		add(savebutton);
		savebutton.addActionListener(this);
		
		
		allbutton=new JButton("显示所有");
		allbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		allbutton.setHorizontalAlignment(SwingConstants.CENTER);
		allbutton.setBounds(150, 500, 150, 30);
		add(allbutton);
		allbutton.addActionListener(this);
		
		partbutton=new JButton("显示未审批");
		partbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		partbutton.setHorizontalAlignment(SwingConstants.CENTER);
		partbutton.setBounds(390, 500, 150, 30);
		add(partbutton);
		partbutton.addActionListener(this);
		
		quitbutton=new JButton("退出");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(630, 500, 150, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		
		setVisible(true);
	}
	private void init(ArrayList<BusinessLoad> businessload) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTable(businessload)); 
		scrollPane.setBounds(50,150,750,350);
		add(scrollPane);
	}
	
	private JTable createTable(ArrayList<BusinessLoad> businessload) {
		JTable table = new JTable();
		String[] tableHeads = new String[]{"装车日期","本营业厅编号","汽运编号","到达地","车辆代号","监装员","押运员","条形码号","运费","状态"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);


		/******转化成Vector***********/
		for(int i = 0;i<businessload.size();i++){
			Vector v = new Vector();
			v.add(businessload.get(i).getDate());
			v.add(businessload.get(i).getBusinessIdentifier());
			v.add(businessload.get(i).getCarIdentifier());
			v.add(businessload.get(i).getDestination());
			v.add(businessload.get(i).getCarCode());
			v.add(businessload.get(i).getSupervision());
			v.add(businessload.get(i).getSuperCargo());
			v.add(businessload.get(i).getBarCode());
			v.add(businessload.get(i).getMoney());
			v.add(businessload.get(i).getReadState());
			dtm.addRow(v);
		}
		return table;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new CheckUI());
		}
		else if(e.getSource() == allbutton){
			BusinessBL businessload=new BusinessBL();
			ArrayList<BusinessLoad> BusinessBL=businessload.checkLoad();
			init(BusinessBL);
			savebutton.setBounds(390, 5000, 150, 30);
		}
		else if(e.getSource() == partbutton){
			BusinessBL businessload=new BusinessBL();
			ArrayList<BusinessLoad> businessbl=businessload.checkLoad("unchecked");		
			init(businessbl);
			savebutton.setBounds(390, 550, 150, 30);
		}
		else if(e.getSource() == savebutton){
			BusinessBL businessload=new BusinessBL();
			ArrayList<BusinessLoad> businessbl=businessload.checkLoad("unchecked");
			if(businessbl.size()!=0){
			for(int i=0;i<businessbl.size();i++){
				businessload.update(businessbl.get(i));
			}
			MainFrame.showmessage("保存成功");
			}
			else{
				MainFrame.showmessage("无未审批单据");
			}
			
		}
	}
}



