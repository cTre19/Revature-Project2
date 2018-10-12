package com.revature.services;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;

@Service
public class AuthServiceImp implements AuthService {

	Logger log = Logger.getLogger(AuthService.class);
	@Autowired
	UserServicesImpl us;

	public User validate(User user){

		log.info("Email passed into validate: " + user.getEmail());
		log.info("Password passed into validate: " + user.getPassword());

		User u = us.getUser(user.getEmail());
		if(u != null) {
			if(u.getPassword().equals(user.getPassword()))
				return u;
		}

		return null;

	}
}
