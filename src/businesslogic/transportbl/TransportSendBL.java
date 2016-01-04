package businesslogic.transportbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.TransportDataService.TransportRecvDataService;
import dataservice.TransportDataService.TransportSendDataService;
import IPadress.IP;
import businesslogicservice.TransportBLService.TransportSendBLService;
import po.TransportSendPO;

public class TransportSendBL{
	public boolean addSendlist(String Sendtranscode,String Flight,String Way,String Senddate,String Startaddress,String Endaddress,String Watcherid,double Fare,String Read){
try {
			
			TransportSendPO transportsendpo=new TransportSendPO(Sendtranscode,Flight,Way,Senddate,Startaddress,Endaddress,Watcherid,Fare,Read);
			TransportSendDataService transportsenddata = (TransportSendDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportsenddata");
			if(transportsenddata.insertTransSend(transportsendpo)){
				System.out.println("insert success");
				return true;
			}
			else{
				System.out.println("insert failed");
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addWay(TransportSendPO transportsendpo,String id){
		transportsendpo.setWay(id);
		return true;
	}
	public boolean addFlight(TransportSendPO transportsendpo,String id){
		transportsendpo.setFlightcode(id);
		return true;
	}
	public boolean addSenddate(TransportSendPO transportsendpo,String id){
		transportsendpo.setSenddate(id);
		return true;
	}
	public boolean addStartaddress(TransportSendPO transportsendpo,String id){
		transportsendpo.setStartaddress(id);
		return true;
	}
	public boolean addEndaddress(TransportSendPO transportsendpo,String id){
		transportsendpo.setEndaddress(id);
		return true;
	}
	public boolean addSendtranscode(TransportSendPO transportsendpo,String id){
		transportsendpo.setSendtranscodeid(id);
		return true;
	}
	public boolean addWatcher(TransportSendPO transportsendpo,String id){
		transportsendpo.setWatcherid(id);
		return true;
	}
	public boolean addFare(TransportSendPO transportsendpo,double money){
		transportsendpo.setFare(money);
		return true;
	}
	public ArrayList<TransportSendPO> getAll(){
		try {
					
					
					TransportSendDataService transportsenddata = (TransportSendDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportsenddata");
					return transportsenddata.getAll();
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
					return null;
				} catch (RemoteException e) {
					e.printStackTrace();
					return null;
				} catch (NotBoundException e) {
					e.printStackTrace();
					return null;
				}
				
			}
	public boolean update(TransportSendPO transportsendpo){
		try {
					
					
					TransportSendDataService transportsenddata = (TransportSendDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportsenddata");
					transportsenddata.update(transportsendpo);
					return true;
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
					return false;
				} catch (RemoteException e) {
					e.printStackTrace();
					return false;
				} catch (NotBoundException e) {
					e.printStackTrace();
					return false;
				}
				
			}
	public ArrayList<TransportSendPO> getPart(String Check){
		try {
					
					
					TransportSendDataService transportsenddata = (TransportSendDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportsenddata");
					return transportsenddata.getPart(Check);
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
					return null;
				} catch (RemoteException e) {
					e.printStackTrace();
					return null;
				} catch (NotBoundException e) {
					e.printStackTrace();
					return null;
				}
			}
	public ArrayList<TransportSendPO> searchSend(String ID){
		try {
					
					
					TransportSendDataService transportsenddata = (TransportSendDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportsenddata");
					return transportsenddata.searchSend(ID);
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
					return null;
				} catch (RemoteException e) {
					e.printStackTrace();
					return null;
				} catch (NotBoundException e) {
					e.printStackTrace();
					return null;
				}
			}
	public static void main(String args[]){
		TransportSendBL transportsendbl=new TransportSendBL();
		ArrayList<TransportSendPO> list=transportsendbl.searchSend("1110002000/01/01sdefghy");
		System.out.println(list.get(0).getSendtranscodeid());
	}
}
