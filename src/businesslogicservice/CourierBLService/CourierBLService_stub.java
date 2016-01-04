package businesslogicservice.CourierBLService;

public class CourierBLService_stub implements CourierBLService{

	@Override
	public boolean memberStart(int id, String password) {
		if(id==00000&&password.equals("abc")){
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean memberValid(boolean a) {
		if(a){
			return true;
		}
		else	
		
		return false;
	}

	@Override
	public boolean informationValid(boolean a) {
		if(a){
			return true;
		}
		else	
		
		return false;
	}

	@Override
	public boolean informationCaculate(boolean a) {
		if(a){
			return true;
		}
		else	
		
		return false;
	}

	@Override
	public boolean informationOutput(String s) {
		System.out.println(s);
		return false;
	}

	@Override
	public boolean queryValid(String s) {
		System.out.println(s);
		return false;
	}

	@Override
	public boolean queryCheckValid(String s) {
		System.out.println(s);
		return false;
	}

	@Override
	public boolean queryCheckInvalid(String s) {
		System.out.println(s);
		return false;
	}
	
}
