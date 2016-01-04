package businesslogicservice.AdministratorBLService;

import java.util.ArrayList;

import po.MemberPO;

public interface AdministratorBLService {
	public void inputid(String id);
	public void inputoldkey(String key);
	public void inputnewkey(String key);
	public void inputconfkey(String key);
	public void inputnewright(String right);
	public boolean checkid(String id,String key);
	public ArrayList<MemberPO> getallUserInfo();
	public boolean change(String id,String key);
	public boolean changeright(String id,String key);

}
