package businesslogicservice.BusinessBLService;

import java.util.ArrayList;

import po.BusinessCarManagement;
import po.BusinessDistribution;
import po.BusinessDriverManagement;
import po.BusinessLoad;
import po.BusinessReceive;
import po.BusinessVoucher;

public interface BusinessBLService {
	public boolean inputin(String date,String identifier,String origin,String state);
	public boolean inputBusinessLoad(String date,String businessIdentifier,String carIdentifier,String destination,String carCode,String supervision,String superCargo,String barCode,String money);
    public boolean inputBusinessDistribution(String arrivalDate,String barCode,String dispatcher);
    public boolean inputBusinessCarManagement(String carNumber,String businessuiNumber, String plateNumber,String serviceTime);
    public boolean inputBusinessDriverManagement(String driverNumber,String name,String birthDate,String identifyNumber
			,String phoneNumber,String gender,String registrationDeadline);
    public boolean inputBusinessVoucher(String receiptDate,String money,String courier,String barCode);
    public ArrayList<BusinessReceive> check(String identifier,String readState);
    public ArrayList<BusinessDistribution> checkDistribution(String barCode,String readState);
    public ArrayList<BusinessLoad> checkLoad(String barCode,String readState);
    public ArrayList<BusinessVoucher> checkMoney(String barCode,String readState);
    public ArrayList<BusinessReceive> checkReceive();
    public ArrayList<BusinessDistribution> checkDistribution();
    public ArrayList<BusinessLoad> checkLoad();
    public ArrayList<BusinessVoucher> checkMoney();
    public ArrayList<BusinessCarManagement> checkCar(String identifier);
    public ArrayList<BusinessDriverManagement> checkDriver(String identifier);
    public boolean deleteBusinessReceive(String identifier);
    public boolean deleteBusinessDistribution(String barCode);
    public boolean deleteBusinessLoad(String barCode);
    public boolean deleteBusinessVouicher(String barCode);
    public boolean deleteBusinessCarManagement(String carNumber);
    public boolean deleteBusinessDriverManagement(String driverNumber);
}


