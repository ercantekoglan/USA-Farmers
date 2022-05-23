package com.usafarmers.farmers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.usafarmers.farmers.domain.Comment;
import com.usafarmers.farmers.domain.User;
import com.usafarmers.farmers.service.AutorityService;
import com.usafarmers.farmers.service.CommentService;
import com.usafarmers.farmers.service.DiscussionService;
import com.usafarmers.farmers.service.UserService;

@Controller
public class DiscussionController {

	@Autowired
	private DiscussionService discussionService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private AutorityService authService;

	// display created discussion form
	@GetMapping("/discussionform")
	public String displayMessages(ModelMap model) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findById(loggedInUser.getUserId());
		model.put("user", user);
		model.put("messages", discussionService.findAll());
		return "discussionform";
	}
	
	// display page by messageId
	@GetMapping("/discussionform/{messageId}")
	public String getMessage(ModelMap model, @PathVariable Long messageId) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findById(loggedInUser.getUserId());
		model.put("message", discussionService.findById(messageId));
		model.put("messages", discussionService.findAll());
		model.put("newcomment", new Comment());
		model.put("comments", commentService.findByMessageId(messageId));
		model.put("loggedInUser", user);
		model.put("userauthority", authService.findById(user.getUserId()));

		return "/displaymessage";

	}

}
