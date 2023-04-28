package com.examportal.examserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.examportal.examserver.entity.Category;
import com.examportal.examserver.entity.Role;
import com.examportal.examserver.entity.User;
import com.examportal.examserver.model.RoleModel;
import com.examportal.examserver.service.CategoryService;
import com.examportal.examserver.service.UserService;

@SpringBootApplication
public class ExamserverApplication {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("----Application starts----");
//
//		User user = new User();
//		user.setFirstName("Soumyadeep");
//		user.setLastName("Mukherjee");
//		user.setEmail("soum@gmail.com");
//		user.setPassword("abc");
//		user.setUsername("soum123");
//		
//		RoleModel r=new RoleModel();
//		r.setUserId(user.getUserId());
//		r.setRoleName("Admin");
//
//		User user1 = userService.createUser(user,r);
//		System.out.println(user1);
//		
//		Category category=new Category();
//		category.setCid(1);
//		category.setTitle("Core Java");
//		category.setDescription("This category consists of various core java concepts");
//		
//		Category category1=categoryService.addCategory(category, r);
//		System.out.println(category1);

//	}

}
