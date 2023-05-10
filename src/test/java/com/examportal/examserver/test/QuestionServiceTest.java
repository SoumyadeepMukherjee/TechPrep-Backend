package com.examportal.examserver.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.examportal.examserver.exception.QuestionNotFoundException;
import com.examportal.examserver.model.EvaluationModel;
import com.examportal.examserver.model.QuestionInputModel;
import com.examportal.examserver.model.QuestionOutputModel;
import com.examportal.examserver.service.QuestionService;

@SpringBootTest
public class QuestionServiceTest {
	
	Logger logger=LoggerFactory.getLogger(QuestionServiceTest.class);

	@Autowired
	private QuestionService questionService;
	
//	@Test
//	public void testViewQuestions()
//	{
//		logger.info("Start of testViewQuestions() method...");
//		
//		List<QuestionInputModel> quesList=new ArrayList<>();
//		
//		quesList.add(new QuestionInputModel("class","Which attribute is used to specify class name of the bean?","name","id","class","constructor-args"));
//		quesList.add(new QuestionInputModel("singleton","What is the default scope of the Spring Bean?","singleton","prototype","request","session"));
//		quesList.add(new QuestionInputModel("To manage the lifecycle of beans and their dependencies","What is the purpose of the Spring IoC container?","To manage the lifecycle of beans and their dependencies","To handle the configuration of the application","To provide a caching mechanism for the application","To provide a security mechanism for the application"));
//		
//		List<QuestionInputModel> actualList=questionService.viewQuestions();
//		
//		assertNotNull(actualList);
//		
//		assertEquals(quesList.size(), actualList.size());
//		
//		logger.info("End of testViewQuestions() method");
//	}
	
	@Test
	public void testViewQuestion() throws QuestionNotFoundException
	{
		logger.info("Start of testViewQuestion() method...");
		
		assertEquals("Which attribute is used to specify class name of the bean?", questionService.viewQuestion(1).getContent());
		
		logger.info("End of testViewQuestion() method");
	}
	
	@Test
	public void testEvaluateQuiz() throws QuestionNotFoundException
	{
		logger.info("Start of testevaluateQuiz() method...");
		
		QuestionOutputModel qm1=new QuestionOutputModel(1,"class","id");
		QuestionOutputModel qm2=new QuestionOutputModel(2,"singleton","singleton");
		QuestionOutputModel qm3=new QuestionOutputModel(3,"To manage the lifecycle of beans and their dependencies","To manage the lifecycle of beans and their dependencies");
		
		List<QuestionOutputModel> qml=new ArrayList<>();
		qml.add(qm1);
		qml.add(qm2);
		qml.add(qm3);
		
		EvaluationModel evaluationModel=new EvaluationModel(101,2,qml);
		
		assertEquals(8,questionService.evaluateQuiz(evaluationModel).get("marksGot"));
		//assertTrue(questionService.evaluateQuiz(evaluationModel).get("attempted").equals();
		
		logger.info("End of evaluateQuiz() method");
	}
}
