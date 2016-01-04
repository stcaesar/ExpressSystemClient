package po;

import java.io.Serializable;

public class BusinessDistribution implements Serializable {
	private String arrivalDate="";
	private String barCode="";
	private String dispatcher="";
	private String readState = "";
public BusinessDistribution(){
		
	}
	public BusinessDistribution(String arrivalDate,String barCode,String dispatcher,String readState){
		setArrivalDate(arrivalDate);setBarCode(barCode);setDispatcher(dispatcher);setReadState(readState);
	}
    public void setArrivalDate(String arrivalDate){
		this.arrivalDate=arrivalDate;
	}
    public String getArrivalDate(){
    	return arrivalDate;
    }public void setBarCode(String barCode){
		this.barCode=barCode;
	}
    public String getBarCode(){
    	return barCode;
    }public void setDispatcher(String dispatcher){
		this.dispatcher=dispatcher;
	}
    public String getDispatcher(){
    	return dispatcher;
    }
    public void setReadState(String readState){
    	this.readState = readState;
    }
	public Object getReadState() {
		return readState;
	}
}

