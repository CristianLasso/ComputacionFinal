package com.taller1.CristianLasso.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.service.FevInstitutionService;

@RestController
@RequestMapping("/admin/fevInstitution")
public class FevInstitutionRestController {
	
	private FevInstitutionService instService;
	
	@Autowired
	public FevInstitutionRestController(FevInstitutionService instService) {
		this.instService = instService;
	}
	
	@GetMapping("/")
	public Iterable<FevInstitution> indexFevInstitution() {
		return instService.findAll();
	}
	
	@GetMapping("/{id}")
	public FevInstitution findByIdAutotran(@PathVariable("id") long autotranId) {
		return instService.findById(autotranId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + autotranId));
	}
	
	@PostMapping
	public void saveFevInstitution(@RequestBody FevInstitution fevInstitution) {
		instService.save(fevInstitution);
	}

	@PutMapping
	public void updateFevInstitution(@RequestBody FevInstitution fevInstitution) {
		instService.save(fevInstitution);
	}

	@DeleteMapping("/del/{id}")
	public void deleteFevInstitution(@PathVariable("id") long id) {
		FevInstitution inst = instService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		instService.delete(inst);
	}

}
