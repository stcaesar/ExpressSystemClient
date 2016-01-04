package po;

import java.io.Serializable;

public class TransportSendPO implements Serializable{
	
	private  String SendTranscodeID="";
	private  String Flightcode="";
	private String Way="";
	private  String Senddate="";
	private String Startaddress="";
	private String Endaddress="";
	private String WatcherID="";
	private double Fare=0;
	private String Read="";
	public TransportSendPO(){
		
	}
	public TransportSendPO(String sendtranscodeid,String flightcode,String way,
			String senddate,String startaddress,String endaddress,String watcherid,double fare,String read){
		this.Flightcode=flightcode;
		this.SendTranscodeID=sendtranscodeid;
		this.Way=way;
		this.Senddate=senddate;
		this.Startaddress=startaddress;
		this.Endaddress=endaddress;
		this.WatcherID=watcherid;
		this.Fare=fare;
		this.Read=read;
	}
	public void setFare(double fare){
		Fare=fare;
	}
	public void setFlightcode(String id){
		Flightcode=id;
	}
	public  void setSendtranscodeid(String id){
		SendTranscodeID=id;
	}
	
	
	public void setWay(String way){
		Way=way;
	}
	public void setSenddate(String stuff){
		Senddate=stuff;
	}
	public void setEndaddress(String stuff){
		Endaddress=stuff;
	}
	public void setStartaddress(String stuff){
		Startaddress=stuff;
	}
	public void setWatcherid(String stuff){
		WatcherID=stuff;
	}
	public void setRead(String stuff){
		Read=stuff;
	}
	public double getFare(){
		return Fare;
	}
	public String getFlightcode(){
		return Flightcode;
	}
	public String getSendtranscodeid(){
		return SendTranscodeID;
	}
	public String getWay(){
		return Way;
	}
	public String getSenddate(){
		return Senddate;
	}
	public  String getEndaddress(){
		return Endaddress;
	}
	public String getStartaddress(){
		return Startaddress;
	}
	public String getWatcherid(){
		return WatcherID;
	}
	public String getRead(){
		return Read;
	}
}
