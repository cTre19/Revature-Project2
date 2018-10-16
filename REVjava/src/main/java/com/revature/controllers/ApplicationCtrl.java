package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserServicesImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ApplicationCtrl {

	@Autowired
	private UserServicesImpl us;

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/application", method=RequestMethod.POST, consumes= {"application/json"})
	public String applicationPost(@RequestBody User user, BindingResult bindingResult, ModelMap modelMap, HttpSession sess){

		System.out.println("inside applicationPost");
		if(user != null) {
			System.out.println(user.toString());
			System.out.println(us.createUser(user));
		}
		// add user to revuser table
		return "login";
		
	}
}
