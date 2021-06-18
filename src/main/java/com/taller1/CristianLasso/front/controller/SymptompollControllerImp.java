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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taller1.CristianLasso.front.model.Symptom;
import com.taller1.CristianLasso.front.model.Symptompoll;
import com.taller1.CristianLasso.back.validation.SymptomValidation;
import com.taller1.CristianLasso.back.validation.SymptompollValidation;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;

@Controller
@RequestMapping("/user")
public class SymptompollControllerImp {

	private BusinessDelegateImp businessDel;

	@Autowired
	public SymptompollControllerImp(BusinessDelegateImp businessDel) {
		this.businessDel = businessDel;
	}

	@GetMapping("/symptompoll/")
	public String indexSymptompoll(Model model) {
		model.addAttribute("symptompoll", businessDel.symptompollFindAll());
		return "/symptompoll/index";
	}

	@GetMapping("/symptompoll/add-symptompoll")
	public String addSymptomnpoll(Model model, @ModelAttribute("symptompoll") Symptompoll Symptompoll) {
		model.addAttribute("symptompoll", new Symptompoll());
		return "/symptompoll/add-symptompoll";
	}

	@PostMapping("/symptompoll/add-symptompoll")
	public String saveSymptompoll(@Validated(SymptomValidation.class) Symptompoll symptompoll,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "symptompoll/add-symptompoll";
			} else {
				businessDel.symptompollSave(symptompoll);
			}
		return "redirect:/user/symptompoll/";
	}

	@GetMapping("/symptompoll/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Symptompoll symptompoll = businessDel.symptompollFinById(id);
		if (symptompoll == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("symptompoll", symptompoll);
		return "/symptompoll/edit-symptompoll";
	}

	@PostMapping("/symptompoll/edit/{id}")
	public String updateSymptompoll(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(SymptompollValidation.class) Symptompoll symptompoll, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("symptompoll", symptompoll);
				return "symptompoll/edit-symptompoll";
			}
			businessDel.symptompollEdit(symptompoll);
		}
		return "redirect:/user/symptompoll/";
	}

	@GetMapping("/symptompoll/del/{id}")
	public String deleteSymptompoll(@PathVariable("id") long id, Model model) {
		businessDel.symptompollDelete(id);
		return "redirect:/user/symptompoll/";
	}
	
}