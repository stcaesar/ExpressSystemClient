package businesslogicservice.FinancialBLService;

public class FinancialBLService_stub implements FinancialBLService{
	public boolean  addDiarydate (int year,int month,int day){
		if(year==1&&month==1&&day==1){
			return true;
		}
		else{
			return false;
		}
	};
	public boolean getDiary ( int year,int month,int day){
		if(year==1&&month==1&&day==1){
			return true;
		}
		else{
			return false;
		}
	};
	public void endDiary(){
		System.out.println("End diary");
	};
	public boolean addCalculate(long date,String way){
		if(date==00010101&&way=="00001"){
			return true;
		}
		else{
			return false;
		}
	};
	public void endCalculate(){
		System.out.println("End calculate.");
	};
	public boolean addCost (String cost,long id){
		if(cost=="00001"&&id==00001){
			return true;
		}
		else{
			return false;
		}
	};
	public boolean getCost (String cost,long id){
		if(cost=="00001"&&id==00001){
			return true;
		}
		else{
			return false;
		}
	};
	public void endCost(){
		System.out.println("End calculate.");
	};
	public boolean insertAccount(long id){
		if(id==00001){
			return true;
		}
		else{
			return false;
		}
	};
	public boolean deleteAccount(long id){
		if(id==00001){
			return true;
		}
		else{
			return false;
		}
		
	};
	public boolean updateAccount(long id){
		if(id==00001){
			return true;
		}
		else{
			return false;
		}
	};
	public boolean findAccount(long id){
		if(id==00001){
			return true;
		}
		else{
			return false;
		}
	};
	public void endAccount(){
		System.out.println("End Account.");
	};
	public boolean addReport(String type,long startdate,long enddate){
		if(type=="00001"&&startdate==00010101&enddate==00010101){
			return true;
		}
		else{
			return false;
		}
	};
	public boolean getReport(String type,long startdate,long enddate){
		if(type=="00001"&&startdate==00010101&enddate==00010101){
			return true;
		}
		else{
			return false;
		}
	};
	public void endReport(){
		System.out.println("End Report.");
	};

}
