package com.examportal.examserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examserver.entity.Quiz;
import com.examportal.examserver.exception.QuizNotFoundException;
import com.examportal.examserver.model.CategoryModel;
import com.examportal.examserver.model.QuizModel;
import com.examportal.examserver.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	Logger logger=LoggerFactory.getLogger(QuizController.class);
	
	@Autowired
	private QuizService quizService;
	
	
	@GetMapping("/viewquizzes")
	public ResponseEntity<?> getQuizzes()
	{
		logger.info("All available quizzes are ->");
		for (QuizModel q:quizService.viewQuizzes())
		{
			logger.info(q.getTitle());
		}
		return ResponseEntity.ok(this.quizService.viewQuizzes());
	}
	
	@GetMapping("/{qid}")
	public Quiz getQuiz(@PathVariable("qid") int qid) throws QuizNotFoundException
	{
		logger.info("Quiz with quiz id "+qid+" ->"+quizService.viewQuiz(qid).getTitle());
		return this.quizService.viewQuiz(qid);
	}
	
}
