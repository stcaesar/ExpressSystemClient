package presentation.storageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class StorageOutUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel idlabel;
	private JLabel outlabel;
	private JLabel destinationlabel;
	private JLabel transportlabel;
	private JLabel centralidlabel;
	private JTextField idfield;
	private JTextField outfield;
	private JComboBox destinationBox;
	private JTextField centralidfield;
	private JComboBox transportbox;
	private JButton returnbutton;
	private JButton inputbutton;
	private JLabel ylabel;
	private JLabel mlabel;
	private JLabel dlabel;
	private JTextField mfield;
	private JTextField dfield;
	
	public StorageOutUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		//标题
		titlelabel= new JLabel("库存出库单");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(210, 15, 450, 160);
		add(titlelabel);
		
		//填写项
		idlabel= new JLabel("快递编号");
		idlabel.setFont(new Font("幼圆", Font.BOLD, 30));
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setBounds(15, 125, 600, 160);
		add(idlabel);
		
		idfield = new JTextField();
		idfield.setBounds(410,190,200,35);
		add(idfield);
		
		outlabel = new JLabel("出库日期");
		outlabel.setFont(new Font("幼圆",Font.BOLD,30));
		outlabel.setHorizontalAlignment(SwingConstants.CENTER);
		outlabel.setBounds(15,200,600,160);
		add(outlabel);
		
		ylabel = new JLabel("年");
	    ylabel.setFont(new Font("幼圆",Font.BOLD,30));
	    ylabel.setHorizontalAlignment(SwingConstants.CENTER);
	    ylabel.setBounds(200, 200, 600, 160);
	    add(ylabel);
	    
	    mfield = new JTextField();
	    mfield.setBounds(520,265,60,35);
	    add(mfield);
	    
	    mlabel = new JLabel("月");
	    mlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    mlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    mlabel.setBounds(300, 200, 600, 160);
	    add(mlabel);
	    
	    dfield = new JTextField();
	    dfield.setBounds(620,265,60,35);
	    add(dfield);
	    
	    dlabel = new JLabel("日");
	    dlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    dlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    dlabel.setBounds(400, 200, 600, 160);
	    add(dlabel);
		
		outfield = new JTextField();
		outfield.setBounds(410,265,70,35);
		add(outfield);
		
		destinationlabel = new JLabel("目的地");
		destinationlabel.setFont(new Font("幼圆",Font.BOLD,30));
		destinationlabel.setHorizontalAlignment(SwingConstants.CENTER);
		destinationlabel.setBounds(30,275,600,160);
		add(destinationlabel);
		
		String[] rolelist = new String[]{"北京","上海","广州","南京"};
		destinationBox = new JComboBox(rolelist);
		destinationBox.setFont(new Font("幼圆", Font.BOLD, 30));
		destinationBox.setBounds(410,340,200,35);
	    add(destinationBox);
	    
	    transportlabel = new JLabel("装运形式");
	    transportlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    transportlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    transportlabel.setBounds(15,350,600,160);
	    add(transportlabel);
	    
	    String[] transportlist = new String[]{"火车","飞机","汽车"};
	    transportbox = new JComboBox(transportlist);
	    transportbox.setFont(new Font("幼圆", Font.BOLD, 30));
	    transportbox.setBounds(410,415,200,35);
	    add(transportbox);
	    
	    centralidlabel = new JLabel("中转编号");
	    centralidlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    centralidlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    centralidlabel.setBounds(15,425,600,160);
	    add(centralidlabel);
	    
	    centralidfield = new JTextField();
	    centralidfield.setBounds(410, 490, 200, 35);
	    add(centralidfield);
	    
	    //出库单录入按钮
	    inputbutton = new JButton("录入");
	    inputbutton.setFont(new Font("幼圆",Font.BOLD,25));
	    inputbutton.setBounds(390,535, 100, 50);
	    add(inputbutton);
	    inputbutton.addActionListener(this);
	    
	    //出库单返回按钮
	    returnbutton = new JButton("返回");
	    returnbutton.setFont(new Font("幼圆", Font.BOLD, 15));
	    returnbutton.setBounds(5, 5, 80, 40);
	    add(returnbutton);
	    returnbutton.addActionListener(this);
	    }
		
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==returnbutton){
			MainFrame.setContentPanel(new StorageOptionUI());
		}
		else if(e.getSource()==inputbutton){
			StorageBL out = new StorageBL();
			Long outtime=Long.parseLong(outfield.getText().trim())*10000+Long.parseLong(mfield.getText().trim())*100+Long.parseLong(dfield.getText().trim());
			String destination=null;
			String transport=null;
			
			if(destinationBox.getSelectedItem().toString()=="广州")destination="guangzhou";
			if(destinationBox.getSelectedItem().toString()=="南京")destination="nanjing";
			if(destinationBox.getSelectedItem().toString()=="上海")destination="shanghai";
			if(destinationBox.getSelectedItem().toString()=="北京")destination="beijing";
			
			if(transportbox.getSelectedItem().toString().trim()=="火车")transport="train";
			if(transportbox.getSelectedItem().toString().trim()=="汽车")transport="vechile";
			if(transportbox.getSelectedItem().toString().trim()=="飞机")transport="plane";
		
			
			if(idfield.getText().trim().equals("")||outfield.getText().trim().equals("")||mfield.getText().trim().equals("")||dfield.getText().trim().equals("")||centralidfield.getText().trim().equals("")){
				StorageErrorUI error = new StorageErrorUI();
			}
			else if(out.inputout(idfield.getText().trim(), outtime, Long.parseLong(centralidfield.getText().trim()), destination,transport )){
				StorageSuccessUI success=new StorageSuccessUI();
			}
			else{
				StorageExistUI exist = new StorageExistUI();
			}
		}
	}

}
