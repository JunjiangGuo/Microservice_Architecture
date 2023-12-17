package fr.insa.msa.studentEvalService.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.msa.studentEvalService.model.Evaluation;

@RestController
@RequestMapping("/evaluation")
public class StudentEvaResource {
	
	@GetMapping("/{idStudent}")
	public Evaluation getStudenEval(@PathVariable("idStudent") int idEtud) {
		
		List<Evaluation> evalList = Arrays.asList(
			new Evaluation(0,13F),
			new Evaluation(1, 10.65F),
			new Evaluation(2,18F),
			new Evaluation(3,15F)
			);

		return evalList.get(idEtud);
	}
}
