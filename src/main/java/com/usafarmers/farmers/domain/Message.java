package com.usafarmers.farmers.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	private Long messageId;
	private String messageTitle;
	private String messageContent;
	private LocalDateTime createdDate;
	private User user;
	private List<Comment> comments;

	public Message() {
	}

	public Message(Long messageId, String messageTitle, String messageContent) {

		this.messageId = messageId;
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	@Column(columnDefinition = "TEXT")
	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@ManyToOne
	@JoinColumn(name = "user_Id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	@OneToMany(mappedBy = "message", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(messageId);
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageTitle=" + messageTitle + ", messageContent="
				+ messageContent + ", createdDate=" + createdDate + ", user=" + user + ", comments=" + comments + "]";
	}

}
