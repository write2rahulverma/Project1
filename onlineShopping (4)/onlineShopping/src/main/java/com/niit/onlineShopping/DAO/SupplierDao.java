package com.niit.onlineShopping.DAO;

import java.util.List;

import com.niit.onlineShopping.model.Supplier;

public interface SupplierDao {
	
	public boolean addSupplier(Supplier supplier);
	public boolean removeSupplier(Supplier supplier);
	public Supplier getSupplierById(int suppId);
	public List<Supplier> getallsuppliers();
}
