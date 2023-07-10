package com.examportal.examserver.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvaluationModel {
	@Override
	public String toString() {
		return "EvaluationModel [userId=" + userId + ", qid=" + qid + ", questions=" + questions + "]";
	}
	public EvaluationModel() {
		super();
	}
	public EvaluationModel(int userId, int qid, List<QuestionOutputModel> questions) {
		super();
		this.userId = userId;
		this.qid = qid;
		this.questions = questions;
	}
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
	private int userId;
	private int qid;
	private List<QuestionOutputModel> questions;
	
	
}
