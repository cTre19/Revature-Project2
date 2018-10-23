package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.beans.User;
import com.revature.services.UserServicesImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class GroupCtrl {


	@Autowired
	private UserServicesImpl us;
	
	
	@RequestMapping(value="/group", method=RequestMethod.POST, consumes= {"application/json"})
	@ResponseBody
	public List<User> getGroup(@RequestBody User user) throws JsonProcessingException {
		System.out.println("inside getGroup()");
		
		return us.getUserLocs(user);
	}
}
