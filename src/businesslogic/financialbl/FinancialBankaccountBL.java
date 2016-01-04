package businesslogic.financialbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import IPadress.IP;
import dataservice.FinancialDataService.FinancialBankaccountDataService;
import po.FinancialBankaccountPO;

public class FinancialBankaccountBL {
public boolean insertOperation(String accountnum,String op,double mo,String da){
	try {
		
		FinancialBankaccountDataService bankaccountdataservice=
				(FinancialBankaccountDataService)Naming.lookup("rmi://"+IP.ip+"/rmi.bankaccountdata");
	if(bankaccountdataservice.insert(accountnum,op,mo,da)){
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
public ArrayList<FinancialBankaccountPO> getAll(String accountnum){
	try {
		
		FinancialBankaccountDataService bankaccountdataservice=
				(FinancialBankaccountDataService)Naming.lookup("rmi://"+IP.ip+"/rmi.bankaccountdata");
	
		
		return bankaccountdataservice.getAll(accountnum);
	
	
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinancialBankaccountBL bankaccountbl=new FinancialBankaccountBL();
		bankaccountbl.insertOperation("2837463929","存入",500.0,"2016/01/01");
		
	}

}
