package po;

import java.io.Serializable;

public class ManagerMember implements Serializable{
	private String rank = "";
	private String unit = "";
	private String name = "";
	public ManagerMember(String rank,String unit,String name){
		setRank(rank);
		setUnit(unit);
		setName(name);
		
	}
	public void setUnit(String unit){
		this.unit= unit;
	}
	public String getUnit(){
		return unit;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setRank(String rank){
		this.rank = rank;
	}
	public String getRank(){
		return rank;
	}

}
