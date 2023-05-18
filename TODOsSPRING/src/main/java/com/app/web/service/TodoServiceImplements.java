package com.app.web.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entity.User;
import com.app.web.entity.Todo;
import com.app.web.service.repository.TodoRepository;

@Service
public class TodoServiceImplements implements TodoService{
	
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<Todo> listAllTodos() {
		return todoRepository.findAll();
	}

	@Override
	public List<Todo> listTodosByTitleAndUsername(String todoTitle, String todoUsername) {
		List<Object[]> results = new ArrayList<>();
		List<Todo> todos = new ArrayList<>();
		if(!todoTitle.equals("") && !todoUsername.equals("")) {
			 results = todoRepository.getTodosByTitleAndUsername(todoTitle, todoUsername);
		}
		else if(!todoTitle.equals("") && todoUsername.equals("")) {
			 results = todoRepository.getTodosByTitle(todoTitle);
		}
		else if (todoTitle.equals("") && !todoUsername.equals("")) {
			 results = todoRepository.getTodosByUsername(todoUsername);
		}
		
		for (Object[] result : results) {
			Long id = (Long) result[0];
		    String title = (String) result[1];
		    boolean completed = (boolean) result[2];
		    User user = new User((Long) result[3], (String) result[4], (String) result[5]);
		    todos.add(new Todo(id, title, completed, user));
		}
		
		return todos;
	}

	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo getTodoById(Long todoId) {
		return todoRepository.getById(todoId);
	}

	@Override
	public void deleteTodo(Long todoId) {
		Todo todo = getTodoById(todoId);
		todoRepository.delete(todo);
		
	}

}
