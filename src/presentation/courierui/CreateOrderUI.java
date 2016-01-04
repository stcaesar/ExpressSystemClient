package presentation.courierui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businesslogic.courierbl.CourierBL;
import po.OrderListPO;
import presentation.factory.SaveLabel;
import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class CreateOrderUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel Snamelb;
	private JLabel Saddresslb;
	private JLabel Sworkplb;
	private JLabel Sphonelb;
	private JLabel Smoblielb;
	private JLabel Rnamelb;
	private JLabel Raddresslb;
	private JLabel Rworkplb;
	private JLabel Rphonelb;
	private JLabel Rmoblielb;
	private JLabel listidlb;
	private JLabel packagetypelb;
	private JLabel expresstypelb;
	private JLabel goodnumlb;
	private JLabel goodMlb;
	private JLabel goodVlb;
	private JLabel goodsytlelb;
	private JLabel goodsizelb;
	private JLabel allcostlb;
	
	private JTextField Snametf;
	private JTextField Saddresstf;
	private JTextField Sworkptf;
	private JTextField Sphonetf;
	private JTextField Smoblietf;
	private JTextField Rnametf;
	private JTextField Raddresstf;
	private JTextField Rworkptf;
	private JTextField Rphonetf;
	private JTextField Rmoblietf;
	private JTextField listidtf;
	private JTextField goodnumtf;
	private JTextField goodMtf;
	private JTextField goodVtf;
	private JTextField goodsytletf;
	private JTextField goodsizetf;


	private JComboBox Saddresscb;
	private JComboBox Raddresscb;
	private JComboBox packagetypecb;
	private JComboBox expresstypecb;
	
	private JButton allcostbt;
	private JButton backbt;
	
	SaveLabel saveicon;
	
	public CreateOrderUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		
		titlelabel= new JLabel("订单创建");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 30));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(200, 0, 450, 40);
		add(titlelabel);
		
		Snamelb= new JLabel("寄件人姓名");
		Snamelb.setFont(new Font("幼圆", Font.BOLD, 20));
		Snamelb.setHorizontalAlignment(SwingConstants.CENTER);
		Snamelb.setBounds(20, 50, 120, 40);
		add(Snamelb);
		
		Saddresslb= new JLabel("住址");
		Saddresslb.setFont(new Font("幼圆", Font.BOLD, 20));
		Saddresslb.setHorizontalAlignment(SwingConstants.CENTER);
		Saddresslb.setBounds(90, 100, 60, 40);
		add(Saddresslb);
		
		Sworkplb= new JLabel("单位");
		Sworkplb.setFont(new Font("幼圆", Font.BOLD, 20));
		Sworkplb.setHorizontalAlignment(SwingConstants.CENTER);
		Sworkplb.setBounds(90, 150, 60, 40);
		add(Sworkplb);
		
		Sphonelb= new JLabel("电话");
		Sphonelb.setFont(new Font("幼圆", Font.BOLD, 20));
		Sphonelb.setHorizontalAlignment(SwingConstants.CENTER);
		Sphonelb.setBounds(90, 200, 60, 40);
		add(Sphonelb);
		
		Smoblielb= new JLabel("手机");
		Smoblielb.setFont(new Font("幼圆", Font.BOLD, 20));
		Smoblielb.setHorizontalAlignment(SwingConstants.CENTER);
		Smoblielb.setBounds(90, 250, 60, 40);
		add(Smoblielb);
		
		Rnamelb= new JLabel("收件人姓名");
		Rnamelb.setFont(new Font("幼圆", Font.BOLD, 20));
		Rnamelb.setHorizontalAlignment(SwingConstants.CENTER);
		Rnamelb.setBounds(400, 50, 120, 40);
		add(Rnamelb);
		
		Raddresslb= new JLabel("住址");
		Raddresslb.setFont(new Font("幼圆", Font.BOLD, 20));
		Raddresslb.setHorizontalAlignment(SwingConstants.CENTER);
		Raddresslb.setBounds(470, 100, 60, 40);
		add(Raddresslb);
		
		Rworkplb= new JLabel("单位");
		Rworkplb.setFont(new Font("幼圆", Font.BOLD, 20));
		Rworkplb.setHorizontalAlignment(SwingConstants.CENTER);
		Rworkplb.setBounds(470, 150, 60, 40);
		add(Rworkplb);
		
		Rphonelb= new JLabel("电话");
		Rphonelb.setFont(new Font("幼圆", Font.BOLD, 20));
		Rphonelb.setHorizontalAlignment(SwingConstants.CENTER);
		Rphonelb.setBounds(470, 200, 60, 40);
		add(Rphonelb);
		
		Rmoblielb= new JLabel("手机");
		Rmoblielb.setFont(new Font("幼圆", Font.BOLD, 20));
		Rmoblielb.setHorizontalAlignment(SwingConstants.CENTER);
		Rmoblielb.setBounds(470, 250, 60, 40);
		add(Rmoblielb);
		
		listidlb= new JLabel("订单号");
		listidlb.setFont(new Font("幼圆", Font.BOLD, 20));
		listidlb.setHorizontalAlignment(SwingConstants.CENTER);
		listidlb.setBounds(10, 300, 80, 40);
		add(listidlb);
		
		packagetypelb= new JLabel("包装");
		packagetypelb.setFont(new Font("幼圆", Font.BOLD, 20));
		packagetypelb.setHorizontalAlignment(SwingConstants.CENTER);
		packagetypelb.setBounds(310, 300, 100, 40);
		add(packagetypelb);
		
		expresstypelb= new JLabel("快递");
		expresstypelb.setFont(new Font("幼圆", Font.BOLD, 20));
		expresstypelb.setHorizontalAlignment(SwingConstants.CENTER);
		expresstypelb.setBounds(580, 300, 100, 40);
		add(expresstypelb);
		
		goodnumlb= new JLabel("货物原件数");
		goodnumlb.setFont(new Font("幼圆", Font.BOLD, 20));
		goodnumlb.setHorizontalAlignment(SwingConstants.CENTER);
		goodnumlb.setBounds(10, 350, 120, 40);
		add(goodnumlb);
		
		goodMlb= new JLabel("重量");
		goodMlb.setFont(new Font("幼圆", Font.BOLD, 20));
		goodMlb.setHorizontalAlignment(SwingConstants.CENTER);
		goodMlb.setBounds(310, 350, 100, 40);
		add(goodMlb);
		
		goodVlb= new JLabel("体积");
		goodVlb.setFont(new Font("幼圆", Font.BOLD, 20));
		goodVlb.setHorizontalAlignment(SwingConstants.CENTER);
		goodVlb.setBounds(610, 350, 100, 40);
		add(goodVlb);
		
		goodsytlelb= new JLabel("内件品名");
		goodsytlelb.setFont(new Font("幼圆", Font.BOLD, 20));
		goodsytlelb.setHorizontalAlignment(SwingConstants.CENTER);
		goodsytlelb.setBounds(100, 400, 100, 40);
		add(goodsytlelb);
		
		goodsizelb= new JLabel("尺寸");
		goodsizelb.setFont(new Font("幼圆", Font.BOLD, 20));
		goodsizelb.setHorizontalAlignment(SwingConstants.CENTER);
		goodsizelb.setBounds(500, 400, 100, 40);
		add(goodsizelb);
		
		allcostlb= new JLabel("");
		allcostlb.setFont(new Font("幼圆", Font.BOLD, 20));
		allcostlb.setBounds(460, 460, 200, 40);
		add(allcostlb);
		
		Snametf = new JTextField();
		Snametf.setBounds(150, 60, 200, 20);
		add(Snametf);
		
		Saddresstf = new JTextField();
		Saddresstf.setBounds(240, 110, 200, 20);
		add(Saddresstf);
		
		Sworkptf = new JTextField();
		Sworkptf.setBounds(150, 160, 200, 20);
		add(Sworkptf);
		
		Sphonetf = new JTextField();
		Sphonetf.setBounds(150, 210, 200, 20);
		add(Sphonetf);
		
		Smoblietf = new JTextField();
		Smoblietf.setBounds(150, 260, 200, 20);
		add(Smoblietf);
		
		Rnametf = new JTextField();
		Rnametf.setBounds(530, 60, 200, 20);
		add(Rnametf);
		
		Raddresstf = new JTextField();
		Raddresstf.setBounds(620, 110, 200, 20);
		add(Raddresstf);
		
		Rworkptf = new JTextField();
		Rworkptf.setBounds(530, 160, 200, 20);
		add(Rworkptf);
		
		Rphonetf = new JTextField();
		Rphonetf.setBounds(530, 210, 200, 20);
		add(Rphonetf);
		
		Rmoblietf = new JTextField();
		Rmoblietf.setBounds(530, 260, 200, 20);
		add(Rmoblietf);
		
		listidtf = new JTextField();
		listidtf.setBounds(90, 310, 200, 20);
		add(listidtf);
		
		goodnumtf = new JTextField();
		goodnumtf.setBounds(130, 360, 200, 20);
		add(goodnumtf);
		
		goodMtf = new JTextField();
		goodMtf.setBounds(410, 360, 200, 20);
		add(goodMtf);
		
		goodVtf = new JTextField();
		goodVtf.setBounds(710, 360, 150, 20);
		add(goodVtf);
		
		goodsytletf = new JTextField();
		goodsytletf.setBounds(200, 410, 200, 20);
		add(goodsytletf);
		
		goodsizetf = new JTextField();
		goodsizetf.setBounds(600, 410, 200, 20);
		add(goodsizetf);
		
		
	
		String[] SaddressList = new String[]{"北京","上海","广州","南京"};
		Saddresscb = new JComboBox(SaddressList);
		Saddresscb.setFont(new Font("幼圆", Font.BOLD, 20));
		Saddresscb.setBounds(150, 100, 80, 30);
		add(Saddresscb);
		
		String[] RaddressList = new String[]{"北京","上海","广州","南京"};
		Raddresscb = new JComboBox(RaddressList);
		Raddresscb.setFont(new Font("幼圆", Font.BOLD, 20));
		Raddresscb.setBounds(530, 100, 80, 30);
		add(Raddresscb);
		
		String[] packageList = new String[]{"纸箱","木箱","快递袋","其他"};
		packagetypecb = new JComboBox(packageList);
		packagetypecb.setFont(new Font("幼圆", Font.BOLD, 20));
		packagetypecb.setBounds(420, 300, 150, 40);
		add(packagetypecb);
		
		String[] expressList = new String[]{"经济快递","标准快递","特快专递"};
		expresstypecb = new JComboBox(expressList);
		expresstypecb.setFont(new Font("幼圆", Font.BOLD, 20));
		expresstypecb.setBounds(670, 300, 150, 40);
		add(expresstypecb);
		
		allcostbt = new JButton("报价");
		allcostbt.setFont(new Font("幼圆", Font.BOLD, 20));
		allcostbt.setHorizontalAlignment(SwingConstants.CENTER);
		allcostbt.setBounds(300, 460, 80, 40);
		allcostbt.setFocusPainted(false);
		add(allcostbt);
		allcostbt.addActionListener(this);
		
		saveicon = new SaveLabel(380, 530);
		add(saveicon);
		saveicon.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				saveorder();
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				saveicon.setIcon(new ImageIcon("image\\save2.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				saveicon.setIcon(new ImageIcon("image\\save1.png"));

				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		
		
		backbt = new JButton("返回");
		backbt.setFont(new Font("幼圆", Font.BOLD, 20));
		backbt.setHorizontalAlignment(SwingConstants.CENTER);
		backbt.setBounds(500, 530, 100, 50);
		backbt.setFocusPainted(false);
		add(backbt);
		backbt.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==allcostbt){
			double allcost = 0;
			allcost = getallcost();
			allcostlb.setText(String.valueOf(allcost));
			System.out.println("frerf"+allcost);
		}
		else if(e.getSource()==backbt){
			MainFrame.setContentPanel(new CourierUI());
		}
	}

	private double getallcost(){
		double result = 0;
		double mass = 0;
		double packagecost = 0;
		mass = CourierBL.getmass(Double.parseDouble(goodVtf.getText().trim()),Double.parseDouble(goodMtf.getText().trim()));
		result = CourierBL.Getexpresscost((String)Saddresscb.getSelectedItem(),(String)Raddresscb.getSelectedItem(),(String)expresstypecb.getSelectedItem(),mass);
		packagecost = CourierBL.getpcost((String)packagetypecb.getSelectedItem());
		result = result + packagecost;
		return result;
	}
	private void saveorder() {

		String Sname = Snametf.getText().trim();
		String Rname = Rnametf.getText().trim();
		String Saddress = (String)Saddresscb.getSelectedItem()+"/"+Saddresstf.getText().trim();
		String Raddress = (String)Raddresscb.getSelectedItem()+"/"+Raddresstf.getText().trim();
		String Sworkp = Sworkptf.getText().trim();
		String Rworkp = Rworkptf.getText().trim();
		String Sphone = Sphonetf.getText().trim();
		String Rphone = Rphonetf.getText().trim();
		String Smoblie = Smoblietf.getText().trim();
		String Rmoblie = Rmoblietf.getText().trim();
		String goodnum = goodnumtf.getText().trim();
		String goodM = goodMtf.getText().trim();
		String goodV = goodVtf.getText().trim();
		String goodsytle = goodsytletf.getText().trim();
		String goodsize = goodsizetf.getText().trim();
		String listid = listidtf.getText().trim();
		String packagetype = (String)packagetypecb.getSelectedItem();
		String expresstype = (String)expresstypecb.getSelectedItem();
		String allcost = allcostlb.getText().trim();
		if(allcost.equals("")||Sname.equals("")||Rname.equals("")||Saddress.equals("")||Raddress.equals("")||Sworkp.equals("")||Rworkp.equals("")||Sphone.equals("")||Rphone.equals("")||Smoblie.equals("")||Rmoblie.equals("")||listid.equals("")||goodsytle.equals("")||goodsize.equals("")||goodnum.equals("")||goodM.equals("")||goodV.equals(""))
		{
			MainFrame.showmessage("请输入完整");
		}
		else{
			OrderListPO resultorderlist = new OrderListPO();
			resultorderlist.setlistid(listid);;
        	resultorderlist.setSname(Sname);
        	resultorderlist.setRname(Rname);
        	resultorderlist.setSaddress(Saddress);
        	resultorderlist.setRaddress(Raddress);
        	resultorderlist.setSworkp(Sworkp);
        	resultorderlist.setRworkp(Rworkp);
        	resultorderlist.setSphone(Sphone);
        	resultorderlist.setRphone(Rphone);
        	resultorderlist.setSmoblie(Smoblie);
        	resultorderlist.setRmoblie(Rmoblie);
        	resultorderlist.setgoodnum(Integer.parseInt(goodnum));
        	resultorderlist.setgoodM(Double.parseDouble(goodM));
        	resultorderlist.setgoodV(Double.parseDouble(goodV));
        	resultorderlist.setgoodsytle(goodsytle);
        	resultorderlist.setgoodsize(goodsize);
        	resultorderlist.setallcost(Double.parseDouble(allcost));
        	switch (packagetype) {
				case "ֽ纸箱":
					packagetype = "zhixiang";
					break;
				case "木箱":
					packagetype = "muxiang";		
					break;
				case "快递袋":
					packagetype = "kuaididai";
					break;
				case "其他":
					packagetype	="other";			
					break;
				default:
					break;
			}
        	switch (expresstype) {
			case "经济快递":
				expresstype = "jinji";
				break;
			case "标准快递":
				expresstype = "biaozhun";		
				break;
			case "特快专递":
				expresstype = "tekuai";
				break;
			default:
				break;
		}
        	resultorderlist.setpackagetype(packagetype);
        	resultorderlist.setexpresstype(expresstype);
        	
        	Calendar c = Calendar.getInstance();
        	int year = c.get(Calendar.YEAR); 
        	int month = c.get(Calendar.MONTH)+1; 
        	int date = c.get(Calendar.DATE); 
        	resultorderlist.setexcepttime(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(date));
        	
//        	resultorderlist = CourierBL.caculate(resultorderlist);//ʱ��ͱ��ۼ���
        	if(CourierBL.saveorderlist(resultorderlist)){
        		MainFrame.showmessage("订单保存成功");
        		clearTextField();
        	}
        	else{
        		MainFrame.showmessage("订单已存在");
        	}

		}
	}
	
	
	private void clearTextField(){
		Snametf.setText("");
		Rnametf.setText("");
		Saddresstf.setText("");
		Raddresstf.setText("");
		Sworkptf.setText("");
		Rworkptf.setText("");
		Sphonetf.setText("");
		Rphonetf.setText("");
		Smoblietf.setText("");
		Rmoblietf.setText("");
		goodnumtf.setText("");
		goodMtf.setText("");
		goodVtf.setText("");
		goodsytletf.setText("");
		goodsizetf.setText("");
		listidtf.setText("");
		allcostlb.setText("");
	}
}
