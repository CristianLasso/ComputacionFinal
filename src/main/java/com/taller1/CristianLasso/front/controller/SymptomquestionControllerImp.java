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
import com.taller1.CristianLasso.front.model.Symptomquestion;
import com.taller1.CristianLasso.back.validation.AutotransitionValidation;
import com.taller1.CristianLasso.back.validation.SymptomValidation;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;

@Controller
@RequestMapping("/user")
public class SymptomquestionControllerImp {

	private BusinessDelegateImp businessDel;

	@Autowired
	public SymptomquestionControllerImp(BusinessDelegateImp businessDel) {
		this.businessDel = businessDel;
	}

	@GetMapping("/symptomquestion/")
	public String indexSymptomquestion(Model model) {
		model.addAttribute("symptomquestion", businessDel.symptomFindAll());
		return "/symptomquestion/index";
	}

	@GetMapping("/symptomquestion/add-symptomquestion")
	public String addSymptomquestion(Model model, @ModelAttribute("symptomquestion") Symptomquestion Symptomquestion) {
		model.addAttribute("symptomquestion", new Symptomquestion());
		return "/symptomquestion/add-symptomquestion";
	}

	@PostMapping("/symptomquestion/add-symptomquestion")
	public String saveSymptomquestion(@Validated(SymptomValidation.class) Symptomquestion symptomquestion,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "symptomquestion/add-symptomquestion";
			} else {
				businessDel.symptomquestionSave(symptomquestion);
			}
		return "redirect:/user/symptomquestion/";
	}

	@GetMapping("/symptomquestion/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Symptomquestion symptomquestion = businessDel.symptomquestionFinById(id);
		if (symptomquestion == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("symptomquestion", symptomquestion);
		return "/symptomquestion/edit-symptomquestion";
	}

	@PostMapping("/symptomquestion/edit/{id}")
	public String updateSymptomquestion(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(SymptomValidation.class) Symptomquestion symptomquestion, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("symptomquestion", symptomquestion);
				return "symptomquestion/edit-symptomquestion";
			}
			businessDel.symptomquestionEdit(symptomquestion);
		}
		return "redirect:/user/symptomquestion/";
	}

	@GetMapping("/symptomquestion/del/{id}")
	public String deleteSmptomquestion(@PathVariable("id") long id, Model model) {
		businessDel.symptomquestionDelete(id);
		return "redirect:/user/symptomquestion/";
	}
	
}