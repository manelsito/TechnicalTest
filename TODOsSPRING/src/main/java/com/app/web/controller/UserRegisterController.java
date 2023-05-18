package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.web.dto.UserRegisterDTO;
import com.app.web.service.UserService;

@Controller
@RequestMapping("/register")
public class UserRegisterController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public UserRegisterDTO returnNewUserRegisterDTO() {
		return new UserRegisterDTO();
	}

	@GetMapping
	public String showRegisterForm() {
		return "register";
	}
	
//	@PostMapping
//	public String registerUser(@ModelAttribute("user") UserRegisterDTO registerDTO) {
//		userService.saveUser(registerDTO);
//		return "redirect:/register?succsess";
//	}
	
}
