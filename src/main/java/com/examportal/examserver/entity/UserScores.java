package com.examportal.examserver.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="userscores")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserScores {
	public UserScores() {
		super();
	}

	@Override
	public String toString() {
		return "UserScores [scoreId=" + scoreId + ", qid=" + qid + ", score=" + score + ", examDate=" + examDate
				+ ", correctAns=" + correctAns + "]";
	}

	public UserScores(int scoreId, int qid, int score, String examDate, int correctAns) {
		super();
		this.scoreId = scoreId;
		this.qid = qid;
		this.score = score;
		this.examDate = examDate;
		this.correctAns = correctAns;
	}

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
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
		return examDate;
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int scoreId;
	
	private int qid;
	
	
	private int score;
	
	private String examDate;
	
	private int correctAns;
	
	
}
