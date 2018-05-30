package com.niit.onlineShopping.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineShopping.DAO.ProductDao;
import com.niit.onlineShopping.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public Product getProductById(int id) {
		return (Product) sessionfactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public boolean addProduct(Product product) {
		try 
		{
			sessionfactory.getCurrentSession().save(product);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeProduct(Product product) {
		try 
		{
			sessionfactory.getCurrentSession().delete(product);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try 
		{
			sessionfactory.getCurrentSession().saveOrUpdate(product);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getProductDetailList() {
		
		String query = "FROM Product";
		return sessionfactory.getCurrentSession()
								.createQuery(query, Product.class)
									.getResultList();
	}
	
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionfactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> getProductByCatId(int catId) {
		
		String query = "FROM Product WHERE active = :active AND catId = :catId";
		return sessionfactory.getCurrentSession()
				.createQuery(query, Product.class)
					.setParameter("active", true)
					.setParameter("catId",catId)
						.getResultList();
	}

}
