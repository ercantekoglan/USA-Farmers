package com.usafarmers.farmers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.usafarmers.farmers.domain.Comment;
import com.usafarmers.farmers.domain.User;
import com.usafarmers.farmers.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	// save user comment
	@PostMapping("/discussionform/{messageId}")
	public String createMomment(Comment comment, @PathVariable Long messageId) {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		commentService.save(comment, messageId, loggedInUser.getUserId());
		return "redirect:/discussionform/{messageId}";
	}

	// delete user comment
	@PostMapping("/message/{messageId}/comment/{commentId}delete")
	public String deleteComment(@PathVariable Long commentId, @PathVariable Long messageId) {
		commentService.delete(commentId);
		return "redirect:/discussionform/" + messageId;
	}

}
