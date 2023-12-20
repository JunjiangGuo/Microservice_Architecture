package fr.insa.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="personmanager")
public class gestionPerson {

	@WebMethod(operationName="addU")
	public Person addUsers(int id, String name, String surname, int age, String gender) {
		System.out.println("User added.");
		return new Users(id, name, surname, age, gender);
	}
	@WebMethod(operationName="addV")
	public Person addVolunteers(int id, String name, String surname, int age, String gender) {
		System.out.println("Volunteer added.");
		return new Volunteers(id, name, surname, age, gender);
	}
	@WebMethod(operationName="addA")
	public Person addAdmin(int id, String name, String surname, int age, String gender) {
		System.out.println("Admin added.");
		Administrator a= new Administrator(id, name, surname, age, gender);
		return a;
	}
}