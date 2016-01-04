package po;

import java.io.Serializable;

public class StorageInPO implements Serializable{
	private String id;
	private long intime;
	private String destination;
	private long district;
	private long row;
	private long shelf;
	private long number;
	private String state;
	public StorageInPO(String id,long intime,String destination,long district,long row,long shelf,long number){
		setid(id);
		setintime(intime);
		setdestination(destination);
		setdistrict(district);
		setrow(row);
		setshelf(shelf);
		setnumber(number);
	}
	public void setstate(String state){
		this.state=state;
	}
	public String getstate(){
		return state;
	}
	public StorageInPO() {
		// TODO Auto-generated constructor stub
	}
	public void setnumber(long number) {
		// TODO Auto-generated method stub
		this.number=number;
	}
	public void setshelf(long shelf) {
		// TODO Auto-generated method stub
		this.shelf=shelf;
	}
	public void setrow(long row) {
		// TODO Auto-generated method stub
		this.row=row;
	}
	public void setdistrict(long district) {
		// TODO Auto-generated method stub
		this.district=district;
	}
	public void setdestination(String destination) {
		// TODO Auto-generated method stub
		this.destination=destination;
	}
	public void setintime(long intime) {
		// TODO Auto-generated method stub
		this.intime=intime;
	}
	public void setid(String id) {
		// TODO Auto-generated method stub
		this.id=id;
	}
	public String getid(){
		return id;
	}
	public long getintime(){
		return intime;
	}
	public String getdestination(){
		return destination;
	}
	public long getdistrict(){
		return district;
	}
	public long getrow(){
		return row;
	}
	public long getshelf(){
		return shelf;
	}
	public long getnumber(){
		return number;
	}

}
