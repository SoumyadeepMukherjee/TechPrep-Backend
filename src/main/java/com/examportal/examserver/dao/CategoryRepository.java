package com.examportal.examserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.examserver.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
//	public Category addCategory(Category category);
//	
//	public Category updateCategory(Category category);
//	
//	public List<Category> getCategories();
//	
//	public Category getCategory(Long categoryId);
//	
//	public void deleteCategory(Long categoryId);

}
