package com.examportal.examserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {
	
	public Question() {
		super();
	}

	public Question(int quesId, String content, String option1, String option2, String option3, String option4,
			String ans, String givenAns, Quiz quiz) {
		super();
		this.quesId = quesId;
		this.content = content;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.ans = ans;
		this.givenAns = givenAns;
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Question [quesId=" + quesId + ", content=" + content + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", ans=" + ans + ", givenAns=" + givenAns
				+ ", quiz=" + quiz + "]";
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
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

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int quesId;
	
	@Column(length=5000)
	private String content;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String ans;
	
	@Transient
	private String givenAns;
	
	@ManyToOne
	@JoinColumn(name="qid")
	private Quiz quiz;

	
	
}
