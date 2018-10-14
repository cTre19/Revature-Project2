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

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.services.UserServicesImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class LoginCtrl {
	
	@Autowired
	private UserServicesImpl us;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet(HttpSession sess){
		System.out.println("inside loginGet()");
		if (sess.getAttribute("user") != null){
			return "home";
		}
		return "login";
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes= {"application/json"})
	public String loginPost(@RequestBody Credentials cred, BindingResult bindingResult, ModelMap modelMap, HttpSession sess){
		
		System.out.println("inside loginPost");
		System.out.println(cred.getEmail());
		System.out.println(cred.getPass());
		User u = us.validate(cred);
		if(u == null) {
			System.out.println("User is null");
		}
		System.out.println(u.toString());
		
		if (bindingResult.hasErrors()){
			System.out.println("inside first if");
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			return "login";
		}
		
		if(u != null){
			System.out.println("inside second if");
			sess.setAttribute("user", u);
			return "home";
		}
		
		//modelMap.addAttribute("errorMessage", "Username or password incorrect");
		
		return "login";
	}
	

}
