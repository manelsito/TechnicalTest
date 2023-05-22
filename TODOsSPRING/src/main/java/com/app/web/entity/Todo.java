package com.app.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Todo")
public class Todo {

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", completed=" + completed + ", user=" + user + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Title", nullable=false, length=255)
	private String title;

	@Column(name = "Completed")
	private boolean completed;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false)
	private User user;
	
	//---COSTRUCTORS---

	public Todo() {

	}

	public Todo(Long id, String title, boolean completed, User user) {
		this.id = id;
		this.title = title;
		this.completed = completed;
		this.user = user;
	}

	public Todo(String title, boolean completed, User user) {
		this.title = title;
		this.completed = completed;
		this.user = user;
	}
	
	//---GETTERS & SETTERS---

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
