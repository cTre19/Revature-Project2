package com.revature.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserServicesImpl;

@RestController
public class UserController {

	@Autowired
	private UserServicesImpl us;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ArrayList<User> getUsers() {
		System.out.println("inside getUsers()");
		
		return us.getAllUsers();
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public void getUser() {
		System.out.println("inside getUser()");
		
	}
}
