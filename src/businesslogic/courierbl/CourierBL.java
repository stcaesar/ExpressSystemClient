package businesslogic.courierbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import IPadress.IP;
import dataservice.AdministratorDataService.AdministratorDataService;
import dataservice.CourierDataService.CourierDataService;
import po.MemberPO;
import po.OrderListPO;

public class CourierBL {
	public static boolean checkorderlist(OrderListPO orderlist){
		try {
			CourierDataService courier = (CourierDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.courierdata");
			return courier.checkorderlist(orderlist);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean checkRec(OrderListPO orderlist){
		try {
			CourierDataService courier = (CourierDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.courierdata");
			return courier.checkRec(orderlist);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean saveorderlist(OrderListPO orderlist){
		try {
			CourierDataService courier = (CourierDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.courierdata");
			return courier.saveorderlist(orderlist);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean delorderlist(OrderListPO orderlist){
		try {
			CourierDataService courier = (CourierDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.courierdata");
			return courier.delorderlist(orderlist);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static OrderListPO getorderlist(OrderListPO orderlist){
		try {
			CourierDataService courier = (CourierDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.courierdata");
			OrderListPO result = courier.getorderlist(orderlist);
			return result;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<OrderListPO> getall(){
		try {
			CourierDataService courier = (CourierDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.courierdata");
			return courier.getallOrderList();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<OrderListPO> getallunchecked(){
		try {
			CourierDataService courier = (CourierDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.courierdata");
			return courier.getallunchecked();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getexpecttime(String saddress,String raddress,String etime){
		String result = "";
		try {
			CourierDataService courier = (CourierDataService) Naming.lookup("rmi://"+IP.ip+"/rmi.courierdata");
			ArrayList<OrderListPO> orderlist = courier.getallOrderList();
			int num = 0;
			int allday = 0;
			for(int i = 0;i<orderlist.size();i++){
				if(!orderlist.get(i).getreceivertime().equals("")){
					String[] stemp = orderlist.get(i).getSaddress().split("/");
					String[] rtemp = orderlist.get(i).getRaddress().split("/");
					if(saddress.equals(stemp[0])&&raddress.equals(rtemp[0])){
						String[] stime = orderlist.get(i).getexcepttime().split("/");
						String[] rtime = orderlist.get(i).getreceivertime().split("/");
						
						long intervalday = 0;
						SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy/MM/dd");
						try {
							Date date1 = simpledateformat.parse(orderlist.get(i).getexcepttime());
							Date date2 = simpledateformat.parse(orderlist.get(i).getreceivertime());
							intervalday = date2.getTime() - date1.getTime();
							intervalday = intervalday / 1000 / 60 / 60 / 24;
							System.out.println(intervalday);
						} 
						catch (ParseException e) {
							e.printStackTrace();
						} 
						allday = (int) (allday+intervalday);
						num++;
					}
				}
			}
			System.out.println(num);
			System.out.println(allday);
			if(num!=0)
			allday = allday/num;
			System.out.println(allday);
			SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = simpledateformat.parse(etime);
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(date);
			cal.add(Calendar.DATE, allday); 

			int Year = cal.get(Calendar.YEAR);  
	        int Month = cal.get(Calendar.MONTH);  
	        int Day = cal.get(Calendar.DAY_OF_MONTH);  
	        result = String.valueOf(Year)+"/"+String.valueOf(Month+1)+"/"+String.valueOf(Day);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static double Getexpresscost(String a,String b, String type,double mass) {
		double distance = 0;
		if(a.equals("北京")){
			if(b.equals("北京")){
				
			}
			else if(b.equals("上海")){
				distance=1064.7;
			}
			else if(b.equals("广州")){
				distance=1888.8;
			}
			else if(b.equals("南京")){
				distance=900;
			}
		}
		else if(a.equals("上海")){
			if(b.equals("北京")){
				distance=1064.7;
			}
			else if(b.equals("上海")){
				
			}
			else if(b.equals("广州")){
				distance=1213;
			}
			else if(b.equals("南京")){
				distance=266;
			}
		}
		else if(a.equals("广州")){
			if(b.equals("北京")){
				distance=1888.8;
			}
			else if(b.equals("上海")){
				distance=1213;
			}
			else if(b.equals("广州")){

			}
			else if(b.equals("南京")){
				distance=1132;
			}
		}
		else if(a.equals("南京")){
			if(b.equals("北京")){
				distance=900;
			}
			else if(b.equals("上海")){
				distance=266;
			}
			else if(b.equals("广州")){
				distance=1132;
			}
			else if(b.equals("南京")){

			}
		}
		
		double expresscost = distance/1000*23*mass;
		
		if(type.equals("经济快递")){
			expresscost = expresscost*18/23;
		}
		else if(type.equals("标准快递")){
			
		}
		else if(type.equals("特快专递")){
			expresscost = expresscost*25/23;
		}
		return expresscost;
	}

	public static double getmass(double V,double M) {
		double result = Math.max(V/5000, M);
		return result;
	}

	public static double getpcost(String type) {
		double result = 0;
		if(type.equals("纸箱")){
			result = 5;
		}
		else if(type.equals("木箱")){
			result = 10;
		}
		else if(type.equals("快递袋")){
			result = 1;
		}
		else if(type.equals("其他")){
			
		}
		return result;
	}
	
	
	
	public static void main(String[] args){
		String str = getexpecttime("北京","上海","2015/3/3");
		System.out.println(str);
	}
	
}
