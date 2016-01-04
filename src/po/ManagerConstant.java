package po;

import java.io.Serializable;

public class ManagerConstant implements Serializable {
	private String city1 = "";
	private String city2 = "";
	private String distance = "";
	private String save = "";
	private String standard = "";
	private String fast = ""; 
	public ManagerConstant(String city1,String city2,String distance,String save,String standard,String fast){
		setCity1(city1);setCity2(city2);setDistance(distance);setSave(save);setStandard(standard);setFast(fast);
		
	}
	public void setCity1(String city1){
		this.city1 = city1; 
	}
	public String getCity1(){
		return city1;
	}
	public void setCity2(String city2){
		this.city2 =city2; 
	}
	public String getCity2(){
		return city2;
	}
	public void setDistance(String distance){
		this.distance = distance;
	}
	public String getDistance(){
		return distance;
	}
	public void setSave(String save){
		this.save = save;
	}
	public String getSave(){
		return save;
	}
	public void setStandard(String standard){
		this.standard = standard;
	}
	public String getStandard(){
		return standard;
	}
	public void setFast(String fast){
		this.fast = fast;
	}
	public String getFast(){
		return fast;
	}

}
