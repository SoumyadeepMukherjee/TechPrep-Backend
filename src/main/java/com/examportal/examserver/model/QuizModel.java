package com.examportal.examserver.model;

import java.util.ArrayList;
import java.util.List;

import com.examportal.examserver.entity.Question;

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
	
	private String title;
	private String description;
	private String maxMarks;
	private String noOfQs;
	
	public QuizModel()
	{
		
	}
	
	public QuizModel(String title, String description, String maxMarks, String noOfQs) {
		super();
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.noOfQs = noOfQs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
