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

import com.taller1.CristianLasso.back.model.Localcondition;
import com.taller1.CristianLasso.back.model.Precondition;
import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.service.LocalconditionService;
import com.taller1.CristianLasso.back.service.PreconditionService;
import com.taller1.CristianLasso.back.service.ThresholdService;
import com.taller1.CristianLasso.back.validation.LocalconditionValidation;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;

@Controller
@RequestMapping("/user")
public class LocalconditionController {

	private BusinessDelegateImp businessDel;
	
	@Autowired
	public LocalconditionController(BusinessDelegateImp businessDel) {
		this.businessDel = businessDel;
	}
	
	@GetMapping("/localcondition/")
	public String indexLocalcondition(Model model) {
		model.addAttribute("localcondition", businessDel.localFindAll());
		return "localcondition/index";
	}
	
	@GetMapping("/localcondition/add-localcondition")
	public String addLocalcondition(Model model, @ModelAttribute("localcondition") Localcondition localcondition) {
		model.addAttribute("localcondition", new Localcondition());
		model.addAttribute("threshold", businessDel.thresFindAll());
		model.addAttribute("precondition", businessDel.preconFindAll());
		return "localcondition/add-localcondition";
	}
	
	@PostMapping("/localcondition/add-localcondition")
	public String saveLocalcondition(@Validated(LocalconditionValidation.class) Localcondition localcondition,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				model.addAttribute("threshold", businessDel.thresFindAll());
				model.addAttribute("precondition", businessDel.preconFindAll());
				return "/localcondition/add-localcondition";
			} else {
				businessDel.localSave(localcondition);
			}
		return "redirect:/localcondition/";
	}
	
	@GetMapping("/localcondition/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Localcondition local = businessDel.localFinById(id);
		if (local == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("localcondition", local.get());
		model.addAttribute("threshold", businessDel.thresFindAll());
		model.addAttribute("precondition", businessDel.preconFindAll());
		return "localcondition/edit-localcondition";
	}
	
	@PostMapping("/localcondition/edit/{id}")
	public String updateLocalcondition(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(LocalconditionValidation.class) Localcondition localcondition, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("localcondition", localcondition);
				model.addAttribute("threshold", businessDel.thresFindAll());
				model.addAttribute("precondition", businessDel.preconFindAll());
				return "localcondition/edit-localcondition";
			}
			businessDel.localSave(localcondition);
		}
		return "redirect:/localcondition/";
	}

	@GetMapping("/localcondition/del/{id}")
	public String deleteLocalcondition(@PathVariable("id") long id, Model model) {
		Localcondition local = businessDel.localFinById(id);
		businessDel.localDelete(local.getLoconId());
		return "redirect:/localcondition/";
	}
	
	@GetMapping("/localcondition/showPrecondition/{id}")
    public String showPrecondition(@PathVariable("id") long id, Model model) {
		Localcondition localcon = businessDel.localFinById(id).get();
		Precondition precon = localcon.getPrecondition();
        ArrayList<Precondition> precons = new ArrayList<Precondition>();
        precons.add(precon);
        model.addAttribute("precondition", precons);
        return "precondition/index";
    }
	
	@GetMapping("/localcondition/showThreshold/{id}")
    public String showThreshold(@PathVariable("id") long id, Model model) {
		Localcondition localcon = businessDel.localFinById(id).get();
		Threshold thres = localcon.getThreshold();
        ArrayList<Threshold> threses = new ArrayList<Threshold>();
        threses.add(thres);
        model.addAttribute("threshold", threses);
        return "threshold/index";
    }
	
}
