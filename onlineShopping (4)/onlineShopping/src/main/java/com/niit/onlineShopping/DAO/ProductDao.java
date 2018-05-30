package com.niit.onlineShopping.DAO;

import java.util.List;

import com.niit.onlineShopping.model.Product;

public interface ProductDao {
	
	public List<Product> getProductDetailList();
	public List<Product> listActiveProducts();
	public Product getProductById(int id);
	public boolean addProduct(Product product);
	public boolean removeProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> getProductByCatId(int catId);
}
