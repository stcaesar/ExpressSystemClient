package po;
public class FinancialPO {
private String Diarydate="";
private String Calculatedate="";
private String Business="";
private double Calculatemoney=0;
private long Costid=0;
private double Costmoney=0;
private long Accountid=0;
private String Reporttype="";
private String Reportstartdate="";
private String Reportenddate="";
public FinancialPO(){
	
}
public FinancialPO(long costid,long accountid,double costmoney,double calculatemoney,
		String diarydate,String calculatedate,String business,String reporttype,
		String reportstartdate,String reportenddate){
	this.Diarydate=diarydate;
	this.Calculatedate=calculatedate;
	this.Business=business;
	this.Calculatemoney=calculatemoney;
	this.Costid=costid;
	this.Costmoney=costmoney;
	this.Accountid=accountid;
	this.Reporttype=reporttype;
	this.Reportstartdate=reportstartdate;
	this.Reportenddate=reportenddate;
}
public void setDiarydate(String stuff){
	this.Diarydate=stuff;
}
public void setCalculatedate(String stuff){
	this.Calculatedate=stuff;
}
public void setBusiness(String stuff){
	this.Business=stuff;
}
public void setCalculatemoney(double money){
	this.Calculatemoney=money;
}
public void setCostid(long id){
	this.Costid=id;
}
public void setCostmoney(double money){
	this.Costmoney=money;
}
public void setAccountid(long id){
	this.Accountid=id;
}
public void setReporttype(String stuff){
	this.Reporttype=stuff;
}
public void setReportstartdate(String stuff){
	this.Reportstartdate=stuff;
}
public void setReportenddate(String stuff){
	this.Reportenddate=stuff;
}

public String getDiarydate(){
	return this.Diarydate;
}
public String getCalculatedate(){
	return this.Calculatedate;
}
public String getBusiness(){
	return this.Business;
}
public double getCalculatemoney(){
	return this.Calculatemoney;
}
public long getCostid(){
	return this.Costid;
}
public double getCostmoney(){
	return this.Costmoney;
}
public long getAccountid(){
	return this.Accountid;
}
public String getReporttype(){
	return this.Reporttype;
}
public String getReportstartdate(){
	return this.Reportstartdate;
}
public String getReportenddate(){
	return this.Reportenddate;
}
}
