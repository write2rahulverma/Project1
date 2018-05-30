package com.niit.onlineShopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineShopping.DAO.CartLineDao;
import com.niit.onlineShopping.DAO.CategoryDao;
import com.niit.onlineShopping.DAO.ProductDao;
import com.niit.onlineShopping.DAO.UserDao;
import com.niit.onlineShopping.exception.ProductNotFoundException;
import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.Product;
import com.niit.onlineShopping.model.User;

@Controller
public class HomeController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CartLineDao cartLineDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Cart cart=new Cart();
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("index");		
		mv.addObject("title","Home");
		mv.addObject("product",productDao.listActiveProducts());
		mv.addObject("categories",categoryDao.getCategoryItems());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("contact");		
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("about");		
		mv.addObject("title","About");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(Model model)
	{
		ModelAndView mv = new ModelAndView("register");		
		mv.addObject("title","Register");
		User user=new User();
		model.addAttribute("user", user);
		mv.addObject("userClickRegister",true);
		return mv;
	}
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String registerpost(@Valid @ModelAttribute("user")User user, BindingResult result, Model model)
	{
		
		// check if there are any errors
		if(result.hasErrors()) {
			
			model.addAttribute("userClickRegister",true);
			model.addAttribute("title","Register");
			
			return "index";
		}
		
		user.setRole("USER");
		cart.setUser(user);
		user.setCart(cart);
		
		userDao.addUser(user);
		cartLineDao.addCart(cart);
		user.setCart(cart);
		userDao.updateUser(user);
		
		return "redirect:/register?operation=user";
	}
	
	@RequestMapping("/login")
    public ModelAndView login(
            @RequestParam(name="error", required = false)
            String error,
            @RequestParam(name="logout", required = false)
            String logout,
            Model model){
		
		ModelAndView mv = new ModelAndView("login");		
		mv.addObject("title","Login");

        if(error != null){
            mv.addObject("message", "Invalid username and password");
        }

        if (logout !=null){
            mv.addObject("message", "You have been logged out successfully");
        }

        mv.addObject("userClickLogin",true);
		return mv;
    }
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
	    // Removes the authentication from securitycontext 		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "redirect:/login?logout";
	}
	
	@RequestMapping("/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv = new ModelAndView("listProduct");		
		mv.addObject("title","All Products");
		mv.addObject("product",productDao.listActiveProducts());
		mv.addObject("categories",categoryDao.getCategoryItems());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("productDetail");
		
		Product product = productDao.getProductById(id);
		
		if(product == null) throw new ProductNotFoundException();		
		product.setViews(product.getViews() + 1);
		productDao.updateProduct(product);
		
		mv.addObject("title",product.getProdName());
		mv.addObject("categories",categoryDao.getCategoryItems());
		mv.addObject("product",product);
		mv.addObject("userClickSingleProduct",true);
		return mv;
	}
	
	@RequestMapping("/show/category/{catId}/products")
	public ModelAndView showCategoryProducts(@PathVariable("catId") int catId) throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("listProduct");
		
		mv.addObject("product",productDao.getProductByCatId(catId));
		mv.addObject("title","Category");
		mv.addObject("categories",categoryDao.getCategoryItems());
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	@RequestMapping("/access-denied")
	public ModelAndView accessDenied()
	{
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("title","403 - Access Denied");
		mv.addObject("errorTitle","Aha! Caught You.");
		mv.addObject("errorDescription","You are not authorized to view this page!");
		return mv;
	}

}
