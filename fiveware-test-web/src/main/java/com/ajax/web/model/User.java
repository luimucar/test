package com.ajax.web.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ajax.web.jsonview.Views;

public class User {

	@JsonView(Views.Public.class)
	String username;
	String password;
	String email;
	String phone;
	String address;
	@JsonView(Views.Public.class)
	String bike;
	@JsonView(Views.Public.class)
	String voption;
	@JsonView(Views.Public.class)
	String houses;

	public User() {
	}

	public User(String username, String password, String email, String phone, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public User(String username, String bike, String houses, String voption) {
		super();
		this.username = username;
		this.bike = bike;
		this.houses = houses;
		this.voption = voption;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBike() {
		return bike;
	}

	public void setBike(String bike) {
		this.bike = bike;
	}
	public String getHouses() {
		return houses;
	}
	public void setHouses(String houses) {
		this.bike = houses;
	}
	public String getVoption() {
		return voption;
	}
	public void setVoption(String voption) {
		this.voption = voption;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", bike="+bike+"]";
	}

}
