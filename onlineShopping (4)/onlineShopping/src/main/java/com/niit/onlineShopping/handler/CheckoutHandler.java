package com.niit.onlineShopping.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.onlineShopping.model.CheckoutModel;
import com.niit.onlineShopping.model.UserModel;
import com.niit.onlineShopping.DAO.CartLineDao;
import com.niit.onlineShopping.DAO.ProductDao;
import com.niit.onlineShopping.DAO.UserDao;
import com.niit.onlineShopping.model.UserAddress;
import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.CartLine;
import com.niit.onlineShopping.model.OrderDetail;
import com.niit.onlineShopping.model.OrderItem;
import com.niit.onlineShopping.model.Product;
import com.niit.onlineShopping.model.User;

@Component
public class CheckoutHandler {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CartLineDao cartLineDao;
	
	@Autowired
	private HttpSession session;
	
	
	public CheckoutModel init(String name) throws Exception{

		User user = userDao.getByUsername(name);
		CheckoutModel checkoutModel = null;	
		System.out.println(name);
		if(user!=null) {
			
			checkoutModel = new CheckoutModel();
			checkoutModel.setUser(user);
			checkoutModel.setCart(user.getCart());
			System.out.println("Checking the user details");
			System.out.println(user.getName());
			System.out.println(checkoutModel.getCart());
			double checkoutTotal = 0.0;
			List<CartLine> cartLines = cartLineDao.listAvailable(user.getCart().getId());
			System.out.println(cartLines);
			if(cartLines.size() == 0 ) {
				throw new Exception("There are no products available for checkout now!");
			}
			
			for(CartLine cartLine: cartLines) {
				checkoutTotal += cartLine.getTotal();
			}
			
			checkoutModel.setCartLines(cartLines);
			checkoutModel.setCheckoutTotal(checkoutTotal);			
		}			
		System.out.println(checkoutModel.getCart());
		System.out.println(checkoutModel.getCheckoutTotal());
		System.out.println(checkoutModel.getCartLines());
		System.out.println(checkoutModel.getUser());
		System.out.println(checkoutModel.getShipping());
		System.out.println(checkoutModel);
		return checkoutModel;
	}
	
	
	public List<UserAddress> getShippingAddresses(CheckoutModel model) {
		System.out.println("You entered getShippingAddresses");
		System.out.println(model);
		System.out.println(model.getUser().getUserId());
		System.out.println(model.getCart());
		System.out.println(model.getShipping());
		List<UserAddress> UserAddresses = userDao.listShippingAddresses(model.getUser().getUserId());
		System.out.println(model.getUser().getUserId());
		System.out.println(model.getCart());
		
		if(UserAddresses.size() == 0) {
			UserAddresses = new ArrayList<>();
		}

		UserAddresses.add(UserAddresses.size(), userDao.getBillingAddress(model.getUser().getUserId()));			
		for(UserAddress address:UserAddresses) {
			System.out.println(address.getApartmentNumber());
		}
		return UserAddresses;
		
	}
	
	public String saveAddressSelection(CheckoutModel checkoutModel, int shippingId) {

		String transitionValue = "success";
		
		//logger.info(String.valueOf(shippingId));
		
		UserAddress shipping = userDao.getAddress(shippingId);		
		
		checkoutModel.setShipping(shipping);
		
		return transitionValue;
		
	}
			
	
	public String saveAddress(CheckoutModel checkoutModel, UserAddress shipping) {

		String transitionValue = "success";
		
		// set the user id
		// set shipping as true
		shipping.setUser(checkoutModel.getUser());
		shipping.setShipping(true);
		userDao.addAddress(shipping);
		
		// set the shipping id to flowScope object
		checkoutModel.setShipping(shipping);
		
		return transitionValue;
		
	}
		

	public String saveOrder(CheckoutModel checkoutModel) {
		String transitionValue = "success";	
		
		// create a new order object
		OrderDetail orderDetail = new OrderDetail();
				
		// attach the user 
		orderDetail.setUser(checkoutModel.getUser());
				
		System.out.println("Checking the user details in save order");
		System.out.println(checkoutModel.getUser().getName());
		session.setAttribute("Name", checkoutModel.getUser().getName());
		session.setAttribute("Email", checkoutModel.getUser().getEmail());
		// attach the shipping UserAddress
		orderDetail.setShipping(checkoutModel.getShipping());
		
		// fetch the billing UserAddress
		UserAddress billing = userDao.getBillingAddress(checkoutModel.getUser().getUserId());		
		orderDetail.setBilling(billing);

		List<CartLine> cartLines = checkoutModel.getCartLines();
		OrderItem orderItem = null;
		
		double orderTotal = 0.0;
		int orderCount = 0;
		Product product = null;
		
		for(CartLine cartLine : cartLines) {
			
			orderItem = new OrderItem();
			
			orderItem.setBuyingPrice(cartLine.getBuyingPrice());
			orderItem.setProduct(cartLine.getProduct());
			orderItem.setProductCount(cartLine.getProductCount());
			orderItem.setTotal(cartLine.getTotal());
			
			orderItem.setOrderDetail(orderDetail);
			orderDetail.getOrderItems().add(orderItem);
			
			orderTotal += orderItem.getTotal();
			orderCount++;
			
			// update the product
			// reduce the quantity of product
			product = cartLine.getProduct();
			product.setProdStock(product.getProdStock() - cartLine.getProductCount());
			product.setPurchases(product.getPurchases() + cartLine.getProductCount());
			productDao.updateProduct(product);
			
			// delete the cartLine
			cartLineDao.remove(cartLine);
			

			
		}
		
		orderDetail.setOrderTotal(orderTotal);
		orderDetail.setOrderCount(orderCount);
		orderDetail.setOrderDate(new Date());
		
		// save the order
		cartLineDao.addOrderDetail(orderDetail);

		// set it to the orderDetails of checkoutModel
		checkoutModel.setOrderDetail(orderDetail);

		
		// update the cart
		Cart cart = checkoutModel.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - orderTotal);
		cart.setCartLines(cart.getCartLines() - orderCount);
		cartLineDao.updateCart(cart);
		
		// update the cart if its in the session
		UserModel userModel = (UserModel) session.getAttribute("userModel");
		System.out.println(userModel.getEmail());
		if(userModel!=null) {
			userModel.setCart(cart);
		}
		
				
		return transitionValue;		
	}

	
	public OrderDetail getOrderDetail(CheckoutModel checkoutModel) {
		return checkoutModel.getOrderDetail();
	}
	
	
	
}