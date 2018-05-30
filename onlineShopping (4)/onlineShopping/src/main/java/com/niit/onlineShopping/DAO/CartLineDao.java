package com.niit.onlineShopping.DAO;

import java.util.List;

import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.CartLine;
import com.niit.onlineShopping.model.OrderDetail;

public interface CartLineDao {

	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
		
	// updating the cart
	boolean addCart(Cart cart);
	boolean updateCart(Cart cart);
	
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
	
	// adding order details
	public boolean addOrderDetail(OrderDetail orderDetail);
	
}