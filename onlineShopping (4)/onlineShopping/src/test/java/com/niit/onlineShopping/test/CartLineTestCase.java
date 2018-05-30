/*package com.niit.onlineShopping.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlineShopping.DAO.CartLineDao;
import com.niit.onlineShopping.DAO.ProductDao;
import com.niit.onlineShopping.DAO.UserDao;
import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.CartLine;
import com.niit.onlineShopping.model.Product;
import com.niit.onlineShopping.model.User;

public class CartLineTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDao cartLineDao = null;
	private static ProductDao productDao = null;
	private static UserDao userDao = null;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.onlineShopping");
		context.refresh();
		
		productDao = (ProductDao)context.getBean("productDao");
		userDao = (UserDao)context.getBean("userDao");
		cartLineDao = (CartLineDao)context.getBean("cartLineDao");
	}

	@Test
	public void testAddNewCartLine() {
		
		user = userDao.getByEmail("r@v");
		
		cart = user.getCart();
		
		product = productDao.getProductById(171);
		
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getProdPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getProdPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the CartLine", true, cartLineDao.add(cartLine));
		
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Failed to update the cart", true, cartLineDao.updateCart(cart));
	}

}*/