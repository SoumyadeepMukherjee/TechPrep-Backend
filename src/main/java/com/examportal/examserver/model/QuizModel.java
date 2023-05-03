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
public class QuizModel {
	
	private String maxMarks;
	private String noOfQs;
	
	
	
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getNoOfQs() {
		return noOfQs;
	}
	public void setNoOfQs(String noOfQs) {
		this.noOfQs = noOfQs;
	}
	
	
	
}
