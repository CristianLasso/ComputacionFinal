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
import com.taller1.CristianLasso.back.validation.AutotransitionValidation;
import com.taller1.CristianLasso.back.validation.SymptomValidation;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;

@Controller
@RequestMapping("/user")
public class SymptomControllerImp {

	private BusinessDelegateImp businessDel;

	@Autowired
	public SymptomControllerImp(BusinessDelegateImp businessDel) {
		this.businessDel = businessDel;
	}

	@GetMapping("/symptom/")
	public String indexSymptom(Model model) {
		model.addAttribute("symptom", businessDel.symptomFindAll());
		return "/symptom/index";
	}

	@GetMapping("/symptom/add-symptom")
	public String addSymptomn(Model model, @ModelAttribute("symptom") Symptom Symptom) {
		System.out.println("Entra al add");
		model.addAttribute("symptom", new Symptom());
		return "/symptom/add-symptom";
	}

	@PostMapping("/symptom/add-symptom")
	public String saveSymptom(@Validated(SymptomValidation.class) Symptom symptom,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		System.out.println("Entra al segundo add");
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "symptom/add-symptom";
			} else {
				businessDel.symptomSave(symptom);
			}
		return "redirect:/user/symptom/";
	}

	@GetMapping("/symptom/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Symptom symptom = businessDel.symptomFinById(id);
		if (symptom == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("symptom", symptom);
		return "/symptom/edit-symptom";
	}

	@PostMapping("/symptom/edit/{id}")
	public String updateSymptom(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(SymptomValidation.class) Symptom symptom, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("symptom", symptom);
				return "symptom/edit-symptom";
			}
			businessDel.symptomEdit(symptom);
		}
		return "redirect:/user/symptom/";
	}

	@GetMapping("/symptom/del/{id}")
	public String deleteSymptom(@PathVariable("id") long id, Model model) {
		businessDel.symptomDelete(id);
		return "redirect:/user/symptom/";
	}
	
}