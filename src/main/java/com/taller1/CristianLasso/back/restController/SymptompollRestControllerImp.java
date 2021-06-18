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
import com.taller1.CristianLasso.back.model.Symptompoll;
import com.taller1.CristianLasso.back.service.AutotransitionService;
import com.taller1.CristianLasso.back.service.SymptomService;
import com.taller1.CristianLasso.back.service.SymptompollService;

@RestController
@RequestMapping("/admin/symptompoll")
public class SymptompollRestControllerImp {

	private SymptompollService symppollService;

	@Autowired
	public SymptompollRestControllerImp(SymptompollService sympService) {
		this.symppollService = sympService;
	}

	@GetMapping("/")
	public Iterable<Symptompoll> indexAutotran() {
		return symppollService.findAll();
	}
	
	@GetMapping("/{id}")
	public Symptompoll findByIdAutotran(@PathVariable("id") long autotranId) {
		return symppollService.findById(autotranId);
	}

	@PostMapping
	public void saveAutotransition(@RequestBody Symptompoll autotransition) {
		symppollService.save(autotransition);
	}

	@PutMapping
	public void updateUser(@RequestBody Symptompoll autotransition) {
		symppollService.update(autotransition);
	}

	@DeleteMapping("/del/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		Symptompoll autotran = symppollService.findById(id);
		symppollService.delete(autotran);
	}
	
}