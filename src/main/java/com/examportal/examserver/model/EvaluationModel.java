package com.examportal.examserver.model;

import java.util.List;

public class EvaluationModel {
	private int userId;
	private int qid;
	private List<QuestionOutputModel> questions;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public List<QuestionOutputModel> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionOutputModel> questions) {
		this.questions = questions;
	}
	
	
}
