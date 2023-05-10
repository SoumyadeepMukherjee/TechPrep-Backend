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
	
	
	
}
