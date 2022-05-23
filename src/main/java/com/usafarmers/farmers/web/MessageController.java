package com.usafarmers.farmers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.usafarmers.farmers.domain.Message;
import com.usafarmers.farmers.domain.User;
import com.usafarmers.farmers.service.DiscussionService;
import com.usafarmers.farmers.service.UserService;

@Controller
public class MessageController {

	@Autowired
	private DiscussionService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private DiscussionService discussionService;

	// display screen to create message page
	@GetMapping("/createmessage")
	public String createMessage(ModelMap model) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.put("user", loggedInUser);
		model.put("message", new Message());
		return "/createmessage";
	}

	// save created message and return discussion form
	@PostMapping("/createmessage")
	public String createMessage(Message message) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findById(loggedInUser.getUserId());
		messageService.saveMessage(message, user.getUserId());
		return "redirect:/discussionform";

	}

	// delete user message-post
	@PostMapping("/message/{messageId}/delete")
	public String deleteMessage(@PathVariable Long messageId) {
		discussionService.delete(messageId);
		return "redirect:/";
	}
	//if admin delete the message in admin panel
	@PostMapping("/adminpanel/{messageId}/delete")
	public String deleteMessageByAdminPanel(@PathVariable Long messageId) {
		discussionService.delete(messageId);
		return "redirect:/adminpanel";
	}

}
