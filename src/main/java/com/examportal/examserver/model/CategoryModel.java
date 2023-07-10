package com.examportal.examserver.model;

import java.util.List;

import com.examportal.examserver.entity.Quiz;

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
public class CategoryModel {
	
	private int cid;
	@Override
	public String toString() {
		return "CategoryModel [cid=" + cid + ", title=" + title + ", description=" + description + "]";
	}

	public CategoryModel() {
		super();
	}

	public CategoryModel(int cid, String title, String description) {
		super();
		this.cid = cid;
		this.title = title;
		this.description = description;
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

	private String title;
	
	private String description;
	
	
}
