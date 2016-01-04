package businesslogic.registerbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import IPadress.IP;
import po.MemberPO;
import dataservice.AdministratorDataService.AdministratorDataService;

public class RegisterBL {
	
	public static boolean register(String userid,String password,String right){
		try {
			MemberPO user = new MemberPO(userid,password,right);
			AdministratorDataService administrator = (AdministratorDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.adminstratordata");
			return administrator.register(user);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	
	}
}
