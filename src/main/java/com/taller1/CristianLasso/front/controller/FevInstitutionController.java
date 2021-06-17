package com.taller1.CristianLasso.front.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taller1.CristianLasso.back.model.FevInstitution;
import com.taller1.CristianLasso.back.service.FevInstitutionService;
import com.taller1.CristianLasso.back.validation.FevInstitutionValidation;

@Controller
@RequestMapping("/user")
public class FevInstitutionController {
	
	private FevInstitutionService instService;
	
	@Autowired
	public FevInstitutionController(FevInstitutionService instService) {
		this.instService = instService;
	}
	
	@GetMapping("/fevInstitution/")
	public String indexFevInstitution(Model model) {
		model.addAttribute("fevInstitution", instService.findAll());
		return "fevInstitution/index";
	}
	
	@GetMapping("/fevInstitution/add-fevInstitution")
	public String addFevInstitution(Model model, @ModelAttribute("fevInstitution") FevInstitution fevInstitution) {
		model.addAttribute("fevInstitution", new FevInstitution());
		return "fevInstitution/add-fevInstitution";
	}
	
	@PostMapping("/fevInstitution/add-fevInstitution")
	public String saveFevInstitution(@Validated(FevInstitutionValidation.class) FevInstitution fevInstitution,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "/fevInstitution/add-fevInstitution";
			} else {
				instService.save(fevInstitution);
			}
		return "redirect:/fevInstitution/";
	}
	
	@GetMapping("/fevInstitution/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Optional<FevInstitution> inst = instService.findById(id);
		if (inst == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("fevInstitution", inst.get());
		return "fevInstitution/edit-fevInstitution";
	}
	
	@PostMapping("/fevInstitution/edit/{id}")
	public String updateFevInstitution(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(FevInstitutionValidation.class) FevInstitution fevInstitution, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("fevInstitution", fevInstitution);
				return "fevInstitution/edit-fevInstitution";
			}
			instService.save(fevInstitution);
		}
		return "redirect:/fevInstitution/";
	}

	@GetMapping("/fevInstitution/del/{id}")
	public String deleteFevInstitution(@PathVariable("id") long id, Model model) {
		FevInstitution inst = instService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		instService.delete(inst);
		return "redirect:/fevInstitution/";
	}

}
