package businesslogic.mannagerbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BusinessReceive;
import po.ManagerConstant;
import po.ManagerMember;
import po.ManagerPay;
import dataservice.BusinessDataService.BusinessDataService;
import dataservice.ManagerDataService.ManagerDataService;
import IPadress.IP;
import businesslogicservice.ManagerBLService.ManagerBLService;

public class ManagerBL implements ManagerBLService{

	@Override
	public boolean inputManagerMember(String rank, String unit, String name) {
		// TODO Auto-generated method stub
		try {
			ManagerMember in = new ManagerMember(rank,unit,name);
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.insertManagerMember(in);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteManagerMember(String unit, String name) {
		
		try {
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.deleteManagerMember(unit,name);
			
			
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
	public ArrayList<ManagerMember> getPO(String rank) {
		
		try {
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.getPO(rank);
			
			
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
	public boolean inputManagerPay(String rank, String job, String money) {
		// TODO Auto-generated method stub
		try {
			ManagerPay in = new ManagerPay(rank,job,money);
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.insertManagerPay(in);
			
			
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
	public boolean deleteManagerPay(String rank, String job) {
		// TODO Auto-generated method stub
		try {
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.deleteManagerPay(rank,job);
			
			
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
	public ArrayList<ManagerPay> getPayPO(String rank, String job) {
		// TODO Auto-generated method stub
		try {
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.getPayPO(rank,job);
			
			
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
	public ArrayList<ManagerPay> getAllPayPO() {
		// TODO Auto-generated method stub
		try {
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.getAllPayPO();
			
			
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
	public boolean inputManagerConstant(String city1, String city2,
			String distance, String save, String standard, String fast) {
		try {
			ManagerConstant in = new ManagerConstant(city1,city2,distance,save,standard,fast);
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.insertManagerConstant(in);
			
			
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
	public boolean deleteManagerConstant(String city1, String city2) {
		try {
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.deleteManagerConstant(city1,city2);
			
			
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
	public ArrayList<ManagerConstant> getConstantPO(String city1, String city2) {
		try {
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.getConstantPO(city1,city2);
			
			
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
	public ArrayList<ManagerConstant> getAllConstantPO() {
		try {
			ManagerDataService manager= (ManagerDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.managerdata");
			return manager.getAllConstantPO();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String [] args){
		ManagerBL manager = new ManagerBL();
//	    manager.inputManagerConstant("上海", "北京", "", "", "", "");
//	    manager.inputManagerConstant("北京", "广州", "", "", "", "");
//	    manager.inputManagerConstant("北京", "南京", "", "", "", "");
//	    
       // manager.inputManagerConstant("上海", "郑州", "", "", "", "");
	 	//manager.deleteManagerConstant("上海", "郑州");
		//System.out.println(manager.getAllConstantPO().size());
}
	
	
}