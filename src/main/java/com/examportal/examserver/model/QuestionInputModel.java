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
	
	private String content;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String ans;
	
	
}
