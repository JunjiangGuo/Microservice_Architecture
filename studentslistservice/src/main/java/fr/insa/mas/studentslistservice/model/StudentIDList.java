package fr.insa.mas.studentslistservice.model;

import java.util.ArrayList;
import java.util.List;

public class StudentIDList {
	List <Integer> studentList;
	
	public StudentIDList() {
		this.studentList = new ArrayList<Integer>();
	}
	
	public List<Integer> getStudentList(){
		return studentList;
	}
	
	public void saddStudentToList(Integer studentId) {
		this.studentList.add(studentId);
	}
}
