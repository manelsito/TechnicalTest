package com.app.web.service;

import java.util.List;

import com.app.web.entity.User;

public interface UserService{

	/**
	 * List all the users in the database
	 * @return the List of the users
	 */
	public List<User> listAllUsers();



}
