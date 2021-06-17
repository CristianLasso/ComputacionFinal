package com.taller1.CristianLasso.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.service.AutotransitionService;

@RestController
@RequestMapping("/admin")
public class AutotransitionRestControllerImp {

	private AutotransitionService autotranService;

	@Autowired
	public AutotransitionRestControllerImp(AutotransitionService autotranService) {
		this.autotranService = autotranService;
	}

	@GetMapping("/autotransition/")
	public Iterable<Autotransition> indexAutotran() {
		return autotranService.findAll();
	}

	@PostMapping("/autotransition/add-autotransition")
	public void saveAutotransition(@RequestBody Autotransition autotransition) {
		autotranService.save(autotransition);
	}

	@PostMapping("/autotransition/edit/{id}")
	public void updateUser(Autotransition autotransition) {
		autotranService.save(autotransition);
	}

	@GetMapping("/users/del/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		Autotransition autotran = autotranService.findById(id);
		autotranService.delete(autotran);
	}
	
}