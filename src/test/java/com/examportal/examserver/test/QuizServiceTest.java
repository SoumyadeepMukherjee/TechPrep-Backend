package com.examportal.examserver.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.examportal.examserver.dao.QuizRepository;
import com.examportal.examserver.exception.QuizNotFoundException;
import com.examportal.examserver.model.QuizModel;
import com.examportal.examserver.service.QuizService;

@SpringBootTest
public class QuizServiceTest {

	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuizRepository quizRepo;
	
	@Test
	public void testGetQuizzes()
	{
		List<QuizModel> quizList=new ArrayList<>();
		
		quizList.add(new QuizModel("This section consists of questions on Java basics & OOPs concepts","100","10","Java Basics and OOPs"));
		quizList.add(new QuizModel("This section consists of questions on Spring basics","100","10","Spring basics"));
		quizList.add(new QuizModel("This section consists of questions based on various Spring Boot concepts","200","20","Spring Boot"));
		quizList.add(new QuizModel("This section consists of questions on Spring Data JPA concepts","100","20","Spring Data JPA"));
		
		List<QuizModel> actualList=quizService.getQuizzes();
		
		assertNotNull(actualList);
		assertEquals(quizList.size(), actualList.size());
	}
	
	@Test
	public void testGetQuiz() throws QuizNotFoundException
	{
		assertEquals("Spring Boot", quizService.getQuiz(3).getTitle());
	}
	
}
