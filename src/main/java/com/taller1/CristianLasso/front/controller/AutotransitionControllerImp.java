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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taller1.CristianLasso.front.model.Autotransition;
import com.taller1.CristianLasso.front.model.FevInstitution;
import com.taller1.CristianLasso.back.service.FevInstitutionService;
import com.taller1.CristianLasso.back.validation.AutotransitionValidation;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;

@Controller
@RequestMapping("/user")
public class AutotransitionControllerImp {

	private BusinessDelegateImp businessDel;
	

	@Autowired
	public AutotransitionControllerImp(BusinessDelegateImp businessDel) {
		this.businessDel = businessDel;
		
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}

	@GetMapping("/autotransition/")
	public String indexAutotran(Model model) {
		model.addAttribute("autotransition", businessDel.autotranFindAll());
		return "/autotransition/index";
	}

	@GetMapping("/autotransition/add-autotransition")
	public String addAutotransition(Model model, @ModelAttribute("autotransition") Autotransition autotransition) {
		model.addAttribute("autotransition", new Autotransition());
		model.addAttribute("fevInstitution", businessDel.instiFindAll());
		return "/autotransition/add-autotransition";
	}

	@PostMapping("/autotransition/add-autotransition")
	public String saveAutotransition(@Validated(AutotransitionValidation.class) Autotransition autotransition,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				model.addAttribute("fevInstitution", businessDel.instiFindAll());
				return "autotransition/add-autotransition";
			} else {
				businessDel.autotranSave(autotransition);
			}
		return "redirect:/user/autotransition/";
	}

	@GetMapping("/autotransition/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Autotransition autotransition = businessDel.autotranFinById(id);
		if (autotransition == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("autotransition", autotransition.get());
		model.addAttribute("fevInstitution", businessDel.instiFindAll());
		return "/autotransition/edit-autotransition";
	}

	@PostMapping("/autotransition/edit/{id}")
	public String updateUser(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(AutotransitionValidation.class) Autotransition autotransition, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("autotransition", autotransition);
				model.addAttribute("fevInstitution", businessDel.instiFindAll());
				return "autotransition/edit-autotransition";
			}
			businessDel.autotranEdit(autotransition);
		}
		return "redirect:/user/autotransition/";
	}

	@GetMapping("/autotransition/del/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		businessDel.autotranDelete(id);
		return "redirect:/user/autotransition/";
	}
	
	@GetMapping("/autotransition/showInstitution/{id}")
    public String showInstitution(@PathVariable("id") long id, Model model) {
		Autotransition auto = businessDel.autotranFinById(id).get();
		FevInstitution inst = businessDel.instiFinById(auto.getInstInstId());
        ArrayList<FevInstitution> instis = new ArrayList<FevInstitution>();
        instis.add(inst);
        model.addAttribute("fevInstitution", instis);
        return "/fevInstitution/index";
    }
	
}