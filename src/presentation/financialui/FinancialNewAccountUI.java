package presentation.financialui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businesslogic.financialbl.FinancialBankaccountBL;
import po.FinancialBankaccountPO;
import presentation.mainframe.MainFrame;

public class FinancialNewAccountUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel serviselabel;
	private JComboBox servisebox;
	private JLabel bankaccountlabel;
	private JLabel moneylabel;
	private JLabel datelabel;
	private JButton savebutton;
	private JButton quitbutton;
	private JTextField bankaccountfield;
	private JTextField moneyfield;
	private JTextField datefield;
	public FinancialNewAccountUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("期初建账");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(337, 40, 250, 80);
		add(titlelabel);
		
		serviselabel= new JLabel("选择操作:");
		serviselabel.setFont(new Font("幼圆", Font.BOLD, 20));
		serviselabel.setHorizontalAlignment(SwingConstants.CENTER);
		serviselabel.setBounds(250, 150, 100, 30);
		add(serviselabel);
		
		
		bankaccountlabel= new JLabel("账户卡号:");
		bankaccountlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		bankaccountlabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankaccountlabel.setBounds(250, 200, 100, 30);
		add(bankaccountlabel);
		
		moneylabel= new JLabel("金额:");
		moneylabel.setFont(new Font("幼圆", Font.BOLD, 20));
		moneylabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneylabel.setBounds(250, 250, 100, 30);
		add(moneylabel);
		
		datelabel= new JLabel("日期:");
		datelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		datelabel.setHorizontalAlignment(SwingConstants.CENTER);
		datelabel.setBounds(250, 300, 100, 30);
		add(datelabel);
		
		String[] serviselist = new String[]{"存款","取款"};
		servisebox = new JComboBox(serviselist);
		servisebox.setFont(new Font("幼圆", Font.BOLD, 20));
		servisebox.setBounds(400, 150, 200, 30);
		add(servisebox);
		
		bankaccountfield=new JTextField();
		bankaccountfield.setBounds(400,200,300,30);
		bankaccountfield.setText("");
		add(bankaccountfield);
		
		moneyfield=new JTextField();
		moneyfield.setBounds(400,250,300,30);
		moneyfield.setText("");
		add(moneyfield);
		
		datefield=new JTextField();
		datefield.setBounds(400,300,300,30);
		datefield.setText("");
		add(datefield);
		
		savebutton=new JButton("确定");
		savebutton.setFont(new Font("幼圆", Font.BOLD, 20));
		savebutton.setHorizontalAlignment(SwingConstants.CENTER);
		savebutton.setBounds(250, 550, 100, 30);
		add(savebutton);
		savebutton.addActionListener(this);
		
		quitbutton=new JButton("退出");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(550, 550, 100, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new FinancialMainUI());
		}
		else if(e.getSource()==savebutton){
			if(bankaccountfield.getText().trim().equals("")||moneyfield.getText().trim().equals("")||datefield.getText().trim().equals("")){
				MainFrame.showmessage("请填写完整");
			}
			else{
				String accountnum="";
				String op="";
				double mo=0;
				String da="";
				accountnum=bankaccountfield.getText().trim();
				da=datefield.getText().trim();
				mo=Double.parseDouble(moneyfield.getText().trim());
				if(servisebox.getSelectedItem().equals("存款")){
					op="存入";
				}
				else{
					op="取出";
				}
				FinancialBankaccountPO bankaccountpo=new FinancialBankaccountPO(accountnum,op,mo,da);
				FinancialBankaccountBL bankaccountbl=new FinancialBankaccountBL();
				bankaccountbl.insertOperation(accountnum, op, mo, da);
				MainFrame.showmessage("保存成功");
			}
		}
	}
}
