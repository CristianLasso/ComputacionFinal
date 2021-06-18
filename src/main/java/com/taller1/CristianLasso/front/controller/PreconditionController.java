package com.taller1.CristianLasso.front.controller;

import java.util.ArrayList;

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

import com.taller1.CristianLasso.front.model.Autotransition;
import com.taller1.CristianLasso.front.model.Precondition;
import com.taller1.CristianLasso.back.validation.PreconditionValidation;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;

@Controller
@RequestMapping("/user")
public class PreconditionController {
	
	private BusinessDelegateImp businessDel;
	
	@Autowired
	public PreconditionController(BusinessDelegateImp businessDel) {
		this.businessDel = businessDel;
	}
	
	@GetMapping("/precondition/")
	public String indexPrecondition(Model model) {
		model.addAttribute("precondition", businessDel.preconFindAll());
		return "/precondition/index";
	}
	
	@GetMapping("/precondition/add-precondition")
	public String addPrecondition(Model model, @ModelAttribute("precondition") Precondition precondition) {
		model.addAttribute("precondition", new Precondition());
		model.addAttribute("autotransition", businessDel.autotranFindAll());
		return "/precondition/add-precondition";
	}
	
	@PostMapping("/precondition/add-precondition")
	public String savePrecondition(@Validated(PreconditionValidation.class) Precondition precondition,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			/*if (bindingResult.hasErrors()) {
				model.addAttribute("autotransition", businessDel.autotranFindAll());
				return "precondition/add-precondition";
			} else {
				businessDel.preconSave(precondition);
			}*/
			businessDel.preconSave(precondition);
		return "redirect:/user/precondition/";
	}
	
	@GetMapping("/precondition/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Precondition pre = businessDel.preconFinById(id);
		if (pre == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("precondition", pre.get());
		model.addAttribute("autotransition", businessDel.autotranFindAll());
		return "/precondition/edit-precondition";
	}
	
	@PostMapping("/precondition/edit/{id}")
	public String updatePrecondition(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(PreconditionValidation.class) Precondition precondition, BindingResult bindingResult, Model model) {
		/*if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("precondition", precondition);
				model.addAttribute("autotransition", businessDel.autotranFindAll());
				return "precondition/edit-precondition";
			}
			businessDel.preconSave(precondition);
		}*/
		businessDel.preconSave(precondition);
		return "redirect:/user/precondition/";
	}

	@GetMapping("/precondition/del/{id}")
	public String deletePrecondition(@PathVariable("id") long id, Model model) {
		Precondition pre = businessDel.preconFinById(id);
		businessDel.preconDelete(pre.getPreconId());
		return "redirect:/user/precondition/";
	}
	
	@GetMapping("/precondition/showAutotransition/{id}")
    public String showAutotransition(@PathVariable("id") long id, Model model) {
		Precondition precon = businessDel.preconFinById(id).get();
		Autotransition autotran = precon.getAutotransition();
        ArrayList<Autotransition> autos = new ArrayList<Autotransition>();
        autos.add(autotran);
        model.addAttribute("autotransition", autos);
        return "/precondition/index";
    }

}
