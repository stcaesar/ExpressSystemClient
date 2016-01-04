package presentation.storageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import businesslogic.storagebl.StorageBL;
import po.StorageInPO;
import presentation.administratorui.AdministratorTableUI;
import presentation.factory.InfoLabel;
import presentation.factory.RoleLabel;
import presentation.factory.logoutLabel;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
import presentation.registerui.RegisterUI;

import java.io.FileOutputStream;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.List;  
  



import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFCellStyle;  
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  

public class StorageOptionUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JButton inbutton;
	private JButton outbutton;
	private JButton countbutton;
	private JButton checkbutton;
	private JLabel warnlabel;
	private JButton adjustbutton;

	private JLabel wlabel;
	private JTextField adjustfield;
	private JLabel adjustlabel;
	RoleLabel roleicon;
	InfoLabel infoicon;
	public StorageOptionUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		//导出的EXCEL位置
		adjustlabel= new JLabel("导出位置输入格式例：E:/库存盘点结果.xls");
		adjustlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		adjustlabel.setHorizontalAlignment(SwingConstants.CENTER);
		adjustlabel.setBounds(210, 510, 450, 160);
		add(adjustlabel);
		
		//选项字

		infoicon = new InfoLabel(50,0,"storage");
		infoicon.setVisible(false);
		add(infoicon);
		
		
		roleicon = new RoleLabel(10,10);
		add(roleicon);
		roleicon.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				roleicon.setIcon(new ImageIcon("image\\role2.png"));
				infoicon.setVisible(true);
				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				roleicon.setIcon(new ImageIcon("image\\role1.png"));
				infoicon.setVisible(false);
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
			
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		
		//库存报警
		warnlabel = new JLabel("库存报警:");
		warnlabel.setFont(new Font("幼圆",Font.BOLD,30));
		warnlabel.setHorizontalAlignment(SwingConstants.CENTER);
		warnlabel.setBounds(310,105,200,35);
		add(warnlabel);
		
		logoutLabel logouticon = new logoutLabel();
		add(logouticon);
	    
	    //入库单按钮
	    inbutton = new JButton("录入入库单");
	    inbutton.setFont(new Font("幼圆",Font.BOLD,30));
	    inbutton.setBounds(310,200,250,50);
	    add(inbutton);
	    inbutton.addActionListener(this);
	    
	    //出库单按钮
	    outbutton = new JButton("录入出库单");
	    outbutton.setFont(new Font("幼圆",Font.BOLD,30));
	    outbutton.setBounds(310,280,250,50);
	    add(outbutton);
	    outbutton.addActionListener(this);
	    
	    //库存查看按钮
	    checkbutton = new JButton("库存查看");
	    checkbutton.setFont(new Font("幼圆",Font.BOLD,30));
	    checkbutton.setBounds(310,360,250,50);
	    add(checkbutton);
	    checkbutton.addActionListener(this);
	    
	    //库存盘点按钮
	    countbutton = new JButton("库存盘点");
	    countbutton.setFont(new Font("幼圆",Font.BOLD,30));
	    countbutton.setBounds(310,440,250,50);
	    add(countbutton);
	    countbutton.addActionListener(this);
	    
	    StorageBL sto = new StorageBL();
	    wlabel = new JLabel(""+sto.getIn((long)0, (long)99999999)+"%");
	    wlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    wlabel.setHorizontalAlignment(SwingConstants.CENTER);
		wlabel.setBounds(410,105,200,35);
		add(wlabel);
	    
	    //库存调整按钮
	    adjustbutton = new JButton("导出表格");
	    adjustbutton.setFont(new Font("幼圆",Font.BOLD,30));
	    adjustbutton.setBounds(450,520,200,40);
	    add(adjustbutton);
	    adjustbutton.addActionListener(this);
	    
	    adjustfield = new JTextField();
	    adjustfield.setBounds(250,520,150,40);
	    add(adjustfield);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==inbutton){
			MainFrame.setContentPanel(new StorageInUI());
		}
		else if(e.getSource()==outbutton){
			MainFrame.setContentPanel(new StorageOutUI());
		}
		else if(e.getSource()==checkbutton){
			MainFrame.setContentPanel(new StorageCheckUI());
		}
		else if(e.getSource()==countbutton){
			  Date dt=new Date();
			     SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
			     String day=matter1.format(dt);
			     MainFrame.setMemberPanel(new StorageTableUI(Long.parseLong(day)));
		}
		else if(e.getSource()==adjustbutton){
			 Date dt=new Date();
		     SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
		     String time=matter1.format(dt);
			StorageBL storage = new StorageBL();
			ArrayList<StorageInPO> memberPOs = storage.check(Long.parseLong(time));
			 // 第一步，创建一个webbook，对应一个Excel文件  
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("盘点结果");  
	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow((int) 0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
	  
	        HSSFCell cell = row.createCell((short) 0);  
	        cell.setCellValue("单号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 1);  
	        cell.setCellValue("入库时间");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 2);  
	        cell.setCellValue("目的地");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 3);  
	        cell.setCellValue("区号");  
	        cell.setCellStyle(style);
	        cell = row.createCell((short) 4);  
	        cell.setCellValue("排号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 5);  
	        cell.setCellValue("架号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 6);  
	        cell.setCellValue("位号");  
	        cell.setCellStyle(style);  
	  
	          
	  
	        for (int i = 0; i < memberPOs.size(); i++)  
	        {  
	            row = sheet.createRow((int) i + 1);  
	            
	            // 第四步，创建单元格，并设置值  
	            row.createCell((short) 0).setCellValue(memberPOs.get(i).getid());  
	            row.createCell((short) 1).setCellValue(memberPOs.get(i).getintime());  
	            row.createCell((short) 2).setCellValue(memberPOs.get(i).getdestination());
	            row.createCell((short) 3).setCellValue(memberPOs.get(i).getdistrict());
	            row.createCell((short) 4).setCellValue(memberPOs.get(i).getrow());
	            row.createCell((short) 5).setCellValue(memberPOs.get(i).getshelf());
	            row.createCell((short) 6).setCellValue(memberPOs.get(i).getnumber());
	            
	        }  
	        // 第六步，将文件存到指定位置  
	        try  
	        {  
	        	String str=adjustfield.getText().trim();
	            FileOutputStream fout = new FileOutputStream(str);  
	            wb.write(fout);  
	            fout.close();
	            StorageSuccessUI success=new StorageSuccessUI();
	        }  
	        catch (Exception e1)  
	        {  
	            e1.printStackTrace();  
	        }  
	    }  

	}
	
	

}
