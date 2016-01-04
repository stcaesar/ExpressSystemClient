package businesslogic.businessbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.BusinessLoad;
import po.BusinessReceive;
import dataservice.BusinessDataService.BusinessDataService;
import dataservice.StorageDataService.StorageDataService;
import IPadress.IP;
import businesslogic.courierbl.CourierBL;
import businesslogicservice.BusinessBLService.BusinessBLService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;









import po.BusinessCarManagement;
import po.BusinessDistribution;
import po.BusinessDriverManagement;
import po.BusinessLoad;
import po.BusinessReceive;
import po.BusinessVoucher;
import po.StorageInPO;
import po.TransportRecvPO;
import dataservice.BusinessDataService.BusinessDataService;
import dataservice.StorageDataService.StorageDataService;
import dataservice.TransportDataService.TransportRecvDataService;
import businesslogic.courierbl.CourierBL;
import businesslogicservice.BusinessBLService.BusinessBLService;

public class BusinessBL implements BusinessBLService{
	public boolean inputin(String date,String identifier,String origin,String state) {
		try {
			BusinessReceive in = new BusinessReceive(date,identifier,origin,state,"unchecked");
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.insertin(in);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean inputBusinessLoad(String date,String businessIdentifier,String carIdentifier,String destination,String carCode,String supervision,String superCargo,String barCode,String money) {
		try {
			BusinessLoad businessLoad = new BusinessLoad(date,businessIdentifier,carIdentifier,destination,carCode,supervision,superCargo,barCode,money,"unchecked");
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.insertBusinessLoad(businessLoad);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
    public boolean inputBusinessDistribution(String arrivalDate,String barCode,String dispatcher){
		try {
			BusinessDistribution businessdistribution = new BusinessDistribution(arrivalDate,barCode,dispatcher,"unchecked");
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.insertBusinessDistribution(businessdistribution);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean inputBusinessCarManagement(String carNumber, String businessuiNumber, String plateNumber,
			String serviceTime) {
		
		try {
			BusinessCarManagement businesscarmanagement = new BusinessCarManagement(carNumber,businessuiNumber,plateNumber,serviceTime);
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.insertBusinessCarManagement(businesscarmanagement);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean inputBusinessDriverManagement(String driverNumber, String name,
			String birthDate, String identifyNumber, String phoneNumber,
			String gender, String registrationDeadline) {
		// TODO Auto-generated method stub
		try {
			BusinessDriverManagement businessdrivermanagement = new BusinessDriverManagement(driverNumber,name,birthDate,identifyNumber,phoneNumber,gender,registrationDeadline);
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.insertBusinessDriverManagement(businessdrivermanagement);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean inputBusinessVoucher(String receiptDate, String money,
			String courier, String barCode) {
		try {
			BusinessVoucher businessvoucher = new BusinessVoucher(receiptDate,money,courier,barCode,"unchecked");
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.insertBusinessVoucher(businessvoucher);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<BusinessReceive> check(String identifier,String readState) {
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getInPO(identifier,readState);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean deleteBusinessReceive(String identifier) {
		// TODO Auto-generated method stub
		try {
			
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.deleteIn(identifier);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<BusinessDistribution> checkDistribution(String barCode,
			String readState) {
		// TODO Auto-generated method stub
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getDistributionPO(barCode,readState);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<BusinessLoad> checkLoad(String barCode, String readState) {
		// TODO Auto-generated method stub
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getLoadPO(barCode,readState);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<BusinessVoucher> checkAllMoney() {
		// TODO Auto-generated method stub
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getAllMoneyPO();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<BusinessVoucher> checkMoney(String barCode,
			String readState) {
		// TODO Auto-generated method stub
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getMoneyPO(barCode,readState);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<BusinessCarManagement> checkCar(String carNumber) {
		// TODO Auto-generated method stub
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getCarPO(carNumber);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<BusinessDriverManagement> checkDriver(String driverNumber) {
		// TODO Auto-generated method stub
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getDriverPO(driverNumber);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean deleteBusinessDistribution(String barCode) {
		// TODO Auto-generated method stub
try {
			
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.deleteDistribution(barCode);
			
			
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
	@Override
	public boolean deleteBusinessLoad(String barCode) {
		// TODO Auto-generated method stub
try {
			
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.deleteLoad(barCode);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteBusinessVouicher(String barCode) {
		// TODO Auto-generated method stub
try {
			
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.deleteMoney(barCode);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteBusinessCarManagement(String carNumber) {
		// TODO Auto-generated method stub
try {
			
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.deleteCar(carNumber);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteBusinessDriverManagement(String driverNumber) {
		// TODO Auto-generated method stub
try {
			
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.deleteDriver(driverNumber);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<BusinessReceive> checkReceive() {
		// TODO Auto-generated method stub
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getAllReceivePO();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<BusinessDistribution> checkDistribution() {
		// TODO Auto-generated method stub
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getAllDistributionPO();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<BusinessLoad> checkLoad() {
		// TODO Auto-generated method stub
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getAllLoadPO();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<BusinessVoucher> checkMoney() {
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getAllMoneyPO();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<BusinessReceive> checkReceive(String readState) {
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getInPO(readState);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<BusinessLoad> checkLoad(String readState) {
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getLoadPO(readState);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<BusinessDistribution> checkDistribution(String readState) {
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getDistributionPO(readState);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<BusinessVoucher> checkVoucher(String readState) {
		try {
			BusinessDataService business= (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
			return business.getMoneyPO(readState);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(BusinessReceive businessreceive){
		try {
					
					
					BusinessDataService business = (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
					business.update(businessreceive);
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
	public boolean update(BusinessLoad businessload){
		try {
					
					
					BusinessDataService business = (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
					business.update(businessload);
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
	public boolean update(BusinessDistribution businessdistribution){
		try {
					
					
					BusinessDataService business = (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
					business.update(businessdistribution);
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
	public boolean update(BusinessVoucher businessvoucher){
		try {
					
					
					BusinessDataService business = (BusinessDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.businessdata");
					business.update(businessvoucher);
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
	
	public static void main(String [] args){
		BusinessBL business = new BusinessBL(); 
		
		BusinessDistribution busi = new BusinessDistribution("luojn","jueying","xiaopao","unchecked");
		//businessdatabase.insertBusinessDistribution(business);
		//business.inputBusinessDistribution("luojn","jueying","xiaopao");
		business.update(busi);
	}
	

}
