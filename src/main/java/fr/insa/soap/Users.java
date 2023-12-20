package fr.insa.soap;

import javax.jws.WebMethod;

public class Users extends Person{
 
	 public Users(int id, String name, String surname, int age, String gender) {
		 super(id,name,surname,age,gender);
	 }
	 
	 public Users() {
		 super();
	 }
	 
	 public String toString() {
		 return "User: " + this.gender + " " + this.name + " " + this.surname + " a " + this.age + " ans";
	 }
	 
}
