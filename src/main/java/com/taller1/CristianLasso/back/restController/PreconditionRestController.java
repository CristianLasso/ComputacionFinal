package com.taller1.CristianLasso.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.service.PreconditionService;

@Controller
@RequestMapping("/admin")
public class PreconditionRestController {
	
	private PreconditionService preconService;
	
	@Autowired
	public PreconditionRestController(PreconditionService precon) {
		this.preconService = precon;
	}
	
	@GetMapping("/precondition/")
	public Iterable<Precondition> indexPrecondition() {
		return preconService.findAll();
	}
	
	@PostMapping("/precondition/add-precondition")
	public void savePrecondition(@RequestBody Precondition precondition) {
		preconService.save(precondition);
	}
	
	@PostMapping("/precondition/edit/{id}")
	public void updatePrecondition(Precondition precondition) {
		preconService.save(precondition);
	}

	@GetMapping("/precondition/del/{id}")
	public void deletePrecondition(@PathVariable("id") long id) {
		Precondition pre = preconService.findById(id);
		preconService.delete(pre);
	}

}
