package com.examportal.examserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ExamserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

}
