package com.examportal.examserver.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.examportal.examserver.exception.QuestionNotFoundException;
import com.examportal.examserver.model.QuestionInputModel;
import com.examportal.examserver.service.QuestionService;

@SpringBootTest
public class QuestionServiceTest {

	@Autowired
	private QuestionService questionService;
	
	@Test
	public void testGetQuestions()
	{
		List<QuestionInputModel> quesList=new ArrayList<>();
		
		quesList.add(new QuestionInputModel("class","Which attribute is used to specify class name of the bean?","name","id","class","constructor-args"));
		quesList.add(new QuestionInputModel("singleton","What is the default scope of the Spring Bean?","singleton","prototype","request","session"));
		quesList.add(new QuestionInputModel("To manage the lifecycle of beans and their dependencies","What is the purpose of the Spring IoC container?","To manage the lifecycle of beans and their dependencies","To handle the configuration of the application","To provide a caching mechanism for the application","To provide a security mechanism for the application"));
		
		List<QuestionInputModel> actualList=questionService.viewQuestions();
		
		assertNotNull(actualList);
		
		assertEquals(quesList.size(), actualList.size());
	}
	
	public void testGetQuestion() throws QuestionNotFoundException
	{
		assertEquals("Which attribute is used to specify class name of the bean?", questionService.viewQuestion(1).getContent());
	}
}
