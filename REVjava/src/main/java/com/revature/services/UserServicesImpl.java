package com.revature.services;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.daos.UserDaoImpl;

@Service
public class UserServicesImpl implements ServicesInterface {

	Logger log = Logger.getLogger(UserServicesImpl.class);
	public UserServicesImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private static UserDaoImpl ud;
	
	public User validate(Credentials cred) {
		ud = new UserDaoImpl();
		ud.getCurrentSession();
		
		Integer uid = ud.getUserId(cred);
		
		User user = ud.getUser(uid);
		
		return user;
	}
	
	
}
