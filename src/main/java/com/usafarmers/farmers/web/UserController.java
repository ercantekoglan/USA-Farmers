package com.usafarmers.farmers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usafarmers.farmers.domain.User;
import com.usafarmers.farmers.service.AddressService;
import com.usafarmers.farmers.service.AutorityService;
import com.usafarmers.farmers.service.MessageService;
import com.usafarmers.farmers.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addresService;
	@Autowired
	private MessageService discussionService;
	@Autowired
	private AutorityService authService;

	
	//display index page
		@GetMapping("/index")
		public String getIndex(ModelMap model) {
			model.put("messages", discussionService.findAll());
			return "index";
		}
	
	@GetMapping("/")
	public String welcomeRedirect() {
		return "redirect:/index";
	}

	// display login page
	@GetMapping("/login")
	public String login(ModelMap model) {

		// to Prevent Authenticated Users From Accessing Login Page
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/";
	}

	// if registered - redirect to display register page
	@GetMapping("/register")
	public String getCreateUser(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			model.put("user", new User());
			return "register";
		}
		
		return "redirect:/";
	}

	// create new user
	@PostMapping("/register")
	public String postCreateUser(User user) {
		userService.saveUser(user);
		return "redirect:/login";
	}

	// check uniqe username
	@PostMapping("/users/exists")
	@ResponseBody
	public Boolean postExists(@RequestBody User user) {
		user = userService.findByUsername(user.getUsername());
		return (user != null);
	}

	// display user profile page
	@GetMapping("/profile")
	public String getProfile(ModelMap model) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findById(loggedInUser.getUserId());
		model.put("user", user);
		return "/profile";
	}

	// update-save profile page
	@PostMapping("/profile")
	public void updateProfile(User user) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User findByUserId = userService.findById(loggedInUser.getUserId());
		user.setUserId(findByUserId.getUserId());
		findByUserId.setUserProduct(user.getUserProduct());
		user.setMessage(findByUserId.getMessage());
		user.setComments(findByUserId.getComments());
		user.setAuthorities(findByUserId.getAuthorities());
		addresService.updateAddress(user);
		userService.updateUser(user);
	}

	// Getmapping for showing the user information
	@GetMapping("/profile/{userId}")
	public String getAccount(ModelMap modelMap, @PathVariable Long userId) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User findUserById = userService.findById(userId);
		modelMap.put("userauthority", authService.findById(loggedInUser.getUserId()));
		modelMap.put("user", findUserById);
		return "/userprofile";
	}
	
	//delete user
	@PostMapping("/profile/{userId}/delete")
	public String deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return "redirect:/index";
	}

	/* ADMIN PANEL MANAGEMENT */
	@GetMapping("/adminpanel")
	public String getAdminPanel(ModelMap model) {
		model.put("users", userService.findAll());
		model.put("messages", discussionService.findAll());
		return "/adminpanel";
	}
	
	//admin panel delete user
	@PostMapping("/adminpanel/{userId}")
	public String deleteAdminUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return "redirect:/adminpanel";
	}


}
