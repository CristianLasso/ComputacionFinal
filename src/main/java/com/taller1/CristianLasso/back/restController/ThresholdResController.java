package com.taller1.CristianLasso.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller1.CristianLasso.back.model.Autotransition;
import com.taller1.CristianLasso.back.model.Threshold;
import com.taller1.CristianLasso.back.service.ThresholdService;

@RestController
@RequestMapping("/admin/threshold")
public class ThresholdResController {
	
	private ThresholdService thresService;
	
	@Autowired
	public ThresholdResController(ThresholdService thresService) {
		this.thresService = thresService;
	}
	
	@GetMapping("/")
	public Iterable<Threshold> indexThreshold() {
		return thresService.findAll();
	}
	
	@GetMapping("/{id}")
	public Threshold findByIdThres(@PathVariable("id") long autotranId) {
		return thresService.findById(autotranId);
	}

	@PostMapping
	public void saveThreshold(@RequestBody Threshold threshold) {
		thresService.save(threshold);
	}

	@PutMapping
	public void updateUser(@RequestBody Threshold threshold) {
			thresService.edit(threshold);
	}

	@DeleteMapping("/del/{id}")
	public void deleteThreshold(@PathVariable("id") long id) {
		Threshold thres = thresService.findById(id);
		thresService.delete(thres);
	}

}
