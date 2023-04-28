package com.examportal.examserver.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Quiz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int qid;
	private String title;
	private String description;
	private String maxMarks;
	private String noOfQs;
	private boolean active=false;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
	private Category category;
	
	@OneToMany(mappedBy="quiz",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Question> questions=new ArrayList<>();

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
