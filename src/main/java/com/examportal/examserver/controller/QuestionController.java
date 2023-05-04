package com.examportal.examserver.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examserver.entity.Question;
import com.examportal.examserver.entity.Quiz;
import com.examportal.examserver.exception.QuestionNotFoundException;
import com.examportal.examserver.exception.QuizNotFoundException;
import com.examportal.examserver.model.QuestionModel;
import com.examportal.examserver.service.QuestionService;
import com.examportal.examserver.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
//	@PostMapping("/")
//	public ResponseEntity<Question> addQuestion(@RequestBody Question question)
//	{
//		return ResponseEntity.ok(this.questionService.addQuestion(question));
//	}
//	
//	@PutMapping("/")
//	public ResponseEntity<Question> updateQuestion(@RequestBody Question q)
//	{
//		return ResponseEntity.ok(this.questionService.updateQuestion(q));
//	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuestions()
	{
		return ResponseEntity.ok(this.questionService.getQuestions());
	}
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionByQuiz(@PathVariable("qid") int qid) throws QuestionNotFoundException, QuizNotFoundException
	{
//		Quiz quiz=new Quiz();
//		quiz.setQid(qid);
//		Set<Question> questions= this.questionService.getQuestionsByQuiz(quiz);
//		return ResponseEntity.ok(questions);
		
		Quiz quiz=this.quizService.getQuiz(qid);
		List<Question> questions=quiz.getQuestions();
		
		if (questions.size()>Integer.parseInt(quiz.getNoOfQs()))
			questions=questions.subList(0,Integer.parseInt(quiz.getNoOfQs()+1));
		
		Collections.shuffle(questions);
		return ResponseEntity.ok(questions);
	}
	
	@GetMapping("/{quesId}")
	public Question getQuestion(@PathVariable("quesId") int quesId) throws QuestionNotFoundException
	{
		return this.questionService.getQuestion(quesId);
	}
	
//	@DeleteMapping("/{quesId}")
//	public void deleteQuestion(@PathVariable("quesId") int quesId) throws QuestionNotFoundException
//	{
//		this.questionService.deleteQuestion(quesId);
//	}
	
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<QuestionModel> questions) throws QuestionNotFoundException
	{
		//System.out.println(questions);
		
		Map<String, Object> mp=this.questionService.evaluateQuiz(questions);
		
		return ResponseEntity.ok(mp);
	}
}
