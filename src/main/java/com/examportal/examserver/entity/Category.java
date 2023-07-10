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
public class Category {
	
	public Category() {
		super();
	}

	public Category(int cid, String title, String description, List<Quiz> quizzes) {
		super();
		this.cid = cid;
		this.title = title;
		this.description = description;
		this.quizzes = quizzes;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", title=" + title + ", description=" + description + ", quizzes=" + quizzes
				+ "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String title;
	private String description;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Quiz> quizzes=new ArrayList<>();
	
	
}
