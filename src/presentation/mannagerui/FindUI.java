package presentation.mannagerui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import businesslogic.businessbl.BusinessBL;
import businesslogic.financialbl.SalaryHistoryBL;
import businesslogic.transportbl.TransportSendBL;
import po.BusinessVoucher;
import po.SalaryHistoryPO;
import po.TransportSendPO;
import presentation.mainframe.MainFrame;

public class FindUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel serviselabel;
	private JLabel startdatelabel;
	private JLabel enddatelabel;
	private JLabel locationlabel;
	private JComboBox servisebox;
	private JTextField locationfield;
	private JTextField startdatefield;
	private JTextField enddatefield;
	private JButton addbutton;
	private JButton findbutton;
	private JButton quitbutton;
	public JScrollPane scrollPane = new JScrollPane(); 
	public FindUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("报表生成");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(320, 40, 250, 80);
		add(titlelabel);
		serviselabel= new JLabel("查询内容:");
		serviselabel.setFont(new Font("幼圆", Font.BOLD, 20));
		serviselabel.setHorizontalAlignment(SwingConstants.CENTER);
		serviselabel.setBounds(225, 130, 100, 30);
		add(serviselabel);
		startdatelabel= new JLabel("起始日期:");
		startdatelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		startdatelabel.setHorizontalAlignment(SwingConstants.CENTER);
		startdatelabel.setBounds(225, 170, 100, 30);
		add(startdatelabel);
		
		locationlabel= new JLabel("导出地址:");
		locationlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		locationlabel.setHorizontalAlignment(SwingConstants.CENTER);
		locationlabel.setBounds(225, 500, 100, 30);
		add(locationlabel);
		
		String[] serviselist = new String[]{"成本收益表","经营情况表"};
		servisebox = new JComboBox(serviselist);
		servisebox.setFont(new Font("幼圆", Font.BOLD, 20));
		servisebox.setBounds(400, 130,300, 30);
		add(servisebox);
		
		enddatelabel= new JLabel("截止日期:");
		enddatelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		enddatelabel.setHorizontalAlignment(SwingConstants.CENTER);
		enddatelabel.setBounds(225, 210, 100, 30);
		add(enddatelabel);
		
		startdatefield=new JTextField();
		startdatefield.setBounds(400,170,300,30);
		startdatefield.setText("日期格式：XXXX/XX/XX");
		add(startdatefield);
		
		locationfield=new JTextField();
		locationfield.setBounds(400,500,300,30);
		locationfield.setText("地址格式：E:/XXXX.xls");
		add(locationfield);
		
		enddatefield=new JTextField();
		enddatefield.setBounds(400,210,300,30);
		enddatefield.setText("日期格式：XXXX/XX/XX");
		add(enddatefield);
		
		findbutton=new JButton("查询");
		findbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		findbutton.setHorizontalAlignment(SwingConstants.CENTER);
		findbutton.setBounds(250, 550, 100, 30);
		add(findbutton);
		findbutton.addActionListener(this);
		
		addbutton=new JButton("生成");
		addbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		addbutton.setHorizontalAlignment(SwingConstants.CENTER);
		addbutton.setBounds(375, 550, 100, 30);
		add(addbutton);
		addbutton.addActionListener(this);
		
		quitbutton=new JButton("取消");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(500, 550, 100, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		
		setVisible(true);
		
	}
	private void initCalculate(ArrayList<BusinessVoucher> voucher,ArrayList<TransportSendPO> sendpo) {
		// TODO Auto-generated method stub
		remove(scrollPane);
		scrollPane = new JScrollPane(createTableCalculate(voucher,sendpo)); 
		scrollPane.setBounds(50,240,750,250);
		add(scrollPane);
	}
	private JTable createTableCalculate(ArrayList<BusinessVoucher> voucher,ArrayList<TransportSendPO> sendpo) {
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
	for(int j=0;j<sendpo.size();j++){
		Vector v = new Vector();
		v.add("付款");
		v.add(sendpo.get(j).getSenddate());
		v.add(sendpo.get(j).getFare());
		v.add(sendpo.get(j).getWatcherid());
		v.add(sendpo.get(j).getSendtranscodeid());
		dtm.addRow(v);
	}
	
		return table;
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
		MainFrame.setContentPanel(new ManagerUI());
	}
	else if(e.getSource() == findbutton&&servisebox.getSelectedItem().equals("成本收益表")){
		if(startdatefield.getText().trim().equals("")||enddatefield.getText().trim().equals("")||
    			locationfield.getText().trim().equals("")){
			MainFrame.showmessage("请输入完整");
		}
    	else{
    		long startdate=0;
			long enddate=0;
			startdate=Long.parseLong(startdatefield.getText().trim().replace('/','0'));
			enddate=Long.parseLong(enddatefield.getText().trim().replace('/','0'));
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
				if(startdate<=Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0'))&&
						enddate>=Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0'))){
					
					outvoucher.add(voucher.get(i));
				}
			}
			for(int i=0;i<send.size();i++){
				if(startdate<=Long.parseLong(send.get(i).getSenddate().replace('/', '0'))&&
						enddate>=Long.parseLong(send.get(i).getSenddate().replace('/', '0'))){
					
					outsend.add(send.get(i));
				}
		}
			for(int i=0;i<salary.size();i++){
				if(startdate<=Long.parseLong(salary.get(i).getDate().replace('/', '0'))&&
						enddate>=Long.parseLong(salary.get(i).getDate().replace('/', '0'))){					
					outsalary.add(salary.get(i));
				}
		}
			initCost(outvoucher,outsend,outsalary);
    	}
	}
    else if(e.getSource() == findbutton&&servisebox.getSelectedItem().equals("经营情况表")){
    	if(startdatefield.getText().trim().equals("")||enddatefield.getText().trim().equals("")){
			MainFrame.showmessage("请输入完整");
		}
		else{
			long startdate=0;
			long enddate=0;
			startdate=Long.parseLong(startdatefield.getText().trim().replace('/','0'));
			enddate=Long.parseLong(enddatefield.getText().trim().replace('/','0'));
			BusinessBL business=new BusinessBL();
			ArrayList<BusinessVoucher> voucher=business.checkAllMoney();
			ArrayList<BusinessVoucher> outvoucher=new ArrayList<BusinessVoucher> ();
			TransportSendBL transportsendbl=new TransportSendBL();
			ArrayList<TransportSendPO> send=transportsendbl.getAll();
			ArrayList<TransportSendPO> outsend=new ArrayList<TransportSendPO>();
		
			for(int i=0;i<voucher.size();i++){
				if(startdate<=Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0'))&&
						enddate>=Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0'))){
					
					outvoucher.add(voucher.get(i));
				}
			}
			for(int i=0;i<send.size();i++){
				if(startdate<=Long.parseLong(send.get(i).getSenddate().replace('/', '0'))&&
						enddate>=Long.parseLong(send.get(i).getSenddate().replace('/', '0'))){
					
					outsend.add(send.get(i));
				}
		}
			initCalculate(outvoucher,outsend);
			
	}
	}
    else if(e.getSource() == addbutton&&servisebox.getSelectedItem().equals("成本收益表")){
    	if(startdatefield.getText().trim().equals("")||enddatefield.getText().trim().equals("")||
    			locationfield.getText().trim().equals("")){
			MainFrame.showmessage("请输入完整");
		}
    	else{
    		double sum=0;
    		long startdate=0;
			long enddate=0;
			startdate=Long.parseLong(startdatefield.getText().trim().replace('/','0'));
			enddate=Long.parseLong(enddatefield.getText().trim().replace('/','0'));
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
				if(startdate<=Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0'))&&
						enddate>=Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0'))){
					
					outvoucher.add(voucher.get(i));
					sum=sum+Double.parseDouble(voucher.get(i).getMoney());
				}
			}
			for(int i=0;i<send.size();i++){
				if(startdate<=Long.parseLong(send.get(i).getSenddate().replace('/', '0'))&&
						enddate>=Long.parseLong(send.get(i).getSenddate().replace('/', '0'))){
					
					outsend.add(send.get(i));
					sum=sum-send.get(i).getFare();
				}
		}
			for(int i=0;i<salary.size();i++){
				if(startdate<=Long.parseLong(salary.get(i).getDate().replace('/', '0'))&&
						enddate>=Long.parseLong(salary.get(i).getDate().replace('/', '0'))){					
					outsalary.add(salary.get(i));
					sum=sum-salary.get(i).getMoney();
					
				}
		}
			 // 第一步，创建一个webbook，对应一个Excel文件  
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("成本收益表");  
	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow((int) 0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
	  
	        HSSFCell cell = row.createCell((short) 0);  
	        cell.setCellValue("收支");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 1);  
	        cell.setCellValue("项目");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 2);  
	        cell.setCellValue("日期");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 3);  
	        cell.setCellValue("金额");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 4);  
	        cell.setCellValue("人员");  
	        cell.setCellStyle(style);  
	        for (int i = 0; i < outvoucher.size(); i++)  
	        {  
	            row = sheet.createRow((int) i + 1);   
	            // 第四步，创建单元格，并设置值  
	            row.createCell((short) 0).setCellValue("收款");  
	            row.createCell((short) 1).setCellValue("营业厅收款");  
	            row.createCell((short) 2).setCellValue(outvoucher.get(i).getReceiptDate());  
	            row.createCell((short) 3).setCellValue(outvoucher.get(i).getMoney());
	            row.createCell((short) 4).setCellValue(outvoucher.get(i).getCourier());
	        } 
	        for (int i = outvoucher.size(); i <outvoucher.size()+outsend.size() ; i++)  
	        {  
	            row = sheet.createRow((int) i + 1);   
	            // 第四步，创建单元格，并设置值  
	            row.createCell((short) 0).setCellValue("付款");  
	            row.createCell((short) 1).setCellValue("运费");  
	            row.createCell((short) 2).setCellValue(outsend.get(i-outvoucher.size()).getSenddate());  
	            row.createCell((short) 3).setCellValue(outsend.get(i-outvoucher.size()).getFare());
	            row.createCell((short) 4).setCellValue(outsend.get(i-outvoucher.size()).getWatcherid());
	        } 
	        for (int i = outvoucher.size()+outsend.size(); i <outsalary.size()+outvoucher.size()+outsend.size() ; i++)  
	        {  
	            row = sheet.createRow((int) i + 1);   
	            // 第四步，创建单元格，并设置值  
	            row.createCell((short) 0).setCellValue("付款");  
	            row.createCell((short) 1).setCellValue("工资");  
	            row.createCell((short) 2).setCellValue(outsalary.get(i-outvoucher.size()-outsend.size()).getDate());  
	            row.createCell((short) 3).setCellValue(outsalary.get(i-outvoucher.size()-outsend.size()).getMoney());
	            row.createCell((short) 4).setCellValue(outsalary.get(i-outvoucher.size()-outsend.size()).getName());
	        } 
	        row = sheet.createRow(outvoucher.size()+outsend.size()+outsalary.size()+ 1);  
	        row.createCell((short) 3).setCellValue(sum);
	        // 第六步，将文件存到指定位置  
	        try  
	        {  
	        	String str=locationfield.getText().trim();
	            FileOutputStream fout = new FileOutputStream(str);  
	            wb.write(fout);  
	            fout.close();
	            MainFrame.showmessage("导出成功");
	        }  
	        catch (Exception e1)  
	        {  
	            e1.printStackTrace();  
	        }  
    	}
	}
    else if(e.getSource() == addbutton&&servisebox.getSelectedItem().equals("经营情况表")){
    	if(startdatefield.getText().trim().equals("")||enddatefield.getText().trim().equals("")||
    			locationfield.getText().trim().equals("")){
			MainFrame.showmessage("请输入完整");
		}
    	else{
    		long startdate=0;
			long enddate=0;
			startdate=Long.parseLong(startdatefield.getText().trim().replace('/','0'));
			enddate=Long.parseLong(enddatefield.getText().trim().replace('/','0'));
			BusinessBL business=new BusinessBL();
			ArrayList<BusinessVoucher> voucher=business.checkAllMoney();
			ArrayList<BusinessVoucher> outvoucher=new ArrayList<BusinessVoucher> ();
			TransportSendBL transportsendbl=new TransportSendBL();
			ArrayList<TransportSendPO> send=transportsendbl.getAll();
			ArrayList<TransportSendPO> outsend=new ArrayList<TransportSendPO>();
			for(int i=0;i<voucher.size();i++){
				if(startdate<=Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0'))&&
						enddate>=Long.parseLong(voucher.get(i).getReceiptDate().replace('/', '0'))){
					
					outvoucher.add(voucher.get(i));
				}
			}
			for(int i=0;i<send.size();i++){
				if(startdate<=Long.parseLong(send.get(i).getSenddate().replace('/', '0'))&&
						enddate>=Long.parseLong(send.get(i).getSenddate().replace('/', '0'))){
					
					outsend.add(send.get(i));
				}
		}
			 // 第一步，创建一个webbook，对应一个Excel文件  
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("经营情况表");  
	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow((int) 0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
	  
	        HSSFCell cell = row.createCell((short) 0);  
	        cell.setCellValue("收支");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 1);  
	        cell.setCellValue("日期");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 2);  
	        cell.setCellValue("金额");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 3);  
	        cell.setCellValue("快递员");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 4);  
	        cell.setCellValue("订单号");  
	        cell.setCellStyle(style);  
	        for (int i = 0; i < outvoucher.size(); i++)  
	        {  
	            row = sheet.createRow((int) i + 1);   
	            // 第四步，创建单元格，并设置值  
	            row.createCell((short) 0).setCellValue("收款");  
	            row.createCell((short) 1).setCellValue(outvoucher.get(i).getReceiptDate());  
	            row.createCell((short) 2).setCellValue(outvoucher.get(i).getMoney());
	            row.createCell((short) 3).setCellValue(outvoucher.get(i).getCourier());
	            row.createCell((short) 4).setCellValue(outvoucher.get(i).getBarCode());  
	        } 
	        for(int i=outvoucher.size();i<outvoucher.size()+outsend.size();i++){
	        	row = sheet.createRow((int) i + 1);  
	        	row.createCell((short) 0).setCellValue("付款");  
	        	row.createCell((short) 1).setCellValue(outsend.get(i-outvoucher.size()).getSenddate());
	        	row.createCell((short) 2).setCellValue(outsend.get(i-outvoucher.size()).getFare());
	        	row.createCell((short) 3).setCellValue(outsend.get(i-outvoucher.size()).getWatcherid());
	        	row.createCell((short) 4).setCellValue(outsend.get(i-outvoucher.size()).getSendtranscodeid());	
	        }
	        // 第六步，将文件存到指定位置  
	        try  
	        {  
	        	String str=locationfield.getText().trim();
	            FileOutputStream fout = new FileOutputStream(str);  
	            wb.write(fout);  
	            fout.close();
	            MainFrame.showmessage("导出成功");
	        }  
	        catch (Exception e1)  
	        {  
	            e1.printStackTrace();  
	        }  
			
    	}
   	}
}
}
