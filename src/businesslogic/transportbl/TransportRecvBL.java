package businesslogic.transportbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.TransportDataService.TransportRecvDataService;
import IPadress.IP;
import businesslogicservice.TransportBLService.TransportRecvBLService;
import po.TransportRecvPO;

public class TransportRecvBL {
	public boolean addRecvlist(String Packageid,String Recvdate,String Recvstartaddress,
			String Recvstate,String Recvtranscode,String Read){
		try {
			
			TransportRecvPO transportrecvpo=new TransportRecvPO(Packageid,Recvdate,Recvstartaddress,
					Recvstate,Recvtranscode,Read);
			TransportRecvDataService transportrecvdata = 
					(TransportRecvDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportrecvdata");
			if(transportrecvdata.insertTransRecv(transportrecvpo)){
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
	public boolean addPackageid(TransportRecvPO transportrecvpo,String id){
		transportrecvpo.setPackageid(id);
		return true;
	}
	public boolean addRecvdate(TransportRecvPO transportrecvpo,String date){
		transportrecvpo.setRecvdate(date);
		return true;
	}
	public boolean addRecvstartaddress(TransportRecvPO transportrecvpo,String address){
		transportrecvpo.setStartaddress(address);
		return true;
	}
	public boolean addRecvstate(TransportRecvPO transportrecvpo,String state){
		transportrecvpo.setState(state);
		return true;
	}
	public boolean addRecvtranscodeid(TransportRecvPO transportrecvpo,String id){
		transportrecvpo.setRecvtranscodeid(id);
		return true;
	}
	public ArrayList<TransportRecvPO> getAll(){
try {
			
			
			TransportRecvDataService transportrecvdata = (TransportRecvDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportrecvdata");
			return transportrecvdata.getAll();
			
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
	public ArrayList<TransportRecvPO> searchRecv(String ID){
		try {
					
					
					TransportRecvDataService transportrecvdata = (TransportRecvDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportrecvdata");
					return transportrecvdata.searchRecv(ID);
					
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
	public boolean update(TransportRecvPO transportrecvpo){
		try {
					
					
					TransportRecvDataService transportrecvdata = (TransportRecvDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportrecvdata");
					transportrecvdata.update(transportrecvpo);
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
	public ArrayList<TransportRecvPO> getPart(String Check){
try {
			
			
			TransportRecvDataService transportrecvdata = (TransportRecvDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.transportrecvdata");
			return transportrecvdata.getPart(Check);
			
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
	public void endRecv(){
		System.out.println("End transport receive.");
	}
	public static void main(String args[]){
		TransportRecvBL testBL=new TransportRecvBL();
		ArrayList<TransportRecvPO> list=testBL.searchRecv("7654321");
		System.out.println(list.size());
	}
}


