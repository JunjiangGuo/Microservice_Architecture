package fr.insa.soap;

public class Volunteers extends Person{

	 public Volunteers(int id, String name, String surname, int age, String gender) {
		 super(id,name,surname,age,gender);
	 }
	 
	 public Volunteers() {
		 super();
	 }
	 
	 public String toString() {
		 return "Volunteer: " + this.gender + " " + this.name + " " + this.surname + " a " + this.age + " ans";
	 }
}
