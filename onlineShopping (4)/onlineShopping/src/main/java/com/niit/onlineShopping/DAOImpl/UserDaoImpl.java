package com.niit.onlineShopping.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineShopping.DAO.UserDao;
import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.User;
import com.niit.onlineShopping.model.UserAddress;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addUser(User user) {
		try 
		{
			
			user.getUserAddress().setUser(user);
			sessionfactory.getCurrentSession().save(user);
			sessionfactory.getCurrentSession().save(user.getUserAddress());
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateUser(User user) {
		try 
		{		
			sessionfactory.getCurrentSession().update(user);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeUser(User user) {
		try 
		{
			user.getUserAddress().setUser(user);
			sessionfactory.getCurrentSession().delete(user);
			sessionfactory.getCurrentSession().delete(user.getUserAddress());
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserById(int userId) {
		return (User) sessionfactory.getCurrentSession().get(User.class, Integer.valueOf(userId));
	}

	@Override
	public List<User> getAllUsers() {
		
		String query = "FROM User";
		return sessionfactory.getCurrentSession()
								.createQuery(query, User.class)
									.getResultList();
	}

	@Override
	public boolean updateCart(Cart cart) {
		try 
		{
			sessionfactory.getCurrentSession().update(cart);
	        return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE Email = :email";
		try {
		return sessionfactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email",email)
							.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}

	@Override
	public UserAddress getAddress(int userAddressId) {
		try {			
			return sessionfactory.getCurrentSession().get(UserAddress.class, userAddressId);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateAddress(UserAddress address) {
		try {			
			sessionfactory.getCurrentSession().update(address);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public UserAddress getBillingAddress(int userId) {
		String selectQuery = "FROM UserAddress WHERE user_userId = :userId AND billing = :isBilling";
		try{
		return sessionfactory
				.getCurrentSession()
					.createQuery(selectQuery,UserAddress.class)
						.setParameter("userId", userId)
						.setParameter("isBilling", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}

	@Override
	public List<UserAddress> listShippingAddresses(int userId) {
		String selectQuery = "FROM UserAddress WHERE user_userId = :userId AND shipping = :isShipping ORDER BY id DESC";
		return sessionfactory
				.getCurrentSession()
					.createQuery(selectQuery,UserAddress.class)
						.setParameter("userId", userId)
						.setParameter("isShipping", true)
							.getResultList();
	}

	@Override
	public boolean addAddress(UserAddress address) {
		try {			
			sessionfactory.getCurrentSession().persist(address);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public User getByUsername(String username) {
		String selectQuery = "FROM User WHERE username = :username";
		try {
		return sessionfactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("username",username)
							.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}

}
