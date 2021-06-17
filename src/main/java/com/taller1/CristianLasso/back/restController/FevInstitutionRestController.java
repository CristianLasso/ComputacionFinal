package com.taller1.CristianLasso.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.service.FevInstitutionService;

@Controller
@RequestMapping("/admin")
public class FevInstitutionRestController {
	
	private FevInstitutionService instService;
	
	@Autowired
	public FevInstitutionRestController(FevInstitutionService instService) {
		this.instService = instService;
	}
	
	@GetMapping("/fevInstitution/")
	public Iterable<FevInstitution> indexFevInstitution() {
		return instService.findAll();
	}
	
	@PostMapping("/fevInstitution/add-fevInstitution")
	public void saveFevInstitution(@RequestBody FevInstitution fevInstitution) {
		instService.save(fevInstitution);
	}

	@PostMapping("/fevInstitution/edit/{id}")
	public void updateFevInstitution(FevInstitution fevInstitution) {
		instService.save(fevInstitution);
	}

	@GetMapping("/fevInstitution/del/{id}")
	public void deleteFevInstitution(@PathVariable("id") long id) {
		FevInstitution inst = instService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		instService.delete(inst);
	}

}
