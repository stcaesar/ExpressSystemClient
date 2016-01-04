package businesslogicservice.TransportBLService;

import po.TransportRecvPO;

public interface TransportRecvBLService {
	TransportRecvPO transportrecvpo=new TransportRecvPO();
	public boolean addRecvlist(String Packageid,String Recvdate,String Recvstartaddress,
			String Recvstate,String Recvtranscode);
	public boolean addPackageid(TransportRecvPO transportrecvpo,String id);
	public boolean addRecvdate(TransportRecvPO transportrecvpo,String date);
	public boolean addRecvstartaddress(TransportRecvPO transportrecvpo,String address);
	public boolean addRecvstate(TransportRecvPO transportrecvpo,String state);
	public boolean addRecvtranscodeid(TransportRecvPO transportrecvpo,String id);
	public void getAll(TransportRecvPO transportrecvpo);
	public void endRecv();
}