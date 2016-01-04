package presentation.courierui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businesslogic.courierbl.CourierBL;
import po.OrderListPO;
import presentation.mainframe.MainFrame;

public class ChangeOrderUI extends JPanel implements ActionListener{
	OrderListPO orderlist;
	
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
	private JLabel listidlb1;
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
	private JButton checkbt;
	private JButton backbt;
	
	public ChangeOrderUI(OrderListPO list){
		orderlist = CourierBL.getorderlist(list);
		
		setBounds(200,0,900,650);
		setLayout(null);
		
		titlelabel= new JLabel("订单查询修改");
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
		
		listidlb1= new JLabel(orderlist.getlistid());
		listidlb1.setFont(new Font("幼圆", Font.BOLD, 20));
		listidlb1.setHorizontalAlignment(SwingConstants.CENTER);
		listidlb1.setBounds(10, 300, 260, 40);
		add(listidlb1);
		
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
		
		allcostlb= new JLabel(String.valueOf(orderlist.getallcost()));
		allcostlb.setFont(new Font("幼圆", Font.BOLD, 20));
		allcostlb.setBounds(460, 460, 200, 40);
		add(allcostlb);
		
		Snametf = new JTextField(orderlist.getSname());
		Snametf.setBounds(150, 60, 200, 20);
		add(Snametf);
		
		String[] Saddress = orderlist.getSaddress().split("/");
		Saddresstf = new JTextField(Saddress[1]);
		Saddresstf.setBounds(240, 110, 200, 20);
		add(Saddresstf);
		
		Sworkptf = new JTextField(orderlist.getSworkp());
		Sworkptf.setBounds(150, 160, 200, 20);
		add(Sworkptf);
		
		Sphonetf = new JTextField(orderlist.getSphone());
		Sphonetf.setBounds(150, 210, 200, 20);
		add(Sphonetf);
		
		Smoblietf = new JTextField(orderlist.getSmoblie());
		Smoblietf.setBounds(150, 260, 200, 20);
		add(Smoblietf);
		
		Rnametf = new JTextField(orderlist.getRname());
		Rnametf.setBounds(530, 60, 200, 20);
		add(Rnametf);
		
		String[] Raddress = orderlist.getRaddress().split("/");
		Raddresstf = new JTextField(Raddress[1]);
		Raddresstf.setBounds(620, 110, 200, 20);
		add(Raddresstf);
		
		Rworkptf = new JTextField(orderlist.getRworkp());
		Rworkptf.setBounds(530, 160, 200, 20);
		add(Rworkptf);
		
		Rphonetf = new JTextField(orderlist.getRphone());
		Rphonetf.setBounds(530, 210, 200, 20);
		add(Rphonetf);
		
		Rmoblietf = new JTextField(orderlist.getRmoblie());
		Rmoblietf.setBounds(530, 260, 200, 20);
		add(Rmoblietf);
		
		
		goodnumtf = new JTextField(String.valueOf(orderlist.getgoodnum()));
		goodnumtf.setBounds(130, 360, 200, 20);
		add(goodnumtf);
		
		goodMtf = new JTextField(String.valueOf(orderlist.getgoodM()));
		goodMtf.setBounds(410, 360, 200, 20);
		add(goodMtf);
		
		goodVtf = new JTextField(String.valueOf(orderlist.getgoodV()));
		goodVtf.setBounds(710, 360, 150, 20);
		add(goodVtf);
		
		goodsytletf = new JTextField(orderlist.getgoodsytle());
		goodsytletf.setBounds(200, 410, 200, 20);
		add(goodsytletf);
		
		goodsizetf = new JTextField(orderlist.getgoodsize());
		goodsizetf.setBounds(600, 410, 200, 20);
		add(goodsizetf);
		
		String[] SaddressList = new String[]{"北京","上海","广州","南京"};
		Saddresscb = new JComboBox(SaddressList);
		Saddresscb.setFont(new Font("幼圆", Font.BOLD, 20));
		Saddresscb.setBounds(150, 100, 80, 30);
		Saddresscb.setSelectedItem(Saddress[0]);
		add(Saddresscb);
		
		String[] RaddressList = new String[]{"北京","上海","广州","南京"};
		Raddresscb = new JComboBox(RaddressList);
		Raddresscb.setFont(new Font("幼圆", Font.BOLD, 20));
		Raddresscb.setBounds(530, 100, 80, 30);
		Raddresscb.setSelectedItem(Raddress[0]);
		add(Raddresscb);
		
		String packagetype = "";
		String expresstype = "";
    	switch (orderlist.getpackagetype()) {
			case "zhixiang":
				packagetype = "纸箱";
				break;
			case "muxiang":
				packagetype = "木箱";		
				break;
			case "kuaididai":
				packagetype = "快递袋";
				break;
			case "other":
				packagetype	="其他";			
				break;
			default:
				break;
		}
    	switch (orderlist.getexpresstype()) {
		case "jinji":
			expresstype = "经济快递";
			break;
		case "biaozhun":
			expresstype = "标准快递";		
			break;
		case "tekuai":
			expresstype = "特快专递";
			break;
		default:
			break;//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
		
		String[] packageList = new String[]{"ֽ纸箱","木箱","快递袋","其他"};
		packagetypecb = new JComboBox(packageList);
		packagetypecb.setFont(new Font("幼圆", Font.BOLD, 20));
		packagetypecb.setBounds(420, 300, 150, 40);
		packagetypecb.setSelectedItem(packagetype);
		add(packagetypecb);
		
		String[] expressList = new String[]{"经济快递","标准快递","特快专递"};
		expresstypecb = new JComboBox(expressList);
		expresstypecb.setFont(new Font("幼圆", Font.BOLD, 20));
		expresstypecb.setBounds(670, 300, 150, 40);
		expresstypecb.setSelectedItem(expresstype);
		add(expresstypecb);

		allcostbt = new JButton("报价");
		allcostbt.setFont(new Font("幼圆", Font.BOLD, 20));
		allcostbt.setHorizontalAlignment(SwingConstants.CENTER);
		allcostbt.setBounds(300, 460, 80, 40);
		allcostbt.setFocusPainted(false);
		add(allcostbt);
		allcostbt.addActionListener(this);
		
		checkbt = new JButton("确认修改");
		checkbt.setFont(new Font("幼圆", Font.BOLD, 20));
		checkbt.setHorizontalAlignment(SwingConstants.CENTER);
		checkbt.setBounds(300, 530, 120, 50);
		checkbt.setFocusPainted(false);
		add(checkbt);
		checkbt.addActionListener(this);
		
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

		if(e.getSource()==checkbt){
			change();
		}
		else if(e.getSource()==allcostbt){
			double allcost = 0;
			allcost = getallcost();
			allcostlb.setText(String.valueOf(allcost));
			System.out.println("frerf"+allcost);
		}
		else if(e.getSource()==backbt){
			MainFrame.setContentPanel(new ManageOrderUI());
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
	
	public void change(){
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
		String packagetype = (String)packagetypecb.getSelectedItem();
		String expresstype = (String)expresstypecb.getSelectedItem();
		String allcost = allcostlb.getText().trim();
		if(allcost.equals("")||Sname.equals("")||Rname.equals("")||Saddress.equals("")||Raddress.equals("")||Sworkp.equals("")||Rworkp.equals("")||Sphone.equals("")||Rphone.equals("")||Smoblie.equals("")||Rmoblie.equals("")||goodsytle.equals("")||goodsize.equals("")||goodnum.equals("")||goodM.equals("")||goodV.equals(""))
		{
			MainFrame.showmessage("请输入完整");
		}
		else{
			OrderListPO resultorderlist = new OrderListPO();
			resultorderlist.setlistid(orderlist.getlistid());
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
//        	resultorderlist = CourierBL.caculate(resultorderlist);//ʱ��ͱ��ۼ���
        	if(CourierBL.delorderlist(orderlist)){
        		if(CourierBL.saveorderlist(resultorderlist)){
        			MainFrame.showmessage("订单修改成功");
        		}
        	}
        	else{
        		MainFrame.showmessage("修改失败");
        	}
		}
	}
}
