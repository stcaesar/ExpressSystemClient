package dataservice.ManagerDataService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BusinessReceive;
import po.ManagerConstant;
import po.ManagerMember;
import po.ManagerPay;
public interface ManagerDataService  extends Remote{
	public boolean find(long id)throws RemoteException;
	public boolean insertManagerMember(ManagerMember po)throws RemoteException;
	public boolean insertManagerPay(ManagerPay po)throws RemoteException;
	public boolean insertManagerConstant(ManagerConstant po)throws RemoteException;
	public boolean deleteManagerMember(String unit,String name)throws RemoteException;
	public boolean deleteManagerConstant(String city1,String city2) throws RemoteException;
	public boolean deleteManagerPay(String rank,String job)throws RemoteException;
	public ArrayList<ManagerMember> getPO(String rank) throws RemoteException;
	public ArrayList<ManagerPay> getPayPO(String rank,String job) throws RemoteException;
	public ArrayList<ManagerPay> getAllPayPO() throws RemoteException;
	public ArrayList<ManagerConstant> getConstantPO(String city1,String city2) throws RemoteException;
	public ArrayList<ManagerConstant> getAllConstantPO() throws RemoteException;
	public void delete(String po)throws RemoteException;
	public void update(String po)throws RemoteException;
	public void init() throws RemoteException;
	public void finish()throws RemoteException; 
}


