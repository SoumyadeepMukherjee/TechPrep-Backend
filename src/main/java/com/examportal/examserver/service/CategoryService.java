package com.examportal.examserver.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.examserver.controller.CategoryController;
import com.examportal.examserver.dao.CategoryRepository;
import com.examportal.examserver.entity.Category;
import com.examportal.examserver.exception.CategoryNotFoundException;
import com.examportal.examserver.model.CategoryModel;

@Service
public class CategoryService {
	
	Logger logger=LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	//Get all categories
	public List<CategoryModel> viewAllCategories() throws CategoryNotFoundException
	{
		logger.info("Start of View all categories");
		List<Category> list = categoryRepo.findAll();
		List<CategoryModel> categories = new ArrayList<>();
		
		for(Category c : list) {
			CategoryModel cm = new CategoryModel();
			cm.setCid(c.getCid());
			cm.setDescription(c.getDescription());
			cm.setTitle(c.getTitle());
			categories.add(cm);
		}
		if(categories.size()==0) {
			throw new CategoryNotFoundException("No categories present");
		}
		return categories;
	}
	
	//Get category by category id
	public CategoryModel viewCategory(int categoryId) throws CategoryNotFoundException
	{
		logger.info("Start of View category by id");
		Category c = categoryRepo.findById(categoryId).orElse(null);
		if(c==null) {
			throw new CategoryNotFoundException("Category Not found ");
		}
		
		CategoryModel category=new CategoryModel();
		category.setCid(c.getCid());
		category.setTitle(c.getTitle());
		category.setDescription(c.getDescription());
		
		return category;
		
	}

	
}
