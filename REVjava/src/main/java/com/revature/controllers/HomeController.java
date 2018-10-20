package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HomeController {

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homeGet(HttpSession sess){
		System.out.println("inside homeGet()");
		if (sess.getAttribute("user") != null){
			System.out.println("user not null");
			return "home";
		}
		System.out.println("User is null");
		return "login";
	}
	
}
