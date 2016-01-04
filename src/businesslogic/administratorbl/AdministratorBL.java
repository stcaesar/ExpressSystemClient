package businesslogic.administratorbl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.AdministratorDataService.AdministratorDataService;
import IPadress.IP;
import businesslogicservice.AdministratorBLService.AdministratorBLService;
import po.MemberPO;

public class AdministratorBL implements AdministratorBLService{

	@Override
	public void inputid(String id) {
		// TODO Auto-generated method stub
		MemberPO member = new MemberPO();
		member.setadminid(id);
	}

	@Override
	public void inputoldkey(String key) {
		// TODO Auto-generated method stub
		MemberPO member = new MemberPO();
		member.setkey(key);
	}

	@Override
	public void inputnewkey(String key) {
		// TODO Auto-generated method stub
		MemberPO member = new MemberPO();
		member.newkey=key;
	}

	@Override
	public void inputconfkey(String key) {
		// TODO Auto-generated method stub
		MemberPO member = new MemberPO();
		member.confkey=key;
	}

	@Override
	public void inputnewright(String right) {
		// TODO Auto-generated method stub
		MemberPO member = new MemberPO();
		member.setright(right);
	}

	@Override
	public boolean checkid(String id,String key) {
		try {
			MemberPO member = new MemberPO(id,key,"");
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

	@Override
	public ArrayList<MemberPO> getallUserInfo() {
		try {
			AdministratorDataService administrator = (AdministratorDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.adminstratordata");
			return administrator.getallUserInfo();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean change(String id,String key) {
		// TODO Auto-generated method stub
		try {
			MemberPO user = new MemberPO(id,key,"");
			AdministratorDataService administrator = (AdministratorDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.adminstratordata");
			return administrator.change(user);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeright(String id, String right) {
		// TODO Auto-generated method stub
		try {
			MemberPO user = new MemberPO(id,"",right);
			System.out.println(right);
			AdministratorDataService administrator = (AdministratorDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.adminstratordata");
			return administrator.changeright(user);
			
			
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
