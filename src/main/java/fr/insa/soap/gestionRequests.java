package fr.insa.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="requestsmanager")

public class gestionRequests {

	@WebMethod(operationName="addR")
	public Requests addRequest(int id, String name, String user, String state) {
		System.out.println("Request added.");
		Requests r1 = new Requests(id,name,user);
		return r1;
	}
	
	
	@WebMethod(operationName="ApproveR")
	public boolean approveRequest() {
		Requests R = new Requests(1,"Guo","Junjiang");
		R.setState(R.getStates(1));
		System.out.println("State Changed to "+R.getState());
		
		return true;
	}
	
	@WebMethod(operationName="DenyR")
	public boolean DenyRequest() {
		Requests R = new Requests(1,"Guo","Junjiang");
		R.setState(R.getStates(2));
		System.out.println("State Changed to "+R.getState());
	
		return true;
	}
	
}
