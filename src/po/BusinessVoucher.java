package po;

import java.io.Serializable;

public class BusinessVoucher implements Serializable {
	private String receiptDate="";
	private String money="";
	private String courier="";
	private String barCode="";
	private String readState = "";
	public BusinessVoucher(String receiptDate,String money,String courier,String barCode,String readState){
		setReceiptDate(receiptDate);setMoney(money);setCourier(courier);setBarCode(barCode);setReadState(readState);
		
	}
	public void setReceiptDate(String receiptDate){
		this.receiptDate=receiptDate;
	}
    public String getReceiptDate(){
    	return receiptDate;
    }public void setMoney(String money){
		this.money=money;
	}
    public String getMoney(){
    	return money;
    }public void setCourier(String courier){
		this.courier=courier;
	}
    public String getCourier(){
    	return courier;
    }public void setBarCode(String barCode){
		this.barCode=barCode;
	}
    public String getBarCode(){
    	return barCode;
    }
    public void setReadState(String readState){
    	this.readState = readState;
    }
    public String getReadState(){
    	return readState;
    } 

}
