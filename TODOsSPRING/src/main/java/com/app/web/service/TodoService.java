package com.app.web.service;

import java.util.List;

import com.app.web.entity.Todo;

public interface TodoService {
	
	public List<Todo> listAllTodos();
	
	public List<Todo> listTodosByTitleAndUsername(String title, String username);
	
	public Todo saveTodo(Todo todo);

	public Todo getTodoById(Long todoId);

	public void deleteTodo(Long todoId);
}
