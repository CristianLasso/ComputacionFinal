package com.taller1.CristianLasso.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taller1.CristianLasso.front.model.FevInstitution;
import com.taller1.CristianLasso.back.validation.FevInstitutionValidation;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;

@Controller
@RequestMapping("/user")
public class FevInstitutionController {
	
	private BusinessDelegateImp businessDel;
	
	@Autowired
	public FevInstitutionController(BusinessDelegateImp businessDel) {
		this.businessDel = businessDel;
	}
	
	@GetMapping("/fevInstitution/")
	public String indexFevInstitution(Model model) {
		model.addAttribute("fevInstitution", businessDel.instiFindAll());
		return "/fevInstitution/index";
	}
	
	@GetMapping("/fevInstitution/add-fevInstitution")
	public String addFevInstitution(Model model, @ModelAttribute("fevInstitution") FevInstitution fevInstitution) {
		model.addAttribute("fevInstitution", new FevInstitution());
		return "/fevInstitution/add-fevInstitution";
	}
	
	@PostMapping("/fevInstitution/add-fevInstitution")
	public String saveFevInstitution(@Validated(FevInstitutionValidation.class) FevInstitution fevInstitution,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "fevInstitution/add-fevInstitution";
			} else {
				businessDel.instiSave(fevInstitution);
			}
		return "redirect:/user/fevInstitution/";
	}
	
	@GetMapping("/fevInstitution/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		FevInstitution inst = businessDel.instiFinById(id);
		if (inst == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("fevInstitution", inst);
		return "/fevInstitution/edit-fevInstitution";
	}
	
	@PostMapping("/fevInstitution/edit/{id}")
	public String updateFevInstitution(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(FevInstitutionValidation.class) FevInstitution fevInstitution, BindingResult bindingResult, Model model) {
		/*if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("fevInstitution", fevInstitution);
				return "fevInstitution/edit-fevInstitution";
			}
			businessDel.instiSave(fevInstitution);
		}*/
		businessDel.instiEdit(fevInstitution);
		return "redirect:/user/fevInstitution/";
	}

	@GetMapping("/fevInstitution/del/{id}")
	public String deleteFevInstitution(@PathVariable("id") long id, Model model) {
		FevInstitution inst = businessDel.instiFinById(id);
		businessDel.instiDelete(inst.getInstId());
		return "redirect:/fevInstitution/";
	}

}
