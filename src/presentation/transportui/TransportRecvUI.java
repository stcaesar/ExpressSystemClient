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





import businesslogic.transportbl.TransportRecvBL;
import po.TransportRecvPO;
import presentation.mainframe.MainFrame;

public class TransportRecvUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel packageidlabel;
	private JLabel recvdatelabel;
	private JLabel startaddresslabel;
	private JLabel recvstatelabel;
	private JLabel recvtranscodelabel;
	private JButton savebutton;
	private JButton quitbutton;
	private JTextField packageidfield;
	private JTextField recvdatefield;
	private JTextField startaddressfield;
	private JComboBox recvstatebox;	
	private JTextField recvtranscodefield;
	TransportRecvPO transportrecvpo=new TransportRecvPO();
	TransportRecvBL transportrecvbl=new TransportRecvBL();
	public TransportRecvUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("中转中心接收");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(337, 40, 250, 80);
		add(titlelabel);
		
		packageidlabel= new JLabel("中转中心编号:");
		packageidlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		packageidlabel.setHorizontalAlignment(SwingConstants.CENTER);
		packageidlabel.setBounds(220, 150, 150, 30);
		add(packageidlabel);
		
		recvdatelabel= new JLabel("接收日期:");
		recvdatelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		recvdatelabel.setHorizontalAlignment(SwingConstants.CENTER);
		recvdatelabel.setBounds(225, 212, 100, 30);
		add(recvdatelabel);
		
		startaddresslabel= new JLabel("出发地点:");
		startaddresslabel.setFont(new Font("幼圆", Font.BOLD, 20));
		startaddresslabel.setHorizontalAlignment(SwingConstants.CENTER);
		startaddresslabel.setBounds(225, 275, 100, 30);
		add(startaddresslabel);
		
		recvstatelabel= new JLabel("接收状态:");
		recvstatelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		recvstatelabel.setHorizontalAlignment(SwingConstants.CENTER);
		recvstatelabel.setBounds(225, 337, 100, 30);
		add(recvstatelabel);
		
		
		
		recvtranscodelabel= new JLabel("中转单编号:");
		recvtranscodelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		recvtranscodelabel.setHorizontalAlignment(SwingConstants.CENTER);
		recvtranscodelabel.setBounds(210, 400, 150, 30);
		add(recvtranscodelabel);
		
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
		
		packageidfield=new JTextField();
		packageidfield.setBounds(400,150,300,30);
		packageidfield.setText("城市编号+营业厅+中转中心（例：025 0 00）");
		add(packageidfield);
		
		
		recvdatefield=new JTextField();
		recvdatefield.setBounds(400,212,300,30);
		recvdatefield.setText("日期格式：XXXX/XX/XX");
		add(recvdatefield);
	
		
		startaddressfield=new JTextField();
		startaddressfield.setBounds(400,275,300,30);
		add(startaddressfield);
		
		
		
		String[] recvstatelist = new String[]{"完整","损坏","丢失",};
		recvstatebox = new JComboBox(recvstatelist);
		recvstatebox.setFont(new Font("幼圆", Font.BOLD, 20));
		recvstatebox.setBounds(400, 337, 100, 30);
		add(recvstatebox);
		
		recvtranscodefield=new JTextField();
		recvtranscodefield.setBounds(400,400,300,30);
		recvtranscodefield.setText("七位数字");
		add(recvtranscodefield);
		
		
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new TransportMainUI());
		}
		else if(e.getSource()==savebutton){
			if(packageidfield.getText().trim().equals("")||recvdatefield.getText().trim().equals("")||startaddressfield.getText().trim().equals("")||
					recvtranscodefield.getText().trim().equals("")){
				MainFrame.showmessage("请填写完整");
			}
			else{
			final String Packageid=packageidfield.getText().trim();
			final String Recvdate=recvdatefield.getText().trim();
			final String Recvstartaddress=startaddressfield.getText().trim();
			final String Recvtranscode=recvtranscodefield.getText().trim();
			final String Read="unchecked";
			String Recvstate=null;
			if(recvstatebox.getSelectedItem().equals("完整")){
				Recvstate="safe";
			}
			else if(recvstatebox.getSelectedItem().equals("丢失")){
				Recvstate="lost";
			}
			else if(recvstatebox.getSelectedItem().equals("损坏")){
				Recvstate="broken";
			}
			TransportRecvBL transportrecvbl=new TransportRecvBL();
			if(transportrecvbl.addRecvlist(Packageid,Recvdate,Recvstartaddress,Recvstate,Recvtranscode,Read)){
				MainFrame.showmessage("保存成功");
			}
			else{
				MainFrame.showmessage("已存在该接收单");
			}
			
		}
		}
	}

}