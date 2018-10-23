package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.services.UserServicesImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserServicesImpl us;
	
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	@ResponseBody
	public List<User> getUser() throws JsonProcessingException {
		System.out.println("inside getUser()");
		
		return us.getPending();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/user", method=RequestMethod.PUT, consumes= {"application/json"})
	@ResponseBody
	public String approveUser(@RequestBody User user) throws JsonProcessingException {
		System.out.println("inside approveUser()");
		
		user.setApproved(3);
		us.update(user);
		System.out.println(user.toString());
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(user);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/user/{email}", method=RequestMethod.DELETE)
	public void denyUser(@PathVariable("email") String email) {
		System.out.println("inside denyUser()");
		System.out.println("email: " + email);
		User u = us.getUser(new User(email+"@revature.com"));
		if(u == null) 
			System.out.println("user is null");
		else {
			System.out.println(u.toString());
			us.deleteUser(u);
		}
		
	}

}
