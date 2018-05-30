package com.niit.onlineShopping.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.onlineShopping.DAO.SupplierDao;
import com.niit.onlineShopping.model.Supplier;

@Repository
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addSupplier(Supplier supplier) {
		try 
		{
			sessionfactory.getCurrentSession().save(supplier);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeSupplier(Supplier supplier) {
		try 
		{
			sessionfactory.getCurrentSession().delete(supplier);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Supplier getSupplierById(int suppId) {
		return (Supplier) sessionfactory.getCurrentSession().get(Supplier.class, Integer.valueOf(suppId));
	}

	@Override
	public List<Supplier> getallsuppliers() {
		
		String query = "FROM Supplier";
		return sessionfactory.getCurrentSession()
								.createQuery(query, Supplier.class)
									.getResultList();
	}
}
