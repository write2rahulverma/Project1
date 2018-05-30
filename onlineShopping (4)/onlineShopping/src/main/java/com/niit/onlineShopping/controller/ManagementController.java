package com.niit.onlineShopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineShopping.DAO.CategoryDao;
import com.niit.onlineShopping.DAO.ProductDao;
import com.niit.onlineShopping.model.Category;
import com.niit.onlineShopping.model.Product;
import com.niit.onlineShopping.util.FileUploadUtility;
import com.niit.onlineShopping.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value="/products")
	public ModelAndView showManageProducts()
	{
		ModelAndView mv = new ModelAndView("manageProduct");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		mv.addObject("product",productDao.getProductDetailList());
		return mv;
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView register(@RequestParam(name="operation", required=false) String operation, Model model)
	{
		ModelAndView mv = new ModelAndView("addProduct");
		mv.addObject("title","Add Product");
		mv.addObject("userClickAddProduct",true);
		Product product=new Product();
		product.setActive(true);
		model.addAttribute("product", product);
		
		if(operation!=null) {			
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
			else if(operation.equals("category")) {
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("addProduct");
		mv.addObject("userClickAddProducts", true);
		mv.addObject("title", "Add Products");
		// fetch the product from the database
		Product product = productDao.getProductById(id);
		// set the product fetch from database
		mv.addObject("product", product);
		return mv;
	}
	
	//handling product submission
	@RequestMapping(value="/addProduct", method= RequestMethod.POST)
	public String registerpost(@Valid @ModelAttribute("product")Product product, BindingResult result, Model model, HttpServletRequest request)
	{
		
		// handle image validation for new products
		if(product.getProdId() == 0) {
			new ProductValidator().validate(product, result);
		}
		else {
			if(!product.getProdImage().getOriginalFilename().equals("")) {
				new ProductValidator().validate(product, result);
			}
		}
		
		if(result.hasErrors()) {
			model.addAttribute("title","Add Product");
			model.addAttribute("userClickAddProduct",true);
			model.addAttribute("message", "Validation failed for Product Submission!");
			
			return "addProduct";
		}
		
		if(product.getProdId() == 0) {
			// create a new product record if id is 0
			productDao.addProduct(product);
		}
		else {
			// update the product if id is not 0
			productDao.updateProduct(product);
		}

		if(!product.getProdImage().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, product.getProdImage(), product.getCode());
		}
		return "redirect:/manage/addProduct?operation=product";
	}
	
	@RequestMapping("/category")
	public String register(Model model)
	{
		Category category=new Category();
		model.addAttribute("Category", category);
		return"category";
	}
	
	// to handle category submission
	@RequestMapping(value="category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		
		//add the new category
		categoryDao.addCategory(category);
		
		return "redirect:/manage/addProduct";
	}
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		// is going to fetch the product from the database
		Product product = productDao.getProductById(id);
		boolean isActive = product.isActive();
		// activating and deactivating based on the value of active field
		product.setActive(!product.isActive());
		// updating the product
		productDao.updateProduct(product);
		
		return (isActive)? 
				"You have succesfully deactivated the product with id " + product.getProdId() 
				: "You have succesfully activated the product with id " + product.getProdId();		
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDao.getCategoryItems();
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}

}
