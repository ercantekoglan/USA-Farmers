package com.usafarmers.farmers.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usafarmers.farmers.domain.Comment;
import com.usafarmers.farmers.domain.Message;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findAllByMessage(Message message);
	
}
