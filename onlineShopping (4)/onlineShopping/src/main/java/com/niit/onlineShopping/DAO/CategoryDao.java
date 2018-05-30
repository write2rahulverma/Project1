package com.niit.onlineShopping.DAO;

import java.util.List;

import com.niit.onlineShopping.model.Category;

public interface CategoryDao {
	
	public boolean addCategory(Category category);
	public boolean removeCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category> getCategoryItems();
	Category get(int id);
	
}
