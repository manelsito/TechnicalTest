package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entity.Todo;
import com.app.web.entity.User;
import com.app.web.service.repository.TodoRepository;
import com.app.web.service.repository.UserRepository;

@SpringBootApplication
public class TodOsSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TodOsSpringApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		User user1 = new User("Manel Agudo", "Manelsito", "1234", "Terra Baixa", "Hospitalet de Llobregat", "08901", "Spain");
		userRepository.save(user1);
		User user2 = new User("Alberto Santos", "Alberto", "1234", "Torres i Amat", "Barcelona", "08001", "Spain");
		userRepository.save(user2);
		
		
		Todo todo1 = new Todo("Todo1", false, 1L);
		todoRepository.save(todo1);
		
		*/
		
		
	}

}
