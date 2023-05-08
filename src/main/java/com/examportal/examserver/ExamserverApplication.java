package com.examportal.examserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamserverApplication {
	
	static Logger logger=LoggerFactory.getLogger(ExamserverApplication.class);

	public static void main(String[] args) {
		
		logger.info("Exam Portal Application starting...");
		SpringApplication.run(ExamserverApplication.class, args);
	}

}
