package po;

import java.io.Serializable;

public class StorageOutPO implements Serializable{
	private String id;
	private String destination;
	private long outtime;
	private String transport;
	private long centralid;
	private String state;
	public StorageOutPO(String id,String destination,long outtime,String transport,long centralid){
		setid(id);
		setdestination(destination);
		setouttime(outtime);
		settransport(transport);
		setcentralid(centralid);
		setstate("unchecked");
	}
	public void setstate(String state){
		this.state=state;
	}
	public String getstate(){
		return state;
	}
	public StorageOutPO() {
		// TODO Auto-generated constructor stub
	}
	public void setid(String id) {
		// TODO Auto-generated method stub
		this.id=id;
	}
	public void setdestination(String destination) {
		// TODO Auto-generated method stub
		this.destination=destination;
	}
	public void setouttime(long outtime) {
		// TODO Auto-generated method stub
		this.outtime=outtime;
	}
	public void settransport(String transport) {
		// TODO Auto-generated method stub
		this.transport=transport;
	}
	public void setcentralid(long centralid) {
		// TODO Auto-generated method stub
		this.centralid=centralid;
	}
	public String getid(){
		return id;
	}
	public String getdestination(){
		return destination;
	}
	public long getouttime(){
		return outtime;
	}
	public String gettransport(){
		return transport;
	}
	public long getcentralid(){
		return centralid;
	}

}
