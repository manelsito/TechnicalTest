package com.app.web.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.web.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	@Query("SELECT t.id, t.title, t.completed, u.id, u.username, u.country FROM Todo t JOIN t.user u WHERE t.title = :title AND u.username = :username")
	List<Object[]> getTodosByTitleAndUsername(@Param("title") String title, @Param("username") String username);

	@Query("SELECT t.id, t.title, t.completed, u.id, u.username, u.country FROM Todo t JOIN t.user u WHERE t.title = :title")
	List<Object[]> getTodosByTitle(@Param("title") String title);

	@Query("SELECT t.id, t.title, t.completed, u.id, u.username, u.country FROM Todo t JOIN t.user u WHERE u.username = :username")
	List<Object[]> getTodosByUsername(@Param("username") String username);
}
