package com.examportal.examserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examportal.examserver.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//Getting user by username
	@Query("select u from User u where u.username=:username")
	public User findByUsername(String username);
	
	@Query("select u from User u where u.email=:email")
	public User findbyEmail(String email);
}
