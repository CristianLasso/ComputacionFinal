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

import com.taller1.CristianLasso.front.model.FevInstitution;
import com.taller1.CristianLasso.front.model.Threshold;
import com.taller1.CristianLasso.back.validation.ThresholdValidation;
import com.taller1.CristianLasso.front.businessdele.BusinessDelegateImp;

@Controller
@RequestMapping("/user")
public class ThresholdController {
	
	private BusinessDelegateImp businessDel;;
	
	@Autowired
	public ThresholdController(BusinessDelegateImp businessDel) {
		this.businessDel = businessDel;
	}
	
	@GetMapping("/threshold/")
	public String indexThreshold(Model model) {
		model.addAttribute("threshold", businessDel.thresFindAll());
		return "/threshold/index";
	}

	@GetMapping("/threshold/add-threshold")
	public String addThreshold(Model model, @ModelAttribute("threshold") Threshold threshold) {
		model.addAttribute("threshold", new Threshold());
		model.addAttribute("fevInstitution", businessDel.instiFindAll());
		return "/threshold/add-threshold";
	}

	@PostMapping("/threshold/add-threshold")
	public String saveThreshold(@Validated(ThresholdValidation.class) Threshold threshold,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			/*if (bindingResult.hasErrors()) {
				model.addAttribute("fevInstitution", businessDel.instiFindAll());
				return "threshold/add-threshold";
			} else {
				businessDel.thresSave(threshold);
			}*/
			businessDel.thresSave(threshold);
		return "redirect:/user/threshold/";
	}

	@GetMapping("/threshold/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Threshold thres = businessDel.thresFinById(id);
		if (thres == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("threshold", thres.get());
		model.addAttribute("fevInstitution", businessDel.instiFindAll());
		return "/threshold/edit-threshold";
	}

	@PostMapping("/threshold/edit/{id}")
	public String updateUser(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(ThresholdValidation.class) Threshold threshold, BindingResult bindingResult, Model model) {
		/*if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("threshold", threshold);
				model.addAttribute("fevInstitution", businessDel.instiFindAll());
				return "threshold/edit-threshold";
			}
			businessDel.thresSave(threshold);
		}*/
		businessDel.thresSave(threshold);
		return "redirect:/user/threshold/";
	}

	@GetMapping("/threshold/del/{id}")
	public String deleteThreshold(@PathVariable("id") long id, Model model) {
		Threshold thres = businessDel.thresFinById(id);
		businessDel.thresDelete(thres.getThresId());
		return "redirect:/user/threshold/";
	}
	
	@GetMapping("/threshold/showInstitution/{id}")
    public String showInstitution(@PathVariable("id") long id, Model model) {
		Threshold thres = businessDel.thresFinById(id).get();
		FevInstitution inst = businessDel.instiFinById(thres.getInstInstId());
        ArrayList<FevInstitution> instis = new ArrayList<FevInstitution>();
        instis.add(inst);
        model.addAttribute("fevInstitution", instis);
        return "/fevInstitution/index";
    }

}
