package businesslogicservice.SenderBLService;

public interface SenderBLService {
	public boolean memberStart(int id,String password);
	public boolean memberValid(boolean i);
	public boolean queryCheckValid(String str);
	public boolean queryCheckInvalid(String str);
	public boolean queryValid(String str);
	public boolean queryOutput(String str);

}
