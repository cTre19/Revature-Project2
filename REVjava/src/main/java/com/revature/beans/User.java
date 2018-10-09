package com.revature.beans;

public class User {
	
	private String firstName;
	private String lastName;
	private int id;
	private String email;
	private String password;
	private String city;
	private String state;
	private String clientCompany;
	private int batchId;
	
	
	
	public User(String firstName, String lastName, int id, String email, String password, String city, String state,
			String clientCompany, int batchId, String position) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
		this.password = password;
		this.city = city;
		this.state = state;
		this.clientCompany = clientCompany;
		this.batchId = batchId;
		this.position = position;
	}
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", email=" + email
				+ ", password=" + password + ", city=" + city + ", state=" + state + ", clientCompany=" + clientCompany
				+ ", batchId=" + batchId + ", position=" + position + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getClientCompany() {
		return clientCompany;
	}
	public void setClientCompany(String clientCompany) {
		this.clientCompany = clientCompany;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	private String position;

}
