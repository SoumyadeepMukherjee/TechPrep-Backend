package com.examportal.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examserver.entity.Quiz;
import com.examportal.examserver.exception.QuizNotFoundException;
import com.examportal.examserver.service.QuizService;

@RestController
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz q) throws QuizNotFoundException
	{
		return ResponseEntity.ok(this.quizService.addQuiz(q));
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz q)
	{
		return ResponseEntity.ok(this.quizService.updateQuiz(q));
	}
	
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
	
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable("qid") int qid) throws QuizNotFoundException
	{
		this.quizService.deleteQuiz(qid);
	}
}
