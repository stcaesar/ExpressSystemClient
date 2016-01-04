package businesslogicservice.CourierBLService;

public interface CourierBLService {
	public boolean memberStart(int id,String password);
	public boolean memberValid(boolean a);
	public boolean informationValid(boolean a);
	public boolean informationCaculate(boolean a);
	public boolean informationOutput(String s);
	public boolean queryValid(String s);
	public boolean queryCheckValid(String s);
	public boolean queryCheckInvalid(String s);
}
