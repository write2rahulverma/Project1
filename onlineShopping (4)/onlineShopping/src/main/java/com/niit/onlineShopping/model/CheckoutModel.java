package com.niit.onlineShopping.model;

import java.io.Serializable;
import java.util.List;

import com.niit.onlineShopping.model.UserAddress;
import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.CartLine;
import com.niit.onlineShopping.model.OrderDetail;
import com.niit.onlineShopping.model.User;

public class CheckoutModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private UserAddress shipping;
	private Cart cart;
	private List<CartLine> cartLines;
	private OrderDetail orderDetail;
	private double checkoutTotal;

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public double getCheckoutTotal() {
		return checkoutTotal;
	}

	public void setCheckoutTotal(double checkoutTotal) {
		this.checkoutTotal = checkoutTotal;
	}

	public List<CartLine> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLine> cartLines) {
		this.cartLines = cartLines;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserAddress getShipping() {
		return shipping;
	}

	public void setShipping(UserAddress shipping) {
		this.shipping = shipping;
	}
	
}
