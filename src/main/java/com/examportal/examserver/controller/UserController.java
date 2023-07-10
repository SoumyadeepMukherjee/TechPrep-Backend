package com.examportal.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examserver.entity.User;
import com.examportal.examserver.model.UserModel;
import com.examportal.examserver.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String username)
	{
		return this.userService.getUser(username);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserModel u)
	{
		User user=userService.findByEmail(u.getEmail());
		
		if (user == null || !user.getPassword().equals(u.getPassword())) 
		{
		      // Invalid credentials, return an error response
		      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}

		// Valid credentials, return a success response
		return ResponseEntity.ok().body("Login successful");
	}
}