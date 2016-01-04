package businesslogic.senderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.courierbl.CourierBL;
import businesslogic.transportbl.TransportRecvBL;
import businesslogic.transportbl.TransportSendBL;
import po.OrderListPO;
import po.TransportRecvPO;
import po.TransportSendPO;
import dataservice.CourierDataService.CourierDataService;

public class SenderBL {

	public static ArrayList<String> check(String orderid) {
			OrderListPO orderlist = new OrderListPO();
			orderlist.setlistid(orderid);
			orderlist = CourierBL.getorderlist(orderlist);
			ArrayList<String> result = new ArrayList();
			TransportRecvBL transrec =new TransportRecvBL();
			TransportSendBL transsend = new TransportSendBL();

			ArrayList<TransportSendPO> send = transsend.searchSend(orderid);
			if(!(send==null)){
				for(int i = 0;i<send.size();i++){
					String temp = send.get(i).getSenddate()+"从"+send.get(i).getStartaddress()+"中转站出发";
					result.add(temp);
				}
			}
			
			if(CourierBL.checkorderlist(orderlist)){
				if(orderlist.getreceiveid().equals("")){
				result.add("物件还未到达目的地");
				}
				else{
					String str =orderlist.getreceivertime()+ "  物件已被"+orderlist.getreceivername()+"收取";
					result.add(str);
					
				}
			}
			else{
				result.add("无信息");
			}
		
			
			return result;
		
		
		
		
	}

}
