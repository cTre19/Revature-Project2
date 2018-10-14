package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="application")
public class Application {

	@Autowired
	private User user;
	
}
