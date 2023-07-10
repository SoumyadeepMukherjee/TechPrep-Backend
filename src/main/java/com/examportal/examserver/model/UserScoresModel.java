package com.examportal.examserver.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
public class UserScoresModel {
	private int qid;
	
	private int score;
	
	@Override
	public String toString() {
		return "UserScoresModel [qid=" + qid + ", score=" + score + ", examDate=" + examDate + ", correctAns="
				+ correctAns + "]";
	}

	public UserScoresModel() {
		super();
	}

	public UserScoresModel(int qid, int score, String examDate, int correctAns) {
		super();
		this.qid = qid;
		this.score = score;
		this.examDate = examDate;
		this.correctAns = correctAns;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getExamDate() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		return currentDateTime.format(formatter);
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public int getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(int correctAns) {
		this.correctAns = correctAns;
	}

	private String examDate;
	
	private int correctAns;
}
