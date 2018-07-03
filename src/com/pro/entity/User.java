package com.pro.entity;

public class User {

	private int id;
	private String username;
	private String password;
	private String role;
	private int apart_id;
	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", apart_id="
				+ apart_id + "]";
	}

	public int getApart_id() {
		return apart_id;
	}

	public void setApart_id(int apart_id) {
		this.apart_id = apart_id;
	}

	public User() {
	}
	
	public User(int id, String username, String password, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
