package com.examportal.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examserver.entity.Quiz;
import com.examportal.examserver.exception.QuizNotFoundException;
import com.examportal.examserver.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes()
	{
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	@GetMapping("/{qid}")
	public Quiz getQuiz(@PathVariable("qid") int qid) throws QuizNotFoundException
	{
		return this.quizService.getQuiz(qid);
	}
	
}
