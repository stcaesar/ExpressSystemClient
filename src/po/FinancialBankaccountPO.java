package po;

import java.io.Serializable;

public class FinancialBankaccountPO implements Serializable{
	private String AccountNum="";
private String Operation="";
private double Money=0;
private String Date="";
public FinancialBankaccountPO(){
	
}
public FinancialBankaccountPO(String nu,String op,double mo,String da){
	this.AccountNum=nu;
	this.Operation=op;
	this.Money=mo;
	this.Date=da;
}
public void setAccountNum(String nu){
	this.AccountNum=nu;
}
public void setOperation(String op){
	this.Operation=op;
}
public void setMoney(double mo){
	this.Money=mo;
}
public void setDate(String da){
	this.Date=da;
}
public String getAccountNum(){
	return this.AccountNum;
}
public String getOperation(){
	return this.Operation;
}
public double getMoney(){
	return this.Money;
}
public String getDate(){
	return this.Date;
}
}
