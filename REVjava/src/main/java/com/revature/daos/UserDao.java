package com.revature.daos;

import org.hibernate.Session;

import com.revature.beans.User;

public interface UserDao {

	public Session getCurrentSession();
	
	public void setCurrentSession(Session currentSession);
	
	public void newSession();

	public User getUser(String email);
	
	public String createUser(User user);
	
	public void deleteUser(String email);
	
	public void updateUser(User user);
	
}
