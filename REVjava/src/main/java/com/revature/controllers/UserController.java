package com.revature.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public ArrayList<User> getUser() throws JsonProcessingException {
		System.out.println("inside getUser()");
		
		User user = us.getUser(new User("john@revature.com"));
		User user2 = us.getUser(new User("j@rev.com"));
		ArrayList<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user2);
		return list;
		/*
		System.out.println(user.toString());
		System.out.println(user2.toString());
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(list); */
	}
	
	/*
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ArrayList<User> getUsers() {
		System.out.println("inside getUsers()");
		
		return us.getAllUsers();
	}*/

}
