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
	
	
	public User createUser(UserModel userModel) throws Exception
	{
		User u= userRepo.findByUsername(userModel.getUsername());
		
		if (u!=null)
		{
			throw new UserNotFoundException("User already present");
		}
		
		u=userRepo.save(u);
		
		return u;
	}
	
	public User getUser(String username)
	{
		return this.userRepo.findByUsername(username);
	}
	
//	public void deleteUser(int id,RoleModel roleModel)
//	{
//		if (roleModel.getRoleName().equals("Admin"))
//			userRepo.deleteById(id);
//	}
}
