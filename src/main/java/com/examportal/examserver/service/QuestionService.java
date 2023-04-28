package com.examportal.examserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.examserver.dao.QuestionRepository;
import com.examportal.examserver.entity.Category;
import com.examportal.examserver.entity.Question;
import com.examportal.examserver.entity.Quiz;
import com.examportal.examserver.exception.CategoryNotFoundException;
import com.examportal.examserver.exception.QuestionNotFoundException;

@Service
public class QuestionService 
{
	
	@Autowired
	private QuestionRepository questionRepo;
	
	public Question addQuestion(Question question)
	{
		question = questionRepo.save(question);
		return question;
	}
	
	public Question updateQuestion(Question question)
	{
		return this.questionRepo.save(question);
	}
	
	public List<Question> getQuestions()
	{
		return this.questionRepo.findAll();
	}
	
	public List<Question> getQuestion(String content) throws QuestionNotFoundException
	{ 
		List<Question> l1 = questionRepo.findAll();
		List<Question> l2 = new ArrayList<>();
		for(Question q :l1) 
		{
			if(q.getContent().contains(content)) {
				l2.add(q);
			}
		}
		if(l2.size()==0) {
			throw new QuestionNotFoundException("No such Question found");
		}
		return l2;
	}
	
	public Set<Question> getQuestionsByQuiz(Quiz quiz)
	{
		int id = quiz.getQid();
		return this.questionRepo.findByQuiz(id);
	}
	
}
