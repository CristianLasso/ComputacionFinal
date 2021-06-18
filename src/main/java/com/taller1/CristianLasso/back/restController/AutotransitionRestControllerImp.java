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
import com.taller1.CristianLasso.back.service.AutotransitionService;

@RestController
@RequestMapping("/admin/autotransition")
public class AutotransitionRestControllerImp {

	private AutotransitionService autotranService;

	@Autowired
	public AutotransitionRestControllerImp(AutotransitionService autotranService) {
		this.autotranService = autotranService;
	}

	@GetMapping("/")
	public Iterable<Autotransition> indexAutotran() {
		return autotranService.findAll();
	}
	
	@GetMapping("/{id}")
	public Autotransition findByIdAutotran(@PathVariable("id") long autotranId) {
		return autotranService.findById(autotranId);
	}

	@PostMapping
	public void saveAutotransition(@RequestBody Autotransition autotransition) {
		autotranService.save(autotransition);
	}

	@PutMapping
	public void updateUser(@RequestBody Autotransition autotransition) {
		autotranService.edit(autotransition);
	}

	@DeleteMapping("/del/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		Autotransition autotran = autotranService.findById(id);
		autotranService.delete(autotran);
	}
	
}