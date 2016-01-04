package businesslogic.loginbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import IPadress.IP;
import dataservice.AdministratorDataService.AdministratorDataService;
import po.MemberPO;


public class LoginBL {
	//����˺������Ƿ���ȷ   
	public static boolean check(String username, String password){
		try {
			MemberPO member = new MemberPO(username,password,"");
			AdministratorDataService administrator = (AdministratorDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.adminstratordata");
			return administrator.login(member);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	
	}
	
	//��ȡ�˻������
	public static String getright(String username, String password){
		try {
			MemberPO member = new MemberPO(username,password,"");
			AdministratorDataService administrator = (AdministratorDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.adminstratordata");
			return administrator.getright(member);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return "";
		
	}
	
	
}
