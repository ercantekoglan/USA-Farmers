package com.usafarmers.farmers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usafarmers.farmers.domain.Nutrients;
import com.usafarmers.farmers.service.NutrientService;

@Controller
public class NutrientController {
	@Autowired
	private NutrientService nutrientFileService;

	//display nutrient knowledge page
	@GetMapping("/nutrients")
	public String getCreateUser(ModelMap model) {
		return "nutrients";
	}

	//fetch nutrients
	@ResponseBody
	@GetMapping("/nutrients/postnutrient/{name}")
	public Nutrients getNutrient(@PathVariable String name) {
		Nutrients nutrient = nutrientFileService.findByName(name);
		return nutrient;

	}

}
