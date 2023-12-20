package fr.insa.soa.RestProject;

public class Person {
	 int id;
	 String name;
	 String surname;
	 int age;
	 String gender;
 
	 public Person(int id, String name, String surname, int age, String gender) {
		 this.id = id;
		 this.name = name;
		 this.surname = surname;
		 this.age = age;
		 this.gender = gender;
	 }
	 
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	 public Person(){
		 
	 }
	 
	 @Override
	 public String toString() {
	        return "Person{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", surname='" + surname + '\'' +
	                ", age=" + age +
	                ", gender='" + gender + '\'' +
	                '}';
	    }
	 
}
