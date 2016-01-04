package businesslogic.financialbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import IPadress.IP;
import po.SalaryHistoryPO;
import dataservice.FinancialDataService.SalaryHistoryDataService;



public class SalaryHistoryBL {
	public boolean insertSalary(String name,double money,String date){
		try {
			
			SalaryHistoryDataService salaryhistorydataservice=
					(SalaryHistoryDataService)Naming.lookup("rmi://"+IP.ip+"/rmi.salaryhistorydata");
		if(salaryhistorydataservice.insertSalary(name,money,date)){
			System.out.println("Insert success");
			return true;
		}
		else{
			System.out.println("Insert failed");
		}
		}
	   catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (RemoteException e) {
		e.printStackTrace();
	} catch (NotBoundException e) {
		e.printStackTrace();
	}
	return false;
	}
	public ArrayList<SalaryHistoryPO> getAll(){
		try {
			
			SalaryHistoryDataService salaryhistorydataservice=
					(SalaryHistoryDataService)Naming.lookup("rmi://"+IP.ip+"/rmi.salaryhistorydata");
			return salaryhistorydataservice.getAll();
		
		}
	   catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (RemoteException e) {
		e.printStackTrace();
	} catch (NotBoundException e) {
		e.printStackTrace();
	}
return null;
	}
	public static void main(String args[]){
		SalaryHistoryPO testpo=new SalaryHistoryPO();
		SalaryHistoryBL testBL=new SalaryHistoryBL();
		testBL.insertSalary("xyz", 1000, "2015/12/31");
	}
}
