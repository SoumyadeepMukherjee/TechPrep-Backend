package com.examportal.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examserver.entity.Category;
import com.examportal.examserver.exception.CategoryNotFoundException;
import com.examportal.examserver.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
//	@PostMapping("/addcategory")
//	public ResponseEntity<Category> addCategory(@RequestBody CategoryInputModel categoryModel) throws CategoryNotFoundException,UserNotFoundException
//	{
//		Category category= categoryService.addCategory(categoryModel);
//		return ResponseEntity.ok(category);
//	}
//	
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") int categoryId) throws CategoryNotFoundException
	{
		return categoryService.getCategory(categoryId);
	}
		
	@GetMapping("/")
	public ResponseEntity<?> getCategories() throws CategoryNotFoundException
	{
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
//	@PutMapping("/")
//	public Category updateCategory(@RequestBody Category category)
//	{
//		return categoryService.updateCategory(category);
//	}
//	
//	@DeleteMapping("/{categoryId}")
//	public void deleteCategory(@PathVariable("categoryId") int categoryId,@RequestBody RoleModel roleModel) throws CategoryNotFoundException, UserNotFoundException
//	{
//		this.categoryService.deleteCategory(categoryId,roleModel);
//	}
}
