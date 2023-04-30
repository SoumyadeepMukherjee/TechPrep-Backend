package com.examportal.examserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
