package businesslogicservice.SenderBLService;

public class SenderBLService_driver {
	public static void driver(SenderBLService figure){
		boolean isstart=figure.memberStart(000000,"abcd");
		boolean isvalid=figure.queryCheckValid("abc");
		System.out.println(isstart+" and "+isvalid);
	}
	public static void main(String args[]){
		SenderBLService sender=new SenderBLService_stub();
		driver(sender);

	}
}
