package com.examportal.examserver.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.examportal.examserver.dao.CategoryRepository;
import com.examportal.examserver.model.CategoryModel;
import com.examportal.examserver.service.CategoryService;

@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepo;


	@Test
	public void testGetCategories()
	{
		List<CategoryModel> categoryList=new ArrayList<>();
		
		categoryList.add(new CategoryModel("This section contains quizzes based on Core Java","Core Java"));
		categoryList.add(new CategoryModel("This section contains quizzes based on Spring Core concepts","Spring Framework"));
		categoryList.add(new CategoryModel("This section contains quizzes based on Spring Boot","Spring Boot"));
		categoryList.add(new CategoryModel("This section contains quizzes based on Spring Data JPA","Spring JPA"));
		
		List<CategoryModel> actualList=categoryService.getCategories();
		
		assertNotNull(actualList);
		assertEquals(categoryList.size(), actualList.size());
	}
	
	@Test
	public void testGetCategoryById()
	{
		assertEquals("Core Java", categoryService.getCategory(10).getTitle());
	}
}
