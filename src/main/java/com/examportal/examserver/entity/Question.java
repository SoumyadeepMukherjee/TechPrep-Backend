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
