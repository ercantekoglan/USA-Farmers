package com.usafarmers.farmers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.usafarmers.farmers.service.DiscussionService;

@Controller
public class IndexController {
	
	@Autowired
	private DiscussionService discussionService;

	//display index page
	@GetMapping("/index")
	public String getCreateUser(ModelMap model) {
		model.put("messages", discussionService.findAll());
		return "index";
	}
	
	

}
