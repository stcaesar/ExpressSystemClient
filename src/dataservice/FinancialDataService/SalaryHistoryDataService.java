package dataservice.FinancialDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SalaryHistoryPO;

public interface SalaryHistoryDataService extends Remote{
public boolean insertSalary(String name,double money,String date)throws RemoteException;
public ArrayList<SalaryHistoryPO> getAll()throws RemoteException;
}
