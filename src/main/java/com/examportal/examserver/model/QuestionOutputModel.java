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
	private String givenAns;
	
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
	
	
}
