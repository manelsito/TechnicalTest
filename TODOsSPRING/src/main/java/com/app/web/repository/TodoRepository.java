package com.app.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.web.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	/**
	 * Function that executes a query to the database to filter by title and username
	 * @param title, the title of the todo
	 * @param username, the username of the user that creates the todo
	 * @return the List of the todos
	 */
	@Query("SELECT t.id, t.title, t.completed, u.id, u.username, u.country FROM Todo t JOIN t.user u WHERE t.title = :title AND u.username = :username")
	List<Object[]> getTodosByTitleAndUsername(@Param("title") String title, @Param("username") String username);

	/**
	 * Function that executes a query to the database to filter by title
	 * @param title , the title of the todo
	 * @return the list of todos
	 */
	@Query("SELECT t.id, t.title, t.completed, u.id, u.username, u.country FROM Todo t JOIN t.user u WHERE t.title = :title")
	List<Object[]> getTodosByTitle(@Param("title") String title);

	/**
	 * Function that executes a query to the database to filter by username
	 * @param username, the username of the user that creates the todo
	 * @return the List of the todos
	 */
	@Query("SELECT t.id, t.title, t.completed, u.id, u.username, u.country FROM Todo t JOIN t.user u WHERE u.username = :username")
	List<Object[]> getTodosByUsername(@Param("username") String username);
}
