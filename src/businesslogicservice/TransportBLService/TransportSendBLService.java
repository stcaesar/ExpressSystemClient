package businesslogicservice.TransportBLService;

import javax.swing.JLabel;


import po.TransportSendPO;

public interface TransportSendBLService {
	TransportSendPO transportsendpo=new TransportSendPO();
	public boolean addWay(TransportSendPO transportsendpo,String id);
	public boolean addFlight(TransportSendPO transportsendpo,String id);
	public boolean addSenddate(TransportSendPO transportsendpo,String id);
	public boolean addStartaddress(TransportSendPO transportsendpo,String id);
	public boolean addEndaddress(TransportSendPO transportsendpo,String id);
	public boolean addSendtranscode(TransportSendPO transportsendpo,String id);
	public boolean addWatcher(TransportSendPO transportsendpo,String id);
	public boolean addFare(TransportSendPO transportsendpo,double money);
	public void getAll(TransportSendPO transportsendpo);
}
