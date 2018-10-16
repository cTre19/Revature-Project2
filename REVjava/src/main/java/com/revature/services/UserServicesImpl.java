package com.revature.services;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.daos.UserDaoImpl;

@Service
public class UserServicesImpl implements ServicesInterface {

	@Autowired
	UserDaoImpl ud;
	Logger log = Logger.getLogger(UserServicesImpl.class);
	public UserServicesImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User validate(Credentials cred) {
		
		User user = ud.getUser(cred);
		
		return user;
	}

	public String createUser(User user) {
		return ud.createUser(user);
	}
	
}
