package com.usafarmers.farmers.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usafarmers.farmers.domain.Comment;
import com.usafarmers.farmers.domain.Message;
import com.usafarmers.farmers.repository.CommentRepository;
import com.usafarmers.farmers.repository.MessageRepository;
import com.usafarmers.farmers.repository.UserRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MessageRepository messageRepo;

	public List<Comment> findAll() {
		return commentRepo.findAll();
	}

	public void save(Comment comment, Long messageId, Long userId) {

		Comment newComment = new Comment();
		newComment.setCommentDetails(comment.getCommentDetails());
		newComment.setCreatedDate(LocalDateTime.now());
		newComment.setMessage(messageRepo.findByMessageId(messageId));
		newComment.setUser(userRepo.findById(userId).orElse(null));
		commentRepo.save(newComment);
	}

	public List<Comment> findByMessageId(Long messageId) {
		Message message = messageRepo.findByMessageId(messageId);
		List<Comment> comments = commentRepo.findAllByMessage(message);
		Collections.reverse(comments);
		return comments;
	}

	public void delete(Long commentId) {

		commentRepo.deleteById(commentId);
	}

}
