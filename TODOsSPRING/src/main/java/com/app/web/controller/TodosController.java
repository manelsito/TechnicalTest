package com.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.entity.Todo;
import com.app.web.entity.User;
import com.app.web.service.TodoService;
import com.app.web.service.UserService;

@Controller
public class TodosController {

	@Autowired
	private TodoService todoService;

	@Autowired
	private UserService userService;

	/**
	 * Controller that directs to the main page of the web
	 * @param model, variable where the information passed to the page is stored
	 * @return the name of the page
	 */
	@GetMapping(value = {"/todos", "/"})
	public String listTodos(Model model) {
		model.addAttribute("todos", todoService.listAllTodos());
		return "todos";
	}

	/**
	 * Controller to filter the todos
	 * @param title, the title of the todo
	 * @param username, the name of the user who created the todo
	 * @param model, variable where the information passed to the page is stored
	 * @return the name of the page
	 */
	@GetMapping("/todosByTitleAndUsername")
	public String listTodosByTitleAndUsername(@RequestParam(required = false) String title,
			@RequestParam(required = false) String username, Model model) {
		model.addAttribute("todos", todoService.listTodosByTitleAndUsername(title, username));
		return "todos";
	}

	/**
	 * controller that directs you to the creation page of todos
	 * @param model, variable where the information passed to the page is stored
	 * @return the name of the page
	 */
	@GetMapping("/todo/new")
	public String addTodoPage(Model model) {
		Todo todo = new Todo();
		model.addAttribute("todo", todo);
		List<User> users = userService.listAllUsers();
		model.addAttribute("users", users);
		return "todo-page";
	}

	/**
	 * controller that directs you to the modification page of todos
	 * @param todoId, the id of the todo to modify
	 * @param model, variable where the information passed to the page is stored
	 * @param authentication object where the logged user is stored
	 * @return the name of the page
	 */
	@GetMapping("/todo/update/{id}")
	public String updateTodoPage(@PathVariable("id") Long todoId, Model model, Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String loggedUserId = userDetails.getUsername();
		Todo todo = todoService.getTodoById(todoId);
		if (todo.getUser().getUsername().equals(loggedUserId)) {
			model.addAttribute("todo", todo);
			return "todo-page";
		}
		else {
			return "redirect:/todos?invalidUser";
		}
	}

	/**
	 * Controller to save the changes of the todo, new or modified
	 * @param todo, the todo to save
	 * @return redirects to the main page
	 */
	@PostMapping("/saveTodo")
	public String saveTodo(@ModelAttribute("todo") Todo todo) {
		todoService.saveTodo(todo);
		return "redirect:/todos";
	}

	/**
	 * Controller to delete a todo
	 * @param todoId, the id of the todo to delete
	 * @return redirects to the main page
	 */
	@GetMapping("/todo/delete/{id}")
	public String deleteTodo(@PathVariable("id") Long todoId) {
		todoService.deleteTodo(todoId);
		return "redirect:/todos";
	}

}
