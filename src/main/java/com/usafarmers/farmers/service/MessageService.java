package com.usafarmers.farmers.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usafarmers.farmers.domain.Message;
import com.usafarmers.farmers.domain.User;
import com.usafarmers.farmers.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private UserService userService;

	public Message saveMessage(Message message, Long userId) {

		User user = userService.findById(userId);
		user.getMessage().add(message);
		message.setUser(user);
		message.setCreatedDate(LocalDateTime.now());
		return messageRepo.save(message);
	}

	public List<Message> findAll() {
		List<Message> findAll = messageRepo.findAll();
		Collections.reverse(findAll);
		return findAll;
	}

	public Message findById(Long id) {
		Optional<Message> findById = messageRepo.findById(id);
		return findById.orElse(null);
	}

	public void delete(Long messageId) {
		messageRepo.deleteById(messageId);

	}



}
