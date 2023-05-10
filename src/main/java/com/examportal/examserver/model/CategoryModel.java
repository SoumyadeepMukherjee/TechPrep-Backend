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
	private String title;
	
	private String description;
	
	
}
