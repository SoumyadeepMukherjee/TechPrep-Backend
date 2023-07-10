package com.examportal.examserver.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.examportal.examserver.entity.UserScores;
import com.examportal.examserver.exception.QuestionNotFoundException;
import com.examportal.examserver.exception.QuizNotFoundException;
import com.examportal.examserver.model.EvaluationModel;
import com.examportal.examserver.model.QuestionInputModel;
import com.examportal.examserver.model.QuestionOutputModel;
import com.examportal.examserver.model.UserScoresModel;
import com.examportal.examserver.service.QuestionService;
import com.examportal.examserver.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	Logger logger=LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;

	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionByQuiz(@PathVariable("qid") int qid) throws QuestionNotFoundException, QuizNotFoundException
	{
		
		Quiz quiz=this.quizService.viewQuiz(qid);
		List<Question> questions=quiz.getQuestions();
		
		if (questions.size()>Integer.parseInt(quiz.getNoOfQs()))
			questions=questions.subList(0,Integer.parseInt(quiz.getNoOfQs()+1));
		
		logger.info("Questions of quiz with quiz id "+quizService.viewQuiz(qid).getQid()+" are:");
		for (Question q:questions)
		{
			logger.info("Question with id "+q.getQuesId()+" :"+q.getContent());
		}
		
		Collections.shuffle(questions);
		return ResponseEntity.ok(questions);
	}
	
	@GetMapping("/{quesId}")
	public QuestionInputModel getQuestion(@PathVariable("quesId") int quesId) throws QuestionNotFoundException
	{	
		logger.info("Question with question id "+quesId+" ->"+questionService.viewQuestion(quesId).getContent());
		return this.questionService.viewQuestion(quesId);
	}
	
	@GetMapping("/userscores")
    public List<UserScores> getQuizResultsByUserName() {
        List<UserScores> userScores = questionService.viewQuizResults();
        logger.info("Quiz results for user {}: {}", userScores);
        return this.questionService.viewQuizResults();
    }

    @PostMapping("/scores")
    public ResponseEntity<UserScores> saveQuizResult(@RequestBody UserScoresModel quizResult) {
        UserScores savedQuizResult = questionService.saveQuizResult(quizResult);
        logger.info("Saved quiz result: {}", savedQuizResult);
        return ResponseEntity.ok(savedQuizResult);
    }
	
	
//	@PostMapping("/eval-quiz")
//	public ResponseEntity<?> evalQuiz(@RequestBody EvaluationModel evaluationModel) throws QuestionNotFoundException
//	{
//		//System.out.println(questions);
//		
//		Map<String, Object> mp=this.questionService.evaluateQuiz(evaluationModel);
//		
//		logger.info("Questions attempted :"+mp.get("attempted"));
//		logger.info("Correct Answers :"+mp.get("correctAnswers"));
//		logger.info("Score :"+mp.get("marksGot"));
//		
//		return ResponseEntity.ok(mp);
//	}
	
	
	
}
