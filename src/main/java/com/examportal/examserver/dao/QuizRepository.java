package com.examportal.examserver.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.examserver.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
//	public Quiz addQuiz(Quiz quiz);
//	
//	public Quiz updateQuiz(Quiz quiz);
//	
//	public Set<Quiz> getQuizzes();
//	
//	public Quiz getQuiz(Long quizId);
//	
//	public void deleteQuiz(Long quizId);
}
