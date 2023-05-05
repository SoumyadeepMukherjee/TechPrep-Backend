package com.examportal.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examserver.exception.CategoryNotFoundException;
import com.examportal.examserver.model.CategoryModel;
import com.examportal.examserver.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	

	@GetMapping("/{categoryId}")
	public CategoryModel getCategory(@PathVariable("categoryId") int categoryId)
	{
		return categoryService.getCategory(categoryId);
	}
		
	@GetMapping("/")
	public ResponseEntity<?> getCategories()
	{
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
}
