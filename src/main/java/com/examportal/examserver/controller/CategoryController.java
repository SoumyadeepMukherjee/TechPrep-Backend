package com.examportal.examserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examserver.model.CategoryModel;
import com.examportal.examserver.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	Logger logger=LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/{categoryId}")
	public CategoryModel viewCategory(@PathVariable("categoryId") int categoryId)
	{
		logger.info("Category with category id "+categoryId+" ->"+categoryService.viewCategory(categoryId).getTitle());
		return categoryService.viewCategory(categoryId);
	}
		
	@GetMapping("/viewcategories")
	public ResponseEntity<?> viewAllCategories()
	{
		logger.info("All available categories are ->");
		for (CategoryModel c:categoryService.viewAllCategories())
		{
			logger.info(c.getTitle());
		}
		
		return ResponseEntity.ok(this.categoryService.viewAllCategories());
	}
	
}
