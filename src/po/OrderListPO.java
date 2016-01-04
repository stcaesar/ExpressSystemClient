package po;

import java.io.Serializable;

public class OrderListPO implements Serializable{
	private String Sname;
	private String Rname;
	private String Saddress;
	private String Raddress;
	private String Sworkp;
	private String Rworkp;
	private String Sphone;
	private String Rphone;
	private String Smoblie;
	private String Rmoblie;
	private int goodnum;
	private double goodM;
	private double goodV;
	private String goodsytle;
	private String goodsize;
	private String listid;
	private String packagetype;
	private String expresstype;
	private double allcost;
	private String excepttime;
	private String receiveid;
	private String receivername;
	private String receivertime;
	private String readState;
	
	public OrderListPO(){
		Sname = "";
		Rname = "";
		Saddress = "";
		Raddress = "";
		Sworkp = "";
		Rworkp = "";
		Sphone = "";
		Rphone = "";
		Smoblie = "";
		Rmoblie = "";
		goodnum = 0;
		goodM = 0;
		goodV = 0;
		goodsytle="";
		goodsize="";
		listid = "";
		packagetype = "";
		expresstype = "";
		allcost = 0;
		excepttime = "";
		receiveid = "";
		receivername = "";
		receivertime = "";
		readState = "unchecked";
	}
	public String getstate(){
		return readState;
	}
	public void setstate(String a){
		this.readState = a;
	}
	
	public String getSname(){
		return Sname;
	}
	public void setSname(String a){
		this.Sname = a;
	}//1
	
	public String getRname(){
		return Rname;
	}
	public void setRname(String a){
		this.Rname = a;
	}//2
	
	public String getSaddress(){
		return Saddress;
	}
	public void setSaddress(String a){
		this.Saddress = a;
	}//3
	
	public String getRaddress(){
		return Raddress;
	}
	public void setRaddress(String a){
		this.Raddress = a;
	}//4
	
	public String getSphone(){
		return Sphone;
	}
	public void setSphone(String a){
		this.Sphone = a;
	}//5
	
	public String getRphone(){
		return Rphone;
	}
	public void setRphone(String a){
		this.Rphone = a;
	}//6
	
	public String getSmoblie(){
		return Smoblie;
	}
	public void setSmoblie(String a){
		this.Smoblie = a;
	}//7
	
	public String getRmoblie(){
		return Rmoblie;
	}
	public void setRmoblie(String a){
		this.Rmoblie = a;
	}//8
	
	public int getgoodnum(){
		return goodnum;
	}
	public void setgoodnum(int a){
		this.goodnum = a;
	}//9
	
	public double getgoodM(){
		return goodM;
	}
	public void setgoodM(double a){
		this.goodM = a;
	}//10
	
	public double getgoodV(){
		return goodV;
	}
	public void setgoodV(double a){
		this.goodV = a;
	}//11
	
	public String getgoodsytle(){
		return goodsytle;
	}
	public void setgoodsytle(String a){
		this.goodsytle = a;
	}//12
	
	public String getgoodsize(){
		return goodsize;
	}
	public void setgoodsize(String a){
		this.goodsize = a;
	}//13
	
	public String getlistid(){
		return listid;
	}
	public void setlistid(String a){
		this.listid = a;
	}//14
	
	public String getexpresstype(){
		return expresstype;
	}
	public void setexpresstype(String a){
		this.expresstype = a;
	}//15
	
	public String getpackagetype(){
		return packagetype;
	}
	public void setpackagetype(String a){
		this.packagetype = a;
	}//15
	
	public double getallcost(){
		return allcost;
	}
	public void setallcost(double a){
		this.allcost = a;
	}//16
	
	public String getexcepttime(){
		return excepttime;
	}
	public void setexcepttime(String a){
		this.excepttime = a;
	}//17
	
	public String getreceiveid(){
		return receiveid;
	}
	public void setreceiveid(String a){
		this.receiveid = a;
	}//18
	
	public String getreceivername(){
		return receivername;
	}
	public void setreceivername(String a){
		this.receivername = a;
	}//19
	
	public String getreceivertime(){
		return receivertime;
	}
	public void setreceivertime(String a){
		this.receivertime = a;
	}//20
	
	public String getSworkp(){
		return Sworkp;
	}
	public void setSworkp(String a){
		this.Sworkp = a;
	}//3
	
	public String getRworkp(){
		return Rworkp;
	}
	public void setRworkp(String a){
		this.Rworkp = a;
	}//4
}
