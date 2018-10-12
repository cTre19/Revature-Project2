package com.revature.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.daos.UserDaoImpl;

@Service
public class UserServicesImpl implements ServicesInterface {

	@Autowired
	private UserDaoImpl ud;
	
	public void addUser(User u) {
		ud.add(u);
	}
	
	public User getUser(String email) {
		return ud.get(email);
	}
	
	public void updateUser(User u, String email) {
		ud.update(u, email);
	}
	
	public void deleteUser(String email) {
		ud.delete(email);
	}
	
	public ArrayList<User> getAllUsers() {
		return ud.getAll();
	}
}
