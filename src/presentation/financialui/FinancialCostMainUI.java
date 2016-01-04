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

import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;
public class FinancialCostMainUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JButton farebutton;
	private JButton rentbutton;
	private JButton salarybutton;
	private JButton quitbutton;
	public FinancialCostMainUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("成本管理");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(315, 40, 250, 80);
		add(titlelabel);
		
		farebutton=new JButton("运费查询");
		farebutton.setFont(new Font("幼圆", Font.BOLD, 20));
		farebutton.setHorizontalAlignment(SwingConstants.CENTER);
		farebutton.setBounds(350,150, 150, 30);
		add(farebutton);
		farebutton.addActionListener(this);
		
		rentbutton=new JButton("租金查询");
		rentbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		rentbutton.setHorizontalAlignment(SwingConstants.CENTER);
		rentbutton.setBounds(350,275, 150, 30);
		
		//rentbutton.addActionListener(this);
		
		salarybutton=new JButton("工资查询");
		salarybutton.setFont(new Font("幼圆", Font.BOLD, 20));
		salarybutton.setHorizontalAlignment(SwingConstants.CENTER);
		salarybutton.setBounds(350,275, 150, 30);
		add(salarybutton);
		salarybutton.addActionListener(this);
		
		quitbutton=new JButton("退出");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(370, 525, 100, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent e){
	if(e.getSource()==quitbutton){
		MainFrame.setContentPanel(new FinancialMainUI());
	}
	else if(e.getSource()==farebutton){
		MainFrame.setContentPanel(new FinancialCostFareUI());
	}
	else if(e.getSource()==rentbutton){
		MainFrame.setContentPanel(new FinancialCostRentUI());
	}
	else if(e.getSource()==salarybutton){
		MainFrame.setContentPanel(new FinancialCostSalaryUI());
	}
}
}