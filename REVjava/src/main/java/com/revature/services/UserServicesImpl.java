package com.revature.services;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public User validate(User u) {
		
		User user = ud.getUser(u.getEmail());
		if(user == null)
			return null;
		
		if(user.getPassword().equals(u.getPassword())) {
			System.out.println("user password: " + user.getPassword());
			System.out.println("u password" + u.getPassword());
			return user;
		} else {
			return null;
		}
	}

	public User getUser(User u) {
		return ud.getUser(u.getEmail());
	}
	
	public String createUser(User user) {
		return ud.createUser(user);
	}
	
}
