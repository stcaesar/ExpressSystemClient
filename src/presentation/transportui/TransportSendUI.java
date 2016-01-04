package presentation.transportui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




import businesslogic.transportbl.TransportSendBL;
import po.TransportSendPO;
import presentation.mainframe.MainFrame;

public class TransportSendUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel flightlabel;
	private JLabel senddatelabel;
	private JLabel startaddresslabel;
	private JLabel endaddresslabel;
	private JLabel sendtranscodelabel;
	private JLabel watcherlabel;
	private JLabel farelabel;
	private JLabel centercode;
	private JButton savebutton;
	private JButton quitbutton;
	
	private JTextField centerfield;
	private JTextField flightfield;
	private JTextField senddatefield;
	private JTextField startaddressfield;
	private JTextField endaddressfield;
	private JComboBox sendway;	
	private JTextField sendtranscodefield;
	private JTextField watcherfield;
	private JTextField farefield;
	TransportSendPO transportsendpo=new TransportSendPO();
	TransportSendBL transportsendbl=new TransportSendBL();
	public TransportSendUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("中转中心装运");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(337, 40, 250, 80);
		add(titlelabel);
		
		centercode= new JLabel("中转中心编号:");
		centercode.setFont(new Font("幼圆", Font.BOLD, 20));
		centercode.setHorizontalAlignment(SwingConstants.CENTER);
		centercode.setBounds(210, 108, 150, 30);
		add(centercode);
		
		flightlabel= new JLabel("航班编号:");
		flightlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		flightlabel.setHorizontalAlignment(SwingConstants.CENTER);
		flightlabel.setBounds(225, 150, 100, 30);
		add(flightlabel);
		
		senddatelabel= new JLabel("装运日期:");
		senddatelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		senddatelabel.setHorizontalAlignment(SwingConstants.CENTER);
		senddatelabel.setBounds(225, 192, 100, 30);
		add(senddatelabel);
		
		startaddresslabel= new JLabel("出发地点:");
		startaddresslabel.setFont(new Font("幼圆", Font.BOLD, 20));
		startaddresslabel.setHorizontalAlignment(SwingConstants.CENTER);
		startaddresslabel.setBounds(225, 234, 100, 30);
		add(startaddresslabel);

		endaddresslabel= new JLabel("目的地点:");
		endaddresslabel.setFont(new Font("幼圆", Font.BOLD, 20));
		endaddresslabel.setHorizontalAlignment(SwingConstants.CENTER);
		endaddresslabel.setBounds(225, 276, 100, 30);
		add(endaddresslabel);

		sendtranscodelabel= new JLabel("中转单编号:");
		sendtranscodelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		sendtranscodelabel.setHorizontalAlignment(SwingConstants.CENTER);
		sendtranscodelabel.setBounds(210, 318, 150, 30);
		add(sendtranscodelabel);
		
		watcherlabel= new JLabel("监装员:");
		watcherlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		watcherlabel.setHorizontalAlignment(SwingConstants.CENTER);
		watcherlabel.setBounds(215, 360, 100, 30);
		add(watcherlabel);
		
		farelabel= new JLabel("运费:");
		farelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		farelabel.setHorizontalAlignment(SwingConstants.CENTER);
		farelabel.setBounds(205, 400, 100, 30);
		add(farelabel);
		
		savebutton=new JButton("保存");
		savebutton.setFont(new Font("幼圆", Font.BOLD, 20));
		savebutton.setHorizontalAlignment(SwingConstants.CENTER);
		savebutton.setBounds(225, 450, 100, 30);
		add(savebutton);
		savebutton.addActionListener(this);
		
		quitbutton=new JButton("取消");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(500, 450, 100, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		
		flightfield=new JTextField();
		flightfield.setBounds(480,150,220,30);
		add(flightfield);
		
		String[] recvstatelist = new String[]{"飞机","火车","汽车",};
		sendway = new JComboBox(recvstatelist);
		sendway.setFont(new Font("幼圆", Font.BOLD, 20));
		sendway.setBounds(400, 150, 70, 30);
		add(sendway);
		
		senddatefield=new JTextField();
		senddatefield.setBounds(400,192,300,30);
		senddatefield.setText("日期格式：XXXX/XX/XX");
		add(senddatefield);
	
		centerfield=new JTextField();
		centerfield.setBounds(400,108,300,30);
		centerfield.setText("城市编号+营业厅+中转中心（例：025 0 00）");
		add(centerfield);
		
		startaddressfield=new JTextField();
		startaddressfield.setBounds(400,234,300,30);
		add(startaddressfield);
		
		endaddressfield=new JTextField();
		endaddressfield.setBounds(400,276,300,30);
		add(endaddressfield);
		
		sendtranscodefield=new JTextField();
		sendtranscodefield.setBounds(400,318,300,30);
		sendtranscodefield.setText("七位数字");
		add(sendtranscodefield);
		
		watcherfield=new JTextField();
		watcherfield.setBounds(400,360,300,30);
		add(watcherfield);
		
		farefield=new JTextField();
		farefield.setBounds(400,400,300,30);
		add(farefield);
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new TransportMainUI());
		}
		else if(e.getSource()==savebutton){
			if(sendtranscodefield.getText().trim().equals("")||flightfield.getText().trim().equals("")||
					senddatefield.getText().trim().equals("")||startaddressfield.getText().trim().equals("")||
					endaddressfield.getText().trim().equals("")||watcherfield.getText().trim().equals("")||
					farefield.getText().trim().equals("")){
				MainFrame.showmessage("请填写完整");
			}
			else if(!(sendtranscodefield.getText().trim().equals("")||flightfield.getText().trim().equals("")||
					senddatefield.getText().trim().equals("")||startaddressfield.getText().trim().equals("")||
					endaddressfield.getText().trim().equals("")||watcherfield.getText().trim().equals("")||
					farefield.getText().trim().equals(""))){
			TransportSendPO transportsendpo=new TransportSendPO();
			final String centerid=centerfield.getText().trim();
			final String Flight=flightfield.getText().trim();
			String Way="";
			final String Startaddress=startaddressfield.getText().trim();
			final String Endaddress=endaddressfield.getText().trim();
			final String Watcherid=watcherfield.getText().trim();
			final double Fare=Double.parseDouble(farefield.getText());	
			final String Senddate=senddatefield.getText().trim();
			final String Sendtranscode=sendtranscodefield.getText().trim();
			final String Read="unchecked";
			if(sendway.getSelectedItem().equals("飞机")){
				Way="plane";
			}
			else if(sendway.getSelectedItem().equals("火车")){
				Way="train";
			}
			else if(sendway.getSelectedItem().equals("汽车")){
				Way="vehicle";
			}
			
			
				if(transportsendbl.addSendlist(Sendtranscode,Flight,Way,Senddate,Startaddress,Endaddress,Watcherid,Fare,Read)){
				MainFrame.showmessage("保存成功");}
				else{
					MainFrame.showmessage("已存在该装运单");
				}
			
			}
			
		}
	}

}
