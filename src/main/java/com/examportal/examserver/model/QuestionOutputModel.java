package com.examportal.examserver.model;

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
public class QuestionOutputModel {
	
	private int quesId;
	private String ans;
	@Override
	public String toString() {
		return "QuestionOutputModel [quesId=" + quesId + ", ans=" + ans + ", givenAns=" + givenAns + "]";
	}
	public QuestionOutputModel() {
		super();
	}
	public QuestionOutputModel(int quesId, String ans, String givenAns) {
		super();
		this.quesId = quesId;
		this.ans = ans;
		this.givenAns = givenAns;
	}
	public int getQuesId() {
		return quesId;
	}
	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getGivenAns() {
		return givenAns;
	}
	public void setGivenAns(String givenAns) {
		this.givenAns = givenAns;
	}
	private String givenAns;
	
}
