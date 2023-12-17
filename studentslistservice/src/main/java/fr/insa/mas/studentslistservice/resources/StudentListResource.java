package fr.insa.mas.studentslistservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.studentslistservice.model.*;
import fr.insa.msa.StudentInfoService.modele.StudentInfos;
import fr.insa.msa.studentEvalService.model.Evaluation;


@RestController
@RequestMapping("/students")
public class StudentListResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("ids/{idSpeciality}")
	public StudentIDList getIDStudent(@PathVariable("idSpeciality") String speciality) {
		
		StudentIDList studentsId = new StudentIDList();
		studentsId.saddStudentToList(0);
		studentsId.saddStudentToList(1);
		studentsId.saddStudentToList(2);
		studentsId.saddStudentToList(3);

		return studentsId;
	}
	
	@GetMapping("/all/{idSpeciality}")
	public List<Student> getStudents(@PathVariable("idSpeciality") String speciality) {
		
		StudentIDList students = new StudentIDList();
		students.saddStudentToList(0);
		students.saddStudentToList(1);
		students.saddStudentToList(2);
		students.saddStudentToList(3);

		
		int i= 0;
		List<Student> listStudents = new ArrayList<Student>();
		
		while (i<students.getStudentList().size()) {
			
			StudentInfos etudInfos = restTemplate.getForObject("http://studentInfoService/student/"+i, StudentInfos.class);
			
			Evaluation eval = restTemplate.getForObject("http://studentEvaluationService/evaluation/"+i, Evaluation.class);
			
			listStudents.add(new Student(i,etudInfos.getFirstName(),etudInfos.getLastName(),eval.getAvreage()));
			i++;
		}
		
		return listStudents;
	}
	
}
