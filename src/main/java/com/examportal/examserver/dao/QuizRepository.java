package com.examportal.examserver.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examportal.examserver.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {

	@Query("select q from Quiz q where q.category.cid=?1")
	List<Quiz> findByCategory(int cid);

//	
//	public Set<Quiz> getQuizzes();
//	
//	public Quiz viewQuiz(int quizId);

//	@Query("select q from Quiz q where q.getQid()=?1")
//	public Set<Quiz> viewQuizByCategory(int cid);
}
