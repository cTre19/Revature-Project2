package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.beans.User;
import com.revature.services.UserServicesImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmpsController {

	@Autowired
	private UserServicesImpl us;
	
	
	@RequestMapping(value="/emps", method=RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() throws JsonProcessingException {
		System.out.println("inside getUsers()");
		
		return us.getUsers();
	}
}
