package com.revature.daos;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public class UserDaoImpl {

	ArrayList<User> db = new ArrayList<User>();
	{
		db.add(new User("Bob", "The_builder", 1,"bob@revature.com","secret", "tampa", "florida", "rev", 1, "trainee"));
		db.add(new User("Bill","Smith", 2, "bill@revature.com", "secret2", "tampa", "florida", "rev", 1, "trainee"));
	}

	public User get(String email) {
		for(int i = 0; i <db.size();i++) {
			if(db.get(i).getEmail().equals(email)) {
				return db.get(i);
			}
		}
		return null;
	}

	public void add(User u) {
		db.add(u);
	}

	public void update(User u, String email) {
		User updated = this.get(email);
		if(updated != null) {
			updated.setFirstName(u.getFirstName());
			updated.setLastName(u.getLastName());
			updated.setId(u.getId());
			updated.setEmail(u.getEmail());
			updated.setPassword(u.getPassword());
			updated.setCity(u.getCity());
			updated.setState(u.getState());
			updated.setClientCompany(u.getClientCompany());
			updated.setBatchId(u.getBatchId());
			updated.setPosition(u.getPosition());
		}
	}

	public void delete(String email) {
		for(int i = 0; i <db.size();i++) {
			if(db.get(i).getEmail().equals(email)) {
				db.remove(i);
			}
		}
	}

	public ArrayList<User> getAll() {
		ArrayList<User> allUsers = new ArrayList<User>();
		for(int i = 0; i <db.size();i++) {
			User u = db.get(i);
			allUsers.add(u);
		}

		return allUsers;
	}
}
