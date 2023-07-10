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
	public QuizModel() {
		super();
	}
	@Override
	public String toString() {
		return "QuizModel [qid=" + qid + ", title=" + title + ", description=" + description + ", maxMarks=" + maxMarks
				+ ", noOfQs=" + noOfQs + "]";
	}
	public QuizModel(int qid, String title, String description, String maxMarks, String noOfQs) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.noOfQs = noOfQs;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
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
	private int qid;
	private String title;
	private String description;
	private String maxMarks;
	private String noOfQs;
	
	
	
}
