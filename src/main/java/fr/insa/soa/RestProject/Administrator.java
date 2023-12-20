package fr.insa.soa.RestProject;

public class Administrator extends Person{

 
	 public Administrator(int id, String name, String surname, int age, String gender) {
		 super(id,name,surname,age,gender);
	 }
	 
	 public Administrator() {
		 super();
	 }
	 
	 public String toString() {
		 return "Admin: " + this.gender + " " + this.name + " " + this.surname + " a " + this.age + " ans";
	 }
}
