package po;

import java.io.Serializable;

public class BusinessDriverManagement implements Serializable {
	private String driverNumber="";
	private String name="";
	private String birthDate="";
	private String identifyNumber="";
	private String phoneNumber="";
	private String gender="";
	private String registrationDeadline="";
	public BusinessDriverManagement(String driverNumber,String name,String birthDate,String identifyNumber
			,String phoneNumber,String gender,String registrationDeadline){
		setDriverNumber(driverNumber);setName(name);setBirthDate(birthDate);setIdentifyNumber(identifyNumber);setPhoneNumber(phoneNumber);
		setGender(gender);setRegistrationDeadline(registrationDeadline);
		
	}
	public void setDriverNumber(String driverNumber ){
		this.driverNumber=driverNumber;
	}
    public String getDriverNumber(){
    	return driverNumber;
    }
    public void setName(String name){
		this.name=name;
	}
    public String getName(){
    	return name;
    }
    public void setBirthDate(String birthDate){
		this.birthDate=birthDate;
	}
    public String getBirthDate(){
    	return birthDate;
    }
    public void setIdentifyNumber(String identifyNumber){
		this.identifyNumber=identifyNumber;
	}
    public String getIdentifyNumber(){
    	return identifyNumber;
    }
    public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
    public String getPhoneNumber(){
    	return phoneNumber;
    }
    public void setGender(String gender){
		this.gender=gender;
	}
    public String getGender(){
    	return gender;
    }
    public void setRegistrationDeadline(String registrationDeadline){
		this.registrationDeadline=registrationDeadline;
	}
    public String getRegistrarionDeadline(){
    	return registrationDeadline;
    }
}
