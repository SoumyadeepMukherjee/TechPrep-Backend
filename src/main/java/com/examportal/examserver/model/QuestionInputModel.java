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
public class QuestionInputModel {
	
	public QuestionInputModel() {
		super();
	}
	public QuestionInputModel(String content, String option1, String option2, String option3, String option4,
			String ans) {
		super();
		this.content = content;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.ans = ans;
	}
	@Override
	public String toString() {
		return "QuestionInputModel [content=" + content + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + ", ans=" + ans + "]";
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
	private String content;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String ans;
	
	
}
