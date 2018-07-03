package com.pro.entity;

import java.util.List;

public class Apartment {
	private int id;
	private String apart_name;
	private String apart_number;
	private List<User> userlist;
	
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	@Override
	public String toString() {
		return "Apartment [id=" + id + ", apart_name=" + apart_name + ", apart_number=" + apart_number + ", userlist="
				+ userlist + "]";
	}
	public Apartment(int id, String apart_name, String apart_number) {
		this.id = id;
		this.apart_name = apart_name;
		this.apart_number = apart_number;
	}
	
	public Apartment() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApart_name() {
		return apart_name;
	}
	public void setApart_name(String apart_name) {
		this.apart_name = apart_name;
	}
	public String getApart_number() {
		return apart_number;
	}
	public void setApart_number(String apart_number) {
		this.apart_number = apart_number;
	}
	
}

