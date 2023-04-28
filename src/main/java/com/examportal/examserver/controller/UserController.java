package com.examportal.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examserver.entity.Role;
import com.examportal.examserver.entity.User;
import com.examportal.examserver.model.RoleModel;
import com.examportal.examserver.model.UserModel;
import com.examportal.examserver.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody UserModel userModel,@RequestBody RoleModel r) throws Exception
	{
		
		return userService.createUser(userModel,r);
	}
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String username)
	{
		return this.userService.getUser(username);
	}
	
//	@DeleteMapping("/{userId}")
//	public void deleteUser(@PathVariable("userId") int userId)
//	{
//		this.userService.deleteUser(userId);
//	}
}