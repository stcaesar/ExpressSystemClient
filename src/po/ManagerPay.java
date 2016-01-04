package po;

import java.io.Serializable;

public class ManagerPay implements Serializable{
    private String rank = "";
    private String job = "";
    private String money = "";
    public ManagerPay(String rank,String job,String money){
    	setRank(rank);setJob(job);setMoney(money);
    }
    public void setRank(String rank){
    	this.rank = rank;
    }
    public String getRank(){
    	return rank;
    }

    public void setJob(String job){
    	this.job = job;
    }
    public String getJob(){
    	return job;
    }
    public void setMoney(String money){
    	this.money = money;
    }
    public String getMoney(){
    	return money;
    }
}

