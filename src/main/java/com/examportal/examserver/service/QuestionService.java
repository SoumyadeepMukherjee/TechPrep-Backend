package com.examportal.examserver.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.examserver.dao.QuestionRepository;
import com.examportal.examserver.dao.QuizRepository;
import com.examportal.examserver.dao.UserRepository;
import com.examportal.examserver.dao.UserScoreRepository;
import com.examportal.examserver.entity.Question;
import com.examportal.examserver.entity.Quiz;
import com.examportal.examserver.entity.User;
import com.examportal.examserver.entity.UserScores;
import com.examportal.examserver.exception.QuestionNotFoundException;
import com.examportal.examserver.model.EvaluationModel;
import com.examportal.examserver.model.QuestionInputModel;
import com.examportal.examserver.model.QuestionOutputModel;
import com.examportal.examserver.model.UserScoresModel;

@Service
public class QuestionService 
{

	Logger logger=LoggerFactory.getLogger(QuestionService.class);
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserScoreRepository userScoreRepo;

	
	//Get all the questions list
	public List<QuestionInputModel> viewQuestions()
	{
		logger.info("Start of view questions method");
		
		List<Question> questionList= this.questionRepo.findAll();
		List<QuestionInputModel> questions=new ArrayList<>();
		
		for (Question q:questionList)
		{
			QuestionInputModel question=new QuestionInputModel();
			question.setContent(q.getContent());
			question.setOption1(q.getOption1());
			question.setOption2(q.getOption2());
			question.setOption3(q.getOption3());
			question.setOption4(q.getOption4());
			
			questions.add(question);
		}
		
		return questions;
	}
	
	//Get a particular question by their id
	public QuestionInputModel viewQuestion(int quesId) throws QuestionNotFoundException
	{ 
		logger.info("Start of view question by id method");
		
		Question q= this.questionRepo.findById(quesId).orElse(null);
		
		if (q==null)
		{
			throw new QuestionNotFoundException("No Question Found");
		}
		
		QuestionInputModel question=new QuestionInputModel();
		question.setContent(q.getContent());
		question.setOption1(q.getOption1());
		question.setOption2(q.getOption2());
		question.setOption3(q.getOption3());
		question.setOption4(q.getOption4());
		question.setAns(q.getAns());
		
		return question;
	}

	//Get a set of questions by a particular quiz
	public Set<QuestionInputModel> getQuestionsByQuiz(Quiz quiz)
	{
		logger.info("Start of Get Questions by Quiz method");
		int id = quiz.getQid();
		Set<Question> questionSet= this.questionRepo.findByQuiz(id);
		Set<QuestionInputModel> questions=new HashSet<>();
		
		for (Question q:questionSet)
		{
			QuestionInputModel question=new QuestionInputModel();
			question.setContent(q.getContent());
			question.setOption1(q.getOption1());
			question.setOption2(q.getOption2());
			question.setOption3(q.getOption3());
			question.setOption4(q.getOption4());
			question.setAns(q.getAns());
			
			questions.add(question);
		}
		
		return questions;
	}
	
	//Viewing the quiz results by user name
	public List<UserScores> viewQuizResults()
	{
		//User user=this.userRepo.findByUsername(userName);

		return userScoreRepo.findAll();
		
	}
	
	//Saving the quiz results
	public UserScores saveQuizResult(UserScoresModel quizResult) {
		UserScores userScore=new UserScores();
		userScore.setQid(quizResult.getQid());
		userScore.setCorrectAns(quizResult.getCorrectAns());
		userScore.setExamDate(quizResult.getExamDate());
		userScore.setScore(quizResult.getScore());
		
		UserScores score= userScoreRepo.save(userScore);
		
		return score;
	}
	
	


	//Evaluate a set of questions
//	public Map<String,Object> evaluateQuiz(EvaluationModel evaluationModel) throws QuestionNotFoundException
//	{
//		logger.info("Start of evaluating quiz method");
//		
//		int marksSingle=5,marksGot=0;
//		int correctAns=0;
//		int attempted=0;
//		
//		for (QuestionOutputModel q:evaluationModel.getQuestions())
//		{
//			QuestionInputModel question=this.viewQuestion(q.getQuesId());
//			
//			if (question==null)
//				throw new QuestionNotFoundException("Question Not Found!");
//			
//			if (question.getAns().equals(q.getGivenAns()))
//			{
//				//Correct  ans
//				correctAns++;
//				
//				//marksSingle=Double.parseDouble(quizRepo.getQuiz(q.getQuesId()).getMaxMarks())/evaluationModel.getQuestions().size();
//				
//				marksGot+=marksSingle;
//			}
//			
//			
//			if (q.getGivenAns()!=null)
//			{
//				attempted++;
//			}
//			
//		}
//		
//		User user=userRepo.findById(evaluationModel.getUserId()).orElse(null);
//		UserScores userScore=new UserScores();
//		userScore.setScore(marksGot);
//		userScore.setCorrectAns(correctAns);
//		//userScore.setExamDate(LocalDateTime.now());
//		userScore.setQid(evaluationModel.getQid());
//		
//		user.getUserScores().add(userScore);
//		
//		userRepo.save(user);
//		
//		Map<String,Object> map=Map.of("marksGot",marksGot,"correctAnswers",correctAns,"attempted",attempted,"userId",evaluationModel.getUserId(),"quizId",evaluationModel.getQid());
//		
//		return map;
//	}

	
}
