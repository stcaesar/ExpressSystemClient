package businesslogicservice.CourierBLService;

public class CourierBLService_driver {
	public static void driver(CourierBLService figure){
		boolean isstart=figure.memberStart(000000,"abcd");
		
		System.out.println(isstart);
		figure.informationOutput("¶©µ¥");
	}
	public static void main(String args[]){
		CourierBLService courier=new CourierBLService_stub();
		driver(courier);

	}
}
