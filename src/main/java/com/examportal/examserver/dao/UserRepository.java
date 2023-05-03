//package com.examportal.examserver.dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.examportal.examserver.entity.User;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Integer>{
//	
//	//Creating user
//	@Query("select u from User u where u.username=:username")
//	public User findByUsername(String username);
//	
//	//Getting user by username
////	public User getUser(String username);
//	
//	//Deleting user by id
////	public void deleteUser(Long id);
//}
