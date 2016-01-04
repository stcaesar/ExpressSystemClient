package dataservice.BusinessDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BusinessCarManagement;
import po.BusinessDistribution;
import po.BusinessDriverManagement;
import po.BusinessLoad;
import po.BusinessReceive;
import po.BusinessVoucher;
import po.StorageInPO;

public interface BusinessDataService extends Remote{
	public boolean insertin(BusinessReceive in) throws RemoteException;
	public boolean insertBusinessLoad(BusinessLoad in) throws RemoteException;
	public boolean insertBusinessCarManagement(BusinessCarManagement in) throws RemoteException;
	public boolean insertBusinessDistribution(BusinessDistribution in)throws RemoteException;
	public boolean insertBusinessDriverManagement(BusinessDriverManagement in) throws RemoteException;
	public boolean insertBusinessVoucher(BusinessVoucher in) throws RemoteException;
	public ArrayList<BusinessReceive> getInPO(String identifier,String readState) throws RemoteException;
	public ArrayList<BusinessDistribution> getDistributionPO(String barCode,String readState) throws RemoteException;
	public ArrayList<BusinessLoad> getLoadPO(String barCode,String readState) throws RemoteException;
	public ArrayList<BusinessVoucher> getMoneyPO(String barCode,String readState) throws RemoteException;
	public ArrayList<BusinessCarManagement> getCarPO(String carNumber) throws RemoteException;
	public ArrayList<BusinessDriverManagement> getDriverPO(String driverNumber) throws RemoteException;
	public ArrayList<BusinessVoucher> getAllMoneyPO() throws RemoteException;
	public ArrayList<BusinessReceive> getAllReceivePO() throws RemoteException;
	public ArrayList<BusinessDistribution> getAllDistributionPO() throws RemoteException;
	public ArrayList<BusinessLoad> getAllLoadPO() throws RemoteException;
	
 	public boolean find(long id)throws RemoteException;
	public void delete(String po)throws RemoteException;
	public void update(String po)throws RemoteException;
	public void init() throws RemoteException;
	public void finish()throws RemoteException;
	public boolean deleteIn(String identifier) throws RemoteException;
	public boolean deleteDistribution(String barCode) throws RemoteException;
	public boolean deleteLoad(String barCode) throws RemoteException;
	public boolean deleteMoney(String barCode) throws RemoteException;
	public boolean deleteCar(String carNumber) throws RemoteException;
	public boolean deleteDriver(String driverNumber) throws RemoteException;
	public boolean update(BusinessReceive businessReceive) throws RemoteException;
	public boolean update(BusinessLoad businessload) throws RemoteException;
	public boolean update(BusinessDistribution businessdistribution) throws RemoteException;
	public boolean update(BusinessVoucher businessvoucher) throws RemoteException;
	public ArrayList<BusinessReceive> getInPO(String readState) throws RemoteException;
	public ArrayList<BusinessDistribution> getDistributionPO(String readState) throws RemoteException;
	public ArrayList<BusinessLoad> getLoadPO(String readState) throws RemoteException;
	public ArrayList<BusinessVoucher> getMoneyPO(String readState) throws RemoteException;

}








