package dataservice.CourierDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderListPO;



public interface CourierDataService extends Remote {
	public boolean saveorderlist(OrderListPO orderlist) throws RemoteException;
	public boolean delorderlist(OrderListPO orderlist) throws RemoteException;
	public OrderListPO getorderlist(OrderListPO orderlist) throws RemoteException;
	public boolean checkorderlist(OrderListPO orderlist) throws RemoteException;
	public boolean checkRec(OrderListPO orderlist) throws RemoteException;
	public ArrayList<OrderListPO> getallOrderList() throws RemoteException;
	public ArrayList<OrderListPO> getallunchecked() throws RemoteException;
}


