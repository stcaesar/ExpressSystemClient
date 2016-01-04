package dataservice.TransportDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransportSendPO;

public interface TransportSendDataService extends Remote{
	public boolean insertTransSend(TransportSendPO transportsendpo)throws RemoteException;
	public boolean delete(String SendTranscodeID) throws RemoteException;
	public boolean update(TransportSendPO transportsendpo) throws RemoteException;
	public ArrayList<TransportSendPO> getAll()throws RemoteException;
	public ArrayList<TransportSendPO> getPart(String Check)throws RemoteException;
	public ArrayList<TransportSendPO> searchSend(String ID)throws RemoteException;
}
