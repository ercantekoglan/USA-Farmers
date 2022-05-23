package com.usafarmers.farmers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usafarmers.farmers.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	Message findByMessageId(Long messageId);

}
