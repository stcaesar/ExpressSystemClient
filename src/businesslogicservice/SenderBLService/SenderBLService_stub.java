package businesslogicservice.SenderBLService;

public class SenderBLService_stub implements SenderBLService{

	
	public boolean memberStart(int id, String password) {
		if(id==000000&&password.equals("abcd")){
			return true;
		}
		else
			return false;
	}

	public boolean memberValid(boolean i) {
		if(i){
			return true;
		}
		else
			return false;
	}

	
	public boolean queryCheckValid(String str) {
		if(str.equals("abc")){
			return true;
		}
		else
			return false;
	}

	
	public boolean queryCheckInvalid(String str) {
		if(str.equals("abc")){
			return true;
		}
		else
			return false;
	}

	
	public boolean queryValid(String str) {
		if(str.equals("abc")){
			return true;
		}
		else
			return false;
	}

	
	public boolean queryOutput(String str) {
		if(str.equals("abc")){
			return true;
		}
		else
			return false;
	}

	
}
