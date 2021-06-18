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
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.service.PreconditionService;

@RestController
@RequestMapping("/admin/precondition")
public class PreconditionRestController {
	
	private PreconditionService preconService;
	
	@Autowired
	public PreconditionRestController(PreconditionService precon) {
		this.preconService = precon;
	}
	
	@GetMapping("/")
	public Iterable<Precondition> indexPrecondition() {
		return preconService.findAll();
	}
	
	@GetMapping("/{id}")
	public Precondition findByIdPrecon(@PathVariable("id") long autotranId) {
		return preconService.findById(autotranId);
	}
	
	@PostMapping
	public void savePrecondition(@RequestBody Precondition precondition) {
		preconService.save(precondition);
	}
	
	@PutMapping
	public void updatePrecondition(@RequestBody Precondition precondition) {
		preconService.edit(precondition);
	}

	@DeleteMapping("/del/{id}")
	public void deletePrecondition(@PathVariable("id") long id) {
		Precondition pre = preconService.findById(id);
		preconService.delete(pre);
	}

}
