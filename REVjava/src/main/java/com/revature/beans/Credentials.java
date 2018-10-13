package com.revature.beans;

public class Credentials {

	private String email;
	
	private String pass;

	public Credentials(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
