package com.taller1.CristianLasso.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taller1.CristianLasso.back.model.Localcondition;
import com.taller1.CristianLasso.back.service.LocalconditionService;

@Controller
@RequestMapping("/admin")
public class LocalconditionRestController {

	private LocalconditionService localconService;
	
	@Autowired
	public LocalconditionRestController(LocalconditionService localcon) {
		this.localconService = localcon;
	}
	
	@GetMapping("/localcondition/")
	public Iterable<Localcondition> indexLocalcondition() {
		return localconService.findAll();
	}
	
	@PostMapping("/localcondition/add-localcondition")
	public void saveLocalcondition(@RequestBody Localcondition localcondition) {
		localconService.save(localcondition);
	}
	
	@PostMapping("/localcondition/edit/{id}")
	public void updateLocalcondition(Localcondition localcondition) {
		localconService.save(localcondition);
	}

	@GetMapping("/localcondition/del/{id}")
	public void deleteLocalcondition(@PathVariable("id") long id) {
		Localcondition local = localconService.findById(id);
		localconService.delete(local);
	}
	
}
