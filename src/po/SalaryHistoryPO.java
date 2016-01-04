package po;

import java.io.Serializable;

public class SalaryHistoryPO implements Serializable{
private String Name="";
private String Date="";
private double Money=0;
public SalaryHistoryPO(){
	
}

public SalaryHistoryPO(String na,double mo,String da){
	this.Name=na;
	this.Money=mo;
	this.Date=da;
}
public String getName(){
	return this.Name;
}
public String getDate(){
	return this.Date;
}
public double getMoney(){
	return this.Money;
}
public void setName(String na){
	this.Name=na;
}
public void setMoney(double mo){
	this.Money=mo;
}
public void setDate(String da){
	this.Date=da;
}

}
