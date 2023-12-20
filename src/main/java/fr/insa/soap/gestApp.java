package fr.insa.soap;

import javax.xml.ws.Endpoint;

public class gestApp {

	public static String host = "localhost";
	public static short port = 8090;
	
	public void demarrerService() {
		String url = "http://" + host + ":" + port + "/";
		String url1 = "http://" + host + ":" + 8091 + "/";
		Endpoint.publish(url, new gestionPerson());
		Endpoint.publish(url1, new gestionRequests());
	}
	
	public static void main(String[] args) {
		
		new gestApp().demarrerService();
		System.out.println("Service a démarré");
		
		Administrator U = new Administrator(1,"G","S",23,"M");
				
	}

}
