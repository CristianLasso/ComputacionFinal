package com.taller1.CristianLasso.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.service.ThresholdService;

@Controller
@RequestMapping("/admin")
public class ThresholdResController {
	
	private ThresholdService thresService;
	
	@Autowired
	public ThresholdResController(ThresholdService thresService) {
		this.thresService = thresService;
	}
	
	@GetMapping("/threshold/")
	public Iterable<Threshold> indexThreshold() {
		return thresService.findAll();
	}

	@PostMapping("/threshold/add-threshold")
	public void saveThreshold(@RequestBody Threshold threshold) {
		thresService.save(threshold);
	}

	@PostMapping("/threshold/edit/{id}")
	public void updateUser(Threshold threshold) {
			thresService.save(threshold);
	}

	@GetMapping("/threshold/del/{id}")
	public void deleteThreshold(@PathVariable("id") long id) {
		Threshold thres = thresService.findById(id);
		thresService.delete(thres);
	}

}
