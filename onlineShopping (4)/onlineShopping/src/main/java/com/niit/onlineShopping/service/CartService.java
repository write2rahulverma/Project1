package com.niit.onlineShopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.onlineShopping.model.UserModel;
import com.niit.onlineShopping.DAO.CartLineDao;
import com.niit.onlineShopping.DAO.ProductDao;
import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.CartLine;
import com.niit.onlineShopping.model.Product;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDao cartLineDao;
	
	@Autowired
	private ProductDao productDao;
		
	@Autowired
	private HttpSession session;
	

	//returns the cart of the user who is logged in
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//returns entire cartline
	public List<CartLine> getCartLines() {

		return cartLineDao.list(this.getCart().getId());

	}	
	
	public String manageCartLine(int cartLineId, int count) {
		
		CartLine cartLine = cartLineDao.get(cartLineId);		

		double oldTotal = cartLine.getTotal();

		
		Product product = cartLine.getProduct();
		
		// check if that much prodStock is available or not
		if(product.getProdStock() < count) {
			return "result=unavailable";		
		}	
		
		// update the cart line
		cartLine.setProductCount(count);
		cartLine.setBuyingPrice(product.getProdPrice());
		cartLine.setTotal(product.getProdPrice() * count);
		cartLineDao.update(cartLine);

	
		// update the cart
		Cart cart = this.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
		cartLineDao.updateCart(cart);
		
		return "result=updated";
	}



	public String addCartLine(int productId) {		
		Cart cart = this.getCart();
		String response = null;
		CartLine cartLine = cartLineDao.getByCartAndProduct(cart.getId(), productId);
		if(cartLine==null) {
			// add a new cartLine if a new product is getting added
			cartLine = new CartLine();
			Product product = productDao.getProductById(productId);
			// transfer the product details to cartLine
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setProductCount(1);
			cartLine.setBuyingPrice(product.getProdPrice());
			cartLine.setTotal(product.getProdPrice());
			
			// insert a new cartLine
			cartLineDao.add(cartLine);
			
			// update the cart
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() + 1);
			cartLineDao.updateCart(cart);

			response = "result=added";						
		} 
		else {
			// check if the cartLine has been already reached to maximum count
			if(cartLine.getProductCount() < 3) {
				// call the manageCartLine method to increase the count
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);				
			}			
			else {				
				response = "result=maximum";				
			}						
		}		
		return response;
	}
	

	public String removeCartLine(int cartLineId) {
		
		CartLine cartLine = cartLineDao.get(cartLineId);
		// deduct the cart
		// update the cart
		Cart cart = this.getCart();	
		cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() - 1);		
		cartLineDao.updateCart(cart);
		
		// remove the cartLine
		cartLineDao.remove(cartLine);
				
		return "result=deleted";
	}


	public String validateCartLine() {
		Cart cart = this.getCart();
		List<CartLine> cartLines = cartLineDao.list(cart.getId());
		if(cart == null || cartLines == null)
		{
			System.out.println(" Value is null");
		}
		double grandTotal = 0.0;
		int lineCount = 0;
		String response = "result=success";
		boolean changed = false;
		Product product = null;
		for(CartLine cartLine : cartLines) {					
			product = cartLine.getProduct();
			changed = false;
			// check if the product is active or not
			// if it is not active make the availability of cartLine as false
			if((!product.isActive() && product.getProdStock() == 0) && cartLine.isAvailable()) {
				cartLine.setAvailable(false);
				changed = true;
			}			
			// check if the cartLine is not available
			// check whether the product is active and has at least one prodStock available
			if((product.isActive() && product.getProdStock() > 0) && !(cartLine.isAvailable())) {
					cartLine.setAvailable(true);
					changed = true;
			}
			
			// check if the buying price of product has been changed
			if(cartLine.getBuyingPrice() != product.getProdPrice()) {
				// set the buying price to the new price
				cartLine.setBuyingPrice(product.getProdPrice());
				// calculate and set the new total
				cartLine.setTotal(cartLine.getProductCount() * product.getProdPrice());
				changed = true;				
			}
			
			// check if that much prodStock of product is available or not
			if(cartLine.getProductCount() > product.getProdStock()) {
				cartLine.setProductCount(product.getProdStock());										
				cartLine.setTotal(cartLine.getProductCount() * product.getProdPrice());
				changed = true;
				
			}
			
			// changes has happened
			if(changed) {				
				//update the cartLine
				cartLineDao.update(cartLine);
				// set the result as modified
				response = "result=modified";
			}
			
			grandTotal += cartLine.getTotal();
			lineCount++;
		}
		
		cart.setCartLines(lineCount++);
		cart.setGrandTotal(grandTotal);
		cartLineDao.updateCart(cart);

		return response;
	}	
}