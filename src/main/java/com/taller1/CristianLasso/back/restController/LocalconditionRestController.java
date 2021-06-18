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
import com.taller1.CristianLasso.back.model.Localcondition;
import com.taller1.CristianLasso.back.service.LocalconditionService;

@RestController
@RequestMapping("/admin/localcondition")
public class LocalconditionRestController {

	private LocalconditionService localconService;
	
	@Autowired
	public LocalconditionRestController(LocalconditionService localcon) {
		this.localconService = localcon;
	}
	
	@GetMapping("/")
	public Iterable<Localcondition> indexLocalcondition() {
		return localconService.findAll();
	}
	
	@GetMapping("/{id}")
	public Localcondition findByIdLocalcon(@PathVariable("id") long autotranId) {
		return localconService.findById(autotranId);
	}
	
	@PostMapping
	public void saveLocalcondition(@RequestBody Localcondition localcondition) {
		localconService.save(localcondition);
	}
	
	@PutMapping
	public void updateLocalcondition(@RequestBody Localcondition localcondition) {
		localconService.edit(localcondition);
	}

	@DeleteMapping("/del/{id}")
	public void deleteLocalcondition(@PathVariable("id") long id) {
		Localcondition local = localconService.findById(id);
		localconService.delete(local);
	}
	
}
