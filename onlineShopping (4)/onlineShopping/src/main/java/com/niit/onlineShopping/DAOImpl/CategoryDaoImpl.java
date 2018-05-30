package com.niit.onlineShopping.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineShopping.DAO.CategoryDao;
import com.niit.onlineShopping.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addCategory(Category category) {
		try 
		{
			sessionfactory.getCurrentSession().save(category);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeCategory(Category category) {
		try 
		{
			sessionfactory.getCurrentSession().delete(category);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try 
		{
			sessionfactory.getCurrentSession().saveOrUpdate(category);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Category> getCategoryItems() {
		
		String query = "FROM Category";
		return sessionfactory.getCurrentSession()
								.createQuery(query, Category.class)
									.getResultList();
	}

	@Override
	public Category get(int catId) {
		
		return (Category) sessionfactory.getCurrentSession().get(Category.class, Integer.valueOf(catId));
		
	}

}
