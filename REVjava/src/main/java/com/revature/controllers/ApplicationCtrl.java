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
public class ApplicationCtrl {

	@Autowired
	private UserServicesImpl us;

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/application", method=RequestMethod.POST, consumes= {"application/json"})
	public String applicationPost(@RequestBody User user, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) throws JsonProcessingException{

		System.out.println("inside applicationPost");

		if(user != null) {
			// check that email does not already exist
			if(us.validate(new Credentials(user.getEmail(), user.getPassword())) == null) {
				System.out.println(us.createUser(user));
				System.out.println(user.toString());
				ObjectMapper om = new ObjectMapper();
				return om.writeValueAsString(user);
			}
		}
		return null;
	}
}
