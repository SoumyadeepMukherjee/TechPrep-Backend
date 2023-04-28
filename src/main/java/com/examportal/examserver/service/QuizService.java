package com.examportal.examserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.examserver.dao.QuizRepository;
import com.examportal.examserver.entity.Category;
import com.examportal.examserver.entity.Quiz;
import com.examportal.examserver.exception.CategoryNotFoundException;
import com.examportal.examserver.exception.QuizNotFoundException;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepo;
	
	public Quiz addQuiz(Quiz quiz) throws QuizNotFoundException
	{
		Quiz c = quizRepo.findById(quiz.getQid()).orElse(null);
		if(c!=null) {
			throw new QuizNotFoundException("Quiz already present");
		}
		quiz = quizRepo.save(quiz);
		return quiz;
	}
	
	public Quiz updateQuiz(Quiz Quiz)
	{
		return this.quizRepo.save(Quiz);
	}
	
	public List<Quiz> getQuizzes()
	{
		return this.quizRepo.findAll();
	}
	
	public Quiz getQuiz(int quizId) throws QuizNotFoundException
	{
		Quiz q = quizRepo.findById(quizId).orElse(null);
		if(q==null) {
			throw new QuizNotFoundException("No quiz id found");
		}
		return q;
	}
	
	public void deleteQuiz(int quizId) throws QuizNotFoundException
	{
		
		Quiz c = quizRepo.findById(quizId).orElse(null);
		if(c==null) {
			throw new QuizNotFoundException("Quiz Not found!!");
		}
		quizRepo.delete(c);
	}
	
}
