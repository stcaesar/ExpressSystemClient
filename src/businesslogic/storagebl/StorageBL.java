package businesslogic.storagebl;


import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.AdministratorDataService.AdministratorDataService;
import dataservice.StorageDataService.StorageDataService;
import IPadress.IP;
import businesslogicservice.StorageBLService.StorageBLService;
import po.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;






public class StorageBL implements StorageBLService{
	
	

	@Override
	public boolean inputinid(String id) {
		StorageInPO in = new StorageInPO();
		in.setid(id);
		
		
		if(id!=null)return true;
		else return false;
	}

	@Override
	public boolean inputoutid(String id) {
		StorageOutPO out = new StorageOutPO();
		out.setid(id);
		
		if(id!=null)return true;
		else return false;
	}

	@Override
	public boolean checktotal(int year, int month, int day) {
		return false;
	}

	@Override
	public boolean checkid(long id) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean checkwarning() {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public void inputintime(int year, int month, int day) {
		StorageInPO in = new StorageInPO();
		in.setintime(year*10000+month*100+day);
		
	}

	@Override
	public void inputdestination(String destination,int label) {
		// TODO Auto-generated method stub
		if(label==1){
			StorageInPO in = new StorageInPO();
			in.setdestination(destination);
			System.out.println(in.getdestination());
		}
		else{
			StorageOutPO out = new StorageOutPO();
			out.setdestination(destination);
		}
	}

	@Override
	public void inputdistrict(long district) {
		// TODO Auto-generated method stub
		StorageInPO in = new StorageInPO();
		in.setdistrict(district);
	}

	@Override
	public void inputrow(long row) {
		// TODO Auto-generated method stub
		StorageInPO in =new StorageInPO();
		in.setrow(row);
	}

	@Override
	public void inputshelf(long shelf) {
		// TODO Auto-generated method stub
		StorageInPO in = new StorageInPO();
		in.setshelf(shelf);
	}

	@Override
	public void inputnumber(long number) {
		// TODO Auto-generated method stub
		StorageInPO in = new StorageInPO();
		in.setnumber(number);
	}

	
	@Override
	public void inputouttime(int year, int month, int day) {
		// TODO Auto-generated method stub
		StorageOutPO out = new StorageOutPO();
		out.setouttime(year*10000+month*100+day);
	}

	@Override
	public void inputtransport(String transport) {
		// TODO Auto-generated method stub
		StorageOutPO out = new StorageOutPO();
		out.settransport(transport);
	}

	@Override
	public void inputcentralid(long centralid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean inputin(String id, Long intime, String destination,
			Long district, Long row, Long shelf, Long number) {
		try {
			StorageInPO in = new StorageInPO(id,intime,destination,district,row,shelf,number);
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.insertin(in);
			
			
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
	public boolean inputout(String id, Long outtime, Long centralid,
			String destination, String transport) {
		// TODO Auto-generated method stub
		try {
			StorageOutPO out = new StorageOutPO(id,destination,outtime,transport,centralid);
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.insertout(out);
			
			
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
	public ArrayList<StorageInPO> check(Long time) {
		try {
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.getInPO(time);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<StorageInPO> getAllin() {
		try {
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.getAllin();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<StorageOutPO> getAllout() {
		try {
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.getAllout();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<StorageInPO> getAllinunchecked() {
		try {
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.getinunchecked();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<StorageOutPO> getAlloutunchecked() {
		try {
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.getoutunchecked();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean changeinstate(String id){
		try {
			StorageInPO in = new StorageInPO();
			in.setid(id);
			
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.changeinstate(in);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean changeoutstate(String id){
		try {
			StorageOutPO out = new StorageOutPO();
			out.setid(id);
			
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.changeoutstate(out);
			
			
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
	public int getIn(Long intime,Long endtime) {
		try {
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.getIn(intime,endtime);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getOut(Long outtime,Long endtime) {
		try {
			StorageDataService storage= (StorageDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.storagedata");
			return storage.getOut(outtime,endtime);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean outExcel(ArrayList<StorageInPO> in) throws Exception{
		// TODO Auto-generated method stub
		boolean isSuccess=false;
		return isSuccess;
	}

	@Override
	public java.lang.Boolean checkwarning() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
