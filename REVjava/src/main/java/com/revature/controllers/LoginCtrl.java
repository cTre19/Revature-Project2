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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public String loginPost(@RequestBody Credentials cred, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) throws JsonProcessingException{
		
		System.out.println("inside loginPost");
		System.out.println(cred.getEmail());
		System.out.println(cred.getPass());
		User u = us.validate(cred);
		if(u == null) {
			System.out.println("User is null");
			return null;
		}
		
		if (bindingResult.hasErrors()){
			System.out.println("inside first if");
			//modelMap.addAttribute("errorMessage", "Incorrect email or password, please try again!");
			return "login";
		}
		
		if(u != null){
			System.out.println(u.toString());
			sess.setAttribute("user", u);
			ObjectMapper om = new ObjectMapper();
			return om.writeValueAsString(u);
		}
		
		
		return null;
	}
	

}
