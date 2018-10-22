package com.revature.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.services.UserServicesImpl;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ViewAppsCtrl {


	@Autowired
	private UserServicesImpl us;
	
	/*
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/viewapps", method=RequestMethod.GET)
	public String viewappsGet(HttpSession sess) throws JsonProcessingException{
		System.out.println("inside loginGet()");
		

		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(all);
	}*/
}
