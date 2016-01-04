package presentation.financialui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.mainframe.MainFrame;
public class FinancialCostRentUI extends JPanel implements ActionListener{
	private JLabel titlelabel;
	private JLabel centerlabel;
	private JTextField centerfield;
	private JLabel datelabel;
	private JTextField datefield;
	private JButton savebutton;
	private JButton quitbutton;
	
	public FinancialCostRentUI(){
		setBounds(200,0,900,650);
		setLayout(null);
		titlelabel= new JLabel("租金查询");
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 35));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(320, 40, 250, 80);
		add(titlelabel);
		
		centerlabel= new JLabel("营业厅号:");
		centerlabel.setFont(new Font("幼圆", Font.BOLD, 20));
		centerlabel.setHorizontalAlignment(SwingConstants.CENTER);
		centerlabel.setBounds(225, 150, 100, 30);
		add(centerlabel);
		
		centerfield=new JTextField();
		centerfield.setBounds(400,150,300,30);
		add(centerfield);
		
		datelabel= new JLabel("查询日期:");
		datelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		datelabel.setHorizontalAlignment(SwingConstants.CENTER);
		datelabel.setBounds(225, 275, 100, 30);
		add(datelabel);
		
		datefield=new JTextField();
		datefield.setBounds(400,275,300,30);
		datefield.setText("日期格式：XXXX/XX/XX");
		add(datefield);
		
		savebutton=new JButton("确定");
		savebutton.setFont(new Font("幼圆", Font.BOLD, 20));
		savebutton.setHorizontalAlignment(SwingConstants.CENTER);
		savebutton.setBounds(250, 450, 100, 30);
		add(savebutton);
		savebutton.addActionListener(this);
		
		quitbutton=new JButton("取消");
		quitbutton.setFont(new Font("幼圆", Font.BOLD, 20));
		quitbutton.setHorizontalAlignment(SwingConstants.CENTER);
		quitbutton.setBounds(500, 450, 100, 30);
		add(quitbutton);
		quitbutton.addActionListener(this);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == quitbutton){
			MainFrame.setContentPanel(new FinancialCostMainUI());
		}
	}
}
