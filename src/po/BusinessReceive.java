package po;

import java.io.Serializable;

public class BusinessReceive implements Serializable{
	private String date="";
	private String identifier="";
	private String origin="";
	private String state="";
	private String readState = "";
	public BusinessReceive(String date,String identifier,String origin,String state,String readState){
		setDate(date);
		setIdentifier(identifier);
		setOrigin(origin);
		setState(state);
		setReadState(readState);
	}
	public void setReadState(String readState){
		this.readState = readState;
	}
	 public String getReadState(){
	    	return readState;
	    }
	public void setDate(String date){
		this.date=date;
	}
    public String getDate(){
    	return date;
    }
    public void setIdentifier(String identifier){
    	this.identifier=identifier;
    }
    public String getIdentifier(){
    	return identifier;
    }
    public void setOrigin(String origin){
		this.origin=origin;
	}
    public String getOrigin(){
    	return origin;
    }
    public void setState(String state){
		this.state=state;
	}
    public String getState(){
    	return state;
    }
}
