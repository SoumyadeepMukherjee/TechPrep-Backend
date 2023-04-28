package com.examportal.examserver.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examportal.examserver.entity.Question;
import com.examportal.examserver.entity.Quiz;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
//	public Question addQuestion(Question q);
//	
//	public Question updateQuestion(Question q);
//	
//	public List<Question> getQuestions();
	
//	public Question getQuestion(Lon questionId);
//	
	public Set<Question> findByQuiz(int id);
	
	@Query("select q from Question q where q.quiz.getQid()=?1")
	public Set<Question> getQuestionsByQuiz(int id);
	
}