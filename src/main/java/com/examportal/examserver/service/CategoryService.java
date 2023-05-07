package com.examportal.examserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.examserver.dao.CategoryRepository;
import com.examportal.examserver.entity.Category;
import com.examportal.examserver.exception.CategoryNotFoundException;
import com.examportal.examserver.model.CategoryModel;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	//Get all categories
	public List<CategoryModel> getCategories() throws CategoryNotFoundException
	{
		List<Category> list = categoryRepo.findAll();
		List<CategoryModel> categories = new ArrayList<>();
		
		for(Category c : list) {
			CategoryModel cm = new CategoryModel();
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
	public CategoryModel getCategory(int categoryId) throws CategoryNotFoundException
	{
		Category c = categoryRepo.findById(categoryId).orElse(null);
		if(c==null) {
			throw new CategoryNotFoundException("Category Not found ");
		}
		
		CategoryModel category=new CategoryModel();
		category.setTitle(c.getTitle());
		category.setDescription(c.getDescription());
		
		return category;
		
	}

	
}
