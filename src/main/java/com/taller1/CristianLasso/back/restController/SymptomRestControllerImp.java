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

import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.Symptom;
import com.taller1.CristianLasso.back.service.AutotransitionService;
import com.taller1.CristianLasso.back.service.SymptomService;

@RestController
@RequestMapping("/admin/symptom")
public class SymptomRestControllerImp {

	private SymptomService sympService;

	@Autowired
	public SymptomRestControllerImp(SymptomService sympService) {
		this.sympService = sympService;
	}

	@GetMapping("/")
	public Iterable<Symptom> indexAutotran() {
		return sympService.findAll();
	}
	
	@GetMapping("/{id}")
	public Symptom findByIdAutotran(@PathVariable("id") long autotranId) {
		return sympService.findById(autotranId);
	}

	@PostMapping
	public void saveAutotransition(@RequestBody Symptom autotransition) {
		sympService.save(autotransition);
	}

	@PutMapping
	public void updateUser(@RequestBody Symptom autotransition) {
		sympService.update(autotransition);
	}

	@DeleteMapping("/del/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		Symptom autotran = sympService.findById(id);
		sympService.delete(autotran);
	}
	
}