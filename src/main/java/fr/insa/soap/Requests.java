package fr.insa.soap;

public class Requests {
	private String [] States = {"Waiting","Validated","Rejected","Chosen","Realized"};
	
	private int request_id;
	private String intitule;
	private String user; 
	private String state;
	
	

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	public Requests(int id, String intitule, String demandeur) {
		this.request_id = id;
		this.intitule = intitule;
		this.user = demandeur;
		this.state = States[0];
	}
	
	public String getStates(int id) {
		return States[id];
	}

	public Requests() {
		
	}
	
}
