package com.app.web.service;

import java.util.List;

import com.app.web.entity.Todo;

public interface TodoService {

	/**
	 * List all the todos in the database
	 * @return the List of todos
	 */
	public List<Todo> listAllTodos();

	/**
	 * List todos filter by title and username
	 * @param title, the title of the todo
	 * @param username, the username of the user that creates the todo
	 * @return the List of todos
	 */
	public List<Todo> listTodosByTitleAndUsername(String title, String username);

	/**
	 * Save a todo
	 * @param todo, the todo to save
	 * @return the todo
	 */
	public Todo saveTodo(Todo todo);

	/**
	 * Find a todo by his id
	 * @param todoId, the id of the todo to do the search
	 * @return the todo
	 */
	public Todo getTodoById(Long todoId);

	/**
	 * Delete a todo
	 * @param todoId, the id of the todo to delete
	 */
	public void deleteTodo(Long todoId);
}
