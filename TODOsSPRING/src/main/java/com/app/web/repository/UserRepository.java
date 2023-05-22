package com.app.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * Function to find a user by the username
	 * @param username, the username to do the search
	 * @return the user find
	 */
	Optional<User> findByUsername(String username);

}
