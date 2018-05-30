package com.niit.onlineShopping.DAO;

import java.util.List;

import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.User;
import com.niit.onlineShopping.model.UserAddress;

public interface UserDao {
	
	
	//add a user
	public boolean addUser(User user);
	public User getUserById(int userId);
	public User getByEmail(String email);
	public User getByUsername(String username);
	
	//update user
	public boolean updateUser(User user);
	
	
	// adding and updating a new address
	public UserAddress getAddress(int userAddressId);
	public boolean addAddress(UserAddress address);
	public boolean updateAddress(UserAddress address);
	public UserAddress getBillingAddress(int userId);
	public List<UserAddress> listShippingAddresses(int userId);
		
	//update cart
	public boolean updateCart(Cart cart);
	
	
	public boolean removeUser(User user);
	public List<User> getAllUsers();
	
}
