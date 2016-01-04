package businesslogicservice.StorageBLService;

import java.util.ArrayList;

import po.StorageInPO;


public interface StorageBLService {
	public boolean inputinid(String id);
	public boolean inputoutid(String id);
	public boolean checktotal(int year,int month,int day);
	public boolean checkid(long id);
	public Boolean checkwarning();
	public void inputintime(int year,int month,int day);
	public void inputouttime(int year,int month,int day);
	public void inputdestination(String destination,int i);
	public void inputdistrict(long district);
	public void inputrow(long row);
	public void inputshelf(long shelf);
	public void inputnumber(long number);
	public void inputtransport(String transport);
	public void inputcentralid(long centralid);
	public boolean inputin(String id,Long intime,String destination,Long district,Long row,Long shelf,Long number);
	public boolean inputout(String id,Long outtime,Long centralid,String destination,String transport);
	public ArrayList<StorageInPO> check(Long time);
	public int getIn(Long intime,Long endtime);
	public int getOut(Long outtime,Long endtime);
	public boolean outExcel(ArrayList<StorageInPO> in) throws Exception;

}
