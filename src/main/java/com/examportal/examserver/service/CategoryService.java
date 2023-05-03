package com.examportal.examserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.examserver.dao.CategoryRepository;
import com.examportal.examserver.entity.Category;
import com.examportal.examserver.exception.CategoryNotFoundException;
import com.examportal.examserver.model.CategoryOutputModel;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
//	public Category addCategory(CategoryInputModel categoryModel) throws CategoryNotFoundException,UserNotFoundException
//	{
//		
//		List<Category> list1 = categoryRepo.findAll();
//		Category category = new Category();
//		if(categoryModel.getRoleName().equalsIgnoreCase("Admin")) 
//		{
//			category.setDescription(categoryModel.getDescription());
//			category.setTitle(categoryModel.getTitle());
//			category = categoryRepo.save(category);
//			return category; 
//		}
//		
//		else {
//			throw new UserNotFoundException("Only Admin can add category");
//		}
//		
//	}
//	
//	public Category updateCategory(Category category)
//	{
//		return this.categoryRepo.save(category);
//	}
//	
	public List<CategoryOutputModel> getCategories() throws CategoryNotFoundException
	{
		List<Category> list = categoryRepo.findAll();
		List<CategoryOutputModel> list1 = new ArrayList<>();
		for(Category c : list) {
			CategoryOutputModel cm = new CategoryOutputModel();
			cm.setDescription(c.getDescription());
			cm.setTitle(c.getTitle());
			list1.add(cm);
		}
		if(list1.size()==0) {
			throw new CategoryNotFoundException("No categories present");
		}
		return list1;
	}
	
	public Category getCategory(int categoryId) throws CategoryNotFoundException
	{
		Category c = categoryRepo.findById(categoryId).orElse(null);
		if(c==null) {
			throw new CategoryNotFoundException("Category Not found ");
		}
		return c;
		
	}
	
//	public void deleteCategory(int categoryId,RoleModel roleModel) throws CategoryNotFoundException, UserNotFoundException
//	{
//		Category c = categoryRepo.findById(categoryId).orElse(null);
//		if(c==null) {
//			throw new CategoryNotFoundException("Category Not found!!");
//		}
//		
//		if (roleModel.getRoleName().equals("Admin"))
//			categoryRepo.delete(c);
//		else
//			throw new UserNotFoundException("Only Admin is allowed to delete category");
//	}
	
}
