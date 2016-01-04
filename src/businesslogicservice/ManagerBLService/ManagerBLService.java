package businesslogicservice.ManagerBLService;

import java.util.ArrayList;

import po.BusinessVoucher;
import po.ManagerConstant;
import po.ManagerMember;
import po.ManagerPay;

public interface ManagerBLService {
	public boolean inputManagerMember(String rank,String unit,String name);
	public boolean inputManagerPay(String rank,String job,String money);
	public boolean inputManagerConstant(String city1,String city2,String distance,String save,String standard,String fast);
	public boolean deleteManagerMember(String unit,String name);
	public boolean deleteManagerPay(String rank,String job);
	public boolean deleteManagerConstant(String city1,String city2);
    public ArrayList<ManagerMember> getPO(String rank);
    public ArrayList<ManagerPay> getPayPO(String rank,String job);
    public ArrayList<ManagerPay> getAllPayPO();
    public ArrayList<ManagerConstant> getConstantPO(String city1,String city2);
    public ArrayList<ManagerConstant> getAllConstantPO();
}
