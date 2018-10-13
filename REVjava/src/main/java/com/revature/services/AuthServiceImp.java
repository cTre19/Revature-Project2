package com.revature.services;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Credentials;
import com.revature.beans.User;

@Service
public class AuthServiceImp implements AuthService {

	Logger log = Logger.getLogger(AuthService.class);
	@Autowired
	UserServicesImpl us;

	public User validate(Credentials c){

		log.info("Email passed into validate: " + c.getEmail());
		log.info("Password passed into validate: " + c.getPass());

		User u = us.getUser(c.getEmail());
		if(u != null) {
			if(u.getPassword().equals(u.getPassword()))
				return u;
		}

		return null;

	}
}
