package businesslogicservice.FinancialBLService;

public class FinancialBLService_driver {
	public static void driver(FinancialBLService figure){
		boolean date=figure.getDiary(1,1,1);
		boolean state=figure.addReport("00001",00010101,00010101);
		System.out.println(date+" and "+state);
		figure.endAccount();
	}
	
	public static void main(String args[]){
		FinancialBLService financial=new FinancialBLService_stub();
		driver(financial);
		
		
	}
}
