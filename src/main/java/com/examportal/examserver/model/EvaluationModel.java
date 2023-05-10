package com.examportal.examserver.model;

import java.util.List;

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
public class EvaluationModel {
	private int userId;
	private int qid;
	private List<QuestionOutputModel> questions;
	
	
}
