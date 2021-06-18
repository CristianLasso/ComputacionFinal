package com.taller1.CristianLasso.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller1.CristianLasso.back.model.Symptom;
import com.taller1.CristianLasso.back.model.Symptomquestion;
import com.taller1.CristianLasso.back.service.SymptomService;
import com.taller1.CristianLasso.back.service.SymptomquestionService;

@RestController
@RequestMapping("/admin/symptomquestion")
public class SymptomquestionRestControllerImp {
	
	private SymptomquestionService symquesService;

	@Autowired
	public SymptomquestionRestControllerImp(SymptomquestionService symquesService) {
		this.symquesService = symquesService;
	}

	@GetMapping("/")
	public Iterable<Symptomquestion> indexAutotran() {
		return symquesService.findAll();
	}
	
	@GetMapping("/{id}")
	public Symptomquestion findByIdAutotran(@PathVariable("id") long autotranId) {
		return symquesService.findById(autotranId);
	}

	@PostMapping
	public void saveAutotransition(@RequestBody Symptomquestion autotransition) {
		symquesService.save(autotransition);
	}

	@PutMapping
	public void updateUser(@RequestBody Symptomquestion autotransition) {
		symquesService.update(autotransition);
	}

	@DeleteMapping("/del/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		Symptomquestion autotran = symquesService.findById(id);
		symquesService.delete(autotran);
	}

}
