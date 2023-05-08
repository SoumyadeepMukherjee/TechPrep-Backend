package com.examportal.examserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.examserver.dao.QuizRepository;
import com.examportal.examserver.entity.Quiz;
import com.examportal.examserver.exception.QuizNotFoundException;
import com.examportal.examserver.model.QuestionOutputModel;
import com.examportal.examserver.model.QuizModel;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepo;
	
	//Get all quizzes
	public List<QuizModel> viewQuizzes()
	{
		List<Quiz> quizList= this.quizRepo.findAll();
		List<QuizModel> quizzes=new ArrayList<>();
		
		for (Quiz q:quizList)
		{
			QuizModel quiz=new QuizModel();
			quiz.setTitle(q.getTitle());
			quiz.setDescription(q.getDescription());
			quiz.setMaxMarks(q.getMaxMarks());
			quiz.setNoOfQs(q.getNoOfQs());
			
			quizzes.add(quiz);
		}
		
		return quizzes;
	}
	
	//Get a particular quiz by quiz id
	public Quiz viewQuiz(int quizId) throws QuizNotFoundException
	{
		Quiz q = quizRepo.findById(quizId).orElse(null);
		if(q==null) {
			throw new QuizNotFoundException("No Quiz found");
			
		}
		
//		QuizModel quiz=new QuizModel();
//		quiz.setTitle(q.getTitle());
//		quiz.setDescription(q.getDescription());
//		quiz.setMaxMarks(q.getMaxMarks());
//		quiz.setNoOfQs(q.getNoOfQs());
		
		return q;
	}
	
}
