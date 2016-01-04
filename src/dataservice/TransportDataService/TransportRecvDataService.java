package dataservice.TransportDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransportRecvPO;



public interface TransportRecvDataService extends Remote{
	public boolean insertTransRecv(TransportRecvPO transportrecvpo)throws RemoteException;
	public boolean delete(String SendTranscodeID) throws RemoteException;
	public boolean update(TransportRecvPO transportrecvpo) throws RemoteException;
	public ArrayList<TransportRecvPO> getAll()throws RemoteException;
	public ArrayList<TransportRecvPO> getPart(String Read)throws RemoteException;
	public ArrayList<TransportRecvPO> searchRecv(String ID)throws RemoteException;
}
