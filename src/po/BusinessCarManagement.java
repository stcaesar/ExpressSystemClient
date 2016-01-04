package po;

import java.io.Serializable;

public class BusinessCarManagement implements Serializable {
	private String carNumber="";
	private String businessuiNumber="";
	private String plateNumber="";
	private String serviceTime="";
	public BusinessCarManagement(String carNumber,String businessuiNumber, String plateNumber,String serviceTime){
		setCarNumber(carNumber);setBusinessuiNumber(businessuiNumber);setPlateNumber(plateNumber);setServiceTime(serviceTime);
		
	}
	public void setCarNumber(String carNumber ){
		this.carNumber=carNumber;
	}
    public String getCarNumber(){
    	return carNumber;
    }
    
    public void setBusinessuiNumber(String businessuiNumber){
		this.businessuiNumber=businessuiNumber;
	}
    public String getBusinessuiNumber(){
    	return businessuiNumber;
    }
    public void setPlateNumber(String plateNumber){
		this.plateNumber=plateNumber;
	}
    public String getPlateNumber(){
    	return plateNumber;
    }
    public void setServiceTime(String serviceTime){
		this.serviceTime=serviceTime;
	}
    public String getServiceTime(){
    	return serviceTime;
    }
}
