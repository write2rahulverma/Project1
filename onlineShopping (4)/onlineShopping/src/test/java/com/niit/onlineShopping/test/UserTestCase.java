/*package com.niit.onlineShopping.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlineShopping.DAO.UserDao;
import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.User;
import com.niit.onlineShopping.model.UserAddress;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user = null;
	private Cart cart = null;
	private UserAddress userAddress = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.onlineShopping");
		context.refresh();
		
		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void testAddUser() {
		
		user = new User();
		user.setName("Akiv");
		user.setUsername("ak");
		user.setPassword("ak");
		user.setEmail("a@k");
		user.setCountry("india");
		user.setEnabled(true);
		user.setRole("USER");
		
		userAddress = new UserAddress();
		userAddress.setApartmentNumber("123");
		userAddress.setStreetName("abcd");
		userAddress.setCity("lko");
		userAddress.setState("UP");
		userAddress.setCountry("india");
		userAddress.setBilling(true);
		userAddress.setShipping(true);
		userAddress.setZipCode("223344");
		
		cart = new Cart();
		
		userAddress.setUser(user);
		
		cart.setUser(user);
		
		user.setCart(cart);
		
		assertEquals("Failed to add the user!", true, userDao.addUser(user));
		
		assertEquals("Failed to add the billing address!", true, userDao.addAddress(userAddress));
	}

}*/