package com.app.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.entity.User;
import com.app.web.service.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	

}
