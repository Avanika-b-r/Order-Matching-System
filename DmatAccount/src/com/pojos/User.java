package com.pojos;

public class User {

	private String user_id;
	private String name;
	private String phone_no;
	private String email;
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String user_id, String name, String phone_no, String email) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.phone_no = phone_no;
		this.email = email;
	}
	
	
}
