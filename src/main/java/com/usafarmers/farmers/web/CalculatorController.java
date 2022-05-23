package com.usafarmers.farmers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usafarmers.farmers.calculateApi.CalculationResponse;
import com.usafarmers.farmers.calculateApi.CropResponse;
import com.usafarmers.farmers.service.CalculatorService;

@Controller
public class CalculatorController {

	@Autowired
	private CalculatorService calSer;

	@GetMapping("/calculator")
	public String getCreateUser(ModelMap model) {

		CropResponse cropResponse = calSer.getCropResponse();

		model.put("crops", cropResponse.crops);

		return "calculator";
	}

	@ResponseBody
	@GetMapping("/calculate/{cropKey}/{yieldGoal}")
	public CalculationResponse calculate(@PathVariable String cropKey, @PathVariable int yieldGoal) {

		CalculationResponse calculatedResponse = calSer.calculate(cropKey, yieldGoal);
		return calculatedResponse;
	}

}
