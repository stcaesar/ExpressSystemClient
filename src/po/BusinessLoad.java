package po;

import java.io.Serializable;

public class BusinessLoad implements Serializable{
	private String date="";
	private String businessIdentifier="";
	private String carIdentifier="";
	private String destination="";
	private String carCode="";
	private String supervision="";
	private String superCargo="";
	private String barCode="";
	private String money="";
	private String readState = "";
	public BusinessLoad(String date,String businessIdentifier,String carIdentifier,String destination,String carCode,String supervision,String superCargo,String barCode,String money,String readState){
		setDate(date);
		setBusinessIdentifier(businessIdentifier);setCarIdentifier(carIdentifier);setDestination(destination);setCarCode(carCode);setSupervision(supervision);setSuperCargo(superCargo);setBarCode(barCode);setMoney(money);setReadState(readState);
	}
	public void setDate(String date){
		this.date=date;
	}
    public String getDate(){
    	return date;
    }public void setBusinessIdentifier(String businessIdentifier){
		this.businessIdentifier=businessIdentifier;
	}
    public String getBusinessIdentifier(){
    	return businessIdentifier;
    }public void setCarIdentifier(String carIdentifier){
		this.carIdentifier=carIdentifier;
	}
    public String getCarIdentifier(){
    	return carIdentifier;
    }public void setDestination(String destination){
		this.destination=destination;
	}
    public String getDestination(){
    	return destination;
    }public void setCarCode(String carCode){
		this.carCode=carCode;
	}
    public String getCarCode(){
    	return carCode;
    }public void setSupervision(String supervision){
		this.supervision=supervision;
	}
    public String getSupervision(){
    	return supervision;
    }public void setSuperCargo(String superCargo){
		this.superCargo=superCargo;
	}
    public String getSuperCargo(){
    	return superCargo;
    }public void setBarCode(String barCode){
		this.barCode=barCode;
	}
    public String getBarCode(){
    	return barCode;
    }
    public void setMoney(String money){
    	 this.money= money;
    }
    public String getMoney(){
    	return money;
    }
    public void setReadState(String readState){
    	this.readState=readState;
    }
    
    public String getReadState(){
    	return readState;
    }
    
}
