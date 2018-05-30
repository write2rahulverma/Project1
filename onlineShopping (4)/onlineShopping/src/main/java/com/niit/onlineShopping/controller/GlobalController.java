package com.niit.onlineShopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.niit.onlineShopping.DAO.UserDao;
import com.niit.onlineShopping.model.User;
import com.niit.onlineShopping.model.UserModel;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDao userDao;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if(session.getAttribute("userModel")==null) {
			
			//add the new user
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDao.getByUsername(authentication.getName());
			if(user!=null) {
				
				//create a new UserModel object to pass the user details
				userModel = new UserModel();
				
				userModel.setId(user.getUserId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setname(user.getName());
				
				if(userModel.getRole().equals("USER")) {
					//set the cart only if user is a buyer
					userModel.setCart(user.getCart());
				}
				
				//set the userModel in the session
				session.setAttribute("userModel", userModel);
				
				return userModel;
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
	}

}
