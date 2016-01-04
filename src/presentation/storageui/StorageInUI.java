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

import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
import businesslogic.storagebl.StorageBL;

public class StorageInUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel idlabel;
	private JLabel intimelabel;
	private JLabel districtlabel;
	private JLabel rowlabel;
	private JLabel shelflabel;
	private JLabel numberlabel;
	private JLabel destinationlabel;
	private JLabel ylabel;
	private JLabel mlabel;
	private JLabel dlabel;
	private JTextField mfield;
	private JTextField dfield;
	private JComboBox destinationBox;
	private JTextField idfield;
	private JTextField intimefield;
	private JTextField districtfield;
	private JTextField rowfield;
	private JTextField shelffield;
	private JTextField numberfield;
	private JButton inputbutton;
	private JButton returnbutton;
	
	public StorageInUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		//入库单的标记和输入框
	    titlelabel = new JLabel("库存入库单");
	    titlelabel.setFont(new Font("幼圆",Font.BOLD,70));
	    titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
	    titlelabel.setBounds(135, 10, 600, 160);
	    add(titlelabel);
	    
	    idlabel = new JLabel("快递编号");
	    idlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    idlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    idlabel.setBounds(15, 100, 600, 160);
	    add(idlabel);
	    
	    idfield = new JTextField();
	    idfield.setBounds(410,165, 200, 35);
	    add(idfield);
	    
	    intimelabel = new JLabel("到达时间");
	    intimelabel.setFont(new Font("幼圆",Font.BOLD,30));
	    intimelabel.setHorizontalAlignment(SwingConstants.CENTER);
	    intimelabel.setBounds(15, 150, 600, 160);
	    add(intimelabel);
	    
	    intimefield = new JTextField();
	    intimefield.setBounds(410,215,70, 35);
	    add(intimefield);
	    
	    ylabel = new JLabel("年");
	    ylabel.setFont(new Font("幼圆",Font.BOLD,30));
	    ylabel.setHorizontalAlignment(SwingConstants.CENTER);
	    ylabel.setBounds(200, 150, 600, 160);
	    add(ylabel);
	    
	    mfield = new JTextField();
	    mfield.setBounds(520,215,60,35);
	    add(mfield);
	    
	    mlabel = new JLabel("月");
	    mlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    mlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    mlabel.setBounds(300, 150, 600, 160);
	    add(mlabel);
	    
	    dfield = new JTextField();
	    dfield.setBounds(620,215,60,35);
	    add(dfield);
	    
	    dlabel = new JLabel("日");
	    dlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    dlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    dlabel.setBounds(400, 150, 600, 160);
	    add(dlabel);
	    
	    districtlabel = new JLabel("区号");
	    districtlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    districtlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    districtlabel.setBounds(45, 200, 600, 160);
	    add(districtlabel);
	    
	    districtfield = new JTextField();
	    districtfield.setBounds(410,265, 200, 35);
	    add(districtfield);
	    
	    rowlabel = new JLabel("排号");
	    rowlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    rowlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    rowlabel.setBounds(45, 250, 600, 160);
	    add(rowlabel);
	    
	    rowfield = new JTextField();
	    rowfield.setBounds(410,315, 200, 35);
	    add(rowfield);
	
	    shelflabel = new JLabel("架号");
	    shelflabel.setFont(new Font("幼圆",Font.BOLD,30));
	    shelflabel.setHorizontalAlignment(SwingConstants.CENTER);
	    shelflabel.setBounds(45, 300, 600, 160);
	    add(shelflabel);
	    
	    shelffield = new JTextField();
	    shelffield.setBounds(410,365, 200, 35);
	    add(shelffield);
	    
	    numberlabel = new JLabel("位号");
	    numberlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    numberlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    numberlabel.setBounds(45, 350, 600, 160);
	    add(numberlabel);
	    
	    numberfield = new JTextField();
	    numberfield.setBounds(410,415, 200, 35);
	    add(numberfield);
	    
	    numberlabel = new JLabel("到达地");
	    numberlabel.setFont(new Font("幼圆",Font.BOLD,30));
	    numberlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    numberlabel.setBounds(30, 400, 600, 160);
	    add(numberlabel);
	    
	    String[] rolelist = new String[]{"北京","上海","广州", "南京"};
	    destinationBox = new JComboBox(rolelist);
	    destinationBox.setFont(new Font("幼圆", Font.BOLD, 30));
	    destinationBox.setBounds(410,465,200,35);
	    add(destinationBox);
	    
	    //入库单的按钮
	    returnbutton = new JButton("返回");
	    returnbutton.setFont(new Font("幼圆", Font.BOLD, 15));
	    returnbutton.setBounds(5, 5, 80, 40);
	    add(returnbutton);
	    returnbutton.addActionListener(this);
	    
	    inputbutton = new JButton("录入");
	    inputbutton.setFont(new Font("幼圆",Font.BOLD,25));
	    inputbutton.setBounds(390,525, 100, 50);
	    add(inputbutton);
	    inputbutton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==returnbutton){
			MainFrame.setContentPanel(new StorageOptionUI());
		}
		else if(e.getSource()==inputbutton){
			StorageBL in = new StorageBL();
			boolean judge=false;
			Long intime=Long.parseLong(intimefield.getText().trim())*10000+Long.parseLong(mfield.getText().trim())*100+Long.parseLong(dfield.getText().trim());
			if(idfield.getText().trim().equals("")||intimefield.getText().trim().equals("")||mfield.getText().trim().equals("")||dfield.getText().trim().equals("")||districtfield.getText().trim().equals("")||rowfield.getText().trim().equals("")||shelffield.getText().trim().equals("")||numberfield.getText().trim().equals("")){
				StorageErrorUI error = new StorageErrorUI();
			}
			if(destinationBox.getSelectedItem().toString().trim()=="广州"){
				judge=in.inputin(idfield.getText().trim(),intime, "guangzhou", Long.parseLong(districtfield.getText().trim()),Long.parseLong(rowfield.getText().trim()), Long.parseLong(shelffield.getText().trim()), Long.parseLong(numberfield.getText().trim()));
			}
			else if(destinationBox.getSelectedItem().toString().trim()=="北京"){
				judge=in.inputin(idfield.getText().trim(),intime, "beijing", Long.parseLong(districtfield.getText().trim()),Long.parseLong(rowfield.getText().trim()), Long.parseLong(shelffield.getText().trim()), Long.parseLong(numberfield.getText().trim()));
			}
			else if(destinationBox.getSelectedItem().toString().trim()=="上海"){
				judge=in.inputin(idfield.getText().trim(),intime, "shanghai", Long.parseLong(districtfield.getText().trim()),Long.parseLong(rowfield.getText().trim()), Long.parseLong(shelffield.getText().trim()), Long.parseLong(numberfield.getText().trim()));
			}
			else if(destinationBox.getSelectedItem().toString().trim()=="南京"){
				judge=in.inputin(idfield.getText().trim(),intime, "nanjing", Long.parseLong(districtfield.getText().trim()),Long.parseLong(rowfield.getText().trim()), Long.parseLong(shelffield.getText().trim()), Long.parseLong(numberfield.getText().trim()));
			}
			if(judge){
				StorageSuccessUI success=new StorageSuccessUI();
			}
			else{
				StorageExistUI exist = new StorageExistUI();
			}
		}
	
	}
	

}
