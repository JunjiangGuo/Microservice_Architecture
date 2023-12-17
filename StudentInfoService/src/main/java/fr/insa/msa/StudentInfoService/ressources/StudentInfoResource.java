package fr.insa.msa.StudentInfoService.ressources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.msa.StudentInfoService.modele.StudentInfos;

@RestController
@RequestMapping("/student")
public class StudentInfoResource {
	
	@GetMapping("/{idStudent}")
	public StudentInfos getInfoEtudent(@PathVariable("idStudent") int id) {
		List<StudentInfos> etudInfos = Arrays.asList(
				new StudentInfos(0,"G","N","12/12/1992"),
				new StudentInfos(1,"fqf","qf","12/12/1992"),
				new StudentInfos(2,"qfqf","qfqsf","12/12/1992"),
				new StudentInfos(3,"A","B","12/12/1222")
				);
		System.out.println("Called!");
		return etudInfos.get(id);
				
	}
}
