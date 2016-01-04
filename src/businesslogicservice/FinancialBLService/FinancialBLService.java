package businesslogicservice.FinancialBLService;

public interface FinancialBLService {
	public boolean  addDiarydate (int year,int month,int day);
	public boolean getDiary ( int year,int month,int day);
	public void endDiary();
	public boolean addCalculate(long date,String way);
	public void endCalculate();
	public boolean addCost (String cost,long id);
	public boolean getCost (String cost,long id);
	public void endCost();
	public boolean insertAccount(long id);
	public boolean deleteAccount(long id);
	public boolean updateAccount(long id);
	public boolean findAccount(long id);
	public void endAccount();
	public boolean addReport(String type,long startdate,long enddate);
	public boolean getReport(String type,long startdate,long enddate);
	public void endReport();
	
}
