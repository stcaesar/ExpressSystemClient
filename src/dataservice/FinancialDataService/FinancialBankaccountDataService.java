package dataservice.FinancialDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.FinancialBankaccountPO;

public interface FinancialBankaccountDataService extends Remote{
	
	public boolean insert(String accountnum,String op,double mo,String da)throws RemoteException;
	
	public ArrayList<FinancialBankaccountPO> getAll(String account)throws RemoteException;
}
