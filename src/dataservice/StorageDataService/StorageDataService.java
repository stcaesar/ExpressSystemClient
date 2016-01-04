package dataservice.StorageDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StorageInPO;
import po.StorageOutPO;

import java.util.ArrayList;

public interface StorageDataService extends Remote{
	public boolean insertin(StorageInPO in) throws RemoteException;
	public boolean insertout(StorageOutPO out) throws RemoteException;
	public ArrayList<StorageInPO> getInPO(Long intime) throws RemoteException;
	public int getIn(Long intime,Long endtime) throws RemoteException;
	public int getOut(Long intime,Long endtime) throws RemoteException;
	public ArrayList<StorageInPO> getAllin() throws RemoteException;
	public ArrayList<StorageOutPO> getAllout() throws RemoteException;
	public ArrayList<StorageInPO> getinunchecked() throws RemoteException;
	public ArrayList<StorageOutPO> getoutunchecked() throws RemoteException;
	public boolean changeinstate(StorageInPO in) throws RemoteException;
	public boolean changeoutstate(StorageOutPO out) throws RemoteException;
}
