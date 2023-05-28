package com.examportal.examserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.examportal.examserver.dao.UserRepository;

import com.examportal.examserver.entity.User;
import com.examportal.examserver.exception.UserNotFoundException;
import com.examportal.examserver.model.UserModel;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	
	public User getUser(String username)
	{
		return this.userRepo.findByUsername(username);
	}
	
	public User findByEmail(String email)
	{
		return this.userRepo.findbyEmail(email);
	}
}
