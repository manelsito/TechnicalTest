package com.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.service.TodoService;
import com.app.web.service.UserService;
import com.app.web.entity.Todo;
import com.app.web.entity.User;

@Controller
public class TodosController {

	@Autowired
	private TodoService todoService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/todos")
	public String listTodos(Model model) {
		model.addAttribute("todos", todoService.listAllTodos());
		return "todos";
	}

	@GetMapping("/todosByTitleAndUsername")
	public String listTodosByTitleAndUsername(@RequestParam(required = false) String title,
			@RequestParam(required = false) String username, Model model) {
		model.addAttribute("todos", todoService.listTodosByTitleAndUsername(title, username));
		return "todos";
	}
	
	@GetMapping("/todo/new")
	public String addTodoPage(Model model) {
		Todo todo = new Todo();
		model.addAttribute("todo", todo);
		List<User> users = userService.listAllUsers();
	    model.addAttribute("users", users);
		return "todo-page";
	}
	
	@GetMapping("/todo/update/{id}")
	public String updateTodoPage(@PathVariable("id") Long todoId, Model model) {
		Todo todo = todoService.getTodoById(todoId);
		model.addAttribute("todo", todo);
		return "todo-page";
	}
	
	@PostMapping("/saveTodo")
	public String saveTodo(@ModelAttribute("todo") Todo todo) {
		todoService.saveTodo(todo);
		return "redirect:/todos";
	}
	
	@GetMapping("/todo/delete/{id}")
	public String deleteTodo(@PathVariable("id") Long todoId) {
		todoService.deleteTodo(todoId);
		return "redirect:/todos";
	}

}
