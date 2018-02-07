package com.niit.angularFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.angularBackend.DAO.UserDAO;
import com.niit.angularBackend.model.User;

@RestController
public class userController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user)
	{
		System.out.println("gggg");
		if(userDAO.addUser(user))
		{
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}

}
