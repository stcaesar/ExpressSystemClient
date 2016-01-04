package po;

import java.io.Serializable;

public class TransportRecvPO implements Serializable{
	private String PackageID="";	
	private String RecvTranscodeID="";
	private String Recvdate="";
	private  String Startaddress="";
	private  String State="";
	private String Read="";
	public TransportRecvPO(){
		
	}
	public TransportRecvPO(String packageid,String recvdate,String startaddress,
			String state,String recvlistid,String read){
		this.PackageID=packageid;		
		this.RecvTranscodeID=recvlistid;
		this.Recvdate=recvdate;
		this.Startaddress=startaddress;
		this.State=state;
		this.Read=read;
	}
	public void setPackageid(String id){
		PackageID=id;
	}
	public void setRead(String stuff){
		Read=stuff;
	}
	public  void setRecvtranscodeid(String id){
		RecvTranscodeID=id;
	}
	public void setRecvdate(String stuff){
		Recvdate=stuff;
	}
	public void setStartaddress(String stuff){
		Startaddress=stuff;
	}
	public  void setState(String stuff){
		State=stuff;
	}
	public  String getPackageid(){
		return PackageID;
	}
	
	public String getRecvtranscodeid(){
		return RecvTranscodeID;
	}
	public  String getRecvdate(){
		return Recvdate;
	}
	public  String getStartaddress(){
		return Startaddress;
	}
	public  String getState(){
		return State;
	}
	public String getRead(){
		return Read;
	}
}
