package com.niit.onlineShopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.niit.onlineShopping.model.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product) target;
		
		//whether file has been selected or not
		if(product.getProdImage() == null || 
				product.getProdImage().getOriginalFilename().equals(""))
		{
			errors.rejectValue("prodImage", null, "Please select an image file to uppload!");
			return;
		}
		
		if(! (product.getProdImage().getContentType().equals("image/jpeg") || 
			  product.getProdImage().getContentType().equals("image/png") || 
			  product.getProdImage().getContentType().equals("image/gif")) )
				
		{
			errors.rejectValue("prodImage", null, "Please use only image file for upload!");
			return;
		}

	}

}
